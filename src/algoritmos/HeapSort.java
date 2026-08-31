package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import java.util.List;

/**
 *
 * @author raul
 */
public class HeapSort {
    public static void heapSort(int[] array, List<EstadoOrdenacao> copias){
        ConstrutorHeapMaximo(array, copias);
        int tamanhoHeap = array.length;
        for(int i = array.length - 1; i >= 1; i--){
            EstadoOrdenacao.salvarEstadoOrdenacao(array, copias);
            trocar(array, 0, i);
            EstadoOrdenacao.salvarEstadoOrdenacao(array, copias);
            tamanhoHeap--;
            HeapMaximo(array, 0,tamanhoHeap, copias);
        }
    }
    
    //Este metodo questiona o se o no que esta visualizando e maior que seu pai
    //no representa a posicao i do array, porem ppara visualizar melhor o problema decidi nomeá-lo como no = nó
    public static void HeapMaximo(int[] array, int no, int tamanhoHeap, List<EstadoOrdenacao> copias){
        int esquerda= Esquerda(no);
        int direita= Direita(no);
        int maior;
        
        if(esquerda < tamanhoHeap && array[esquerda] > array[no]){
            maior = esquerda;
        }
        else{
            maior = no;
        }
        if(direita < tamanhoHeap && array[direita] > array[maior]){
            maior = direita;
        }
        if(maior != no){
            EstadoOrdenacao.salvarEstadoOrdenacao(array, copias);
            trocar(array, no, maior);
            EstadoOrdenacao.salvarEstadoOrdenacao(array, copias);
            HeapMaximo(array, maior, tamanhoHeap, copias);
        }
        
    }
    
    public static void ConstrutorHeapMaximo(int[] array, List<EstadoOrdenacao> copias) {
        int tamanhoHeap = array.length;
        for(int i = (array.length / 2) - 1; i >= 0; i--){
            HeapMaximo(array, i, tamanhoHeap, copias);
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
