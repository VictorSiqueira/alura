package aula5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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

		/*----------------------------------------------------------*/
		
		//MODO CORRETO COM STREAMS
		List<Curso> correct = list.stream().filter(c -> c.getAlunos() >= 30).collect(Collectors.toList());
		
		
		/* é muito interessante usar colletor pois ele possibilita "exportar"
		 * praticamente para todos os tipos de Iterators (lista, hashMap, etc).
		 * 
		 * Alem disso é interessante ver que existe metodos em stream que possibilita
		 * realizar buscar dentro dele, como o findAny, find First, ect. só conferir abaixo
		 * http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html*/
		
		correct.forEach(curso -> System.out.println(curso.getNome()));

	}
}
