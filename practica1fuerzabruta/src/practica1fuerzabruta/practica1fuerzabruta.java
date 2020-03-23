package practica1fuerzabruta;
import java.util.ArrayList;
import java.util.List;

public class practica1fuerzabruta {
	public practica1fuerzabruta() {
	}
	
	private List<String> permutacion (String aux){
		List <String> listos = new ArrayList<String>();
		List <String> auxi = new ArrayList<String>();
		List <String> auxi2 = new ArrayList<String>();
		if (aux.length()==0) {
			listos.add("");
			return listos;
		}
		listos = permutacion (aux.substring(1));
		for (int i=0; i<listos.size(); i++) {
			String pasando = listos.get(i);
			auxi = intercalar (pasando, aux.charAt(0));
			for (int j=0; j<auxi.size(); j++) {
				auxi2.add(auxi.get(j));
			}
		}
		listos = auxi2;
		return listos;
	}
	
	private List<String> intercalar (String intercambio, char pasa) {
		List <String> aux = new ArrayList<String>();
		if (intercambio.length() == 0) {
			aux.add(Character.toString(pasa));
			return aux;
		}
		for (int i=0; i<=intercambio.length(); i++) {
			if (i==0) {
				aux.add(Character.toString(pasa).concat(intercambio));
			}
			if (i>0 && i<intercambio.length()) {
				String aux1 = intercambio.substring(0, i);
				String aux2 = intercambio.substring(i, intercambio.length());
				aux.add(aux1.concat(Character.toString(pasa).concat(aux2)));
			}
			if (i==intercambio.length()) {
				aux.add(intercambio.concat(Character.toString(pasa)));
			}
		}
		return aux;
	}
	
	private List <String> unir (char primero, List <String> permutado) {
		List <String> aux = new ArrayList<String>();
		String cadena = Character.toString(primero);
		for (int i=0; i<permutado.size(); i++) {
			aux.add(cadena.concat(permutado.get(i)));
		}
		return aux;
	}
	
	private List<String> sublistas (String lista){
		List <String> aux = new ArrayList<String>();
		for (int i=0; i<=lista.length(); i++) {
			for (int j=i+1; j<=lista.length(); j++) {
				aux.add(lista.substring(i, j));
			}
		}
		aux.add("");
		return aux;
	}
	
	public List<String> subconjuntos (String lista){
		List <String> subcon = new ArrayList<String>();
		if (lista.length() == 0) {
			subcon.add(" ");
			return subcon;
		}
		List <String> aux1 = new ArrayList<String>();
		List <String> aux2 = new ArrayList<String>();
		aux1 = subconjuntos (lista.substring(1));
		aux2 = unir (lista.charAt(0), aux1);
		for (int i=0; i<aux1.size(); i++) {
			aux2.add(aux1.get(i));
		}
		return aux2;
	}
	
	public boolean anagrama (String lista1, String lista2) {
		List <String> permutaciones = permutacion (lista1);
		for (int i=0; i<permutaciones.size(); i++) {
			if (permutaciones.get(i).compareTo(lista2) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean perteneceSubLista (String lista1, String lista2) {
		List <String> subListas = sublistas(lista2);
		for (int i=0; i<subListas.size(); i++) {
			if (subListas.get(i).compareTo(lista1) == 0) {
				return true;
			}
		}
		return false;
	}
}
