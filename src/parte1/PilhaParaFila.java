package parte1;

public class PilhaParaFila {

    public static String cancelarPedido(CafeFila pedido, CafePilha cancelado){

        if (pedido.estaVazia()) {
            return null;
        }

        if (cancelado.estaCheia()) {
            return null;
        }

        String pedidoCancelado = pedido.cancelarPedido();
        cancelado.adicionarCancelado(pedidoCancelado);

        return "O pedido " + pedidoCancelado + " foi cancelado";
    }

    public static String restaurarPedido(CafePilha cancelado, CafeFila pedido){

        if (cancelado.estaVazia()) {
            return null;
        }

        if (pedido.estaCheia()) {
            return null;
        }

        String pedidoRestaurado = cancelado.removerCancelado(); ////
        pedido.adicionarPedido(pedidoRestaurado);

        return "O pedido " + pedidoRestaurado + " foi restaurado";
    }
}
