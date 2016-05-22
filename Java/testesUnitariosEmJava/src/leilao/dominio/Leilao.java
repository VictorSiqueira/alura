package leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
	private String descricao;
	private List<Lance> lances;
	
	
	public Leilao(String descricao) {
		super();
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void propoe (Lance lance){
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())){
			lances.add(lance);
		}
	}
	
	private boolean podeDarLance(Usuario usuario){
		if(!ultimoLanceDado().getUsuario().equals(usuario) && qtdDeLancesDoUsuario(usuario) < 5){
			return true;
		}
		return false;
	}

	private int qtdDeLancesDoUsuario(Usuario usuario) {
		int total = 0;
		for(Lance l : lances){
			if(l.getUsuario().equals(usuario))total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}	
	
}
