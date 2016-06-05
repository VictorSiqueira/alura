package aula4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
//Stream
/*é uma nova interface que possibilita interagir com as collections
 * para facilitar algumas tarefas
 * é importante resaltar que Stream e Collections não são compativeis 
 * e não é possivel realizar cast entre eles
 */

class Curso {
	private String nome;
	private Integer alunos;
	
	
	public Curso(String nome, Integer alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAlunos() {
		return alunos;
	}
	public void setAlunos(Integer alunos) {
		this.alunos = alunos;
	}
	
	
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> list = new ArrayList<>();
		List<Curso> otherList = new ArrayList<>();

		list.add(new Curso("Python", 10));
		list.add(new Curso("C", 20));
		list.add(new Curso("PHP", 30));
		list.add(new Curso("Java", 20));
	
		list.sort(Comparator.comparing(curso -> curso.getAlunos()));		
		list.forEach(curso -> System.out.println(curso.getNome()));
		//filtrando acima de 30 aluns e jogando em outra lista
		list.stream().filter(c -> c.getAlunos() >= 30).forEach(c -> otherList.add(c));
		
		//filtrando acima de 30 aluns e printando na tela
		list.stream().filter(c -> c.getAlunos() >= 30).map(c -> c.getAlunos()).forEach(n -> System.out.println(n));
		
		//filtrando acima de 30 aluns e somando o total do resultado
		Integer i = list.stream().filter(c -> c.getAlunos() >= 30).mapToInt(c -> c.getAlunos()).sum();
		
		//criando stram de String
		Stream<String> nomes = list.stream().map(Curso::getNome);
		
		System.out.println("todos alunos do filtro: "+i);
		
		otherList.forEach(curso -> System.out.println(curso.getNome()));

	}
}
