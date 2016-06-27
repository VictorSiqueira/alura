package gerenciadorDeCursos;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		String aula1 = "conhecendo mais de listas";
		String aula2 = "modelando a classe aula";
		String aula3 = "trabalhando com Sets";
		
		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		aulas.remove(0);
		
		System.out.println(aulas);
		
		for (String string : aulas) {
			System.out.println("Aula: "+ string);
		}
		
		Collections.sort(aulas);
	}

}
