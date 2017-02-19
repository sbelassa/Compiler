package compiler.otherentities;

public abstract class Node {
	
	
	private Node left;
	private Node right;
	
	
	public Node(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	
	public String toString() {
		return "Node [left=" + left + ", right=" + right + "]";
	}

	public abstract String printNode(String str);


}
