/*
 * 
 */
package compiler.otherentities;

// TODO: Auto-generated Javadoc
/**
 * The Class Atom.
 */
public class Atom extends Node{
	
	/** The code. */
	private String code;
	
	/** The a type. */
	private AtomType aType;
	
	/** The action. */
	private int action;
	
	
	
	/**
	 * Instantiates a new atom.
	 */
	public Atom() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new atom.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public Atom(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new atom.
	 *
	 * @param code the code
	 * @param aType the a type
	 * @param action the action
	 */
	public Atom(String code, AtomType aType, int action) {
		super(null, null);
		this.code = code;
		this.aType = aType;
		this.action = action;
	}

	
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the a type.
	 *
	 * @return the a type
	 */
	public AtomType getaType() {
		return aType;
	}

	/**
	 * Sets the a type.
	 *
	 * @param aType the new a type
	 */
	public void setaType(AtomType aType) {
		this.aType = aType;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public int getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(int action) {
		this.action = action;
	}

	
	
	
	/* (non-Javadoc)
	 * @see compiler.otherentities.Node#toString()
	 */
	public String toString() {
		return "Atom [code=" + code + ", aType=" + aType + ", action=" + action + "]";
	}

	/* (non-Javadoc)
	 * @see compiler.otherentities.Node#printNode(java.lang.String)
	 */
	@Override
	public String printNode(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
