package algoritmos;

import java.util.List;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;

public class SelectionSort {
    
    public static void selectionSort(int[] a, List<EstadoOrdenacao> copias){
        // Cria o array que rastreia os ordenados (por padrão, todos iniciam como false)
        boolean[] ordenados = new boolean[a.length];
        
        EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        for(int i = 0; i < a.length / 2; i++){
            int menor = i;
            int maior = i;
            
            for(int j = i + 1; j < a.length - i; j++ ){
                EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, j, menor, TipoAcao.COMPARACAO, ordenados);
                
                if (a[menor] > a [j]){
                    menor = j;
                }
                if(a[maior] < a[j]){
                    maior = j;
                }
            }
            
            trocar(a, i, menor);
            EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, i, menor, TipoAcao.TROCA, ordenados);
            
            if(maior == i){
                maior = menor;
            }
            
            trocar(a, a.length - i - 1, maior);
            EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, a.length - i - 1, maior, TipoAcao.TROCA, ordenados);
            
            // Neste ponto, os dois extremos encontraram suas posições definitivas
            ordenados[i] = true;
            ordenados[a.length - i - 1] = true;
            
            // Salva um frame neutro para mostrar eles ficando cinza antes do próximo laço
            EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        } 
        
        // Se o array tiver tamanho ímpar, o elemento central sobra no meio e já estará ordenado
        if (a.length % 2 != 0) {
            ordenados[a.length / 2] = true;
            EstadoOrdenacao.salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        }
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}