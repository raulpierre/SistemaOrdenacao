package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

public class QuickSort {

    public static void quickSort(int[] array, List<EstadoOrdenacao> copias) {
        boolean[] ordenados = new boolean[array.length];
        
        // Frame inicial neutro
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        quickSortRecursivo(array, 0, array.length - 1, copias, ordenados);
        
        // No final de tudo, garante que todo o array fique cinza (definitivamente ordenado)
        for (int i = 0; i < array.length; i++) {
            ordenados[i] = true;
        }
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }

    private static void quickSortRecursivo(int[] array, int start, int end, List<EstadoOrdenacao> copias, boolean[] ordenados) {
        if (start <= end) {
            // Se sobrou apenas um elemento na partição, ele já está na posição final (Cinza)
            if (start == end) {
                ordenados[start] = true;
                salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
                return;
            }
            
            int pivotIndex = partition(array, start, end, copias, ordenados);
            
            // Chama a recursão para os lados esquerdo e direito do pivô
            quickSortRecursivo(array, start, pivotIndex - 1, copias, ordenados);
            quickSortRecursivo(array, pivotIndex + 1, end, copias, ordenados);
        }
    }

    private static int partition(int[] array, int start, int end, List<EstadoOrdenacao> copias, boolean[] ordenados) {
        // Escolhendo o último elemento do bloco como pivô
        int pivot = array[end];
        
        // Destaca o pivô em Amarelo para iniciar a varredura
        salvarEstadoOrdenacao(array, copias, end, -1, TipoAcao.PIVO, ordenados);

        int i = start - 1;

        for (int j = start; j < end; j++) {
            // Compara o elemento atual com o pivô (Verde e Azul)
            salvarEstadoOrdenacao(array, copias, j, end, TipoAcao.COMPARACAO, ordenados);

            if (array[j] <= pivot) {
                i++;
                // Se i e j são diferentes, mostra a troca em Vermelho
                if (i != j) {
                    trocar(array, i, j);
                    salvarEstadoOrdenacao(array, copias, i, j, TipoAcao.TROCA, ordenados);
                }
            }
        }

        // Coloca o pivô no lugar correto dele no meio da partição
        i++;
        if (i != end) {
            trocar(array, i, end);
            salvarEstadoOrdenacao(array, copias, i, end, TipoAcao.TROCA, ordenados);
        }

        // A posição atual do pivô é definitiva! Fica Cinza.
        ordenados[i] = true;
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);

        return i;
    }

    private static void trocar(int[] a, int p1, int p2) {
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}