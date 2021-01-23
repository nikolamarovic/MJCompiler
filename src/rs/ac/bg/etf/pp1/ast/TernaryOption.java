// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class TernaryOption extends Expr {

    private TernaryOperator TernaryOperator;

    public TernaryOption (TernaryOperator TernaryOperator) {
        this.TernaryOperator=TernaryOperator;
        if(TernaryOperator!=null) TernaryOperator.setParent(this);
    }

    public TernaryOperator getTernaryOperator() {
        return TernaryOperator;
    }

    public void setTernaryOperator(TernaryOperator TernaryOperator) {
        this.TernaryOperator=TernaryOperator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TernaryOperator!=null) TernaryOperator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TernaryOperator!=null) TernaryOperator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TernaryOperator!=null) TernaryOperator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TernaryOption(\n");

        if(TernaryOperator!=null)
            buffer.append(TernaryOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TernaryOption]");
        return buffer.toString();
    }
}
