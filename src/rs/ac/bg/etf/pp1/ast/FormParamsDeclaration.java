// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class FormParamsDeclaration extends FormParsList {

    private SingleFormPars SingleFormPars;

    public FormParamsDeclaration (SingleFormPars SingleFormPars) {
        this.SingleFormPars=SingleFormPars;
        if(SingleFormPars!=null) SingleFormPars.setParent(this);
    }

    public SingleFormPars getSingleFormPars() {
        return SingleFormPars;
    }

    public void setSingleFormPars(SingleFormPars SingleFormPars) {
        this.SingleFormPars=SingleFormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleFormPars!=null) SingleFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleFormPars!=null) SingleFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleFormPars!=null) SingleFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamsDeclaration(\n");

        if(SingleFormPars!=null)
            buffer.append(SingleFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamsDeclaration]");
        return buffer.toString();
    }
}
