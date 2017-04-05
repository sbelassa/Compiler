/*
 * 
 */
package compiler.entities;

/**
 * The Class Conc.
 */
public class Conc extends Node{

	/**
	 * Instantiates a new conc.
	 */
	public Conc() {
		super();
	}

	/**
	 * Instantiates a new conc.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public Conc(Node left, Node right) {
		super(left, right);
	}

	/** (non-Javadoc)
	 * @see compiler.otherentities.Node#toString()
	 */
	@Override
	public String toString() {
		return "Conc";
	}
	
	

	
	
}
