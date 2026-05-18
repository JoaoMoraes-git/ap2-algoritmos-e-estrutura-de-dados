package parte3;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        ListaAnuncio anuncios = new ListaAnuncio();
        Anuncio a1 = new Anuncio(UUID.randomUUID(), "Facebook", "Rede social Facebook");
        Anuncio a2 = new Anuncio(UUID.randomUUID(), "Uber", "App Uber");
        Anuncio a3 = new Anuncio(UUID.randomUUID(), "Ifood", "App Ifood");

        anuncios.inserirNoFim(a1);
        anuncios.inserirNoFim(a2);
        anuncios.inserirNoFim(a3);

        boolean ativo = true;

        while (ativo) {
            System.out.println("1. Exibir e avançar\n2. Adicionar anúncio\n3. Remover anúncio\n4. Listar ciclo completo\n5. Sair do programa");

            int escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    anuncios.exibirAvancar();
                    break;

                case 2: //
                    System.out.println("Adicionar anúncio");
                    break;

                case 3: //
                    System.out.println("Remover anúncio");
                    break;

                case 4: //
                    System.out.println("Listar ciclo completo");
                    break;

                case 5: //
                    System.out.println("Saindo do programa...");
                    ativo = false;
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
