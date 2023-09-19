package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoverEmpresa {
	
	public void executa (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			System.out.println("Removendo empresa!");
		
			String paramID = request.getParameter("id");
			Integer id = Integer.valueOf(paramID);
			
			Banco banco = new Banco();
			banco.remove(id);
			
			response.sendRedirect("listaEmpresas");
		
	}
}
