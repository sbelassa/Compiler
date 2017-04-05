package compiler.entities;

public class ScanTest {

	public static void main(String[] args) {
		
		Scan sc= new Scan();
		
		
		//printing results
		System.out.println("Non Terminal Vocabulary : ");
		for(String st1 : sc.getDicoNT())
			System.out.println(st1);
		System.out.println("Terminal Vocabulary : ");
		for(String st2 : sc.getDicoT())
			System.out.println(st2);
		System.out.println("Symboles : ");
		for(String st3 : sc.getSymboles())
			System.out.println(st3);
	}

}
