package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Empresa> listaEmpresas = new ArrayList<>();

	public void adiciona(Empresa empresa) {
		this.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return this.listaEmpresas;
	}

	@Override
	public String toString() {
		return "Banco [listaEmpresas=" + listaEmpresas + "]";
	}

	
}
