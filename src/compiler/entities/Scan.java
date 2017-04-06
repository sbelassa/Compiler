package compiler.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Scan {

	private ArrayList<String> dicoNT;
	private ArrayList<String> dicoT;
	private ArrayList<Character> dicoTC;
	private ArrayList<Character> dicoNTC;
	private ArrayList<String> symboles;
	private String rule;
	private Atom scannedAtom;

	/**
	 * adding a structure for the scan output but then we have exactly what we
	 * wanted in Atom (code,action,AtomType,value)
	 **/

	/**
	 * the main scan function
	 */
	public Scan() {
		dicoNT = new ArrayList<String>(Arrays.asList("S", "N", "E", "T", "F", "IDNTER"));
		dicoT = new ArrayList<String>(Arrays.asList("+", ".", "(", ")", "[", "]", "(/", "/)", "ELTER"));
		dicoTC = new ArrayList<Character>(Arrays.asList('+', '(', ')', '[', ']', '.', ',', ';'));
		dicoNTC = new ArrayList<Character>(Arrays.asList('S', 'T', 'E', 'F', 'N'));
		symboles = new ArrayList<String>(Arrays.asList(";", "->", ",", ":="));
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

	/**
	 * doesn't work
	 * 
	 * @param rule
	 * @return
	 */

	public Atom scanRule1(String rule) {
		if (!this.rule.isEmpty()) {
			char first = rule.charAt(0);

			if (Character.toString(first) == "->") {
				if (!symboles.contains(first)) {
					symboles.add("->");
				}
				this.rule = rule.substring(1);
				return new Atom(2, AtomType.Terminal, 0, Character.toString(first));
			} else if (first == 'S'/* dicoNT.contains(first) */) {
				this.rule = rule.substring(1);
				return new Atom(null, AtomType.NonTerminal, 0, Character.toString(first));
			} else if (dicoT.contains(first)) {
				this.rule = rule.substring(1);
				return new Atom(null, AtomType.Terminal, 0, Character.toString(first));
			}

			else {
				if (rule.length() > 0)
					this.rule = rule.substring(1);
				return new Atom(null, AtomType.Terminal, 0, Character.toString(first));
			}
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

	public Scan(ArrayList<String> dicoNT, ArrayList<String> dicoT, ArrayList<Character> dicoTC,
			ArrayList<String> symboles, String rule, Atom scannedAtom) {
		super();
		this.dicoNT = dicoNT;
		this.dicoT = dicoT;
		this.dicoTC = dicoTC;
		this.symboles = symboles;
		this.rule = rule;
		this.scannedAtom = scannedAtom;
	}

	/**
	 * 
	 * @param rule
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * 
	 * @return
	 */
	public Atom getScannedAtom() {
		return scannedAtom;
	}

	public Scan(ArrayList<String> dicoNT, ArrayList<String> dicoT, ArrayList<String> symboles, String rule,
			Atom scannedAtom) {
		super();
		this.dicoNT = dicoNT;
		this.dicoT = dicoT;
		this.symboles = symboles;
		this.rule = rule;
		this.scannedAtom = scannedAtom;
	}

	public void setScannedAtom(Atom scannedAtom) {
		this.scannedAtom = scannedAtom;
	}

/********************************SCAN MAIN FUNCTION*******************************************************/
	
	/**
	 * 
	 * @param rule
	 * @param tmp
	 * @return
	 */
	public  Atom scanThis(String rule, String tmp) {
		
		if (!this.rule.isEmpty()) {
			
			/// get the first character of the rule
			Character first = rule.charAt(0);
			
			if (first == ':') {
				if (rule.charAt(1)== '=') {
					this.rule = rule.substring(1);
						if(!symboles.contains(first))
							symboles.add(":=");
						
					return new Atom(null, AtomType.Terminal, 0,":=");
				} 
					else {
						System.out.println("unknown symbol");

					}
				
			} else 
					if (dicoTC.contains(first)) {
							if (!tmp.isEmpty()) {
								if(!dicoNT.contains(tmp))
									dicoNT.add(tmp);
								return new Atom(null, AtomType.NonTerminal,0,tmp);
							}

					if(!symboles.contains(first))
						symboles.add(Character.toString(first));
					
					this.rule = rule.substring(1);
					return new Atom(null,  AtomType.Terminal,0, Character.toString(first));
				}
			else if (first == '"') {
				if (tmp.isEmpty()) {
				    this.rule = rule.substring(1);
                    return scanThis(this.rule, tmp);
                }
				else {
					if(!dicoT.contains(tmp))
						dicoT.add(tmp);
					this.rule = rule.substring(1);
					return new Atom(null, AtomType.Terminal,0, tmp);
				}

			} else {
				tmp += first;
                this.rule = rule.substring(1);
				return scanThis(this.rule, tmp);
			}
		} else {
			if(!dicoNT.contains(tmp))
					dicoNT.add(tmp);
            if(rule.length() > 0)
			    this.rule = rule.substring(1);
			return new Atom(null,AtomType.Terminal,0, tmp);
		}
		return null;
	}

}
