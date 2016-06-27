package gerenciadorDeCursos;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> aulas;
	private Set<Aluno> alunos = new HashSet<>();
	
/*O LinkedHashSet nos dá a performance 
 * de um HashSet mas com acesso previsível e ordenado.*/
	
	public Curso(String nome, String instrutor, List<Aula> aulas) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
		this.aulas = aulas;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public void adicionaAula(Aula aula){
		if(this.aulas != null){
			this.aulas.add(aula);
		}
	}
	
	public Integer getTempoTotal() {
		Integer total = 0;
		for(Aula aula : this.aulas){
			total += aula.getTempo();
		}
		return total;
	}

	public void matriculaAluno(Aluno a1) {
		this.alunos.add(a1);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public Boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	public Aluno buscaMatricula(Integer numero){
		for(Aluno aluno : this.alunos){
			if(aluno.getNumeroMatricula().equals(numero))
				return aluno;		
		}
		//ideal utilizar para quando nao encontra um
		//elemento dentro de uma lista
		//inves de retornar null
		throw new NoSuchElementException("elemento nao encontrado");
	}
	
}
