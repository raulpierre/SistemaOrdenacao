package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

/**
 *
 * @author raul / cayke
 */
public class ShellSort {
    
    public static void shellSort(int[] array, List<EstadoOrdenacao> copias){
        int tamanho = array.length;
        // Array para controlar a cor cinza (true) ou laranja (false)
        boolean[] ordenados = new boolean[tamanho];
        
        // Frame inicial neutro
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        int espacamento = 1;
        while(espacamento < tamanho / 3){
            espacamento = 3 * espacamento + 1;
        }
        
        while(espacamento >= 1){
            
            // Na última passada (espacamento == 1), o primeiro elemento já está garantido como base da sublista
            if (espacamento == 1) {
                ordenados[0] = true;
            }
            
            for(int i = espacamento; i < tamanho; i++){
                int j = i;
                
                // Destaca o elemento atual que será "puxado" para trás
                salvarEstadoOrdenacao(array, copias, j, -1, TipoAcao.COMPARACAO, ordenados);
                
                // Quebramos a condição para capturar a comparação antes da troca
                while(j >= espacamento){
                    
                    // Mostra as barras que estão sendo comparadas na distância do espaçamento
                    salvarEstadoOrdenacao(array, copias, j, j - espacamento, TipoAcao.COMPARACAO, ordenados);
                    
                    if (array[j - espacamento] > array[j]) {
                        trocar(array, j - espacamento, j);
                        
                        // Mostra a troca (Vermelho) saltando a distância correta
                        salvarEstadoOrdenacao(array, copias, j - espacamento, j, TipoAcao.TROCA, ordenados);
                        j = j - espacamento;
                    } else {
                        // Se não houver necessidade de troca, encerra a avaliação desta barra
                        break; 
                    }
                }
                
                // Se for a última passada, preenchemos as barras com Cinza progressivamente
                if (espacamento == 1) {
                    for(int k = 0; k <= i; k++) {
                        ordenados[k] = true;
                    }
                    salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
                }
            }
            
            espacamento /= 3;
        }
        
        // Marca o array inteiro como definitivamente ordenado no último frame
        for(int k = 0; k < tamanho; k++) {
            ordenados[k] = true;
        }
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }
    
    private static void trocar(int[] a, int p1, int p2){
        int t = a[p1];
        a[p1] = a[p2];
        a[p2] = t;
    }
}