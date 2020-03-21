package practica1fuerzabruta;
import java.util.ArrayList;
import java.util.List;

public class practica1fuerzabruta {
	public practica1fuerzabruta() {
	}
	
	/**public List<String> permutacion (String aux){
		List <String> listos = new ArrayList<String>();
		if (aux.length()==0) {
			return listos;
		}
		if (aux.length()==1) {
			listos.add(aux);
			return listos;
		}
		List <String> agregar = new ArrayList<String>();
		for (int i=0; i<aux.length(); i++) {	
			if (i==0) {
				agregar = unir(aux.charAt(0), permutacion(aux.substring(1)));
			}
			if (i!=0 && i!=aux.length()-1) {
				String prob1 = aux.substring(0, i);
				String prob2 = aux.substring(i+1, aux.length());
				String pas = prob1.concat(prob2);
				List <String> auxi = new ArrayList<String>();
				List <String> auxi2 = permutacion(pas);
				auxi = unir(aux.charAt(i), permutacion(pas));
				for (int j=0; j<auxi2.size(); j++) {
					System.out.println("elementos " + auxi2.get(0));
				}
			}else {
				List <String> auxi = new ArrayList<String>();
				auxi = unir(aux.charAt(i), permutacion(aux.substring(0, i)));
				for (int j=0; j<auxi.size(); j++) {
					agregar.add(auxi.get(0));
				}
			}
		}
		return agregar;
	}
	
	private List <String> unir (char primero, List <String> permutado) {
		List <String> aux = new ArrayList<String>();
		String cadena = Character.toString(primero);
		for (int i=0; i<permutado.size(); i++) {
			aux.add(cadena.concat(permutado.get(i)));
		}
		return aux;
	}*/
	
	public List<String> sublistas (String lista){
		List <String> aux = new ArrayList<String>();
		for (int i=0; i<=lista.length(); i++) {
			for (int j=i+1; j<=lista.length(); j++) {
				aux.add(lista.substring(i, j));
			}
		}
		aux.add("");
		return aux;
	}
}
