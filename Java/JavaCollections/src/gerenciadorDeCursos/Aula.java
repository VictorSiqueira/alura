package gerenciadorDeCursos;

public class Aula implements Comparable<Aula> {
	private String titulo;
	private Integer tempo;
	
	public Aula(String titulo, Integer tempo) {
		super();
		this.titulo = titulo;
		this.tempo = tempo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getTempo() {
		return tempo;
	}
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	
	@Override
	public String toString() {
		return "Aula: "+this.titulo;
	}

	@Override
	public int compareTo(Aula o) {
		return this.titulo.compareTo(o.getTitulo());
	}
	
	
}
