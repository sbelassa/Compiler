package compiler.entities;

public class Stack {

	
	final static int SIZE = 40; // assez grand ?

	private int sp ;
	private Node [] t;

	
	/**
	 * Constructor
	 */
	public Stack () { // Construire une pile vide
	    t = new Node[SIZE] ; sp = 0;
	}
	
	
	
	/**
	 * Test is the Stack is empty
	 * @return
	 */
	public boolean isEmpty() { return sp == 0 ; }

	
	//
	public void push(Node x) {
		if (sp >= SIZE) throw new Error ("Push : pile pleine") ;
	    t[sp++] = x ; 
	}

	
	
	public Node pop() {
	    if (isEmpty()) throw new Error ("Pop : pile vide") ;
	    return t[--sp] ; 
	}
}
