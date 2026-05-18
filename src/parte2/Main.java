package parte2;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        ListaPlaylist playlist = new ListaPlaylist<>();
        int escolhaInt = 0;

        String tituloMusica = "";
        String artistaMusica = "";
        String albumMusica = "";
        String duracaoMusica = "";

        Musica m1 = new Musica("Shine On You Crazy Diamond", "Pink Floyd", "Wish You Were Here", 1500);
        Musica m2 = new Musica("Killer Queen", "Queen", "Sheer Heart Attack", 181);
        Musica m3 = new Musica("Made in Heaven", "Queen", "Made in heaven", 245);
        Musica m4 = new Musica("Dream On", "Aerosmith", "Aerosmith", 266);

//        playlist.adicionarNoFim(m1);
//        playlist.adicionarNoFim(m2);
//        playlist.adicionarNoFim(m3);
//        playlist.adicionarNoFim(m4);

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
                    tituloMusica = playlist.proximo();
                    break;

                case "<":
                    tituloMusica = playlist.anterior();
                    break;

                case "*":////
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
                    System.out.println("1. Para ordenar playlist por título\n2. Para ordenar playlist por artista");
                    escolhaInt = scan.nextInt();
                    if (escolhaInt == 1) {
                        playlist.ordenarPorTitulo();
                        scan.nextLine();
                    } else if (escolhaInt == 2) {
                        playlist.ordenarPorArtista();
                        scan.nextLine();
                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;

                case "!":
                    System.out.println("Listando músicas da playlist");
                    playlist.imprimirLista();
                    break;

                case "+":
                    System.out.println("Adicionando música");

                    System.out.println("Digite o nome da música");
                    String musicaNome = scan.nextLine();
                    System.out.println("Digite o nome do artista");
                    String musicaArtista = scan.nextLine();
                    System.out.println("Digite o nome do album");
                    String musicaAlbum = scan.nextLine();
                    System.out.println("Digite a duração da música (em segundos)");
                    int musicaDuracao = scan.nextInt();

                    Musica m = new Musica(musicaNome, musicaArtista, musicaAlbum, musicaDuracao);

                    System.out.println("1. Para colocar a música no começo da playlist\n2. Para colocar no final\n3. Para colocar no meio");
                    escolhaInt = scan.nextInt();

                    if(escolhaInt == 1){
                        playlist.adicionarNoInicio(m);
                        System.out.println("A música foi adicionada no início da playlist");
                        scan.nextLine();
                    } else if (escolhaInt == 2) {
                        playlist.adicionarNoFim(m);
                        System.out.println("A música foi adicionada no final da playlist");
                        scan.nextLine();
                    } else if (escolhaInt == 3) {
                        System.out.println("Digite a posição da playlist em que deseja colocar a música");
                        escolhaInt = scan.nextInt();
                        scan.nextLine();
                        playlist.adicionarNaPosicao(m, escolhaInt);
                        System.out.println("A música foi adicionada na posição " + escolhaInt);
                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;

                case "-":
                    System.out.println("Removendo música");
                    System.out.println("1. Para remover por posição\n2. Para remover por título");
                    escolhaInt = scan.nextInt();
                    if (escolhaInt == 1) {
                        System.out.println("Digite a posição da música que deve ser removida");
                        escolhaInt = scan.nextInt();
                        scan.nextLine();
                        playlist.removerPorPosicao(escolhaInt);
                    } else if (escolhaInt == 2) {
                        System.out.println("Digite o título da música que deve ser removida");
                        scan.nextLine();
                        escolha = scan.nextLine().trim().toLowerCase();
                        playlist.removePorTitulo(escolha);
                        } else {
                        System.out.println("Posição inválida");
                    }
                    break;

                default:
                    System.out.println("Opção inválida");
            }



        }
    }
}
