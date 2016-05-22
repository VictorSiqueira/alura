package collectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaOrdenacao {

	 public static void main(String[] args) {
	        List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();

	        ContaPoupanca c1 = new ContaPoupanca(400, "Caio");
	        c1.deposita(1500.0);
	        contas.add(c1);

	        ContaPoupanca c2 = new ContaPoupanca(467, "Adriano");
	        c2.deposita(2050.99);
	        contas.add(c2);

	        ContaPoupanca c3 = new ContaPoupanca(230, "Victor");
	        c3.deposita(1070.0);
	        contas.add(c3);

	        Collections.sort(contas);

	        for (ContaPoupanca conta : contas) {
	            System.out.println(conta);
	        }
	    }
}
