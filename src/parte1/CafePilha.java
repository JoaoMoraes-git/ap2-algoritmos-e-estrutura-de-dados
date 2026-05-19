package parte1;

public class CafePilha {
    private No topo;

    public boolean estaVazia() {
        return topo == null;
    }

    public void adicionarCancelado(String pedido) {
        No novo = new No(pedido);
        novo.proximo = topo;
        topo = novo;
    }

    public String removerCancelado() {
        if (estaVazia()) return null;

        String removido = topo.dado;
        topo = topo.proximo;

        System.out.println("O pedido " + removido + " foi restaurado");
        return removido;
    }

    public void imprimirPedidosCancelados() {
        System.out.println("--Pedidos Cancelados--");

        No atual = topo;
        int i = 0;

        if (atual == null) {
            System.out.println("Nenhum pedido cancelado");
            return;
        }

        while (atual != null) {
            System.out.println("Id: " + i + " / " + atual.dado);
            atual = atual.proximo;
            i++;
        }
    }
}