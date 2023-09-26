 package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("!!Controlador!!");
		
			String paramAcao = request.getParameter("acao");
					
			String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			String nome;
			try {
				Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
				Acao acao = (Acao) classe.newInstance();
				nome = acao.executa(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | ServletException e) {
				throw new ServletException(e);
			}
			
//		    String nome = null;
//		    if(paramAcao.equals("ListaEmpresas")) {
//		    	ListaEmpresas acao = new ListaEmpresas();
//		    	nome = acao.executa(request, response);
//		    	
//		    } else if (paramAcao.equals("RemoverEmpresa")) {
//		    	RemoverEmpresa acao = new RemoverEmpresa();
//		    	nome = acao.executa(request, response);
//		    	
//		    } else if(paramAcao.equals("MostraEmpresa")) {
//		    	MostraEmpresa acao = new MostraEmpresa();
//		    	nome = acao.executa(request, response);
//		    	
//		    } else if(paramAcao.equals("AlteraEmpresa")) {
//		    	AlteraEmpresa acao = new AlteraEmpresa();
//		    	nome = acao.executa(request, response);
//		    	
//		    } else if(paramAcao.equals("NovaEmpresa")) {
//		    	NovaEmpresa acao = new NovaEmpresa();
//		    	nome =  acao.executa(request, response);
//		    	
//		    } else if(paramAcao.equals("FormNovaEmpresa")) {
//		    	FormNovaEmpresa acao = new FormNovaEmpresa();
//		    	nome =  acao.executa(request, response);
//		    }
		    
		    
		    String[] tipoEEndereco = nome.split(":");
		    
		    if (tipoEEndereco[0].equals("forward")) {
			    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view"+ tipoEEndereco[1]);
				rd.forward(request, response);
		    } else if (tipoEEndereco[0].equals("redirect")) {
		    	response.sendRedirect(tipoEEndereco[1]);
		    }
	}

}
