package compiler.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Scan {

	private ArrayList<String> dicoNT;
	private ArrayList<String> dicoT;
	private ArrayList<String> symboles;
	private String rule;
	/**
	 * adding a structure for the scan output but then we have exactly 
	 * what we wanted in Atom (code,action,AtomType,value) 
	 **/

	/**
	 * the main scan function
	 */
	public Scan() {
		dicoNT = new ArrayList<String>(Arrays.asList("S","N","E","T","F"));
		dicoT = new ArrayList<String>(Arrays.asList("+",".","(",")","[","]","(/","/)","IDNTER","ELTER"));
		symboles = new ArrayList<String>(Arrays.asList(";","->",",",":="));
		System.out.println("Write the rule you want to scan in one line and hit enter: ");
		Scanner in = new Scanner(System.in);
		rule = in.nextLine();
		in.close();
	}

	/**
	 * 
	 * @param dicoNT
	 * @param dicoT
	 * @param symboles
	 * @param rule
	 */
	public Scan(ArrayList<String> dicoNT, ArrayList<String> dicoT, ArrayList<String> symboles, String rule) {
		this.dicoNT = dicoNT;
		this.dicoT = dicoT;
		this.symboles = symboles;
		this.rule = rule;
	}


	public Atom scanRule(String rule){
		if (!this.rule.isEmpty()) {
			char first = rule.charAt(0);
				if(first == ' ' || first== '\n'){
					first = rule.charAt(1);
				}
				
				if(first == )
			
			
			
			
			/*if(dicoNT.contains(first)){
				return new Atom(Character.toString(first), AtomType.NonTerminal, 0,Character.toString(first));
			}
			else if(dicoT.contains(first)){
				return new Atom(Character.toString(first), AtomType.Terminal, 0,Character.toString(first));
			}*/
			

		}
		return null;
	}
	
	/****************************************************************/
	/**
	 * GETTERS AND SETTERS 
	 */
	public ArrayList<String> getDicoNT() {
		return dicoNT;
	}

	public void setDicoNT(ArrayList<String> dicoNT) {
		this.dicoNT = dicoNT;
	}

	public ArrayList<String> getDicoT() {
		return dicoT;
	}

	public void setDicoT(ArrayList<String> dicoT) {
		this.dicoT = dicoT;
	}

	public ArrayList<String> getSymboles() {
		return symboles;
	}

	public void setSymboles(ArrayList<String> symboles) {
		this.symboles = symboles;
	}

	/**
	 * 
	 * @return
	 */
	public String getRule() {
		return rule;
	}
	
	/**
	 * 
	 * @param rule
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	
}
