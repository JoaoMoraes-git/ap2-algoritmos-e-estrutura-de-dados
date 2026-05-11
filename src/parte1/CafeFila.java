package parte1;

public class CafeFila {
    private Pedido [] elementos;
    private int tamanho;

    public CafeFila(int capacidade){
        this.elementos = new Pedido[capacidade];
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

    public boolean enfileirar(Pedido e){
        if(!estaCheia()){
            this.elementos[tamanho] = e;
            tamanho ++;
            return true;
        }
        return false;
    }

    public Pedido desenfileirar(){
        if(!estaVazia()){
            Pedido elementoRemovido = this.elementos[0];
            for(int i = 1; i < tamanho; i++){
                elementos[i - 1] = elementos[i];
            }
            tamanho--;
            return elementoRemovido;
        }
        return null;
    };

    public Pedido espiar(){
        if(!estaVazia()){
            return this.elementos[0];
        }
        return null;
    };


}
