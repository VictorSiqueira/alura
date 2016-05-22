package testesUnitariosEmJava;

//importa estaticamente para nao precisar ficar repetindo
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import leilao.dominio.Lance;
import leilao.dominio.Leilao;
import leilao.dominio.Usuario;
import leilao.servicos.Avaliador;


//é sempre interessante pensar em 4 tipos de basicos de teste
// Unico valor
// valores crescentes
// valores decrescentes
// valores randomicos

//usar esse tipo de classe ajuda bastante a pensar em não deixar
//metodo muito acoplados e melhores estruturados para uso generico


public class TesteDoAvaliador {
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	@Before 
	//serve para o Junit executar antes começar cada teste
	public void criaAvaliador(){
		this.leiloeiro = new Avaliador();
		joao = new Usuario(0, "joao");
		jose = new Usuario(0, "jose");
		maria = new Usuario(0, "maria");
	}
	
	@Test(expected = RuntimeException.class)
	//declarção da exceção esperada, dispensando a necessidade do try/catch
	//pois com essa declarção ele entende que deve aprovar o teste quando lançar uma exceção
	
	public void leilaoNulo(){	
		Leilao leilao = new CriadorDeLeilao().para("xbox").constroi();
		leiloeiro.avalia(leilao);
		
		Assert.fail();// testa falha
	}
	
	
	@Test
	//a o metodo precisa  ser public void
	public void ordemCrescente() {
		// passo 1 : criar cenario
		Usuario joao = new Usuario(0, "joao");
		Usuario jose = new Usuario(0, "jose");
		Usuario maria = new Usuario(0, "maria");
		
		Leilao leilao = new Leilao("Play 3");
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		
		// passo 2 : executar ação
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		//passo 3 : verificar resultado
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		//assertEquals(valor a serconferido, metodo, parametro para arredondamento);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
			
	}
	
	
	@Test
	public void lanceUnitario() {
		
		Leilao leilao = new Leilao("Play 3");
		leilao.propoe(new Lance(joao, 1000.0));		
		
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 1000.0;
		double menorEsperado = 1000.0;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
			
	}
	
	
	/*=========*/
	
	@Test
	public void encontrarMaioresLances(){
				
		Leilao leilao = new CriadorDeLeilao().para("play 3")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0).
				constroi();
		
		criaAvaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> lances = leiloeiro.getTresMaiores();
		assertEquals(3, lances.size());
		assertEquals(400.0, lances.get(0).getValor(),0.00001);
		assertEquals(300.0, lances.get(1).getValor(),0.00001);
		assertEquals(200.0, lances.get(2).getValor(),0.00001);
		
	}

}
