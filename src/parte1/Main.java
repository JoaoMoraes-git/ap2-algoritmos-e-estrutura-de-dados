package parte1;

public class Main {
    static void main() {

        CafeFila fila = new CafeFila(5);

        Pedido p1 = new Pedido(1, "Café", "Café preto");

        fila.espiar();
        fila.enfileirar(p1);
        fila.espiar();
    }
}
