package compiler.entities;

public class ScanTest {

	/// TESTS
	/// S:=[a]+b,;
	/// S:='a',;
	public static void main(String[] args) {
		
		Scan sc = new Scan();
		while(!sc.getRule().isEmpty()) {
			Atom a = sc.scanThis(sc.getRule(),"");
			System.out.println(a.toString());
		}

	}

}
