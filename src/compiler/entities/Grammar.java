package compiler.entities;
import compiler.tree.*;

public class Grammar {
	
	
	private Node[] forest;
	private int nbTree;
	
	
	public Grammar (int nbTree){
		this.forest = new Node[nbTree];
		this.nbTree= nbTree;
	}
	
	
	public Grammar(int nbTree, Node[] forest) {
		super();
		this.forest = forest;
		this.nbTree = nbTree;
	}

	
	public Grammar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void setTreeInForest(int x, Node n){
		if ( x>0 && x<nbTree-1){
			this.forest[x]=n;
		}
		else{


		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	


	public void GenForet(){
		 this.setTreeInForest(0, this.GenRule1());
		 this.setTreeInForest(2, this.GenRule3());
		 this.setTreeInForest(3, this.GenRule4());
	}
	
	
	
	private Node GenRule1(){
		Node  N = new Node (1,Type.NonTerminal,"N");
		Node  E = new Node (1,Type.NonTerminal,"E");
		Node  fl = new Node (1,Type.Terminal,"->");
		Node  vir = new Node (1,Type.Terminal,",");
		Node  pvir = new Node (1,Type.Terminal,";");
		
		return this.GenConc(GenStar(GenConc(GenConc(GenConc(N, fl), E), vir)), pvir);
	}
	
	
	private Node GenRule2(){
		
		
		return null;
		
	}
	
	
	private Node GenRule3(){
		Node  T = new Node (1,Type.NonTerminal,"T");
		Node  plus = new Node (1,Type.Terminal,"+");
		
		return this.GenConc(T, GenStar(GenConc(plus, T)));
	}
	
	
	
	private Node GenRule4(){
		Node  F = new Node (1,Type.NonTerminal,"F");
		Node  dot = new Node (1,Type.Terminal,".");
		
		return this.GenConc(F, GenStar(GenConc(dot, F)));
	}
	
	
	
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////	
	public Node GenConc (Node p1, Node p2){
		Node conc = new Node(3, Type.Conc, ".");
		conc.setBranche(0, p1);
		conc.setBranche(1, p2);
		return conc;
	}
	
	
	
	public Node GenUnion (Node p1, Node p2){
		Node union = new Node(3, Type.Union, "+");
		union.setBranche(0, p1);
		union.setBranche(1, p2);
		return union;
	}
	
	
	public Node GenStar (Node p){
		Node star = new Node(3, Type.Star, "*");
		Node Laccol = new Node (1,Type.Terminal,"[");
		Node Raccol = new Node (1,Type.Terminal,"]");
		star.setBranche(0, Laccol);
		star.setBranche(1, p);
		star.setBranche(2, Raccol);
		return star;
	}
	
	
	//p peut etre un node ou NULL 
	public Node GenUn (Node p){
		Node un = new Node(1,Type.Terminal, "U");
		un.setBranche(0, p);
		return un;
	}
	
	
	
	public Node GenAtom ( Node p){
		Node atom = new Node(1,Type.Atom,"A");
		atom.setBranche(0, p);
		return atom;
	}


	public Node[] getForest() {
		return forest;
	}


	public void setForest(Node[] forest) {
		this.forest = forest;
	}


	public int getNbTree() {
		return nbTree;
	}


	public void setNbTree(int nbTree) {
		this.nbTree = nbTree;
	}
	
	public void printTree(Node n)
	{		
		if(!n.equals(null)) {
			
			if(n.getType() == Type.Conc){
				System.out.println("Concat");
			}
			if(n.getType() == Type.Union){
				System.out.println("Union");
			}
			
		}
	}
	

}
