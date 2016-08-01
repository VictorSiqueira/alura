package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")//endpoint para servlet
//sempre que eu quiser escrever uma servlet preciso extender de HttpServlet
public class BuscaEmpresa implements Tarefa{
	
	public BuscaEmpresa() {
		System.out.println("Construindo Servlet BuscaEmpresa: "+this);
	}
	
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");		
		Collection<Empresa> buscaSimilaridade = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", buscaSimilaridade);		
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}	
}
