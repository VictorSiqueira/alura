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
public class BuscaEmpresaServlet extends HttpServlet{
	
	public BuscaEmpresaServlet() {
		System.out.println("Construindo Servlet BuscaEmpresa: "+this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Iniciando Servlet BuscaEmpresa: "+this);
	}
	// Para forçar a invocação do método destroy devemos parar o servidor
	//dando stop no servidor (não dê stop no console, que mata o servidor 
	//sem dar tempo de reação).
	@Override
	public void destroy() {
		System.out.println("Destruindo Servlet BuscaEmpresa: "+this);
		super.destroy();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		//paramentro passado apos "?" na url. 
		//ex.: http://localhost:8080/gerenciador/busca?filtro=doce
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> buscaSimilaridade = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", buscaSimilaridade);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
		
		//resposta em geração de html
		
//		writer.println("<html><body>");
//		writer.println("Resultado da busca : <br/>");
//		
//		//paramentro passado apos "?" na url. 
//		//ex.: http://localhost:8080/gerenciador/busca?filtro=doce
//		String filtro = req.getParameter("filtro");
//		
//		Collection<Empresa> buscaSimilaridade = new EmpresaDAO().buscaPorSimilaridade(filtro);
//		writer.println("<ul>");
//
//		//for each em lambda
//		buscaSimilaridade.forEach( emp -> {
//			writer.println("<li>"+emp.getId()+"- "+emp.getNome()+"</li>");
//		});
//		
//		writer.println("<ul>");		
//		writer.println("</body></html>");

	}	
}
