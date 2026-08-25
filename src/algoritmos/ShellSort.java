package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import java.util.List;

/**
 *
 * @author raul
 */
public class ShellSort {
    public  static void shellSort(int[] array, List<EstadoOrdenacao> copias){
        
        int espacamento = 1;
        int tamanho = array.length;
        
        while(espacamento < tamanho / 3){
            
            espacamento = 3 * espacamento +1  ;
            
        }
        while(espacamento >= 1){
            
            for(int i = espacamento; i < tamanho; i++){
                
                int j = i;
                
                while(j >= espacamento && array[j - espacamento] > array[j]){
                    
                    EstadoOrdenacao.salvarEstadoOrdenacao(array, -1, -1, -1, copias);
                    trocar(array, j-espacamento, j);
                    
                    EstadoOrdenacao.salvarEstadoOrdenacao(array, -1, -1, -1, copias);
                    j = j - espacamento;
                }
            }
            
            espacamento /= 3;
            
        }
    }
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}
