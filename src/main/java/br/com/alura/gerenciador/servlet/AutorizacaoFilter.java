package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("!!Autorizacao Filter!!");
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogando = sessao.getAttribute("usuarioLogado") == null;
		boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin")); // inves de colocar as todas as paginas que precisam de login, faz verificacao somente as que nao precisam
		if(ehAcaoProtegida && usuarioNaoEstaLogando) { 
			response.sendRedirect("entrada?acao=FormLogin");
			return;
		}
		
		chain.doFilter(request, response);
		
	}
}
