package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

/**
 *
 * @author Cayke
 */
public class InsertionSort {
    
    public static void insertionSort(int[] array, List<EstadoOrdenacao> copia){
        
        salvarEstadoOrdenacao ( array , -1 , -1 , -1 , copia );
        
        for(int i = 1 ; i < array.length ; i ++){
            
            int j = i;
            while(j > 0 && array[j-1] >  array[j]){
                trocar( array , j-1 , j);
                j--;
                
                salvarEstadoOrdenacao ( array , i , j , i , copia );
            }
            
            salvarEstadoOrdenacao ( array , i , j , i , copia );

        }
        
        

    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
    
}
