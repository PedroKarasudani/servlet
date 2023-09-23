package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			System.out.println("Fazendo Lougout");
			HttpSession sessao = request.getSession();
			//sessao.removeAttribute("usuarioLogado"); funciona, mas o navegador continua com o mesmo cookie, o proximo login pode extrair informacoes do antigo login
			sessao.invalidate(); //dessa forma invalida o cookie do antigo login
			
			return "redirect:entrada?acao=FormLogin";
		
	}

}
