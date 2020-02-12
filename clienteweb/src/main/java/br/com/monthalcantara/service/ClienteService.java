package br.com.monthalcantara.service;

import java.util.ArrayList;
import java.util.List;

import br.com.monthalcantara.model.Cliente;

public class ClienteService {
	static List<Cliente> lista = new ArrayList<Cliente>();
	public void cadastrar(Cliente cli) {
		lista.add(cli);
	}
	
	public static List<Cliente> getLista() {
		return lista;
	}

	public static void setLista(List<Cliente> lista) {
		ClienteService.lista = lista;
	}
	public void excluir(int indice) {
		lista.remove(indice);
	}
}
