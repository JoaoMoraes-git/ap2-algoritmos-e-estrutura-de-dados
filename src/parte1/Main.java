package parte1;

public class Main {
    static void main() {

        CafeFila fila = new CafeFila(5);

//        Pedido p1 = new Pedido(1, "Café", "Café preto");

        fila.espiar();
        fila.adicionarPedido("Café Preto");
        fila.adicionarPedido("Café com Leite");
        fila.adicionarPedido("Café Mocha");
        fila.adicionarPedido("Café Americano");
        System.out.println(fila.atenderPedido());
        fila.imprimirPedidosPendentes();
        fila.espiar();
    }
}
