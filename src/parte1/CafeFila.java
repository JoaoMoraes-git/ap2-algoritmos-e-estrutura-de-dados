package parte1;

public class CafeFila {
    private No inicio;
    private No fim;

    public boolean estaVazia() {
        return inicio == null;
    }

    public void adicionarPedido(String pedido) {
        No novo = new No(pedido);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public String cancelarPedido(){
        if(estaVazia()){
            return null;
        }

        String removido = inicio.dado;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        System.out.println("O pedido " + removido + " foi cancelado");
        return removido;
    }

    public String atenderPedido(){
        if(estaVazia()){
            return null;
        }

        String removido = inicio.dado;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return "O pedido " + removido + " foi atendido";
    }

    public void imprimirPedidosPendentes(){
        System.out.println("--Pedidos Pendentes--");

        No atual = inicio;

        if (atual == null) {
            System.out.println("Nenhum pedido pendente");
            return;
        }

        int i = 0;
        while (atual != null) {
            System.out.println("Id: " + i + " / " + atual.dado);
            atual = atual.proximo;
            i++;
        }
    }

}
