package compiler.test;

import compiler.entities.Grammar;
import compiler.tree.Node;
import compiler.tree.Type;

public class TestClass {

	public static void main(String[] args) {

		Node n= new Node();
		n.setType(Type.Conc);
		Grammar g=new Grammar(2);
		g.setTreeInForest(0, n);
		g.printTree(n);
		
		//System.out.println("yoyoyo3");
	}

}
