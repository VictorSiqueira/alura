package leilao.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leilao.dominio.Lance;
import leilao.dominio.Leilao;

public class Avaliador {
	private Leilao leilao;
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;//menor numero que cabe num double
	private double menorDeTodos = Double.POSITIVE_INFINITY;//menor numero que cabe num double;
	private List<Lance> maiores;
	
	public void avalia (Leilao leilao){
		if(leilao.getLances().size() < 1){
			throw new RuntimeException("Não é possivel avaliar um leilao sem lances!");
		}
		for(Lance lance : leilao.getLances()){
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
		}
		
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance l1, Lance l2){
				if(l1.getValor()< l2.getValor())return 1;
				if(l1.getValor()> l2.getValor())return -1;
				return 0;
			}
		});
		
		// digo onde começa e qual o tamaho da lista
		// no caso está sendo utilizado um if ternario para isso
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size()); 
	}
	
	public List<Lance> getTresMaiores() {
		return maiores;
	}
	
	public double getMaiorLance(){
		return maiorDeTodos;
	}
	
	public double getMenorLance(){
		return menorDeTodos;
	}
}
