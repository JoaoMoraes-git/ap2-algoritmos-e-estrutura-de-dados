package parte1;

public class CafeFila {
    private String [] elementos;
    private int tamanho;

    public CafeFila(int capacidade){
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

    public boolean enfileirar(String e){
        if(!estaCheia()){
            this.elementos[tamanho] = e;
            tamanho ++;
            return true;
        }
        return false;
    }

    public String desenfileirar(){
        if(!estaVazia()){
            String elementoRemovido = this.elementos[0];
            for(int i = 1; i < tamanho; i++){
                elementos[i - 1] = elementos[i];
            }
            tamanho--;
            return elementoRemovido;
        }
        return null;
    }

    public String espiar(){
        if(!estaVazia()){
            return this.elementos[0];
        }
        return null;
    }

    public void imprimirPedidosPendentes(){
        System.out.println("--Pedidos Pendentes--");
        if(!estaVazia()){
            for(int i = 0; i < tamanho; i++){
                System.out.println("Id: " + i + " / Descrição: " + this.elementos[i]);
            }
            return;
        }
        System.out.println("Nenhum pedido pendente no momento");
    }



}
