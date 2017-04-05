/*
 * 
 */
package compiler.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Union.
 */
public class Union extends Node{

	/* (non-Javadoc)
	 * @see compiler.otherentities.Node#printNode(java.lang.String)
	 */
	@Override
	public String printNode(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Instantiates a new union.
	 */
	public Union() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new union.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public Union(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see compiler.otherentities.Node#toString()
	 */
	@Override
	public String toString() {
		return "Union";
	}

	
	
}
