// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class VarParams extends VarParsList {

    private VarParsList VarParsList;
    private VarParsDecl VarParsDecl;

    public VarParams (VarParsList VarParsList, VarParsDecl VarParsDecl) {
        this.VarParsList=VarParsList;
        if(VarParsList!=null) VarParsList.setParent(this);
        this.VarParsDecl=VarParsDecl;
        if(VarParsDecl!=null) VarParsDecl.setParent(this);
    }

    public VarParsList getVarParsList() {
        return VarParsList;
    }

    public void setVarParsList(VarParsList VarParsList) {
        this.VarParsList=VarParsList;
    }

    public VarParsDecl getVarParsDecl() {
        return VarParsDecl;
    }

    public void setVarParsDecl(VarParsDecl VarParsDecl) {
        this.VarParsDecl=VarParsDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarParsList!=null) VarParsList.accept(visitor);
        if(VarParsDecl!=null) VarParsDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarParsList!=null) VarParsList.traverseTopDown(visitor);
        if(VarParsDecl!=null) VarParsDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarParsList!=null) VarParsList.traverseBottomUp(visitor);
        if(VarParsDecl!=null) VarParsDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarParams(\n");

        if(VarParsList!=null)
            buffer.append(VarParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarParsDecl!=null)
            buffer.append(VarParsDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarParams]");
        return buffer.toString();
    }
}
