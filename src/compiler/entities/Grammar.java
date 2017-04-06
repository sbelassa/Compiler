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
	
	
	/**Stack to generate the GPL**/
	private Stack pile;

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
	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grammar [rules=" + rules + "]";
	}
	
	/**
	 * just a dumb function to print a character the number of times we give
	 *
	 * @param c the c
	 * @param cnt the cnt
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
	 * printing the tree that contains the nodes just by calling the function that prints nodes
	 *
	 * @param ruleNum the rule num
	 */
	public void PrintTree(int ruleNum){
		
		PrintNode(rules.get(ruleNum), 1);
	}
	
	

	/**
	 * 
	 * @param node
	 * @param scan
	 * @return
	 */
	public Boolean analyseG0(Node node, Atom scannedAtom){
		
		if(node.equals(null))
			return true;
		
		if(node instanceof Conc){
			if(analyseG0(node.getLeft(),scannedAtom)){
				return analyseG0(node.getRight(),scannedAtom);
			}
			else
			{
				return false;
			}
		}
		
		if(node instanceof Union){
			if(analyseG0(node.getLeft(),scannedAtom)){
				return true;
			}
			else{
				return analyseG0(node.getRight(),scannedAtom);
			}
		}
		
		if(node instanceof Star){
			return analyseG0(node.getLeft(),scannedAtom);			
		}
		
		if(node instanceof Un){
			return analyseG0(node.getLeft(),scannedAtom);
		}
		
		if(node instanceof Atom){
			
			if(((Atom) node).getaType() == AtomType.Terminal){
				if(((Atom) node).getCode() == scannedAtom.getCode()){ //code est rempli par le scan !!!!!?????
					if(((Atom) node).getAction() != 0){
						g0Action(((Atom) node).getAction(),scannedAtom);
						//scan.scanRule(node.getLeft().toString());// to verify
						//call scan
						}
					else
						return false;
					}
				} else if(((Atom) node).getaType() == AtomType.NonTerminal){
					
					if(analyseG0(rules.get(((Atom) node).getCode()), scannedAtom))
					{
						if(((Atom) node).getAction() != 0){
							g0Action(((Atom) node).getAction(),scannedAtom);
							return true;
						}
					
					}
				else 
					return false;
			}
		}
		return false;
	}
		

	/**
	 * 
	 * @param G0
	 * @return the grammar G0 filled with the 5 rules
	 */
	private Grammar fillInG0(Grammar G0){

		/**
		 * code is generated here from 1 to 17 to all vocabulary
		 */
				/// add first rule
				Node rule1= new Conc(
									new Star(
										new Conc(
												new Conc(
														new Conc(
																new Atom(1,AtomType.NonTerminal,0,"N"), 
																new Atom(2, AtomType.Terminal,0,"->")), 
														new Atom(3, AtomType.NonTerminal,0,"E")), 
												new Atom(4, AtomType.Terminal,1,","))), 
									new Atom(5, AtomType.Terminal,0,";"));
				///second rule
				Node rule2= new Atom(6,AtomType.Terminal,2,"IDNTER");
				
				///third rule
				Node rule3= new Conc(
									new Star(
											new Conc(
													new Atom(7,AtomType.Terminal,0,"+"),
													new Atom(8,AtomType.NonTerminal,3,"T"))),
									new Atom(8,AtomType.NonTerminal,0,"T"));				
				
				///fourth rule
						Node rule4= new Conc(
											new Star(
													new Conc(
															new Atom(9, AtomType.Terminal,0,"."),
															new Atom(10, AtomType.NonTerminal,4,"F"))), 
											new Atom(10, AtomType.NonTerminal,0,"F"));
				
				
				///fifth rule
				Node rule5 = new Union(
									new Union(
											new Union(
													new Union(
															new Atom(11, AtomType.Terminal, 5,"ELTER"),
															new Atom(6, AtomType.Terminal, 5,"IDNTER")
																	),
															new Conc(
																	new Atom(12, AtomType.Terminal, 0,"("),
																	new Conc(
																			new Atom(3, AtomType.NonTerminal, 0,"E"),
																			new Atom(13, AtomType.Terminal, 0,")")
																			)
																	)
															),
											new Conc(
													new Atom(14, AtomType.Terminal, 0,"["),
													new Conc(
															new Atom(3, AtomType.NonTerminal, 0,"E"),
															new Atom(15, AtomType.Terminal,6,"]")
															)
														)
													),
									new Conc(
											new Atom(16, AtomType.NonTerminal, 0,"(/"),
											new Conc(
													new Atom(3, AtomType.NonTerminal, 0,"E"),
													new Atom(17, AtomType.Terminal,7,"/)")
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

	
	
	public void g0Action( int act, Node node){
		Node T1;
		Node T2;
		
		switch (act){
		
			case 1 : T1 = pile.pop();
					 T2 = pile.pop();
					 //rules[rules.size()]=T1;
					 this.rules.add(T2);
					 break;
					 
			case 2 : pile.push(node);
					//pile.push(new Atom(Recherche(DICONT), act, catype));
					 break;
					 
			case 3 : T1=pile.pop();
					 T2=pile.pop();
					 pile.push(new Union(T1,T2));
					 break;
			
			case 4 : T1=pile.pop();
					 T2=pile.pop();
					 pile.push(new Conc(T1,T2));
					 break;
				
			case 5 :
					/* if(caType == Terminal ){
						 	pile.push(new Atom(Recherche(DICO, act, AtomType.Terminal)));
					 }
					 else{
						 pile.push(new Atom(Recherche(DICONT),act,AtomType.NonTerminal));
					 }*/
				 	 pile.push(node);
					 break;
					 
			case 6 : T1=pile.pop();
					 pile.push(new Star(T1));
					 break;
					
			case 7 : T1=pile.pop();
					 pile.push(new Un(T1));
					 
					 
		}		
	}
	
	/**
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
		
		
		
		/***************Scan and analyse **********************/
		/// TESTS
		/// S=['a']+'b',;
		/// S='a',;
		System.out.println("*********** Scan and analyse: ");
		Scan scan= new Scan();
		Atom atom=scan.scanThis(scan.getRule(), "");
		//Atom atom=scan.scanRule1(scan.getRule());
		while(!scan.getRule().isEmpty()) {
			Atom a = scan.scanThis(scan.getRule(),"");
			//Atom a = scan.scanRule1(scan.getRule());
			System.out.println(a.toString());
		}
		boolean isOk = G0.analyseG0(G0.rules.get(0), atom);
		System.out.println(isOk);
		
	}

}
