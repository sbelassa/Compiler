/*
 * 
 */
package compiler.test;
import compiler.tree.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Grammar.
 */
public class Grammar {
	
	
	/** The forest. */
	private Node[] forest;
	
	/** The nb tree. */
	private int nbTree;
	
	
	/**
	 * Instantiates a new grammar.
	 *
	 * @param nbTree the nb tree
	 */
	public Grammar (int nbTree){
		this.forest = new Node[nbTree];
		this.nbTree= nbTree;
	}
	
	
	/**
	 * Instantiates a new grammar.
	 *
	 * @param nbTree the nb tree
	 * @param forest the forest
	 */
	public Grammar(int nbTree, Node[] forest) {
		super();
		this.forest = forest;
		this.nbTree = nbTree;
	}

	
	/**
	 * Instantiates a new grammar.
	 */
	public Grammar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Sets the tree in forest.
	 *
	 * @param x the x
	 * @param n the n
	 */
	public void setTreeInForest(int x, Node n){
		if ( x>0 && x<nbTree-1){
			this.forest[x]=n;
		}
		else{


		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	


	/**
 * Gen foret.
 */
public void GenForet(){
		 setTreeInForest(0, this.GenRule1());
		 setTreeInForest(2, this.GenRule3());
		 setTreeInForest(3, this.GenRule4());
	}
	
	
	
	/**
	 * Gen rule 1.
	 *
	 * @return the node
	 */
	public Node GenRule1(){
		Node  N = GenAtom("N",0,Type.NonTerminal);
		Node  E = GenAtom("E",0,Type.NonTerminal);
		Node  fl = GenAtom("->",0,Type.Terminal);
		Node  vir = GenAtom(",",1,Type.Terminal);
		Node  pvir = GenAtom(";",0,Type.Terminal);
		
		return GenConc(GenStar(GenConc(GenConc(GenConc(N, fl), E), vir)), pvir);
	}
	
	
	/**
	 * Gen rule 2.
	 *
	 * @return the node
	 */
	private Node GenRule2(){
		
		
		return null;
		
	}
	
	
	/**
	 * Gen rule 3.
	 *
	 * @return the node
	 */
	//pif action
	private Node GenRule3(){
		Node  T = GenAtom("T",0,Type.NonTerminal);
		Node  plus = GenAtom("+",0,Type.NonTerminal);
		
		return this.GenConc(T, GenStar(GenConc(plus, T)));
	}
	
	
	
	/**
	 * Gen rule 4.
	 *
	 * @return the node
	 */
	private Node GenRule4(){
		Node  F = new Node (1,Type.NonTerminal,"F");
		Node  dot = new Node (1,Type.Terminal,".");
		
		return this.GenConc(F, GenStar(GenConc(dot, F)));
	}
	
	
	
	
	
	
	
	
/**
 * Gen conc.
 *
 * @param p1 the p 1
 * @param p2 the p 2
 * @return the node
 */
//////////////////////////////////////////////////////////////////////////////////////////////	
	public Node GenConc (Node p1, Node p2){
		Node conc = new Node(3, ".",Operations.Conc);
		conc.setBranche(0, p1);
		conc.setBranche(1, p2);
		return conc;
	}
	
	
	
	/**
	 * Gen union.
	 *
	 * @param p1 the p 1
	 * @param p2 the p 2
	 * @return the node
	 */
	public Node GenUnion (Node p1, Node p2){
		Node union = new Node(3, "+", Operations.Union);
		union.setBranche(0, p1);
		union.setBranche(1, p2);
		return union;
	}
	
	
	/**
	 * Gen star.
	 *
	 * @param p the p
	 * @return the node
	 */
	public Node GenStar (Node p){
		Node star = new Node(3, "*",Operations.Star);
		Node Laccol = new Node (1,Type.Terminal,"[");
		Node Raccol = new Node (1,Type.Terminal,"]");
		star.setBranche(0, Laccol);
		star.setBranche(1, p);
		star.setBranche(2, Raccol);
		return star;
	}
	
	
	/**
	 * Gen un.
	 *
	 * @param nom the nom
	 * @return the node
	 */
	//p peut etre un node ou NULL 
	public Node GenUn (String nom){
		Node un = new Node(0,Type.Terminal, nom);
		return un;
	}
	
	
	
	/**
	 * Gen atom.
	 *
	 * @param nom the nom
	 * @param action the action
	 * @param type the type
	 * @return the node
	 */
	public Node GenAtom ( String nom, int action, Type type){
		Node atom = new Node(0,type, nom);
		return atom;
	}


	/**
	 * Gets the forest.
	 *
	 * @return the forest
	 */
	public Node[] getForest() {
		return forest;
	}


	/**
	 * Sets the forest.
	 *
	 * @param forest the new forest
	 */
	public void setForest(Node[] forest) {
		this.forest = forest;
	}


	/**
	 * Gets the nb tree.
	 *
	 * @return the nb tree
	 */
	public int getNbTree() {
		return nbTree;
	}


	/**
	 * Sets the nb tree.
	 *
	 * @param nbTree the new nb tree
	 */
	public void setNbTree(int nbTree) {
		this.nbTree = nbTree;
	}
	
	/**
	 * Char printer.
	 *
	 * @param c the c
	 * @param cnt the cnt
	 */
	public void charPrinter(char c, int cnt){
	    int i;
	    for(i = 0; i < cnt; i++){
	        System.out.println(c);
	    }
	}
	
	/**
	 * Prints the tree.
	 *
	 * @param n the n
	 */
	public void printTree(Node n)
	{	
		int cnt=1;
		System.out.println("Printing Tree:");
		charPrinter('-', cnt*2);
		
		if(!n.equals(null)) {
			
			if(n.getOps() == Operations.Conc){
				System.out.println("Concat");
			}
			if(n.getOps() == Operations.Union){
				System.out.println("Union");
			}
			if(n.getOps() == Operations.Star){
				System.out.println("Star");
			}
			if(n.getOps() == Operations.Un){
				System.out.println("Un");
			}
			if(n.getOps() == Operations.Atom){
				System.out.println("Atom");
			}
			
		}
	}
	

}