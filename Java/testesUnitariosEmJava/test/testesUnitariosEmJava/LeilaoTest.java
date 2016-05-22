package testesUnitariosEmJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;
import leilao.dominio.Lance;
import leilao.dominio.Leilao;
import leilao.dominio.Usuario;

public class LeilaoTest {
	@Test
	public void recebeUmLance(){
		Leilao leilao = new Leilao("Macbook");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario(0, "BNome"), 2000.0));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void recebeVartiosLances(){
		Leilao leilao = new Leilao("Macbook");
		leilao.propoe(new Lance(new Usuario(0, "BNome"), 2000.0));
		leilao.propoe(new Lance(new Usuario(0, "XPTO"), 3000.0));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(),0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValor(),0.00001);
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidos(){
		Leilao leilao = new Leilao("Macbook");
		Usuario steveJobs = new Usuario(0, "steveJobs");
		
		leilao.propoe(new Lance(steveJobs,2000.0));
		leilao.propoe(new Lance(steveJobs,3000.0));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisdeCincoLances(){
		Leilao leilao = new Leilao("Macbook");
		Usuario steveJobs = new Usuario(0, "steveJobs");
		Usuario billGates = new Usuario(0, "billGates");
		
		leilao.propoe(new Lance(steveJobs,2000.0));
		leilao.propoe(new Lance(billGates,3000.0));
		
		leilao.propoe(new Lance(steveJobs,4000.0));
		leilao.propoe(new Lance(billGates,5000.0));
		
		leilao.propoe(new Lance(steveJobs,6000.0));
		leilao.propoe(new Lance(billGates,7000.0));
		
		leilao.propoe(new Lance(steveJobs,8000.0));
		leilao.propoe(new Lance(billGates,9000.0));
		
		leilao.propoe(new Lance(steveJobs,10000.0));
		leilao.propoe(new Lance(billGates,11000.0));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(),0.00001);

		
	}
}
