// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclSingle implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ConstName ConstName;
    private ConstDeclVal ConstDeclVal;

    public ConstDeclSingle (ConstName ConstName, ConstDeclVal ConstDeclVal) {
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
        this.ConstDeclVal=ConstDeclVal;
        if(ConstDeclVal!=null) ConstDeclVal.setParent(this);
    }

    public ConstName getConstName() {
        return ConstName;
    }

    public void setConstName(ConstName ConstName) {
        this.ConstName=ConstName;
    }

    public ConstDeclVal getConstDeclVal() {
        return ConstDeclVal;
    }

    public void setConstDeclVal(ConstDeclVal ConstDeclVal) {
        this.ConstDeclVal=ConstDeclVal;
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
        if(ConstName!=null) ConstName.accept(visitor);
        if(ConstDeclVal!=null) ConstDeclVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
        if(ConstDeclVal!=null) ConstDeclVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        if(ConstDeclVal!=null) ConstDeclVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclSingle(\n");

        if(ConstName!=null)
            buffer.append(ConstName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclVal!=null)
            buffer.append(ConstDeclVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclSingle]");
        return buffer.toString();
    }
}
