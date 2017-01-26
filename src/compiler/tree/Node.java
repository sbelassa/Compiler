package compiler.tree;

public class Node {
	
	private Node Branche[];
	private int nbBranche;
	private Type type;
	private String nom;
	
	
	public Node (int nbBranche, Type type, String nom){
		this.nbBranche=nbBranche;
		this.Branche = new Node[nbBranche];
		this.type=type;
		this.nom=nom;
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
		return this.nom;
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
		this.nom = nom;
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
		this.nom = nom;
	}
	

}
