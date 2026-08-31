package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

/**
 *
 * @author Cayke
 */
public class BubbleSort {
    
    public static void bubbleSort(int[] a, List<EstadoOrdenacao> copias){
        
        salvarEstadoOrdenacao(a , copias );
        
        do{
            
            boolean troca = false;
            
            for(int  i = 0 ; i < a.length - 1 ; i++ ){
                
                int  j = i + 1;
                
                salvarEstadoOrdenacao(a , copias );
                
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    troca = true;
                    
                    salvarEstadoOrdenacao(a, copias);
                }
            }
            
            if(troca == false){
                break;
            }
            
        } while(true);
        
    }
}
