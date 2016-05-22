package collectionsExamples;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {    
	
	private String nome;
	private Double saldo;

	public ContaPoupanca(int i, String string) {
		this.nome = string;
		super.numero = i;
	}

	@Override
    public int compareTo(ContaPoupanca outra) {
        return this.getNumero() - outra.getNumero();
    }

	public void deposita(double d) {
		this.saldo += d;
		
	}
}