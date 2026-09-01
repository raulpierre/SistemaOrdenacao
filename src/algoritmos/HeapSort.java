package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

/**
 *
 * @author raul
 */
public class HeapSort {
    
    public static void heapSort(int[] array, List<EstadoOrdenacao> copias){
        // Array para controlar a cor cinza (true) ou laranja (false)
        boolean[] ordenados = new boolean[array.length];
        
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        ConstrutorHeapMaximo(array, copias, ordenados);
        int tamanhoHeap = array.length;
        
        for(int i = array.length - 1; i >= 1; i--){
            // Destaca os nós que serão trocados (a raiz atual com a última folha não ordenada)
            salvarEstadoOrdenacao(array, copias, 0, i, TipoAcao.COMPARACAO, ordenados);
            
            trocar(array, 0, i);
            
            // Destaca a troca efetuada (Vermelho)
            salvarEstadoOrdenacao(array, copias, 0, i, TipoAcao.TROCA, ordenados);
            
            // O elemento trocado para o fim agora está na sua posição definitiva (Cinza)
            ordenados[i] = true;
            salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
            
            tamanhoHeap--;
            HeapMaximo(array, 0, tamanhoHeap, copias, ordenados);
        }
        
        // No final, o primeiro elemento que sobrou (índice 0) também está na posição correta
        ordenados[0] = true;
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }
    
    //Este metodo questiona o se o no que esta visualizando e maior que seu pai
    //no representa a posicao i do array, porem ppara visualizar melhor o problema decidi nomeá-lo como no = nó
    public static void HeapMaximo(int[] array, int no, int tamanhoHeap, List<EstadoOrdenacao> copias, boolean[] ordenados){
        int esquerda= Esquerda(no);
        int direita= Direita(no);
        int maior;
        
        // Quebramos a condição para poder pintar a barra antes de testar a veracidade
        if (esquerda < tamanhoHeap) {
            salvarEstadoOrdenacao(array, copias, esquerda, no, TipoAcao.COMPARACAO, ordenados);
            if (array[esquerda] > array[no]) {
                maior = esquerda;
            } else {
                maior = no;
            }
        } else {
            maior = no;
        }
        
        if (direita < tamanhoHeap) {
            salvarEstadoOrdenacao(array, copias, direita, maior, TipoAcao.COMPARACAO, ordenados);
            if (array[direita] > array[maior]) {
                maior = direita;
            }
        }
        
        if(maior != no){
            trocar(array, no, maior);
            // Destaca a troca dentro da árvore
            salvarEstadoOrdenacao(array, copias, no, maior, TipoAcao.TROCA, ordenados);
            
            HeapMaximo(array, maior, tamanhoHeap, copias, ordenados);
        }
    }
    
    public static void ConstrutorHeapMaximo(int[] array, List<EstadoOrdenacao> copias, boolean[] ordenados) {
        int tamanhoHeap = array.length;
        for(int i = (array.length / 2) - 1; i >= 0; i--){
            HeapMaximo(array, i, tamanhoHeap, copias, ordenados);
        }
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
    
    public static int Esquerda(int no){
        return 2 * no + 1;
    }
    public static int Direita(int no){
        return 2 * no + 2;
    }
}