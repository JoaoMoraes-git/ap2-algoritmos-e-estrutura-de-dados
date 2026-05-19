package parte1;

public class Main {
    static void main() {

        CafeFila fila = new CafeFila();
        CafePilha pilha = new CafePilha();


        fila.adicionarPedido("Café Preto");
        fila.adicionarPedido("Café com Leite");
        fila.adicionarPedido("Café Mocha");
        fila.adicionarPedido("Café Americano");

        PilhaParaFila.cancelarPedido(fila, pilha);
        PilhaParaFila.cancelarPedido(fila, pilha);
        PilhaParaFila.restaurarPedido(pilha, fila);
        PilhaParaFila.cancelarPedido(fila, pilha);

        PilhaParaFila.cancelarPedido(fila, pilha);
        PilhaParaFila.cancelarPedido(fila, pilha);
        PilhaParaFila.restaurarPedido(pilha, fila);



        pilha.imprimirPedidosCancelados();
//        System.out.println(fila.atenderPedido());
        fila.imprimirPedidosPendentes();
    }
}
