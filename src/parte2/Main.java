package parte2;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);

        String tituloMusica = "";
        String artistaMusica = "";
        String albumMusica = "";
        String duracaoMusica = "";

        boolean ativo = true;

        String instrucoes = "Instruções da playlist:\n> Para ir para a próxima música\n< Para voltar a música anterior\n* Para tocar a música atual" +
                "\n+ Para adicionar uma música\n- Para remover uma música\n^ Para ordenar a playlist\n! Para listar todas as músicas\n? Para ver essas instruções novamente\nX Para sair do programa";

        System.out.println(instrucoes);

        while (ativo == true){
            System.out.println();
            System.out.println("----Menu de Playlist----");
            System.out.println();
            System.out.println("Música: " + tituloMusica);
            System.out.println(artistaMusica);
            System.out.println(albumMusica);
            System.out.println(duracaoMusica);
            System.out.println();
            System.out.println("        <  *  >        ");
            System.out.println(" X   ?   ^   !   +   - ");
            System.out.println("------------------------");

            String escolha = scan.nextLine().trim().toLowerCase();
            switch (escolha){
                case ">":
                    System.out.println("Próxima música");
                    break;

                case "<":
                    System.out.println("Voltar música");
                    break;

                case "*":
                    System.out.println("Tocar música");
                    break;

                case "x":
                    System.out.println("Saindo do programa...");
                    ativo = false;
                    break;

                case "?":
                    System.out.println(instrucoes);
                    break;

                case "^":
                    System.out.println("Ordenar playlist");
                    break;

                case "!":
                    System.out.println("Listar músicas");
                    break;

                case "+":
                    System.out.println("Adicionar música");
                    break;

                case "-":
                    System.out.println("Remover música");
                    break;

                default:
                    System.out.println("Opção inválida");
            }



        }
    }
}
