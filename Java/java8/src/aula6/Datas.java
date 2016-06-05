package aula6;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//NOVA API DE DATAS
public class Datas {
	public static void main(String[] args){
		
		LocalDate hoje = LocalDate.now();		
		LocalDate olimpiada = LocalDate.of(2016, Month.AUGUST, 5);
		
		Period periodo  = Period.between(hoje, olimpiada);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatter.format(hoje);
		
		System.out.println(periodo);
		System.out.println(dataFormatada);
	
	}
}
