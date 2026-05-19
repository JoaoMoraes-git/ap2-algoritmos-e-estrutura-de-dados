package parte1;

public class PilhaParaFila {

    public static String cancelarPedido(CafeFila pedido, CafePilha cancelado){

        if (pedido.estaVazia()) {
            return null;
        }


        String pedidoCancelado = pedido.cancelarPedido();

        if (pedidoCancelado != null) {
            cancelado.adicionarCancelado(pedidoCancelado);
        }

        return "O pedido " + pedidoCancelado + " foi cancelado";
    }

    public static String restaurarPedido(CafePilha cancelado, CafeFila pedido){

        if (cancelado.estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }

        String pedidoRestaurado = cancelado.removerCancelado();

        if (pedidoRestaurado != null) {
            pedido.adicionarPedido(pedidoRestaurado);
        }

        return pedidoRestaurado;
    }
}
