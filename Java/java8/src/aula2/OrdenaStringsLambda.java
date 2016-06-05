package aula2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//Lambda
//é eficiente usar ela quando é necessario usar uma interface como 
//parametro, ou seja, que vai te obrigar a implementar metodos, com 
//lambda vc implementa apenas os metodos e por tras é gerado a classe
//mas essa classe deve ser sempre uma interface funcional que é aquele
//que tem  1 único método abstrato. Além desse método ela pode ter outros 
//métodos, contanto que sejam default.

public class OrdenaStringsLambda {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("palavra 1");
		palavras.add("segunda palavra 2");
		palavras.add("primeira palavra 2");
		palavras.add("outra palavra, 4");
	
		
		//MODO RESUMIDO
		 palavras.forEach(new Consumer<String>(){
		    public void accept(String palavra) {
		        System.out.println(palavra);
		    }
		});
		 
		 //MODO LAMBDA
		 //o compilador subentede e cria a classe 
		 //que deve ser inserida como paramentro
		 
		 //ou seja é equivalente ao codigo de cima, 
		 //onde o 's' é o item da lista, e a '->' 
		 //indica a ação que deve ser tomada
		 palavras.forEach(s -> System.out.println(s));
		 
		 
		 /*------------------------------------------*/
		 
		 /*MODO RESUMIDO*/
		 palavras.sort(new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
		    }
		});
		 
		 /*MODO LAMBDA*/
		 //exemplo com 2 paramteros é necessario por entre parenteses
		palavras.sort(( s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		
		/*------------------------*/
		
		 /*MODO RESUMIDO*/
		/*new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();*/
		
		
		/*MODO LAMBDA*/
		 //exemplo com sem paramteros é necessario por parenteses
		//new Thread( () ->  System.out.println("Executando um Runnable")).start();
		
	}
}
