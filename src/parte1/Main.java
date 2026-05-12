package parte1;

public class Main {
    static void main() {

        CafeFila fila = new CafeFila(5);
        CafePilha pilha = new CafePilha(5);

        fila.espiar();
        fila.adicionarPedido("Café Preto");
        fila.adicionarPedido("Café com Leite");
        fila.adicionarPedido("Café Mocha");
        fila.adicionarPedido("Café Americano");

        PilhaParaFila.cancelarPedido(fila, pilha);
        PilhaParaFila.cancelarPedido(fila, pilha);



        pilha.imprimirPedidosCancelados();
        System.out.println(fila.atenderPedido());
        fila.imprimirPedidosPendentes();
        fila.espiar();
    }
}
