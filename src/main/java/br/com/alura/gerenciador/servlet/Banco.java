package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static int chaveSequencial = 1;

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

	
}
