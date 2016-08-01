package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

//é importante resaltar que servlets geram apenas uma instancia, ou seja,
//só morrem no desligamento do server
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{
	final static Map<String, String> USUARIOS_LOGADOS = new HashMap<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario =  new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if(usuario == null){
			writer.println("Usuario nao encontrado");
		}else{
//			String codigoAleatorio = "" + System.currentTimeMillis()+"/"+Math.random();
//			USUARIOS_LOGADOS.put(codigoAleatorio, email);
			
			//trabalhando com session
			HttpSession session = req.getSession();
			//guarda na memoria do servidor e cria um hash no cookies do cara
			session.setAttribute("usuarioLogado", usuario);
			
			
			//enviando cookie na resposta do server
//			Cookie cookie = new Cookie("usuario.logado", codigoAleatorio);
//			cookie.setMaxAge(10*60);
//			resp.addCookie(cookie);
			writer.println("Bem-vindo: "+usuario.getEmail());
		}
	}
}
