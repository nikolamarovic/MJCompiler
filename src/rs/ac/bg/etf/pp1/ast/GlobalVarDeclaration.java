// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclaration extends GlobalVarDecl {

    private Type Type;
    private GlobalVarParsList GlobalVarParsList;

    public GlobalVarDeclaration (Type Type, GlobalVarParsList GlobalVarParsList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.GlobalVarParsList=GlobalVarParsList;
        if(GlobalVarParsList!=null) GlobalVarParsList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public GlobalVarParsList getGlobalVarParsList() {
        return GlobalVarParsList;
    }

    public void setGlobalVarParsList(GlobalVarParsList GlobalVarParsList) {
        this.GlobalVarParsList=GlobalVarParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(GlobalVarParsList!=null) GlobalVarParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(GlobalVarParsList!=null) GlobalVarParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(GlobalVarParsList!=null) GlobalVarParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarParsList!=null)
            buffer.append(GlobalVarParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclaration]");
        return buffer.toString();
    }
}
