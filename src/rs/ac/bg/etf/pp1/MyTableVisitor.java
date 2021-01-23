package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class MyTableVisitor extends DumpSymbolTableVisitor {
	
	@Override
	public void visitStructNode(Struct structToVisit) {
		super.visitStructNode(structToVisit);
		switch (structToVisit.getKind()) {
		case Struct.Bool:
			output.append("boolType");
		break;
		}
	}
	
	
	
	public String printObjNode(Obj objToVisit) {
		output.setLength(0);
		this.visitObjNode(objToVisit);
		String tmp = new String(super.output.toString());
		output.setLength(0);
		return tmp.toString();
	}
}
