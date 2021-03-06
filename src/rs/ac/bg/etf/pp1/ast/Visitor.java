// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(PostDesignStatement PostDesignStatement);
    public void visit(ArrayExprList ArrayExprList);
    public void visit(Mulop Mulop);
    public void visit(Relop Relop);
    public void visit(MethodVarList MethodVarList);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(ProgramDeclList ProgramDeclList);
    public void visit(MethodRetType MethodRetType);
    public void visit(GlobalVarParsDecl GlobalVarParsDecl);
    public void visit(PrintConsts PrintConsts);
    public void visit(StatementList StatementList);
    public void visit(ConstDeclVal ConstDeclVal);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(Designator Designator);
    public void visit(VarParsList VarParsList);
    public void visit(RelopExprList RelopExprList);
    public void visit(RelopExpr RelopExpr);
    public void visit(FormParsList FormParsList);
    public void visit(MinusList MinusList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ArrayExprDecl ArrayExprDecl);
    public void visit(ClassMethodOption ClassMethodOption);
    public void visit(MonkeyHelp MonkeyHelp);
    public void visit(Expr Expr);
    public void visit(Expr1 Expr1);
    public void visit(GlobalVarParsList GlobalVarParsList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ProgramList ProgramList);
    public void visit(ClassVarList ClassVarList);
    public void visit(SingleFormPars SingleFormPars);
    public void visit(ArrayBrace ArrayBrace);
    public void visit(ExtendsOption ExtendsOption);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(AddopTerm AddopTerm);
    public void visit(ClassDecl ClassDecl);
    public void visit(VarParsDecl VarParsDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(AddopTermList AddopTermList);
    public void visit(ModDecl ModDecl);
    public void visit(DivDecl DivDecl);
    public void visit(MulDecl MulDecl);
    public void visit(GreaterOrEqual GreaterOrEqual);
    public void visit(LessOrEqual LessOrEqual);
    public void visit(Less Less);
    public void visit(Greater Greater);
    public void visit(NotEqual NotEqual);
    public void visit(EqualTo EqualTo);
    public void visit(FactorNew FactorNew);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(MulopFactor MulopFactor);
    public void visit(NoMulopFactorListDecls NoMulopFactorListDecls);
    public void visit(MulopFactorListDecls MulopFactorListDecls);
    public void visit(SubTermDecl SubTermDecl);
    public void visit(AddTermDecl AddTermDecl);
    public void visit(NoAddopTermList NoAddopTermList);
    public void visit(AddopTermListDecl AddopTermListDecl);
    public void visit(Term Term);
    public void visit(MinusTermHelp MinusTermHelp);
    public void visit(Expr1NoMinus Expr1NoMinus);
    public void visit(Expr1Minus Expr1Minus);
    public void visit(TernaryPrepare2 TernaryPrepare2);
    public void visit(TernaryPrepare1 TernaryPrepare1);
    public void visit(TernaryOperator TernaryOperator);
    public void visit(Expr1Option Expr1Option);
    public void visit(TernaryOption TernaryOption);
    public void visit(ArrayPrepare ArrayPrepare);
    public void visit(DesignatorName DesignatorName);
    public void visit(DesignatorSingle DesignatorSingle);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(Modification Modification);
    public void visit(Assignment Assignment);
    public void visit(Decrement Decrement);
    public void visit(Increment Increment);
    public void visit(PrintConst PrintConst);
    public void visit(NoPrintConsts NoPrintConsts);
    public void visit(HasPrintConsts HasPrintConsts);
    public void visit(DesignStatement DesignStatement);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(StatementDerived1 StatementDerived1);
    public void visit(NoStatementListDeclarations NoStatementListDeclarations);
    public void visit(StatementListDeclarations StatementListDeclarations);
    public void visit(SingleFormParsDecl SingleFormParsDecl);
    public void visit(FormParamsDeclaration FormParamsDeclaration);
    public void visit(FormParamsDeclarations FormParamsDeclarations);
    public void visit(NoFormParams NoFormParams);
    public void visit(FormParams FormParams);
    public void visit(NoMethodVarDeclarations NoMethodVarDeclarations);
    public void visit(MethodVarDeclarations MethodVarDeclarations);
    public void visit(VoidRetType VoidRetType);
    public void visit(OtherRetType OtherRetType);
    public void visit(MethodName MethodName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDeclaration NoMethodDeclaration);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoExtendsOption NoExtendsOption);
    public void visit(ExtendsOptionDeclaration ExtendsOptionDeclaration);
    public void visit(NoClassVarDeclarations NoClassVarDeclarations);
    public void visit(ClassVarDeclarations ClassVarDeclarations);
    public void visit(NoClassMethodOptionDeclaration NoClassMethodOptionDeclaration);
    public void visit(ClassMethodOptionDeclaration ClassMethodOptionDeclaration);
    public void visit(ClassName ClassName);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(ConstName ConstName);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstDeclSingle ConstDeclSingle);
    public void visit(NoConstListDeclarations NoConstListDeclarations);
    public void visit(ConstListDeclarations ConstListDeclarations);
    public void visit(ConstDecl ConstDecl);
    public void visit(LocalVar LocalVar);
    public void visit(LocalVarArray LocalVarArray);
    public void visit(ErrorLocalVarSemi ErrorLocalVarSemi);
    public void visit(VarParam VarParam);
    public void visit(VarParams VarParams);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ErrorGlobalComma1 ErrorGlobalComma1);
    public void visit(GlobalVar GlobalVar);
    public void visit(GlobalVarArray GlobalVarArray);
    public void visit(GlobalVarSingle GlobalVarSingle);
    public void visit(GlobalVarParams GlobalVarParams);
    public void visit(GlobalVarDeclaration GlobalVarDeclaration);
    public void visit(GlobalClassList GlobalClassList);
    public void visit(GlobalConstList GlobalConstList);
    public void visit(GlobalVarList GlobalVarList);
    public void visit(NoProgramList NoProgramList);
    public void visit(ProgramListDecls ProgramListDecls);
    public void visit(Type Type);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
