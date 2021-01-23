package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());

	public static Struct boolType;
	private Struct lastDeclaredType = null;
	private Obj currentMethod = null;
	private Obj currentClass = null;
	private MyTableVisitor myTableVisitor = new MyTableVisitor(); 
	
	private String imePrograma;
	private boolean newAssignment = false;
	
	public int numOfErrors = 0;
	public int nVars = 0;
	
	public static int classCnt = 0;
	public static int methodCnt = 0;
	public static int globalVarCnt = 0;
	public static int globalConCnt = 0;
	public static int globalArrCnt = 0;
	public static int localVarCnt = 0;
	public static int stmtCnt = 0;
	
	private ArrayList<Struct> termList = new ArrayList<>();
	private ArrayList<Struct> factorList = new ArrayList<>();
	
	
	
	// ********** CONSTRUCTOR **********
	public SemanticAnalyzer(){
		boolType = new Struct(Struct.Bool);
		boolType.setElementType(Tab.noType);
		Tab.insert(Obj.Type, "bool", boolType);
	}
	
	
	
	// ********** UTIL **********
	public boolean checkType(int x){
		return (x == Obj.Fld || x == Obj.Elem || x == Obj.Var)? true:false;
	}
	
	public boolean isDeclared(String name) {
		return (Tab.find(name)==Tab.noObj)?false:true;
	}
	
	public MyTableVisitor getMyTableVisitor() {
		return this.myTableVisitor;
	}
	
	
	
	
	// ********** REPORT INFO/ERROR **********
	public void reportError(String message, SyntaxNode info) {
		this.numOfErrors++;
        log.error(message);
    }
	
	public void reportInfo(String message, SyntaxNode info) {
        log.info(message);
    }
	
	public void reportErrorNoDeclared(int line, String name) {
		reportError("Greska na liniji " + line + ": Ime " + name + " nije deklarisano.", null);
	}
	
	
	
	// ********** PROGRAM DECLARATION **********
	public void visit(ProgramName progName){
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
		
		imePrograma = program.getProgramName().getProgName();
	}
	
	
	
	// ********** METHOD DECLARATION **********
	public void visit(MethodDecl methodDecl) {
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
	}

	public void visit(MethodName methodName) {
		methodCnt++;
		
		methodName.obj  = Tab.insert(Obj.Meth, methodName.getMethName(), methodName.getMethodRetType().struct);
		Tab.openScope();
		
		currentMethod = methodName.obj;
		
		reportInfo("Linija " + methodName.getLine() + ": Obradjuje se funkcija " + methodName.getMethName(), methodName);
		
	}
	
	public void visit(OtherRetType retType) {
		retType.struct = retType.getType().struct;
	}
	
	public void visit(VoidRetType noRetType) {
		noRetType.struct = new Struct(Struct.None);
	}
	
	
	
	// ********** TYPE DECLARATION **********
	public void visit(Type type) {
		
		Obj retType = Tab.find(type.getTypeName());
		if(retType == Tab.noObj) {
			reportError("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola!", null);
			type.struct = Tab.noType;
			lastDeclaredType = Tab.noType;
		}else {
			if(retType.getKind() == Obj.Type) {
				type.struct = retType.getType();
				lastDeclaredType = retType.getType();
			}else {
				reportError("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
				lastDeclaredType = Tab.noType;
			}
		}
	}
	
	
	
	// ********** GLOBAL VAR DECLARATION **********
	public void visit(GlobalVarArray glVarArray) {
		
		if(Tab.find(glVarArray.getVarName()) == Tab.noObj) {
			
			if(lastDeclaredType != Tab.noType) {
			
				glVarArray.obj = Tab.insert(Obj.Var, glVarArray.getVarName(), new Struct(Struct.Array));
				glVarArray.obj.getType().setElementType(lastDeclaredType);
				reportInfo("Linija " + glVarArray.getLine() + ": Deklarise se promenljiva " + glVarArray.getVarName(), null);
		
			}else reportError("Greska na " + glVarArray.getLine() + ":  Lose deklarisan tip za promenljivu " + glVarArray.getVarName(), null);	
		
		}else reportError("Greska na " + glVarArray.getLine() + ": " + glVarArray.getVarName() + " vec deklarisano.", null);	
	
	}
	
	public void visit(GlobalVar glVarSingle) {
		
		if(Tab.find(glVarSingle.getVarName()) == Tab.noObj) {
			
			if(lastDeclaredType != Tab.noType) {
			
				globalVarCnt++;
				glVarSingle.obj = Tab.insert(Obj.Var, glVarSingle.getVarName(), lastDeclaredType);
				glVarSingle.obj.getType().setElementType(Tab.noType);
				reportInfo("Linija " + glVarSingle.getLine() + ": Deklarise se promenljiva " + glVarSingle.getVarName(), null);
			
			}else reportError("Greska na " + glVarSingle.getLine() + ":  Lose deklarisan tip za promenljivu " + glVarSingle.getVarName(), null);
		
		}else reportError("Greska na " + glVarSingle.getLine() + ": " + glVarSingle.getVarName() + " vec deklarisano.", null);
		
	}
	
	
	
	// ********** LOCAL VAR DECLARATION **********
	public void visit(LocalVarArray localVarArray) {
		if(Tab.currentScope().findSymbol(localVarArray.getVarName()) != Tab.noObj) {	
			
			if(lastDeclaredType != Tab.noType) {
			
				int typeToInsert = -1;
				if(currentMethod != null) {
					typeToInsert = Obj.Var;
				}else {
					if(currentClass == null) typeToInsert = Obj.Var; 
					else typeToInsert = Obj.Fld;
				}
				
				localVarArray.obj = Tab.insert(typeToInsert, localVarArray.getVarName(), new Struct(Struct.Array));
				localVarArray.obj.getType().setElementType(lastDeclaredType);
				
				localVarCnt++;
				reportInfo("Linija " + localVarArray.getLine() + ": Deklarise se promenljiva " + localVarArray.getVarName(), null);
			
			}else reportError("Greska na " + localVarArray.getLine() + ":  Lose deklarisan tip za promenljivu " + localVarArray.getVarName(), null);
			
		}else reportError("Greska na " + localVarArray.getLine() + ": " + localVarArray.getVarName() + " vec deklarisano.", null);
		
	}
	
	public void visit(LocalVar localVarSingle) {
		
		if(Tab.currentScope().findSymbol(localVarSingle.getVarName()) != Tab.noObj) {	
				if(lastDeclaredType != Tab.noType) {
					
					int typeToInsert = -1;
					if(currentMethod != null) {
						typeToInsert = Obj.Var;
					}else {
						if(currentClass == null) typeToInsert = Obj.Var; 
						else typeToInsert = Obj.Fld;
					}

					localVarSingle.obj = Tab.insert(typeToInsert, localVarSingle.getVarName(), lastDeclaredType);
					localVarSingle.obj.getType().setElementType(Tab.noType);
				
					localVarCnt++;
					reportInfo("Linija " + localVarSingle.getLine() + ": Deklarise se promenljiva " + localVarSingle.getVarName(), null);
					
				}else reportError("Greska na " + localVarSingle.getLine() + ":  Lose deklarisan tip za promenljivu " + localVarSingle.getVarName(), null);
				
		}else reportError("Greska na " + localVarSingle.getLine() + ": " + localVarSingle.getVarName() + " vec deklarisano.", null);
		
	}
	
	
	
	// ********** CONST DECLARATION **********
	public void visit(ConstDeclSingle constSingle) {
		globalConCnt++;
		if(Tab.find(constSingle.getConstName().getName()) == Tab.noObj) {
			Obj dummy = Tab.insert(Obj.Con, constSingle.getConstName().getName(), lastDeclaredType);
			dummy.setAdr(constSingle.getConstDeclVal().obj.getAdr());
			constSingle.obj = dummy;
			reportInfo("Linija " + constSingle.getLine() + ": Deklarise se promenljiva " + constSingle.getConstName().getName(), null);
		}else {
			reportError("Greska na " + constSingle.getLine() + ": " + constSingle.getConstName().getName() + " vec deklarisano.", null);
		}
	}
		
	public void visit(NumConst num) {
		num.obj = new Obj(Obj.Con, null, new Struct(Struct.Int));
		num.obj.setAdr(num.getN1());
	}
	
	public void visit(CharConst ch) {
		ch.obj = new Obj(Obj.Con, null, new Struct(Struct.Char));
		ch.obj.setAdr(ch.getC1().charAt(0));
	}
	
	public void visit(BoolConst b) {
		//log.info("Usao u bool");
		if(b.getB1().equals("true")) {
			b.obj = new Obj(Obj.Con, null, boolType);
			b.obj.setAdr(1);
		}else {
			b.obj = new Obj(Obj.Con, null, boolType);
			b.obj.setAdr(0);
		}
	}
	
	
	
	// ********** CLASS DECLARATION **********
	public void visit(ClassName className) {
		currentClass = Tab.insert(Obj.Type, className.getName(), new Struct(Struct.Class));
		className.obj = currentClass;
		Tab.openScope();
		reportInfo("Obradjuje se klasa " + className.getName(), null);
	}
	
	public void visit(ClassDeclaration classDecl) {
		classCnt++;
		Tab.chainLocalSymbols(currentClass);
		Tab.closeScope();
		currentClass = null;
	}
	
	
	
	// ********** STATEMENT DECLARATION **********
	
	
	
	// ********** READ STATEMENT **********
	public void visit(ReadStatement readStmt) {
		stmtCnt++;
		if(isDeclared(readStmt.getDesignator().obj.getName())) {
			Obj dummy = readStmt.getDesignator().obj;
			if(dummy.getType().getKind() == Struct.Array) reportError("Greska na liniji " + readStmt.getLine() + ": " + dummy.getName() + " mora biti promenljiva, element niza ili objekat klase.", null);
			else {
				if(!checkType(dummy.getKind()))
					reportError("Greska na liniji " + readStmt.getLine() + ": " + dummy.getName() + " mora biti promenljiva, element niza ili objekat klase.", null);
				
				if(!(dummy.getType() == Tab.intType || dummy.getType() == Tab.charType || dummy.getType() == boolType)) {
					reportError("Greska na liniji " + readStmt.getLine() + ": " + dummy.getName() + " mora biti tipa int, char ili const.", null);
				}
			}
		}else reportErrorNoDeclared(readStmt.getLine(), readStmt.getDesignator().obj.getName());
	}
	
	
	
	// ********** PRINT STATEMENT **********
	public void visit(PrintStatement print) {
		stmtCnt++;
		if(print.getExpr().struct != Tab.intType && print.getExpr().struct != Tab.charType && print.getExpr().struct != boolType) {
			reportError("Greska na liniji " + print.getLine() + ": Izraz unutar print naredbe mora biti tipa int, char ili bool.", null);
		}
	}
	
	
	
	// ********** INCREMENT **********
	public void visit(Increment incStmt) {
		if(isDeclared(incStmt.getDesignator().obj.getName())){
			
			Obj dummy = Tab.find(incStmt.getDesignator().obj.getName());
			if(!checkType(dummy.getKind())) 
				reportError("Greska na liniji " + incStmt.getLine() + ": " + dummy.getName() + " mora biti promenljiva, element niza ili objekat klase.", null);
			
			if(dummy.getType().getKind() == Struct.Array) {
				if(dummy.getType().getElemType() != Tab.intType) 
					reportError("Greska na liniji " + incStmt.getLine() + ": " + dummy.getName() + " mora biti tipa int.", null);
			}else 
				if(dummy.getType() != Tab.intType) 
					reportError("Greska na liniji " + incStmt.getLine() + ": " + dummy.getName() + " mora biti tipa int.", null);
			
		}else reportErrorNoDeclared(incStmt.getLine(), incStmt.getDesignator().obj.getName());
	}
	
	
	
	// ********** DECREMENT **********
	public void visit(Decrement decStmt) {
		if(isDeclared(decStmt.getDesignator().obj.getName())){
			
			Obj dummy = Tab.find(decStmt.getDesignator().obj.getName());
			if(!checkType(dummy.getKind())) 
				reportError("Greska na liniji " + decStmt.getLine() + ": " + dummy.getName() + " mora biti promenljiva, element niza ili objekat klase.", null);
			
			if(dummy.getType().getKind() == Struct.Array) {
				if(dummy.getType().getElemType() != Tab.intType) 
					reportError("Greska na liniji " + decStmt.getLine() + ": " + dummy.getName() + " mora biti tipa int.", null);
			}else 
				if(dummy.getType() != Tab.intType) 
					reportError("Greska na liniji " + decStmt.getLine() + ": " + dummy.getName() + " mora biti tipa int.", null);
		
		}else reportErrorNoDeclared(decStmt.getLine(), decStmt.getDesignator().obj.getName());
	}
	
	
	
	// ********** ASSIGNMENT **********
	public void visit(Assignment assignStmt) {
		
		if(assignStmt.getDesignator().obj != Tab.noObj && assignStmt.getExpr().struct != Tab.noType){
			
			Struct left = assignStmt.getDesignator().obj.getType();
			Struct right = assignStmt.getExpr().struct;
			
			if(!newAssignment) {
				//reportInfo("Levi tip je: " + left.getKind(), null);
				//reportInfo("Desni tip je: " + right.getKind(), null);
				
				if(left.getKind() == right.getKind()) {
					if(!right.assignableTo(left)) 
						reportError("Greska na liniji " + assignStmt.getLine() + ": Tipovi nisu kompatibilni. ", null);
				}else reportError("Greska na liniji " + assignStmt.getLine() + ": Tipovi nisu ni isti.", null);
				
			}else{
				newAssignment = false;
				if(!right.compatibleWith(left.getElemType())) {
					reportError("Greska na liniji " + assignStmt.getLine() + ": Tipovi moraju biti kompatibilni pri alociranju.", null);
				}	
			}
		}
	}

	
	
	// ********** DESIGNATOR **********
	public void visit(Designator designator) {
		designator.obj = Tab.find(designator.obj.getName());
	}
	
	public void visit(ArrayPrepare arrPrepare) {
		if(((DesignatorArray)arrPrepare.getParent()).obj != Tab.noObj) {
			arrPrepare.obj = Tab.find(((DesignatorArray)arrPrepare.getParent()).getDesignatorName().getDesignName());
		}
	}
	
	public void visit(DesignatorArray desArray) {
		
		desArray.obj = Tab.find(desArray.getDesignatorName().getDesignName());
		
		StringBuilder sb = new StringBuilder();
		if(desArray.getExpr().struct != Tab.noType) {
			
			if(desArray.getExpr().struct.getKind() != Struct.Int) reportError("Greska na liniji " + desArray.getLine() + ": Izraz unutar zagrada mora biti tipa int.", null);
			else {
				sb.append("Linija "+ desArray.getLine() + ": " +  desArray.getDesignatorName().getDesignName());
				if(isDeclared(desArray.obj.getName())) {
					if(desArray.obj.getType().getKind() == Struct.Array) {
						sb.append(" - pronadjeno!\t" + myTableVisitor.printObjNode(desArray.obj));
						reportInfo(sb.toString(), desArray);
						desArray.obj = new Obj(Obj.Elem, desArray.getDesignatorName().getDesignName(), desArray.obj.getType().getElemType(), desArray.obj.getAdr(), desArray.obj.getLevel());
					}else {
						reportError("Greska na liniji " + desArray.getLine() + ": " + desArray.getDesignatorName().getDesignName() + " nije niz.", null);
						desArray.obj = Tab.noObj;
					}
				}else reportErrorNoDeclared(desArray.getLine(), desArray.obj.getName());
			}
		}else desArray.obj = Tab.noObj;
		
	}
	
	public void visit(DesignatorSingle desSingle) {
		
		desSingle.obj = Tab.find(desSingle.getDesignatorName().getDesignName());
		
		StringBuilder sb = new StringBuilder();	
		if(desSingle.obj != Tab.noObj) {
				sb.append("Linija "+ desSingle.getLine() + ": " +  desSingle.getDesignatorName().getDesignName());
				sb.append(" - pronadjeno!\t" + myTableVisitor.printObjNode(desSingle.obj));
				reportInfo(sb.toString(), desSingle);
		}else reportErrorNoDeclared(desSingle.getLine(), desSingle.getDesignatorName().getDesignName());
	}
	
	public void visit(DesignStatement dStmt) {
		stmtCnt++;
	}
	
	
	
	// ********** TERNARY OPERATOR **********
	public void visit(TernaryOption tern) {
		tern.struct = tern.getTernaryOperator().struct;
	}
	
	public void visit(TernaryOperator ternaryOperator) {
		if(ternaryOperator.getExpr11().struct != ternaryOperator.getExpr12().struct) {
			reportError("Greska na liniji " + ternaryOperator.getLine() + ": Drugi i treci izraz moraju biti istog tipa.", null);
			ternaryOperator.struct = Tab.noType;
		}else 
			ternaryOperator.struct = ternaryOperator.getExpr11().struct;
	}
	
	
	
	// ********** EXPR1 **********
	public void visit(Expr1Option expr1Decl) {
		expr1Decl.struct = expr1Decl.getExpr1().struct;
		//reportInfo("Expr1Option - Kind: " + expr1Decl.struct.getKind(), null);
	}
	
	public void visit(Expr1 expr1) {
		
		
		boolean okComp = true, okInt = true;
		//proveravam za sve u addopTermListi da li su kompatibilni i da li su tipa int
		for(Struct term:termList) {
			if(term.getKind() != Struct.Int) okInt = false;
			if(!expr1.struct.compatibleWith(term)) okComp = false;
		}
		termList.clear();
		if(!(okComp && okInt)) {
			if(!okInt) reportError("Greska na liniji " + expr1.getLine() + ": Ulancani izrazi moraju biti tipa int.",null);
			if(!okComp) reportError("Greska na liniji " + expr1.getLine()+ ": Tipovi u ulancanoj strukturi nisu kompatibilni.", null);			
			expr1.struct = Tab.noType;
		}
	}
	
	public void visit(Expr1Minus expr1) {
		expr1.struct = expr1.getTerm().struct;
	}
	
	public void visit(Expr1NoMinus expr1) {
		expr1.struct = expr1.getTerm().struct;
	}
	
	// ********** TERM **********
	public void visit(AddTermDecl addTerm) {
		if(addTerm.getTerm().struct != Tab.noType) {
			addTerm.struct = addTerm.getTerm().struct;
			termList.add(addTerm.getTerm().struct);
		}	
	}

	public void visit(SubTermDecl subTerm) {
		if(subTerm.getTerm().struct != Tab.noType) {
			subTerm.struct = subTerm.getTerm().struct;
			termList.add(subTerm.getTerm().struct);
		}	
	}
	
	public void visit(Term term) {
		 term.struct = term.getFactor().struct;
		//reportInfo("Term - Kind:" + term.struct.getKind(), null);
		//proveravam za sve u addopTermListi da li su kompatibilni
		boolean okInt = true, okComp = true;
		for(Struct f:factorList) {
			if(f.getKind() != Struct.Int) okInt = false;
			if(!term.struct.compatibleWith(f)) okComp = false;
		}
		
		factorList.clear();
		if(okInt && okComp) term.struct = term.getFactor().struct;
		else {
			if(!okInt) reportError("Greska na liniji " + term.getLine() + ": Ulancani izrazi moraju biti tipa int.",null);
			if(!okComp) reportError("Greska na liniji " + term.getLine()+ ": Tipovi u ulancanoj strukturi nisu kompatibilni.", null);
			term.struct = Tab.noType;
		}
	}
	
	
	
	// ********** FACTOR **********
	public void visit(MulopFactor mulopFactor) {
		if(mulopFactor.getFactor().struct != Tab.noType) {
			mulopFactor.struct = mulopFactor.getFactor().struct;
			factorList.add(mulopFactor.getFactor().struct);
		}
	}
	
	public void visit(FactorDesignator fDesignator) {
		if(fDesignator.getDesignator().obj != Tab.noObj) fDesignator.struct = fDesignator.getDesignator().obj.getType();
		else fDesignator.struct = Tab.noType;
	}
	
	public void visit(FactorNum fNum) {
		fNum.struct = Tab.intType;
		fNum.struct.setElementType(Tab.noType);
	}
	
	public void visit(FactorChar fChar) {
		fChar.struct = Tab.charType;
		fChar.struct.setElementType(Tab.noType);
	}
	
	public void visit(FactorBool fBool) {
		fBool.struct = boolType;
		fBool.struct.setElementType(Tab.noType);
	}
	
	public void visit(FactorExpr fExpr) {
		fExpr.struct = fExpr.getExpr().struct;
	}
	
	public void visit(FactorNew fNew) {
		if(fNew.getExpr().struct != Tab.intType) {
			reportError("Greska na liniji " + fNew.getLine() + ".  Unutar zagrada mora biti tipa int.", null);
			fNew.struct = Tab.noType;
		}else {
			newAssignment = true;
			fNew.struct = fNew.getType().struct;
		}
	}
	
//	public void visit(Modification mod) {
//		mod.struct = mod.getDesignator().obj.getType().getElemType();
//	}
	
	
	// ********** PRINT NUMBERS **********
	public String printNumbers() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n=====================SEMANTICKA OBRADA=====================\n");
		sb.append(classCnt + "     classes\n");
		sb.append(methodCnt  + "     methods in the program\n");
		sb.append(globalVarCnt + "     global variables\n");
		sb.append(globalConCnt + "     global constants\n");
		sb.append(globalArrCnt + "     global arrays\n");
		sb.append(localVarCnt + "     local variables in main\n");
		sb.append(stmtCnt + (stmtCnt>10?"":" ") + "    statements in main");
		return sb.toString();
	}
	
	public String printProgramLocals() {
		StringBuilder sb = new StringBuilder();
		reportInfo("" + Tab.find(imePrograma).getLocalSymbols().size(),null);
		
		for(Obj o:Tab.find(imePrograma).getLocalSymbols()) 
			sb.append(o.getName() + " "+ o.getKind());
		
		return sb.toString();
	}
}
