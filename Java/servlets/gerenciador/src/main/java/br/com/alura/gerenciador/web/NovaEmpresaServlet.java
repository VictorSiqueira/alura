package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		
		new EmpresaDAO().adiciona(empresa);
		
		//quando insiro no request um atributo ele apenas dura a reuisição
		//depois de entregar aoclient, morre
		req.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
		
		//escrevendo respostaHTML em varias linhas
//		PrintWriter printWriter = resp.getWriter();
//		printWriter.println("<html><body>");
//		printWriter.println("Empresa "+empresa.getNome()+" adicionada com sucesso.");
//		printWriter.println("</body></html>");
	}
}
