package practica1fuerzabruta;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class practica1fuerzabrutaTest {

	@Test
	/**void testProb() {
		practica1fuerzabruta asd = new practica1fuerzabruta();
		List<String> permutado = new ArrayList<String>();
		permutado = asd.permutacion("fda");
		String preu = "fda";
		System.out.println("pre: " + preu.substring(0, 1));
		System.out.println("pos: " + preu.substring(2, preu.length()));
		System.out.println ("final: " + preu.substring(0, 1).concat(preu.substring(2, preu.length())));
		System.out.println(permutado.size());
		for (int i=0; i<permutado.size(); i++) {
			System.out.print(permutado.get(i) + ", ");
		}
	}*/
	
	void testSublistas() {
		practica1fuerzabruta asd = new practica1fuerzabruta();
		asd.sublistas("asd");
	}

}
