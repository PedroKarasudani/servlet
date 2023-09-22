package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogando") == null) {
			return "redirect:entrada?acao=FormLogin";
		}
		
		System.out.println("Listando Empresa!");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("lista", lista);
		
		return "forward:/listaEmpresas.jsp";
	}
}
