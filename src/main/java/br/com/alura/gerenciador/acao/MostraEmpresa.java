package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Mostrando Empresa!!");		
		
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloID(id);
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		
		return "forward:/formAlteraEmpresa.jsp";
	
	}

}
