package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().removeAttribute("usuarioLogado");//basta remover que invalida o item
		//req.getSession().invalidate(); // mata a sessao completamente
		
		
//		Cookie cookie =  new Cookies(req.getCookies()).buscaUsuarioLogado();
//		PrintWriter printWriter = resp.getWriter();
//		if(cookie == null){
//			printWriter.println("Usuário ja deslogado");
//			return;//para parar a execução
//		}
//		cookie.setMaxAge(0);
//		resp.addCookie(cookie);
//		printWriter.println("Volte sempre");
		
		//redirecionamento a partir do client-side(aberto)
		//resp.sendRedirect("logout.html");
		
		//redirecionamento interno no server side(escondido)
		//pasta WEB-INF não é acessivel
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
	}
}
