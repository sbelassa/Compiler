package compiler.otherentities;

public class Atom extends Node{
	
	private String code;
	private AtomType aType;
	private int action;
	
	
	
	public Atom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atom(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	public Atom(String code, AtomType aType, int action) {
		super(null, null);
		this.code = code;
		this.aType = aType;
		this.action = action;
	}

	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AtomType getaType() {
		return aType;
	}

	public void setaType(AtomType aType) {
		this.aType = aType;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	
	
	
	public String toString() {
		return "Atom [code=" + code + ", aType=" + aType + ", action=" + action + "]";
	}

	@Override
	public String printNode(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
