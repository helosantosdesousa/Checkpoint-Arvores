package arvore;

import fila.FilaOferta;
import objetos.Cliente;

public class ArvoreCadastro {

    private class ARVORE {
        Cliente dado;
        ARVORE esq;
        ARVORE dir;
    }

    public ARVORE root = null;

    public ARVORE inserir(ARVORE p, Cliente cliente) {
        if (p == null) {
            p = new ARVORE();
            p.dado = cliente;
            p.esq = null;
            p.dir = null;
        } else if (cliente.getCpf() < p.dado.getCpf())
            p.esq = inserir(p.esq, cliente);
        else
            p.dir = inserir(p.dir, cliente);
        return p;
    }

    public void show(ARVORE p) {
        if (p != null) {
            show(p.esq);
            System.out.print("\t" + p.dado);
            show(p.dir);
        }
    }

    public boolean consulta(ARVORE p, long cpf) {
        if (p == null) return false;
        if (cpf == p.dado.getCpf()) return true;
        return cpf < p.dado.getCpf() ? consulta(p.esq, cpf) : consulta(p.dir, cpf);
    }

    public ARVORE removeValor(ARVORE p, long cpf) {
        if (p == null) return null;

        if (cpf == p.dado.getCpf()) {
            if (p.esq == null && p.dir == null) return null;
            if (p.esq == null) return p.dir;
            if (p.dir == null) return p.esq;

            ARVORE aux = p.dir;
            while (aux.esq != null) aux = aux.esq;
            p.dado = aux.dado;
            p.dir = removeValor(p.dir, aux.dado.getCpf());
        } else if (cpf < p.dado.getCpf()) {
            p.esq = removeValor(p.esq, cpf);
        } else {
            p.dir = removeValor(p.dir, cpf);
        }
        return p;
    }

    public void gerarFila(ARVORE p, double valorMinimo, FilaOferta fila) {
        if (p != null) {
            gerarFila(p.dir, valorMinimo, fila);  // Ordem decrescente
            if (p.dado.getTotalGasto() >= valorMinimo) {
                fila.enqueue(p.dado);
            }
            gerarFila(p.esq, valorMinimo, fila);
        }
    }

    public double somaGastos(ARVORE p) {
        if (p == null) return 0;
        return p.dado.getTotalGasto() + somaGastos(p.esq) + somaGastos(p.dir);
    }

    public int contarClientesAcimaDe(ARVORE p, double valorMinimo) {
        if (p == null) return 0;
        int count = (p.dado.getTotalGasto() >= valorMinimo) ? 1 : 0;
        return count + contarClientesAcimaDe(p.esq, valorMinimo) + contarClientesAcimaDe(p.dir, valorMinimo);
    }

    public void mostraClientesNaoParticipantes(ARVORE p) {
        if (p != null) {
            mostraClientesNaoParticipantes(p.esq);
            if (!p.dado.isApto(false)) {
                System.out.println(p.dado);
            }
            mostraClientesNaoParticipantes(p.dir);
        }
    }
}
