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
	

}
