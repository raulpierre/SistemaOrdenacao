
package gui.componentesTela;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLACK;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLUE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.ORANGE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.YELLOW;

/**
 *
 * @author cayke
 */
public class Grafico {
    
   // private int comprimento;// e definida pela soma das colunas e os espacamentos
    //private int altura;// e definida pelo maior elemento do array
    
//    public Grafico(int comprimento, int altura){
//        this.comprimento = comprimento;
//        this.altura = altura;
//        
//    }
    
    public void desenharGrafico (EngineFrame e, EstadoOrdenacao estado){
        
        int[] a = estado.array;
        
        int tamanho = 30;
        int espacamento = 10;
        
        int iniX = e.getScreenWidth() / 4;
        int iniY = e.getScreenHeight() - 10;
        
        for(int i = 0; i < a.length; i++){
            int v =  a[i];
            int altura = v * tamanho;
            e.fillRectangle(iniX + i * (tamanho + espacamento), iniY - altura, tamanho, altura, ORANGE);
        }
        
        if(estado.posI >= 0){
            e.fillCircle(iniX + estado.posI * (tamanho + espacamento) + tamanho / 2, iniY - a[estado.posI] * tamanho - 10 ,5, BLACK);
        }
        if(estado.posJ >= 0){
            e.fillCircle(iniX + estado.posJ * (tamanho + espacamento) + tamanho / 2, iniY - a[estado.posJ] * tamanho - 20 ,5, YELLOW);
        }
        if(estado.posMenor >= 0){
            e.fillCircle(iniX + estado.posMenor * (tamanho + espacamento) + tamanho / 2, iniY - a[estado.posMenor] * tamanho - 30 ,5, BLUE);
        }
        
    }
    
}
