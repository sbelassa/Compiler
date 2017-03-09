/*
 * 
 */
package compiler.otherentities;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The grammar containing rules.
 */
public class Grammar {
	
	/** The rules. */
	private ArrayList<Node> rules;
	
	

	/**
	 * Instantiates a new grammar.
	 *
	 * @param rules the rules
	 */
	public Grammar(ArrayList<Node> rules) {
		this.rules = rules;
	}



	/**
	 * Instantiates a new grammar.
	 */
	public Grammar() {
		rules= new ArrayList<Node>();

	}



	/**
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	public ArrayList<Node> getRules() {
		return rules;
	}



	/**
	 * Sets the rules.
	 *
	 * @param rules the new rules
	 */
	public void setRules(ArrayList<Node> rules) {
		this.rules = rules;
	}


	/**
	 * Adds the rule.
	 *
	 * @param rule the rule
	 */
	public void addRule(Node rule){
		rules.add(rule);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grammar [rules=" + rules + "]";
	}
	
	/**
	 * Char printer.
	 *
	 * @param c the c
	 * @param cnt the cnt
	 */
	/*!
	 * 
	 * just a dumb function to print a character the number of times we give
	 */
	public void charPrinter(char c, int cnt){
	    for(int i = 0; i < cnt; i++){
	        System.out.print(c);
	    }
	}
	
	
	/**
	 * printing a node using the dumb function to represent the levels of the tree nodes
	 * recursive printing.
	 *
	 * @param node the node
	 * @param cnt the cnt
	 */
	public void PrintNode(Node node,int cnt){
		
		charPrinter('-', cnt*2);/// two '-' representing one level
		System.out.println(node.toString());		
		
		if(node.getLeft()!=null){
			PrintNode(node.getLeft(),cnt+1);
		}
		//System.out.println("\n");
		if(node.getRight()!=null){
			
			PrintNode(node.getRight(), cnt+1);
		}
		
		
	}

	/**
	 * Prints the tree.
	 *
	 * @param ruleNum the rule num
	 */
	///printing the tree that contains the nodes just by calling the function that prints nodes
	public void PrintTree(int ruleNum){
		
		//if(rules.get(ruleNum))
		PrintNode(rules.get(ruleNum), 1);
	}
	
	
	/**
	 * 
	 * @param n
	 */
	public Boolean Analyse(Node node){
		
		if(node instanceof Conc){
			if(Analyse(node.getLeft())){
				return Analyse(node.getRight());
			}
			else
			{
				return false;
			}
		}
		
		if(node instanceof Union){
			if(Analyse(node.getLeft())){
				return true;
			}
			else{
				return Analyse(node.getRight());
			}
		}
		
		if(node instanceof Star){
			//FIXME check the algo
			return true;
			while(Analyse(node));
		}
		
		if(node instanceof Un){
			return Analyse(node.getLeft());
		}
		
		if(node instanceof Atom){
			
			if(((Atom) node).getaType() == AtomType.Terminal){
				if(((Atom) node).getCode() == code){ //code est rempli par le scan !!!!!?????
					return true;
					if(((Atom) node).getAction() != 0){
						G0Action(((Atom) node).getAction());
						Scan();
						}
					else
						return false;
					}
				}
			}
			
			else if(((Atom) node).getaType() == AtomType.NonTerminal){
				if(Analyse(((Atom) node).getCode())){
					if(((Atom) node).getAction() != 0){
						G0Action(((Atom) node).getAction());
						return true;
					}
				
				}
				else 
					return false;
			}
		}
		
		

		
		
	
	
	private void Scan() {
		// TODO Auto-generated method stub
		
	}



	private void G0Action(int action) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		///the grammar containing all 5 rules
		Grammar G= new Grammar();
		
		///first rule
		Node rule1= new Conc(
							new Star(
								new Conc(
										new Conc(
												new Conc(
														new Atom("N", AtomType.NonTerminal,0), 
														new Atom("->", AtomType.Terminal,0)), 
												new Atom("E", AtomType.NonTerminal,0)), 
										new Atom(",", AtomType.Terminal,1))), 
							new Atom(";", AtomType.Terminal,0));
		
		///second rule
		Node rule2= new Atom("IDNTER",AtomType.Terminal,0);
		
		///third rule
		Node rule3= new Conc(
							new Star(
									new Conc(
											new Atom("+",AtomType.Terminal,0),
											new Atom("T",AtomType.NonTerminal,0))),
							new Atom("T",AtomType.NonTerminal,0));				
		
		///fourth rule
				Node rule4= new Conc(
									new Star(
											new Conc(
													new Atom(".", AtomType.Terminal,0),
													new Atom("F", AtomType.NonTerminal,0))), 
									new Atom("F", AtomType.NonTerminal,0));
		
		
		///fifth rule
		Node rule5 = new Union(
							new Union(
									new Union(
											new Union(
													new Atom("ELTER", AtomType.Terminal, 0),
													new Atom("IDNTER", AtomType.Terminal, 0)
															),
													new Conc(
															new Atom("(", AtomType.Terminal, 0),
															new Conc(
																	new Atom("E", AtomType.NonTerminal, 0),
																	new Atom(")", AtomType.Terminal, 0)
																	)
															)
													),
									new Conc(
											new Atom("[", AtomType.Terminal, 0),
											new Conc(
													new Atom("E", AtomType.NonTerminal, 0),
													new Atom("]", AtomType.Terminal, 0)
													)
												)
											),
							new Conc(
									new Atom("(/", AtomType.NonTerminal, 0),
									new Conc(
											new Atom("E", AtomType.NonTerminal, 0),
											new Atom("/)", AtomType.Terminal, 0)
											)
									)
						);
		
		
		
		
		///adding rules to the grammar
		G.addRule(rule1);
		G.addRule(rule2);
		G.addRule(rule3);
		G.addRule(rule4);
		G.addRule(rule5);

		///System.out.println(node.toString());
		
		///printing all 5 rules
		for(int i=0;i<G.rules.size();i++){
			System.out.println("\n****** Printing Rule number "+(i+1)+" :\n ");
			G.PrintTree(i);
		}
	}

}
