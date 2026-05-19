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

            String escolha = scan.nextLine();

            switch (escolha) {
                case "1":
                    anuncios.exibirAvancar();
                    break;

                case "2":
                    System.out.println("Digite o nome da empresa do anúncio");
                    String empresa = scan.nextLine();
                    System.out.println("Digite a descrição do anúncio");
                    String descricao = scan.nextLine();

                    Anuncio anuncio = new Anuncio(UUID.randomUUID(), empresa, descricao);

                    System.out.println("1. Para adicionar após o anúncio atual\n2. Para adicionar anúncio no fim");
                    escolha = scan.nextLine();
                    if (escolha.equals("1")) {
                        anuncios.inserirApos(anuncio);
                    } else if (escolha.equals("2")) {
                        anuncios.inserirNoFim(anuncio);
                    } else {
                        System.out.println("Opção inválida");
                    }

                    break;

                case "3": //
                    System.out.println("Digite o ID do anúncio que deve ser removido");
                    escolha = scan.nextLine();
                    anuncios.removerPorId(escolha);
                    break;

                case "4":
                    anuncios.imprimir();
                    break;

                case "5":
                    System.out.println("Saindo do programa...");
                    ativo = false;
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
