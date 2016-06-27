package gerenciadorDeCursos;

import java.util.ArrayList;

public class TestaListaAulas {

	public static void main(String[] args) {
		Aula aula1 = new Aula("Java", 20);
		Aula aula2 = new Aula("PHP", 10);
		Aula aula3 = new Aula("WEB", 30);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);


	}

}
