/*
 * 
 */
package compiler.tree;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {
	
	/** The Branche. */
	private Node Branche[];
	
	/** The nb branche. */
	private int nbBranche;
	
	/** The type. */
	private Type type;
	
	/** The Value. */
	private String Value;
	
	/** The ops. */
	private Operations ops;
	
	
	/**
	 * Instantiates a new node.
	 *
	 * @param nbBranche the nb branche
	 * @param type the type
	 * @param nom the nom
	 */
	public Node (int nbBranche, Type type, String nom){
		this.nbBranche=nbBranche;
		this.Branche = new Node[nbBranche];
		this.type=type;
		this.Value=nom;
	}
	
	
	/**
	 * Instantiates a new node.
	 *
	 * @param nbBranche the nb branche
	 * @param value the value
	 * @param ops the ops
	 */
	public Node(int nbBranche, String value, Operations ops) {
		super();
		this.nbBranche = nbBranche;
		Value = value;
		this.ops = ops;
	}


	/**
	 * Instantiates a new node.
	 *
	 * @param branche the branche
	 * @param value the value
	 * @param ops the ops
	 */
	public Node(Node[] branche, String value, Operations ops) {
		super();
		Branche = branche;
		Value = value;
		this.ops = ops;
	}


	
	/**
	 * Instantiates a new node.
	 *
	 * @param branche the branche
	 * @param nbBranche the nb branche
	 * @param type the type
	 * @param value the value
	 * @param ops the ops
	 */
	public Node(Node[] branche, int nbBranche, Type type, String value,
			Operations ops) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		this.type = type;
		Value = value;
		this.ops = ops;
	}


	/**
	 * Instantiates a new node.
	 *
	 * @param branche the branche
	 * @param nbBranche the nb branche
	 * @param value the value
	 * @param ops the ops
	 */
	public Node(Node[] branche, int nbBranche, String value, Operations ops) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		Value = value;
		this.ops = ops;
	}

	
	/**
	 * Instantiates a new node.
	 */
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Instantiates a new node.
	 *
	 * @param branche the branche
	 * @param nbBranche the nb branche
	 * @param type the type
	 * @param nom the nom
	 */
	public Node(Node[] branche, int nbBranche, Type type, String nom) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		this.type = type;
		this.Value = nom;
	}

	
	/**
	 * Sets the branche.
	 *
	 * @param x the x
	 * @param n the n
	 */
	public void setBranche(int x, Node n){
		if ( x>0 && x<nbBranche-1){
			this.Branche[x]=n;
		}
		else{
			//on fait quoi ?
		}
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom(){
		return this.Value;
	}


	/**
	 * Gets the branche.
	 *
	 * @return the branche
	 */
	public Node[] getBranche() {
		return Branche;
	}


	/**
	 * Sets the branche.
	 *
	 * @param branche the new branche
	 */
	public void setBranche(Node[] branche) {
		Branche = branche;
	}


	/**
	 * Gets the nb branche.
	 *
	 * @return the nb branche
	 */
	public int getNbBranche() {
		return nbBranche;
	}


	/**
	 * Sets the nb branche.
	 *
	 * @param nbBranche the new nb branche
	 */
	public void setNbBranche(int nbBranche) {
		this.nbBranche = nbBranche;
	}


	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}


	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Type type) {
		this.type = type;
	}


	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.Value = nom;
	}



	
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return Value;
	}


	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		Value = value;
	}


	/**
	 * Gets the ops.
	 *
	 * @return the ops
	 */
	public Operations getOps() {
		return ops;
	}


	/**
	 * Sets the ops.
	 *
	 * @param ops the new ops
	 */
	public void setOps(Operations ops) {
		this.ops = ops;
	}



	

}