package fila;

import objetos.Cliente;

public class FilaOferta {

	private class NO {
		Cliente cliente;
		NO prox;
	}

	private NO inicio, fim;

	public void init() {
		inicio = fim = null;
	}

	public boolean isEmpty() {
		return (inicio == null && fim == null);
	}

	public void enqueue(Cliente cliente) {
		NO novo = new NO();
		novo.cliente = cliente;
		novo.prox = null;
		if (inicio == null) {
			inicio = fim = novo;
		} else {
			fim.prox = novo;
			fim = novo;
		}
	}

	public Cliente dequeue() {
		if (inicio == null) return null;
		Cliente cliente = inicio.cliente;
		inicio = inicio.prox;
		if (inicio == null) fim = null;
		return cliente;
	}
}



