package template;

import static algoritmos.SelectionSort.selectionSort;
import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import java.util.ArrayList;
import java.util.List;


public class Main extends EngineFrame {
    private int[] a;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    private Image logo;
    
    
    
    public Main() {
        
        super(
            800,                 // largura                      / width
            450,                 // algura                       / height
            "Window Title",      // título                       / title
            60,                  // quadros por segundo desejado / target FPS
            true 
        );
        
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
   
    
    public static void main( String[] args ) {
        new Main();
    }
    
   
}
