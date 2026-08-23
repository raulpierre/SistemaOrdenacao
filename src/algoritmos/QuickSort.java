package algoritmos;

import gui.EstadoOrdenacao;
import java.util.List;

/**
 *
 * @author raul
 */
public class QuickSort {
    
    public static void quickSort(int[] array, int inicio, int fim){
        if(inicio < fim){
            int meio = particao(array, inicio, fim);
            quickSort(array, inicio, meio - 1);
            quickSort(array, meio + 1, fim);
        }
    }
    
    public static int particao(int[] array, int inicio, int fim){
        int pivo =  array[fim];
        int index1 = inicio - 1;
        for(int index2 = inicio; index2 < fim; index2++){
            if(array[index2] <= pivo){
                index1 += 1;
                trocar(array, index1, index2);
            }
        }
        trocar(array, index1 + 1, fim);
        return index1 + 1;
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
    
    
    
}
