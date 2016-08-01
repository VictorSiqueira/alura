package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Simplicando tudo para apenas uma Servlet
/**
 * Servlet implementation class FazTudo
 */
@WebServlet("/fazTudo")
public class FazTudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FazTudo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String tarefa = req.getParameter("tarefa");
    	if(tarefa ==  null){
    		throw new IllegalArgumentException("Você esqueceu de passar a tarefa.");
    	}
    	tarefa = "br.com.alura.gerenciador.web" + tarefa;
    	// o java precisa executar referecnia a classe em compilação,
    	//para isso usamos o Class, o <?> é para tornar geenerico
    	try {
			Class<?> tipo = Class.forName(tarefa);
			//interface para agrupar as classes
			Tarefa obj = (Tarefa)tipo.newInstance();
			String pagina = obj.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException e) {
			throw new  ServletException(e);
		}
    }
}
