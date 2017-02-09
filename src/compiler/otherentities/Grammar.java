package compiler.otherentities;

import java.util.ArrayList;

public class Grammar {
	
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
	
	
	public void charPrinter(char c, int cnt){
	    int i;
	    for(i = 0; i < cnt; i++){
	        System.out.println(c);
	    }
	}
	
	

	public void PrintNode(Node node,int cnt){
		
		charPrinter('-', cnt*2);
		node.toString();
		System.out.println("\n");
		
		
		if(node.getLeft()!=null){
			PrintNode(node.getLeft(),cnt+1);
			
		}
		System.out.println("\n");

		if(node.getRight()!=null){
			
			PrintNode(node.getRight(), cnt+1);
		}
		
		
	}


	public void PrintTree(int ruleNum){
		//if(rules.get(ruleNum))
		
		PrintNode(rules.get(ruleNum), 1);
		
		
	}
	
	
	public static void main(String[] args) {

		
		Grammar G= new Grammar();
		
		
		//the rule #1
		
		//the rule #2
		G.addRule(new Atom("IDNTER",AtomType.Terminal,0));
		G.PrintTree(0);
	}

}
