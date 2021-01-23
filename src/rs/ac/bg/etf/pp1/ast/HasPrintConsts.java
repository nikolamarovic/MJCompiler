// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class HasPrintConsts extends PrintConsts {

    private PrintConst PrintConst;

    public HasPrintConsts (PrintConst PrintConst) {
        this.PrintConst=PrintConst;
        if(PrintConst!=null) PrintConst.setParent(this);
    }

    public PrintConst getPrintConst() {
        return PrintConst;
    }

    public void setPrintConst(PrintConst PrintConst) {
        this.PrintConst=PrintConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintConst!=null) PrintConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintConst!=null) PrintConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintConst!=null) PrintConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasPrintConsts(\n");

        if(PrintConst!=null)
            buffer.append(PrintConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasPrintConsts]");
        return buffer.toString();
    }
}
