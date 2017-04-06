/*
 * 
 */
package compiler.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Atom.
 */
public class Atom extends Node{
	
	/** The code. */
	private Integer code;
	
	/** The a type. */
	private AtomType aType;
	
	/** The action. */
	private int action;
	
	/** string */
	private String value;
	
	
	
	public Atom(Node left, Node right, int code, AtomType aType, int action, String value) {
		super(left, right);
		this.code = code;
		this.aType = aType;
		this.action = action;
		this.value = value;
	}
	
	public Atom(int code, AtomType aType, int action, String value) {
		this.code = code;
		this.aType = aType;
		this.action = action;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Instantiates a new atom.
	 */
	public Atom() {
		super();
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
	public Atom(int code, AtomType aType, int action) {
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
	public Integer getCode() {
		return code;
	}

	public Atom(Integer code, AtomType aType, int action, String value) {
		this.code = code;
		this.aType = aType;
		this.action = action;
		this.value = value;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(Integer code) {
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

	
	
	
	@Override
	public String toString() {
		return "Atom ==> code=" + code + ", aType=" + aType + ", action=" + action + ", value=" + value;
	}



}
