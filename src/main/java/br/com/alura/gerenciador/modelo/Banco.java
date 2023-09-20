package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static int chaveSequencial = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Intel");
		listaEmpresas.add(empresa1);
		listaEmpresas.add(empresa2);
		
		Usuario usuario1 = new Usuario("Pedro", "12345");
		Usuario usuario2 = new Usuario("Barbara", "12345");
		listaUsuario.add(usuario1);
		listaUsuario.add(usuario2);
	}
	
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	
	
	public void remove(Integer id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}

	@Override
	public String toString() {
		return "Banco [listaEmpresas=" + listaEmpresas + "]";
	}



	public Empresa buscaEmpresaPeloID(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	
}
