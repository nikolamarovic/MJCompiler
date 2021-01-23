// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarParams extends GlobalVarParsList {

    private GlobalVarParsList GlobalVarParsList;
    private GlobalVarParsDecl GlobalVarParsDecl;

    public GlobalVarParams (GlobalVarParsList GlobalVarParsList, GlobalVarParsDecl GlobalVarParsDecl) {
        this.GlobalVarParsList=GlobalVarParsList;
        if(GlobalVarParsList!=null) GlobalVarParsList.setParent(this);
        this.GlobalVarParsDecl=GlobalVarParsDecl;
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.setParent(this);
    }

    public GlobalVarParsList getGlobalVarParsList() {
        return GlobalVarParsList;
    }

    public void setGlobalVarParsList(GlobalVarParsList GlobalVarParsList) {
        this.GlobalVarParsList=GlobalVarParsList;
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
        if(GlobalVarParsList!=null) GlobalVarParsList.accept(visitor);
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarParsList!=null) GlobalVarParsList.traverseTopDown(visitor);
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarParsList!=null) GlobalVarParsList.traverseBottomUp(visitor);
        if(GlobalVarParsDecl!=null) GlobalVarParsDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarParams(\n");

        if(GlobalVarParsList!=null)
            buffer.append(GlobalVarParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarParsDecl!=null)
            buffer.append(GlobalVarParsDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarParams]");
        return buffer.toString();
    }
}
