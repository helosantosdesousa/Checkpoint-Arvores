package arvore;

public class ArvoreOferta {

	private class ARVORE {
		int dado;
		ARVORE esq;
		ARVORE dir;
	}

	public ARVORE root = null;

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
