/*
 * 
 */
package compiler.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public abstract class Node {
	
	
	/** The left. */
	private Node left;
	
	/** The right. */
	private Node right;
	
	
	/**
	 * Instantiates a new node.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public Node(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Instantiates a new node.
	 */
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Node [left=" + left + ", right=" + right + "]";
	}

	/**
	 * Prints the node.
	 *
	 * @param str the str
	 * @return the string
	 */
	public abstract String printNode(String str);


}
