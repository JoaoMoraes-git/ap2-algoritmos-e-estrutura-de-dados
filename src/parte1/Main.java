package parte1;

public class Main {
    static void main() {

        CafeFila fila = new CafeFila(5);

//        Pedido p1 = new Pedido(1, "Café", "Café preto");

        fila.espiar();
        fila.enfileirar("Café Preto");
        fila.enfileirar("Café com Leite");
        fila.enfileirar("Café Mocha");
        fila.enfileirar("Café Americano");
        fila.imprimirPedidosPendentes();
        fila.espiar();
    }
}
