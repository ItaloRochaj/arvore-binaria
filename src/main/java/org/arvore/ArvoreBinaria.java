package org.arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo)); // Correção de setNoDir
        }
        return atual;
    }

    public void exibirInOrdem() {
        System.out.println("\nExibindo em ordem:");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", "); // Mudança de println para print
            exibirInOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem() {
        System.out.println("\nExibindo em pós-ordem:");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", "); // Mudança de println para print
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\nExibindo em pré-ordem:");
        exibirPreOrdem(this.raiz); // Correção de chamada para o método correto
    }

    private void exibirPreOrdem(BinNo<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", "); // Mudança de println para print
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void remover(T conteudo) {
        this.raiz = remover(this.raiz, conteudo);
    }

    private BinNo<T> remover(BinNo<T> atual, T conteudo) {
        if (atual == null) {
            System.out.println("Conteúdo não encontrado.");
            return null;
        }

        if (conteudo.compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(remover(atual.getNoEsq(), conteudo));
        } else if (conteudo.compareTo(atual.getConteudo()) > 0) {
            atual.setNoDir(remover(atual.getNoDir(), conteudo));
        } else {
            // Caso 1: nó sem filhos
            if (atual.getNoEsq() == null && atual.getNoDir() == null) {
                return null;
            }
            // Caso 2: nó com apenas um filho
            if (atual.getNoEsq() == null) {
                return atual.getNoDir();
            }
            if (atual.getNoDir() == null) {
                return atual.getNoEsq();
            }
            // Caso 3: nó com dois filhos
            BinNo<T> temp = encontrarMinimo(atual.getNoDir());
            atual.setConteudo(temp.getConteudo());
            atual.setNoDir(remover(atual.getNoDir(), temp.getConteudo()));
        }
        return atual;
    }

    private BinNo<T> encontrarMinimo(BinNo<T> atual) {
        while (atual.getNoEsq() != null) {
            atual = atual.getNoEsq();
        }
        return atual;
    }
}
