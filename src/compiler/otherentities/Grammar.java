package compiler.otherentities;

import java.util.ArrayList;

/**
 * The grammar containing rules
 * 
 */
public class Grammar {
	
	/// list of rules
	private ArrayList<Node> rules;
	
	

	public Grammar(ArrayList<Node> rules) {
		this.rules = rules;
	}



	public Grammar() {
		rules= new ArrayList<Node>();

	}



	public ArrayList<Node> getRules() {
		return rules;
	}



	public void setRules(ArrayList<Node> rules) {
		this.rules = rules;
	}


	public void addRule(Node rule){
		rules.add(rule);
	}
	
	
	@Override
	public String toString() {
		return "Grammar [rules=" + rules + "]";
	}
	
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
	 * recursive printing
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

	///printing the tree that contains the nodes just by calling the function that prints nodes
	public void PrintTree(int ruleNum){
		
		//if(rules.get(ruleNum))
		PrintNode(rules.get(ruleNum), 1);
	}
	
	
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
		///Node rule5= new Node();

		
		///adding rules to the grammar
		G.addRule(rule1);
		G.addRule(rule2);
		G.addRule(rule3);
		G.addRule(rule4);
		///G.addRule(rule5);

		///System.out.println(node.toString());
		
		///printing all 5 rules
		for(int i=0;i<G.rules.size();i++){
			System.out.println("\n****** Printing Rule number "+i+" :\n ");
			G.PrintTree(i);
		}
	}

}
