package algoritmos;

import java.util.List;
import gui.Main;
import gui.EstadoOrdenacao;

/**
 *
 * @author raul
 */
public class SelectionSort {
    
    public static void selectionSort(int[] a, List<EstadoOrdenacao> copias){
        EstadoOrdenacao.salvarEstadoOrdenacao(a, -1, -1, -1, copias);
        for(int i = 0; i < a.length / 2; i++){
            int menor = i;
            int maior = i;
            for(int j = i + 1; j < a.length - i; j++ ){
                if (a[menor] > a [j]){
                    menor = j;
                }
                if(a[maior] < a[j]){
                    maior = j;
                }
                EstadoOrdenacao.salvarEstadoOrdenacao(a, i, j, menor, copias);
            }
            trocar(a, i, menor);
            if(maior == i){
                maior = menor;
            }
            trocar(a, a.length - i - 1, maior);
            EstadoOrdenacao.salvarEstadoOrdenacao(a, i, 0, menor, copias);
        } 
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}
