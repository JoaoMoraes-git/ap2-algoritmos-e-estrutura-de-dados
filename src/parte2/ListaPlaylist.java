package parte2;

public class ListaPlaylist<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public ListaPlaylist() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionarNoFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
    }

    public void adicionarNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(T elemento, int indice){
        if (indice < 0 || indice > tamanho){
            System.out.println("Posição inválida");
            return;
        }

        No<T> novo = new No<>(elemento);

        //No começo
        if (indice == 0) {
            novo.proximo = inicio;

            if (inicio != null) {
                inicio.anterior = novo;
            }

            inicio = novo;
        }
        //No final
        else if (indice == tamanho) {
            if (inicio == null) {
                inicio = novo;
            } else {
                No<T> atual = inicio;

                while (atual.proximo != null){
                    atual = atual.proximo;

                }

                atual.proximo = novo;
                novo.anterior = atual;
            }
        }

        //No meio
        else {
            No<T> atual = inicio;

            for (int i = 0; i < indice - 1; i++){
                atual = atual.proximo;
            }

            novo.proximo = atual.proximo;
            novo.anterior = atual;

            atual.proximo.anterior = novo;
            atual.proximo = novo;
        }

        tamanho++;
    }

    public void remover(T dado) {
        if (inicio == null) return;

        No<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                if (atual == inicio) {
                    inicio = atual.proximo;
                    if (inicio != null) inicio.anterior = null;
                }

                else if (atual == fim) {
                    fim = atual.anterior;
                    if (fim != null) fim.proximo = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                return;
            }
            atual = atual.proximo;
        }
    }

    public boolean contem(T dado) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(dado)) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public void imprimirLista() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
            System.out.println();
        }
        System.out.println();
    }




}
