/*
 * 
 */
package compiler.entities;

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
	public Boolean analyseG0(Node node){
		
		if(node instanceof Conc){
			if(analyseG0(node.getLeft())){
				return analyseG0(node.getRight());
			}
			else
			{
				return false;
			}
		}
		
		if(node instanceof Union){
			if(analyseG0(node.getLeft())){
				return true;
			}
			else{
				return analyseG0(node.getRight());
			}
		}
		
		if(node instanceof Star){
			//FIXME check the algo
			return analyseG0(node.getLeft());
			
		}
		
		if(node instanceof Un){
			return analyseG0(node.getLeft());
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
				if(analyseG0(((Atom) node).getCode())){
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
	 * 
	 * @param G0
	 * @return the grammar G0 filled with the 5 rules
	 */
	private Grammar fillInG0(Grammar G0){

				/// add first rule
				Node rule1= new Conc(
									new Star(
										new Conc(
												new Conc(
														new Conc(
																new Atom("0",AtomType.NonTerminal,0,"N"), 
																new Atom("0", AtomType.Terminal,0,"->")), 
														new Atom("0", AtomType.NonTerminal,0,"E")), 
												new Atom("1", AtomType.Terminal,1,","))), 
									new Atom("0", AtomType.Terminal,0,";"));
				
				
				/**
				 * new Atom(1, 0, AtomType.NONTERMINAL, "N")
				 * code, action, atype,chaine
				 */
				///second rule
				Node rule2= new Atom("2",AtomType.Terminal,2,"IDNTER");
				
				///third rule
				Node rule3= new Conc(
									new Star(
											new Conc(
													new Atom("0",AtomType.Terminal,0,"+"),
													new Atom("3",AtomType.NonTerminal,3,"T"))),
									new Atom("0",AtomType.NonTerminal,0,"T"));				
				
				///fourth rule
						Node rule4= new Conc(
											new Star(
													new Conc(
															new Atom("0", AtomType.Terminal,0,"."),
															new Atom("4", AtomType.NonTerminal,4,"F"))), 
											new Atom("0", AtomType.NonTerminal,0,"F"));
				
				
				///fifth rule
				Node rule5 = new Union(
									new Union(
											new Union(
													new Union(
															new Atom("5", AtomType.Terminal, 5,"ELTER"),
															new Atom("5", AtomType.Terminal, 5,"IDNTER")
																	),
															new Conc(
																	new Atom("0", AtomType.Terminal, 0,"("),
																	new Conc(
																			new Atom("0", AtomType.NonTerminal, 0,"E"),
																			new Atom("0", AtomType.Terminal, 0,")")
																			)
																	)
															),
											new Conc(
													new Atom("0", AtomType.Terminal, 0,"["),
													new Conc(
															new Atom("0", AtomType.NonTerminal, 0,"E"),
															new Atom("0", AtomType.Terminal, 0,"]")
															)
														)
													),
									new Conc(
											new Atom("0", AtomType.NonTerminal, 0,"(/"),
											new Conc(
													new Atom("0", AtomType.NonTerminal, 0,"E"),
													new Atom("0", AtomType.Terminal, 0,"/)")
													)
											)
								);
				
				
				
				
				///adding 5  rules to the grammar
				G0.addRule(rule1);
				G0.addRule(rule2);
				G0.addRule(rule3);
				G0.addRule(rule4);
				G0.addRule(rule5);
		
		return G0;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		
		///the grammar containing all 5 rules
		   Grammar G0 = new Grammar();
		   G0.fillInG0(G0);
				

		System.out.println("Your G0 has : "+G0.rules.size()+" rules!");
		
		///printing all 5 rules
		for(int i=0;i<G0.rules.size();i++){
			System.out.println("\n****** Printing Rule number "+(i+1)+" :\n ");
			G0.PrintTree(i);
		}
	}

}
