package gui.componentesTela;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @author raul
 */

public class EstadoOrdenacao{
    int[] array;
    int posI;
    int posJ;
    int posMenor;
    
    public EstadoOrdenacao(int[] array, int posI, int posJ, int posMenor){
        this.array = array;
        this.posI = posI;
        this.posJ = posJ;
        this.posMenor = posMenor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Arrays.hashCode(this.array);
        hash = 17 * hash + this.posI;
        hash = 17 * hash + this.posJ;
        hash = 17 * hash + this.posMenor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstadoOrdenacao other = (EstadoOrdenacao) obj;
        if (this.posI != other.posI) {
            return false;
        }
        if (this.posJ != other.posJ) {
            return false;
        }
        if (this.posMenor != other.posMenor) {
            return false;
        }
        return Arrays.equals(this.array, other.array);
    }
    
    public static void salvarEstadoOrdenacao(int[] origem, int posI, int posJ, int posMenor, List<EstadoOrdenacao> copias){
        
        int[] copia = new int[origem.length];
        
        //System.arraycopy(origem, 0, copia, 0, origem.length); melhor maneira de se copiar um array em java
        
        for(int i = 0; i < copia.length; i++){
            copia[i] = origem[i];
        }
        EstadoOrdenacao estadoCopia = new EstadoOrdenacao(copia, posI, posJ, posMenor);
        
        copias.add(estadoCopia);
    }
    
}
