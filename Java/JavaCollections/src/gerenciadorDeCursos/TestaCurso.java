package gerenciadorDeCursos;

import java.util.ArrayList;

public class TestaCurso {
	/*
	 * A classe Vector possui as mesmas características que um ArrayList,
	 *  com a diferença de que o primeiro possui acesso sincronizado 
	 *  e o segundo não. */
	
	/*List é uma sequência e aceita elementos duplicados.
	 * Set não aceita duplicados, mas não define ordem.*/

	public static void main(String[] args) {
		Curso curso =  new Curso("Java","Victor",new ArrayList<>());
		curso.adicionaAula(new Aula("Classes", 15));
		System.out.println(curso.getAulas());		
		System.out.println(curso.getTempoTotal());		
		
		Aluno a1 = new Aluno("Victor Siqueira",72092);
		Aluno a2 = new Aluno("Mathues Saots",72031);
		Aluno a3 = new Aluno("bruna Leite",5092);
		
		curso.matriculaAluno(a1);
		curso.matriculaAluno(a2);
		curso.matriculaAluno(a3);
		
		System.out.println("Alunos: \n");
		curso.getAlunos().forEach(a -> System.out.println(a));
		System.out.println(curso.estaMatriculado(a1));
		
		Aluno a4 = new Aluno("Victor Siqueira",72092);
		System.out.println(curso.estaMatriculado(a4));
		
		/*
		 * FORMA ANTIGA DE ITERAR
		 * Set<Aluno> alunos = javaColecoes.getAlunos();
			Iterator<Aluno> iterador = alunos.iterator();
			
			while (iterador.hasNext()) {
			    System.out.println(iterador.next());
			}*/
		
		System.out.println(curso.buscaMatricula(72092));	
	}

}
