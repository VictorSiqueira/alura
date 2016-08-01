package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		req.getSession().removeAttribute("usuarioLogado");//basta remover que invalida o item
		return "/WEB-INF/paginas/logout.html";
	}
}
