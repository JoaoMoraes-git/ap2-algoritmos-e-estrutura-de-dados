package parte2;

public class ListaPlaylist<T> {

    private No<T> inicio;
    private No<T> fim;
    private No<T> atual;
    private int tamanho;
    private int indiceAtual;

    public ListaPlaylist() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        this.indiceAtual = 0;
    }

    public Musica tocar() {

        if (atual == null) {
            System.out.println("A lista está vazia");
            return null;
        }

        return (Musica) atual.dado;
    }

    public String proximo() {

        if (atual == null) {
            return "A playlist está vazia";
        }

        if (atual.proximo == null) {
            return "Você já está no final da playlist";
        }

        atual = atual.proximo;
        indiceAtual++;

        Musica musica = (Musica) atual.dado;
        return musica.getTitulo();
    }

    public String anterior() {

        if (atual == null) {
            return "A playlist está vazia";
        }

        if (atual.anterior == null) {
            return "Você já está no início da playlist";
        }

        atual = atual.anterior;
        indiceAtual--;

        Musica musica = (Musica) atual.dado;
        return musica.getTitulo();
    }

    public void adicionarNoFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            atual = novoNo;
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
            atual = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(T dado, int indice){
        if (indice < 0 || indice > tamanho){
            System.out.println("Posição inválida");
            return;
        }

        No<T> novoNo = new No<>(dado);

        //Se for o primeiro item adicionado
        if (inicio == null) {
            inicio = novoNo;
            atual = novoNo;
            fim = novoNo;
            return;
        }

        //No começo
        if (indice == 0) {
            novoNo.proximo = inicio;

            if (inicio != null) {
                inicio.anterior = novoNo;
            }

            inicio = novoNo;
        }
        //No final
        else if (indice == tamanho) {
            if (inicio == null) {
                inicio = novoNo;
            } else {
                No<T> atual = inicio;

                while (atual.proximo != null){
                    atual = atual.proximo;

                }

                atual.proximo = novoNo;
                novoNo.anterior = atual;
            }
        }

        //No meio
        else {
            No<T> atual = inicio;

            for (int i = 0; i < indice - 1; i++){
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;

            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
        }

        tamanho++;
    }

    public void removePorTitulo(String titulo) {

        No<T> atual = inicio;
        No<T> anterior = null;

        if (inicio == null) {
            System.out.println("A playlist está vazia");
            return;
        }

        Musica tituloM = (Musica) atual.dado;
        if (tituloM.getTitulo().trim().toLowerCase().equals(titulo)) {

            if (this.atual == atual) {
                this.atual = atual.proximo;
            }
            inicio = inicio.proximo;

            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }

            System.out.println("A música " + tituloM.getTitulo() + " foi removida");
            tamanho--;
            return;
        }

        while (atual != null) {
            tituloM = (Musica) atual.dado;
            if (tituloM.getTitulo().trim().toLowerCase().equals(titulo)) {

                if (this.atual == atual) {
                    if (atual.proximo != null) {
                        this.atual = atual.proximo;
                    } else {
                        this.atual = anterior;
                    }
                }
                anterior.proximo = atual.proximo;

                if (atual.proximo != null) {
                    atual.proximo.anterior = anterior;
                } else {
                    fim = anterior;
                }

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

        if (indice == 0) {
            No<T> removido = inicio;

            if (this.atual == removido) {
                this.atual = inicio.proximo;
            }

            inicio = inicio.proximo;

            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }

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

        if (this.atual == atual) {
            if (atual.proximo != null) {
                this.atual = atual.proximo;
            } else {
                this.atual = anterior;
            }
        }
        anterior.proximo = atual.proximo;

        if (atual.proximo != null) {
            atual.proximo.anterior = anterior;
        } else {
            fim = anterior;
        }
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
