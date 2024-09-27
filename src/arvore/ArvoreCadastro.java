package arvore;

import objetos.Clientes;

public class ArvoreCadastro{

		private class ARVORE {
			int dado;
			ARVORE esq;
			ARVORE dir;
		}

		public ARVORE root = null;

		//(cadastro.root, cliente)
		public ARVORE inserir(ARVORE p, Clientes cliente) {
			// insere elemento em uma ABB
			if (p == null) {
				p = new ARVORE();
				p.dado = cliente.getCpf();
				p.esq = null;
				p.dir = null;
			} else if (cliente.getCpf() < p.dado)
				p.esq = inserir(p.esq, cliente.getCpf());
			else
				p.dir = inserir(p.dir, cliente.getCpf());
			return p;
		}

		public void show(ARVORE p) {
			if (p != null) {
				show(p.esq);
				System.out.print("\t" + p.dado);
				show(p.dir);
			}
		}

		public boolean consulta(ARVORE p, int info) {
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
		
}
