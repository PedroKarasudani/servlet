package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

/**
 * Servlet implementation class RemoverEmpresaServlet
 */
@WebServlet("/removerEmpresa")
public class RemoverEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);
		
		Banco banco = new Banco();
		banco.remove(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
