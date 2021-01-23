// generated with ast extension for cup
// version 0.8
// 18/0/2021 23:35:19


package rs.ac.bg.etf.pp1.ast;

public class Expr1Minus extends Expr1 {

    private Term Term;
    private MinusTermHelp MinusTermHelp;
    private AddopTermList AddopTermList;

    public Expr1Minus (Term Term, MinusTermHelp MinusTermHelp, AddopTermList AddopTermList) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.MinusTermHelp=MinusTermHelp;
        if(MinusTermHelp!=null) MinusTermHelp.setParent(this);
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public MinusTermHelp getMinusTermHelp() {
        return MinusTermHelp;
    }

    public void setMinusTermHelp(MinusTermHelp MinusTermHelp) {
        this.MinusTermHelp=MinusTermHelp;
    }

    public AddopTermList getAddopTermList() {
        return AddopTermList;
    }

    public void setAddopTermList(AddopTermList AddopTermList) {
        this.AddopTermList=AddopTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(MinusTermHelp!=null) MinusTermHelp.accept(visitor);
        if(AddopTermList!=null) AddopTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(MinusTermHelp!=null) MinusTermHelp.traverseTopDown(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(MinusTermHelp!=null) MinusTermHelp.traverseBottomUp(visitor);
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr1Minus(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MinusTermHelp!=null)
            buffer.append(MinusTermHelp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr1Minus]");
        return buffer.toString();
    }
}
