// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class TernaryOperator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Expr1 Expr1;
    private TernaryPrepare1 TernaryPrepare1;
    private Expr1 Expr11;
    private TernaryPrepare2 TernaryPrepare2;
    private Expr1 Expr12;

    public TernaryOperator (Expr1 Expr1, TernaryPrepare1 TernaryPrepare1, Expr1 Expr11, TernaryPrepare2 TernaryPrepare2, Expr1 Expr12) {
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
        this.TernaryPrepare1=TernaryPrepare1;
        if(TernaryPrepare1!=null) TernaryPrepare1.setParent(this);
        this.Expr11=Expr11;
        if(Expr11!=null) Expr11.setParent(this);
        this.TernaryPrepare2=TernaryPrepare2;
        if(TernaryPrepare2!=null) TernaryPrepare2.setParent(this);
        this.Expr12=Expr12;
        if(Expr12!=null) Expr12.setParent(this);
    }

    public Expr1 getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr1 Expr1) {
        this.Expr1=Expr1;
    }

    public TernaryPrepare1 getTernaryPrepare1() {
        return TernaryPrepare1;
    }

    public void setTernaryPrepare1(TernaryPrepare1 TernaryPrepare1) {
        this.TernaryPrepare1=TernaryPrepare1;
    }

    public Expr1 getExpr11() {
        return Expr11;
    }

    public void setExpr11(Expr1 Expr11) {
        this.Expr11=Expr11;
    }

    public TernaryPrepare2 getTernaryPrepare2() {
        return TernaryPrepare2;
    }

    public void setTernaryPrepare2(TernaryPrepare2 TernaryPrepare2) {
        this.TernaryPrepare2=TernaryPrepare2;
    }

    public Expr1 getExpr12() {
        return Expr12;
    }

    public void setExpr12(Expr1 Expr12) {
        this.Expr12=Expr12;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr1!=null) Expr1.accept(visitor);
        if(TernaryPrepare1!=null) TernaryPrepare1.accept(visitor);
        if(Expr11!=null) Expr11.accept(visitor);
        if(TernaryPrepare2!=null) TernaryPrepare2.accept(visitor);
        if(Expr12!=null) Expr12.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
        if(TernaryPrepare1!=null) TernaryPrepare1.traverseTopDown(visitor);
        if(Expr11!=null) Expr11.traverseTopDown(visitor);
        if(TernaryPrepare2!=null) TernaryPrepare2.traverseTopDown(visitor);
        if(Expr12!=null) Expr12.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        if(TernaryPrepare1!=null) TernaryPrepare1.traverseBottomUp(visitor);
        if(Expr11!=null) Expr11.traverseBottomUp(visitor);
        if(TernaryPrepare2!=null) TernaryPrepare2.traverseBottomUp(visitor);
        if(Expr12!=null) Expr12.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TernaryOperator(\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryPrepare1!=null)
            buffer.append(TernaryPrepare1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr11!=null)
            buffer.append(Expr11.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernaryPrepare2!=null)
            buffer.append(TernaryPrepare2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr12!=null)
            buffer.append(Expr12.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TernaryOperator]");
        return buffer.toString();
    }
}
