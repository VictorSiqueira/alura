package langexamples;

import java.io.PrintStream;

import pojo.Generica;

public class TesteSysOut {

	public static void main(String[] args) {
		PrintStream saida = System.out;
		Generica conta = new Generica("teste", 1.0);
		Generica conta2 = new Generica("teste", 1.0);
		saida.println(conta);
	    saida.println(conta.equals(conta2));
	    conta.findEachLetter();
	}
}
