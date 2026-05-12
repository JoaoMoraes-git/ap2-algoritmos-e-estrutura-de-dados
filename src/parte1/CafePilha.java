package parte1;

public class CafePilha {
    private String [] elementos;
    private int tamanho;

    public CafePilha(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
    }
    public boolean estaVazia(){
        return tamanho == 0;
    }
    public boolean estaCheia(){
        return tamanho == this.elementos.length;
    }

    public boolean adicionarCancelado(String e){
        if(!estaCheia()){
            this.elementos[tamanho] = e;
            tamanho ++;
            return true;
        }
        return false;
    }

    public String desempilhar(){
        if(!estaVazia()){
            tamanho--;
            return this.elementos[tamanho];
        }
        return null;
    }

    public String espiar(){
        if(!estaVazia()){
            return this.elementos[tamanho - 1];
        }
        return null;
    }

    public void imprimirPedidosCancelados(){
        System.out.println("--Pedidos Cancelados--");
        if(!estaVazia()){
            for(int i = 0; i < tamanho; i++){
                System.out.println("Id: " + i + " / Descrição: " + this.elementos[i]);
            }
            System.out.println();
            return;
        }
        System.out.println("Nenhum pedido pendente no momento");
    }


}
