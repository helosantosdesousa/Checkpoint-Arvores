package aplicacao;

import java.util.Scanner;

import arvore.ArvoreCliente;
import fila.FilaCliente;
import objetos.Clientes;

public class DivulgaOferta {

	//Maria Clara Barreto Donato RM-551390
	//Heloísa Santos de Sousa RM-550256

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		ArvoreCliente cadastro = new ArvoreCliente();
		//ArvoreCadastro oferta = new ArvoreCadastro();
		FilaCliente filaCliente = new FilaCliente();
		filaCliente.init();

		int opcao, op = 0, whatsapp;
		long cpf = 0;
		String nome;
		double totalGasto = 0;

		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscricao um cliente");
			System.out.println(" 2 - Oferta de novo produto/promocacao");
			System.out.println(" 3 – Entrar no Submenu ");
			System.out.println(" 4 - Remove um cliente do cadastro");

			cadastro.show(cadastro.root);

			opcao = le.nextInt();
			switch (opcao) {

				case 0:
					System.out.println("\n\nClientes que não aceitaram ou não estavam "
							+ "adequados para a oferta");
					/*
					 * Apresenta todos os clientes que nao aceitaram nenhuma oferta
					 */
					break;

				case 1:
					System.out.print("Digite nome: ");
					le.nextLine();
					nome = le.nextLine();
					System.out.print("Digite CPF: ");
					cpf = le.nextLong();
					System.out.print("Whatsapp: ");
					whatsapp = le.nextInt();
					System.out.print("Informe total gasto do cliente R$: ");
					totalGasto = le.nextDouble();

					/*
					 * Intancia um objeto da classe Cliente e insere na ABB cadastro organizada pelo CPF
					 */
					Clientes cliente = new Clientes(nome, cpf, whatsapp, totalGasto);
					cadastro.root = cadastro.inserir(cadastro.root, cliente.getCpf());
					//cadastro.show(cadastro.root\n);
					break;


				/*case 2:
					System.out.print("Qual o valor de saldo minimo exigido: R$ ");
					totalGasto = le.nextDouble();*/
		/*
		-- Percorrendo a ABB de cadastro gera ABB oferta usando como criterio de organizacao o total de gasto do cliente.
		-- Usando um método de percurso gerar uma fila de clientes para contactar via whatsapp, em ordem decrescente de gastos (o primeiro cliente deve ser o com maior valor de gasto.
		-- Esvazia ABB oferta.
		-- Nesse trecho de programa que é simulada a tentativa de fazer o contato com cada um dos clientes presentes na fila. Até nao ter mais clientes para contactar.
		-- Cada cliente que aceita a oferta tem o atributo apto para oferta alterado para false no seu cadastro
		*/
					//break;
				case 3:
//----------------------------------- SUBMENU -----------------------------------------------------------
					do {
						System.out.println("\t 1) Consulta cliente buscando pelo CPF ");
						System.out.println("\t 2) Apresenta o total de gasto de todos os clientes");
						System.out.println("\t 3) Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
						System.out.println("\t 4) Volta menu principal");
						op = le.nextInt();
						switch (op) {
							//Apresenta todos os atributos do cliente consultado ou avisa se CPF nao foi encontrado.
							case 1:
								System.out.print("Informe CPF para consulta");
								cpf = le.nextInt();
								if (cadastro.consulta(cadastro.root, cpf))
									System.out.println("Valor presente na árvore binária");
								else
									System.out.println("Valor nao está presente na árvore binária");
								break;
							case 2:
						//Apresenta soma de todos os gastos de todos os clientes
								break;

                            case 3:
						//Apresenta a quantidade de clientes com gastos a partir do minimo consultado
								/*
								int cont=0;
								System.out.print("Qual valor minimo de gastos para consulta? R$ ");
								double minimo = le.nextDouble();

								System.out.println("Quantidade de clientes que gastaram no mínimo R$ " + minimo + ": " + cont);
								break;*/
							case 4:
								System.out.println("Voltando ao menu principal....");
								break;
							default:
								System.out.println("Opcao invalida");
						}
						break;
					} while (op != 4);
					//-------------------------- FIM DO SUBMENU ----------------------------------------------------------------

				case 4:
					/*Encerra o programa: antes de fechar aplicação deve ser apresentados todos os clientes que
não aceitaram nenhuma das ofertas presentes na ABB de cadastro só então o programa deve
ser encerrado.*/
					System.out.print("Informe CPF do cliente que deseja ser retirado do cadastro: ");
					cpf = le.nextInt();

					//Retira da ABB de cadastro o cliente escolhido pelo CPF
					/*if (cadastro.consulta(cadastro.root, cpf)) {
						cadastro.root = cadastro.removeValor(cadastro.root, cpf);
						System.out.println("Cliente removido com sucesso.");
					} else {
						System.out.println("Cliente com CPF " + cpf + " não encontrado.");
					}*/
					break;

				default:
					System.out.println("Opcao invalida");
			}
		} while (opcao != 0);
		le.close();
	}
}