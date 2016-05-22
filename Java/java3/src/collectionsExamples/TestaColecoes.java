package collectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class TestaColecoes {

	public static void main(String[] args) {
		ArrayList nomes = new ArrayList<>();
		nomes.add("Mauricio");
		nomes.add("Guilherme");
		
		Collections.sort(nomes);
		
		System.out.println(nomes.get(0));
		System.out.println(nomes.contains("Guilherme"));

	}

}
