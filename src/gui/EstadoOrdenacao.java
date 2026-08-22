package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLACK;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLUE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.ORANGE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.YELLOW;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;

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
        
        for(int i = 0; i <copia.length; i++){
            copia[i] = origem[i];
        }
        EstadoOrdenacao estadoCopia = new EstadoOrdenacao(copia, posI, posJ, posMenor);
        
        copias.add(estadoCopia);
    }
    
    public void desenharEstadoOrdenacao(EngineFrame e) {
        
        int[] a = this.array;
        int tamanho = 30;
        int iniX = 10;
        int iniY = 440;
        int espacamento = 10;
        
        for(int i =0; i < a.length; i++){
            int v =  a[i];
            int altura = v * tamanho;
            e.fillRectangle(iniX + i * (tamanho + espacamento), iniY - altura, tamanho, altura, ORANGE);
        }
        
        if(this.posI >= 0){
            e.fillCircle(iniX + this.posI * (tamanho + espacamento) + tamanho / 2, iniY - a[this.posI] * tamanho - 10 ,5, BLACK);
        }
        if(this.posJ >= 0){
            e.fillCircle(iniX + this.posJ * (tamanho + espacamento) + tamanho / 2, iniY - a[this.posJ] * tamanho - 20 ,5, YELLOW);
        }
        if(this.posMenor >= 0){
            e.fillCircle(iniX + this.posMenor * (tamanho + espacamento) + tamanho / 2, iniY - a[this.posMenor] * tamanho - 30 ,5, BLUE);
        }
    }
}
