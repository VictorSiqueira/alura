package aula1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//DEFAULT METHODS
//são metodos dentro de uma interface que necessitem ter corpo
//para isso é necessario declara-los com o modificador 'default'
// assim ele podera ter corpo


public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("palavra 1");
		palavras.add("segunda palavra 2");
		palavras.add("primeira palavra 2");
		palavras.add("outra palavra, 4");
		
		Comparator<String> comparator = new ComparadorPorTamanho();
		// na versao 7 do java precisava fazer dessa forma
		Collections.sort(palavras,comparator);
		
		//na versao 8 a classe list implementa o sort, passando um comparator
		//na versao 7 interfaces nao podiam ter corpo, na 8 podem, é possivel
		//ver isso acessando o metodo sort abaixo
		palavras.sort(comparator);
		
		/*MODO RESUMIDO
		 palavras.sort(new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
		    }
		});*/
		
		// na versao 7 do java precisava fazer dessa forma
		for(String p : palavras){
			System.out.println(p);
		}
		
		//na versao 8 pode se iterar
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		/*MODO RESUMIDO
		 palavras.forEach(new Consumer<String>(){
		    public void accept(String palavra) {
		        System.out.println(palavra);
		    }
		});*/
		
		System.out.println(palavras);
	}
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println("accept: "+t);		
	}
	
}

class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length()){
			return -1;
		}
		if(o1.length() < o2.length()){
			return 1;
		}		
		return 0;
	}
	
}