package parte3;

public class ListaAnuncio<T> {
    private No<T> fim;
    private No<T> anuncioAtual;
    private int tamanho;

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
        tamanho++;
    }

    public void inserirApos(T valor) {
        No <T> novo = new No<>(valor);
        if (fim == null) {
            fim = novo;
            fim.proximo = fim;
            anuncioAtual = fim;
        } else {
            if (anuncioAtual == null) {
                anuncioAtual = fim.proximo;
            }
            novo.proximo = anuncioAtual.proximo;
            anuncioAtual.proximo = novo;

            if (anuncioAtual == fim) {
                fim = novo;
            }
        }
        tamanho++;
    }

    public void exibirAvancar () {
        if (fim == null) {
            System.out.println("Não tem nenhum anúncio");
            return;
        }

        if (anuncioAtual == null) {
            anuncioAtual = fim.proximo;
        }

        System.out.println(anuncioAtual.dado);

        anuncioAtual = anuncioAtual.proximo;


    }

    public void removerPorId(String id) {
        if (fim == null) {
            System.out.println("A lista está vazia");
            return;
        }
        No<T> atual = fim.proximo;
        No<T> anterior = fim;

        for (int i = 0; i < tamanho; i++) {
            Anuncio anuncio = (Anuncio) atual.dado;

            if (anuncio.getId().toString().equals(id)) {

                if(anuncioAtual == atual) {
                    if (tamanho == 1) {
                        anuncioAtual = null;
                    } else {
                        anuncioAtual = atual.proximo;
                    }

                }

                if (atual == fim && atual == fim.proximo) {
                    fim = null;
                } else {
                    anterior.proximo = atual.proximo;

                    if (atual == fim) {
                        fim = anterior;
                    }
                }

                tamanho--;
                return;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        System.out.println("Não tem nenhum anúncio com esse ID");

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
