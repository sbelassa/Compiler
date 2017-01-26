package compiler.tree;

public class Node {
	
	private Node Branche[];
	private int nbBranche;
	private Type type;
	private String Value;
	private Operations ops;
	
	
	public Node (int nbBranche, Type type, String nom){
		this.nbBranche=nbBranche;
		this.Branche = new Node[nbBranche];
		this.type=type;
		this.Value=nom;
	}
	
	
	public Node(int nbBranche, String value, Operations ops) {
		super();
		this.nbBranche = nbBranche;
		Value = value;
		this.ops = ops;
	}


	public Node(Node[] branche, String value, Operations ops) {
		super();
		Branche = branche;
		Value = value;
		this.ops = ops;
	}


	
	public Node(Node[] branche, int nbBranche, Type type, String value,
			Operations ops) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		this.type = type;
		Value = value;
		this.ops = ops;
	}


	public Node(Node[] branche, int nbBranche, String value, Operations ops) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		Value = value;
		this.ops = ops;
	}

	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Node(Node[] branche, int nbBranche, Type type, String nom) {
		super();
		Branche = branche;
		this.nbBranche = nbBranche;
		this.type = type;
		this.Value = nom;
	}

	
	public void setBranche(int x, Node n){
		if ( x>0 && x<nbBranche-1){
			this.Branche[x]=n;
		}
		else{
			//on fait quoi ?
		}
	}

	public String getNom(){
		return this.Value;
	}


	public Node[] getBranche() {
		return Branche;
	}


	public void setBranche(Node[] branche) {
		Branche = branche;
	}


	public int getNbBranche() {
		return nbBranche;
	}


	public void setNbBranche(int nbBranche) {
		this.nbBranche = nbBranche;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public void setNom(String nom) {
		this.Value = nom;
	}




	

}
