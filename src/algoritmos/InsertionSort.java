package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

/**
 *
 * @author Cayke
 */
public class InsertionSort {
    
    public static void insertionSort(int[] array, List<EstadoOrdenacao> copias){
        int n = array.length;
        // Array para controlar a cor cinza (true) ou laranja (false)
        boolean[] ordenados = new boolean[n];
        
        // No Insertion Sort, o primeiro elemento isolado já é considerado uma sublista "ordenada"
        ordenados[0] = true;
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        for(int i = 1 ; i < n ; i++){
            
            int j = i;
            
            // Destaca o elemento que será inserido na sublista (Verde)
            salvarEstadoOrdenacao(array, copias, j, -1, TipoAcao.COMPARACAO, ordenados);
            
            // Separamos a condição do while para poder capturar e desenhar a comparação visualmente
            while(j > 0) {
                // Destaca os dois elementos sendo comparados (Verde e Azul)
                salvarEstadoOrdenacao(array, copias, j, j - 1, TipoAcao.COMPARACAO, ordenados);
                
                if (array[j - 1] > array[j]) {
                    trocar(array, j - 1, j);
                    
                    // Salva o estado com destaque de troca (Vermelho)
                    salvarEstadoOrdenacao(array, copias, j - 1, j, TipoAcao.TROCA, ordenados);
                    j--;
                } else {
                    // Se o elemento da esquerda não é maior, a barra encontrou seu lugar correto
                    break;
                }
            }
            
            // Após a inserção, todos os elementos até o índice 'i' agora fazem parte da sublista cinza
            for(int k = 0; k <= i; k++) {
                ordenados[k] = true;
            }
            
            // Frame neutro mostrando a sublista ordenada crescendo
            salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        }
        
        // Marca o array inteiro como definitivamente ordenado no último frame
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}