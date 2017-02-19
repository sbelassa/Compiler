package compiler.test;

import compiler.entities.Grammar;
import compiler.tree.Node;
import compiler.tree.Operations;
import compiler.tree.Type;

public class TestClass {

	public static void main(String[] args) {

		Node n= new Node(2,"hghg",Operations.Conc);
		n.toString();
		//n.setType(Type.Conc);
		Grammar g=new Grammar(2);
		n= g.GenRule1();
		g.setTreeInForest(0, n);
		g.printTree(n);
		
		
		
	}

}
