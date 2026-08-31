package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

public class MergeSort {

    public static void mergeSort(int[] array, List<EstadoOrdenacao> copias) {
        salvarEstadoOrdenacao(array, copias);
        
        int length = array.length;
        int[] tempMS = new int[length];
        
        topDown(array, 0, length - 1, tempMS, copias);
    }

    private static void topDown(int[] array, int start, int end, int[] tempMS, List<EstadoOrdenacao> copias) {
        int middle;
        if (start < end) {
            middle = (start + end) / 2;
            topDown(array, start, middle, tempMS, copias);
            topDown(array, middle + 1, end, tempMS, copias);
            merge(array, start, middle, end, tempMS, copias);
        }
    }

    private static void merge(int[] array, int start, int middle, int end, int[] tempMS, List<EstadoOrdenacao> copias) {
        int i = start;
        int j = middle + 1;
        
        for (int k = start; k <= end; k++) {
            tempMS[k] = array[k];
        }
        
        for (int k = start; k <= end; k++) {
            
            int posI = (i <= middle) ? i : -1;
            int posJ = (j <= end) ? j : -1;
            salvarEstadoOrdenacao(array, copias);

            if (i > middle) {
                array[k] = tempMS[j++];
            } else if (j > end) {
                array[k] = tempMS[i++];
            } else if (tempMS[j] < tempMS[i]) {
                array[k] = tempMS[j++];
            } else {
                array[k] = tempMS[i++];
            }
            
            salvarEstadoOrdenacao(array, copias);
        }
    }
}