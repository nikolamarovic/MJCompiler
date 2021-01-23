// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class FormParamsDeclarations extends FormParsList {

    private FormParsList FormParsList;
    private SingleFormPars SingleFormPars;

    public FormParamsDeclarations (FormParsList FormParsList, SingleFormPars SingleFormPars) {
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.SingleFormPars=SingleFormPars;
        if(SingleFormPars!=null) SingleFormPars.setParent(this);
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
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
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(SingleFormPars!=null) SingleFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(SingleFormPars!=null) SingleFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(SingleFormPars!=null) SingleFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamsDeclarations(\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleFormPars!=null)
            buffer.append(SingleFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamsDeclarations]");
        return buffer.toString();
    }
}
