/*
 * 
 */
package compiler.entities;

/**
 * The Class Star.
 */
public class Star extends Node {

	/**
	 * Instantiates a new star.
	 */
	public Star() {
		super();
	}

	/**
	 * Instantiates a new star.
	 *
	 * @param node the node
	 */
	public Star(Node node) {
		super(node, null);
	}
	

	/** (non-Javadoc)
	 * @see compiler.otherentities.Node#toString()
	 */
	@Override
	public String toString() {
		return "Star";
	}


}
