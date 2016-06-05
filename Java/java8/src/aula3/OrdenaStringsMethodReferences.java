package aula3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//Method references
//nao sei explicar de forma facil

public class OrdenaStringsMethodReferences {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("palavra 1");
		palavras.add("segunda palavra 2");
		palavras.add("primeira palavra 2");
		palavras.add("outra palavra, 4");

		 //MODO LAMBDA
		 palavras.forEach(s -> System.out.println(s));
		 
		 //MODO METHOD REFERENCES
		 palavras.forEach(System.out::println);
		 
		 /*------------------------------------------*/

		 /*MODO LAMBDA*/
		palavras.sort(( s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		 //MODO METHOD REFERENCES
		palavras.sort(Comparator.comparing(String::length));
		
	}
}
