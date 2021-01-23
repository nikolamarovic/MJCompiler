// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class ProgramListDecls extends ProgramList {

    private ProgramList ProgramList;
    private ProgramDeclList ProgramDeclList;

    public ProgramListDecls (ProgramList ProgramList, ProgramDeclList ProgramDeclList) {
        this.ProgramList=ProgramList;
        if(ProgramList!=null) ProgramList.setParent(this);
        this.ProgramDeclList=ProgramDeclList;
        if(ProgramDeclList!=null) ProgramDeclList.setParent(this);
    }

    public ProgramList getProgramList() {
        return ProgramList;
    }

    public void setProgramList(ProgramList ProgramList) {
        this.ProgramList=ProgramList;
    }

    public ProgramDeclList getProgramDeclList() {
        return ProgramDeclList;
    }

    public void setProgramDeclList(ProgramDeclList ProgramDeclList) {
        this.ProgramDeclList=ProgramDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramList!=null) ProgramList.accept(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramList!=null) ProgramList.traverseTopDown(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramList!=null) ProgramList.traverseBottomUp(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramListDecls(\n");

        if(ProgramList!=null)
            buffer.append(ProgramList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDeclList!=null)
            buffer.append(ProgramDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramListDecls]");
        return buffer.toString();
    }
}
