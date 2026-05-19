package parte3;

public class ListaAnuncio<T> {
    private No<T> fim;
    private No<T> anuncioAtual;

    public ListaAnuncio() {
        this.fim = null;
    }

    public void inserirNoFim(T valor) {
        No<T> novo = new No<>(valor);
        if (fim == null) {
            fim = novo;
            fim.proximo = fim;
        } else {
            novo.proximo = fim.proximo;
            fim.proximo = novo;
            fim = novo;
        }
    }

    public void inserirApos(T valor) {
        No <T> novo = new No<>(valor);
        if (fim == null) {
            fim = novo;
            fim.proximo = fim;
            anuncioAtual = fim; //
        } else {//
            if (anuncioAtual == null) {//
                anuncioAtual = fim.proximo;//
            }//
            novo.proximo = anuncioAtual.proximo;
            anuncioAtual.proximo = novo;
        }
    }

    public void exibirAvancar () {
        if (fim == null) {
            System.out.println("Não tem nenhum anúncio");
            return;
        }

        if (anuncioAtual == null) {
            anuncioAtual = fim.proximo;
        } else {
            anuncioAtual = anuncioAtual.proximo;
        }

        System.out.println(anuncioAtual.dado);


    }

    public T removerNoInicio() {
        if (fim == null) return null;
        No<T> inicio = fim.proximo;
        T valor = inicio.dado;
        if (fim == inicio) {
            fim = null;
        } else {
            fim.proximo = inicio.proximo;
        }
        return valor;
    }

    public void imprimir() {
        if (fim == null) return;
        No<T> atual = fim.proximo;
        do {
            System.out.print(atual.dado + "\n");
            atual = atual.proximo;
        } while (atual != fim.proximo);
        System.out.println();
    }


}
