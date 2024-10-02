package aplicacao;

import java.util.Scanner;

import arvore.ArvoreCadastro;
import arvore.ArvoreCliente;
import fila.FilaOferta;
import objetos.Cliente;

public class DivulgaOferta {
	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		ArvoreCadastro cadastro = new ArvoreCadastro();
		FilaOferta filaCliente = new FilaOferta();

		int opcao, op = 0, whatsapp;
		String nome;
		long cpf;
		double total = 0;

		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscrição de um cliente");
			System.out.println(" 2 - Oferta de novo produto/promoção");
			System.out.println(" 3 – Entrar no Submenu");
			System.out.println(" 4 - Remover um cliente do cadastro");

			cadastro.show(cadastro.root);

			opcao = le.nextInt();
			switch (opcao) {

				case 0:
					System.out.println("\n\nClientes que não aceitaram ou não estavam adequados para a oferta");
					break;

				case 1:
					System.out.print("Digite nome: ");
					le.nextLine();
					nome = le.nextLine();
					System.out.print("Digite CPF(String): ");
					cpf = le.nextLong();
					System.out.print("Whatsapp: ");
					whatsapp = le.nextInt();
					System.out.print("Informe total gasto do cliente R$: ");
					total = le.nextDouble();

					Cliente cliente = new Cliente(nome, cpf, whatsapp, total);
					cadastro.root = cadastro.inserir(cadastro.root, cliente);
					cadastro.show(cadastro.root);

					break;

				case 2:
					System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
					total = le.nextDouble();

					// Percorrendo a ABB de cadastro para enfileirar clientes que atendem o saldo mínimo
					cadastro.gerarFila(cadastro.root, total, filaCliente);

					Cliente clienteFila;
					while ((clienteFila = filaCliente.dequeue()) != null) {
						System.out.println("Entrando em contato com: " + clienteFila.getNome() + " via WhatsApp: " + clienteFila.getWhatsapp());
						System.out.println("Cliente aceitou a oferta? (1-Sim / 2-Não)");
						int resposta = le.nextInt();
						if (resposta == 1) {
							// Cliente aceitou a oferta, modificando diretamente o cliente da árvore
							clienteFila.setApto(true); // Como clienteFila é uma referência, a árvore será atualizada automaticamente.
							System.out.println("Oferta aceita!");
						} else {
							System.out.println("Oferta recusada!");
						}
					}

					break;


				case 3:
					do {
						System.out.println("\t 1) Consulta cliente buscando pelo CPF");
						System.out.println("\t 2) Apresenta o total de gasto de todos os clientes");
						System.out.println("\t 3) Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
						System.out.println("\t 4) Volta menu principal");
						op = le.nextInt();

						switch (op) {
							case 1:
								System.out.print("Informe CPF para consulta: ");
								cpf = le.nextLong();
								if (cadastro.consulta(cadastro.root, cpf)) {
									System.out.println("Cliente encontrado na árvore de cadastro.");
								} else {
									System.out.println("Cliente não encontrado.");
								}
								break;
							case 2:
								double totalGastos = cadastro.somaGastos(cadastro.root);
								System.out.println("Total gasto por todos os clientes: R$ " + totalGastos);
								break;
							case 3:
								System.out.print("Qual valor mínimo de gastos para consulta? R$ ");
								double minimo = le.nextDouble();
								int cont = cadastro.contarClientesAcimaDe(cadastro.root, minimo);
								System.out.println("Quantidade de clientes que gastaram no mínimo R$ " + minimo + ": " + cont);
								break;
							case 4:
								System.out.println("Voltando ao menu principal...");
								break;
							default:
								System.out.println("Opção inválida.");
						}
					} while (op != 4);
					break;

				case 4:
					System.out.print("Informe CPF do cliente que deseja ser retirado do cadastro: ");
					cpf = le.nextLong();
					cadastro.root = cadastro.removeValor(cadastro.root, cpf);
					System.out.println("Cliente removido com sucesso.");
					break;

				default:
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
		le.close();
	}
}
