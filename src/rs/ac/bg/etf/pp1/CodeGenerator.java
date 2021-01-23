package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	Logger log = Logger.getLogger(getClass());
	
	private int mainPc;
	private Obj progObj = null;
	
	private Obj printConst = Tab.noObj;
	
	private ArrayList<Integer> adr1List = new ArrayList<>();
	private ArrayList<Integer> adr2List = new ArrayList<>();
	
	private int mulopOption = -1;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(ProgramName prog) {
		progObj = Tab.find(prog.getProgName());
	}
	
	public void visit(MethodName methName) {
		
		if("main".equalsIgnoreCase(methName.getMethName())) {
			mainPc = Code.pc;
		}
		methName.obj.setAdr(Code.pc);
		
		Code.put(Code.enter);
		Code.put(0);
		Code.put(SemanticAnalyzer.localVarCnt);
	}
	
	public void visit(MethodDecl methDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	
	
	public void visit(PrintStatement print) {
		
		if(print.getExpr().struct != Tab.charType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		
		if(printConst!=Tab.noObj) {
			Code.load(printConst);
			Code.loadConst(5);
			Code.put(Code.print);
			printConst = Tab.noObj;
		}
	}
	
	public void visit(ReadStatement rd) {
		if(rd.getDesignator().obj.getType() == Tab.intType || rd.getDesignator().obj.getType() == SemanticAnalyzer.boolType) {
			Code.put(Code.read);
		}else {
			Code.put(Code.bread);
		}
		Code.store(rd.getDesignator().obj);
	}
	
	public void visit(PrintConst num) {
		printConst = new Obj(Obj.Con, "$", Tab.intType);
		printConst.setAdr(num.getN1());
	}
	
	public void visit(TernaryOperator ternOp) {
		
		Code.fixup(adr2List.get(0));
		adr2List.remove(0);
	}
	
	public void visit(TernaryPrepare1 tern) {
		Code.loadConst(0);//sa cime poredim  
		Code.put(Code.jcc + Code.eq);
		
		//tmpAdr1 = Code.pc; 
		adr1List.add(Code.pc);
		Code.put2(0);
	}	
	
	public void visit(TernaryPrepare2 tern) {
		Code.put(Code.jmp);
		
		//tmp2Adr = Code.pc;
		adr2List.add(Code.pc);
		Code.put2(0);
		
		//Code.fixup(tmpAdr1)
		Code.fixup(adr1List.get(adr1List.size()-1)); //ovde se postavlja adresa gde treba da se skoci ako je izraz false
		adr1List.remove(adr1List.size()-1);
	}
	
	public void visit(ArrayPrepare arrPrep) {
		Code.load(arrPrep.obj);	
	}
	
	public void visit(Assignment assignStmt) {
		Obj designatorObj = assignStmt.getDesignator().obj;
		Code.store(designatorObj);
	}
	
//	public void visit(Modification mod) {
//		
//	}
		
	public void visit(MinusTermHelp help) {
		Code.put(Code.neg);
	}
	
	public void visit(FactorDesignator fDes) {
		Code.load(fDes.getDesignator().obj); 
	}
	
	public void visit(FactorNum num) {
		Obj con = new Obj(Obj.Con, "$", num.struct);
		con.setAdr(num.getN1());
		Code.load(con);		
	}
	
	public void visit(FactorChar fChar) {
		Obj con = new Obj(Obj.Con, "$", fChar.struct);
		con.setAdr(fChar.getC1().charAt(0));
		Code.load(con);
	}

	public void visit(FactorBool fBool) {
		Obj b = new Obj(Obj.Con, "$", Tab.intType);
		
		if((fBool.getB1().equals("true") || fBool.getB1().equals("false"))) {
			if(fBool.getB1().equals("true")) b.setAdr(1);
			else b.setAdr(0);
		}
//		else {
//			if (fBool.getB1().contains("[a-zA-Z]+") == false){
//				int x = Integer.parseInt(fBool.getB1());
//				if(x>0) b.setAdr(1);
//				else b.setAdr(0);
//			}
//		}
		
		Code.load(b);
	}
	
	public void visit(Increment inc) {
		Obj design = inc.getDesignator().obj;
		if(inc.getDesignator() instanceof DesignatorArray) {
			Code.put(Code.dup2);
		}
		Code.load(design);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(design);
	}
	
	public void visit(Decrement dec) {
		Obj design = dec.getDesignator().obj;
		if(dec.getDesignator() instanceof DesignatorArray) {
			Code.put(Code.dup2);
		}
		Code.load(design);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(design);
	}
	
	public void visit(AddTermDecl addTerm) {
		Code.put(Code.add);
	}
	
	public void visit(SubTermDecl subTerm) {
		Code.put(Code.sub);
	}
	
	public void visit(MulopFactor mulopFactor) {
		switch(mulopOption) {
			case 0:
				Code.put(Code.mul);
				break;
			case 1:
				Code.put(Code.div);
				break;
			case 2:
				Code.put(Code.rem);
				break;
		}
	}
	
	public void visit(MulDecl mulDecl) {
		mulopOption = 0;
	}
	
	public void visit(DivDecl divDecl) {
		mulopOption = 1;
	}
	
	public void visit(ModDecl modDecl) {
		mulopOption = 2;
	}
	
	public void visit(FactorNew fNew) {
		Code.put(Code.newarray);
		if(fNew.struct.getKind() == Struct.Int) Code.put(1);
		else Code.put(0);
	}
}
