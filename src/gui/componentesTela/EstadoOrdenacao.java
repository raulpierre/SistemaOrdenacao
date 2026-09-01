package gui.componentesTela;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @author raul
 */

public class EstadoOrdenacao{
    private int[] array;
    
    private int indicePrimario;   // Ex: o elemento selecionado, o pivot, etc.
    private int indiceSecundario; // Ex: o elemento com o qual está sendo comparado

    boolean[] getOrdenados() {
        return ordenados;
    }
    public enum TipoAcao {COMPARACAO, TROCA, PIVO, ORDENADO, NENHUMA}
    private TipoAcao acao;
    private boolean[] ordenados;
    
    public EstadoOrdenacao(int[] array){
        this.array = array;
    }

    public EstadoOrdenacao(int[] array, int indicePrimario, int indiceSecundario, TipoAcao acao, boolean[] ordenados) {
        this.array = array;
        this.indicePrimario = indicePrimario;
        this.indiceSecundario = indiceSecundario;
        this.acao = acao;
        this.ordenados = ordenados;
    }
    
    public static void salvarEstadoOrdenacao(int[] origem, List<EstadoOrdenacao> copias, int indicePrimario, int indiceSecundario, TipoAcao acao, boolean[] ordenados){
        int[] copia = origem.clone();
        boolean[] copiaOrdenados = ordenados.clone(); // Clona os estados de ordenação também
        
        EstadoOrdenacao estadoCopia = new EstadoOrdenacao(copia, indicePrimario, indiceSecundario, acao, copiaOrdenados);
        copias.add(estadoCopia);
    }
    
    
    public static void salvarEstadoOrdenacao(int[] origem, List<EstadoOrdenacao> copias){
        
        int[] copia = new int[origem.length];
        
        //System.arraycopy(origem, 0, copia, 0, origem.length); melhor maneira de se copiar um array em java
        
        for(int i = 0; i < copia.length; i++){
            copia[i] = origem[i];
        }
        EstadoOrdenacao estadoCopia = new EstadoOrdenacao(copia);
        
        copias.add(estadoCopia);
    }

    public int[] getArray() {
        return array;
    }

    public int getIndicePrimario() {
        return indicePrimario;
    }

    public int getIndiceSecundario() {
        return indiceSecundario;
    }

    public TipoAcao getAcao() {
        return acao;
    }
    
    
}
