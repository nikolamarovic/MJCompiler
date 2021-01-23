// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarSingle extends GlobalVarParsList {

    private GlobalVarParsDecl GlobalVarParsDecl;

    public GlobalVarSingle (GlobalVarParsDecl GlobalVarParsDecl) {
        this.GlobalVarParsDecl=GlobalVarParsDecl;
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.setParent(this);
    }

    public GlobalVarParsDecl getGlobalVarParsDecl() {
        return GlobalVarParsDecl;
    }

    public void setGlobalVarParsDecl(GlobalVarParsDecl GlobalVarParsDecl) {
        this.GlobalVarParsDecl=GlobalVarParsDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarSingle(\n");

        if(GlobalVarParsDecl!=null)
            buffer.append(GlobalVarParsDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarSingle]");
        return buffer.toString();
    }
}
