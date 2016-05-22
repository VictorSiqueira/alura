package pojo;

public class Generica {
	
	private String nome;
	private Double valor;
	
	public Generica() {
		super();
	}
	
	public Generica(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * metodo sobrescrito do toString default
	 */
	public String toString(){
		return "esse objeto com o valor de "+ this.valor;
	}
	
	/**
	 * metodo sobrescrito do equals default
	 */
	public boolean equals(Object obj) {
		Generica outraConta = (Generica) obj;
			return this.valor.equals(outraConta.valor) && 
					this.nome.equals(outraConta.nome);
    }
	
	public void findEachLetter() {
		for(int i = 0;i >= this.nome.length();i++){
			System.out.println("\n"+this.nome.charAt(this.nome.length()-i));
		}
	}
	
	public void invertePalavrasDaFrase(String texto) {
        String[] palavras = texto.split(" ");
        for (int i = palavras.length - 1; i >= 0; i--) {
            System.out.print(palavras[i] + " ");
        }
        System.out.println("");
    }
}
