package arvore;

import objetos.Clientes;

public class ArvoreCliente {

		private class ARVORE {
			int dado;
			ARVORE esq;
			ARVORE dir;
		}

		public ARVORE root = null;

		//(cadastro.root, cliente)
		public ARVORE inserir(ARVORE p, int info) {
			// insere elemento em uma ABB
			if (p == null) {
				p = new ARVORE();
				p.dado = info;
				p.esq = null;
				p.dir = null;
			} else if (info < p.dado)
				p.esq = inserir(p.esq, info);
			else
				p.dir = inserir(p.dir, info);
			return p;
		}

		public void show(ARVORE p) {
			if (p != null) {
				show(p.esq);
				System.out.print("\t" + p.dado);
				show(p.dir);
			}
		}

		public boolean consulta(ARVORE p, double info) {
			boolean achou = false;
			if (p != null) {
				if (info == p.dado)
					achou = true;
				else if (info < p.dado)
					achou = consulta(p.esq, info);
				else
					achou = consulta(p.dir, info);
			}
			return achou;
		}

	public ARVORE removeValor(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				if (p.esq == null && p.dir == null) // nó a ser removido é nó folha
					return null;
				if (p.esq == null) { // se não há sub-árvore esquerda o ponteiro passa apontar para a sub-árvore
					// direita
					return p.dir;
				} else {
					if (p.dir == null) { // se não há sub-árvore direita o ponteiro passa apontar para a sub-árvore
						// esquerda
						return p.esq;
					} else { /*
					 * o nó a ser retirado possui sub-arvore esquerda e direita, então o nó que será
					 * retirado deve-se encontrar o menor valor na sub-árvore á direita
					 */
						ARVORE aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else { // procura dado a ser removido na ABB
				if (info < p.dado)
					p.esq = removeValor(p.esq, info);
				else
					p.dir = removeValor(p.dir, info);
			}
		}
		return p;
	}
		
}
