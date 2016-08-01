package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;


@WebFilter(urlPatterns="/*")//define para onde o filter vai trabalhar, no caso pra tudo
public class Auditoria implements Filter {

	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String usuario = getUsuario(req, resp);
		
		System.out.println("Usuario: "+usuario+", acessando: "+req.getRequestURI());
		// quando se usa um filter é necessario informar ele para dar sequencia
		//ao processo do serviço, pois quando ele intercepta, nao necessariamente,
		//havera retorno pro client
		chain.doFilter(request, resp);
	}
	
	
	private String getUsuario(HttpServletRequest req, HttpServletResponse resp) {
		//obtendo valores da session
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario != null){
			req.getSession().setMaxInactiveInterval(10*60);//limite de interação do usuario por session
			return usuario.getEmail();
		}else 
			return "deslogado";
		
		
		//obtendo os cookies do navegador client
//		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		if(cookie== null)
//			return "deslogado";
//		return cookie.getValue();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
