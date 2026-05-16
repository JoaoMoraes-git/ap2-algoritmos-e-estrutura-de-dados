package parte2;

public class ListaPlaylist<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;
    private int indiceAtual;

    public ListaPlaylist() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        this.indiceAtual = 0;
    }

//    public void proximo() {
//        if (indiceAtual + 1 > tamanho) {
//            System.out.println("");
//        }
//    }

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

    public void removePorTitulo(String titulo) {

        No atual = inicio;
        No anterior = null;

        if (inicio == null) {
            System.out.println("A playlist está vazia");
            return;
        }

        Musica tituloM = (Musica) atual.dado;
        if (tituloM.getTitulo().trim().toLowerCase().equals(titulo)) {
            inicio = inicio.proximo;
            System.out.println("A música " + tituloM.getTitulo() + " foi removida");
            tamanho--;
            return;
        }

        while (atual != null) {
            tituloM = (Musica) atual.dado;
            if (tituloM.getTitulo().trim().toLowerCase().equals(titulo)) {
                anterior.proximo = atual.proximo;
                System.out.println("A música " + tituloM.getTitulo() + " foi removida");
                tamanho--;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        System.out.println("Música não encontrada na playlist");

    }

    public void removerPorPosicao(int indice) {

        int contagem = 0;

        if (indice < 0 || indice >= tamanho) {
            System.out.println("Nenhuma música nessa posição");
            return;
        }

        if (inicio == null) {
            System.out.println("A playlist está vazia.");
            return;
        }
        // Se o nó a ser removido for o head
        if (indice == 0) {
            inicio = inicio.proximo;
            tamanho--;
            return;
        }

        No atual = inicio;
        No anterior = null;
        while (indice > contagem) {
            anterior = atual;
            atual = atual.proximo;
            contagem++;
        }

        anterior.proximo = atual.proximo;
        tamanho--;
    }

    public void ordenarPorTitulo() {
        if (inicio == null) {
            System.out.println("A playlist está vazia");
            return;
        }

        boolean trocado;

        do {
            trocado = false;
            No atual = inicio;

            while (atual.proximo != null) {
                Musica musicaAtual = (Musica) atual.dado;
                Musica musicaProxima = (Musica) atual.proximo.dado;

                if (musicaAtual.getTitulo().compareToIgnoreCase(musicaProxima.getTitulo()) > 0) {

                    Object temp = atual.dado;
                    atual.dado = atual.proximo.dado;
                    atual.proximo.dado = temp;

                    trocado = true;
                }

                atual = atual.proximo;
            }
        } while (trocado);
        System.out.println("A lista foi ordenada por título");
    }

    public void ordenarPorArtista() {
        if (inicio == null) {
            System.out.println("A playlist está vazia");
            return;
        }

        boolean trocado;

        do {
            trocado = false;
            No atual = inicio;

            while (atual.proximo != null) {
                Musica musicaAtual = (Musica) atual.dado;
                Musica musicaProxima = (Musica) atual.proximo.dado;

                if (musicaAtual.getArtista().compareToIgnoreCase(musicaProxima.getArtista()) > 0) {

                    Object temp = atual.dado;
                    atual.dado = atual.proximo.dado;
                    atual.proximo.dado = temp;

                    trocado = true;
                }

                atual = atual.proximo;
            }
        } while (trocado);
        System.out.println("A lista foi ordenada por artista");
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
        int indice = 0;
        while (atual != null) {
            System.out.print(indice + ". " + atual.dado + " ");
            atual = atual.proximo;
            indice ++;
            System.out.println();
        }
        System.out.println();
    }

    public int getTamanho() {
        return this.tamanho;
    }




}
