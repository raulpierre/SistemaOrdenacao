package gui.telas;

import static algoritmos.SelectionSort.selectionSort;
import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import gui.componentesTela.EstadoOrdenacao;
import java.util.ArrayList;
import java.util.List;


public class TelaSelectionSort extends EngineFrame {
    
    
    private int[] a;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    public TelaSelectionSort() {
        
        super(800,450,"Window Title", 60, true );
    
    }
    
    @Override
    public void create() {
        
        copias = new ArrayList<>();
        a = new int[]{9, 5, 4, 1, 2, 7, 6, 8, 3, 10};
        copiaAtual = 0;
        
        tempoParaMudar = 1;
        contadorTempo = 0;
        
        selectionSort(a, copias);
        System.out.println(copias.size());
    }

    
    @Override
    public void update( double delta ) {
        
        contadorTempo += delta;
        
        if(contadorTempo >= tempoParaMudar){
            if(copiaAtual< copias.size() -1 ){
                copiaAtual++;
            }
            contadorTempo = 0;
        }
        
    }
    
    
    @Override
    public void draw() {
        
        clearBackground( WHITE );
        
        copias.get(copiaAtual).desenharEstadoOrdenacao(this);
    
    }
   
}
