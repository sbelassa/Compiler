/*
 * 
 */
package compiler.entities;

/**
 * The Class Union.
 */
public class Union extends Node{


	/**
	 * Instantiates a new union.
	 */
	public Union() {
		super();
	}

	/**
	 * Instantiates a new union.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public Union(Node left, Node right) {
		super(left, right);
	}

	/** (non-Javadoc)
	 * @see compiler.otherentities.Node#toString()
	 */
	@Override
	public String toString() {
		return "Union";
	}

	
	
}
