// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class ErrorGlobalComma1 extends GlobalVarParsDecl {

    public ErrorGlobalComma1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrorGlobalComma1(\n");

        buffer.append(tab);
        buffer.append(") [ErrorGlobalComma1]");
        return buffer.toString();
    }
}
