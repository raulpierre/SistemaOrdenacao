package algoritmos;

import java.util.List;
import template.Main;
import template.EstadoOrdenacao;

/**
 *
 * @author raul
 */
public class SelectionSort {
    
    public static void selectionSort(int[] a, List<EstadoOrdenacao> copias){
        EstadoOrdenacao.salvarEstadoOrdenacao(a, -1, -1, -1, copias);
        for(int i = 0; i < a.length; i++){
            int menor = i;
            for(int j = i + 1; j < a.length; j++ ){
                if (a[menor] > a [j]){
                    menor = j;
                }
                EstadoOrdenacao.salvarEstadoOrdenacao(a, i, j, menor, copias);
            }
            trocar(a, i,menor);
            EstadoOrdenacao.salvarEstadoOrdenacao(a, i, 0, menor, copias);
        } 
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}
