package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

public class BubbleSort {

    public static void bubbleSort(int[] a, List<EstadoOrdenacao> copias) {
        int n = a.length;
        // Array para controlar a cor cinza (true) ou laranja (false)
        boolean[] ordenados = new boolean[n];

        // Frame inicial: tudo laranja
        salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.NENHUMA, ordenados);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                // Destaca os dois elementos adjacentes sendo comparados (Verde e Azul)
                salvarEstadoOrdenacao(a, copias, j, j + 1, TipoAcao.COMPARACAO, ordenados);

                if (a[j] > a[j + 1]) {
                    // Realiza a troca
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    // Salva o estado com destaque de troca (Vermelho nas duas barras)
                    salvarEstadoOrdenacao(a, copias, j, j + 1, TipoAcao.TROCA, ordenados);
                }
            }
            
            // O último elemento avaliado neste laço "borbulhou" até o topo e está na posição final (Cinza)
            ordenados[n - 1 - i] = true;
            
            // Frame neutro para mostrar a barra recém-ordenada ficando cinza antes de recomeçar a varredura
            salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        }
        
        // Quando o laço termina, o primeiro elemento (índice 0) automaticamente já está ordenado
        ordenados[0] = true;
        
        // Marca o array inteiro como definitivamente ordenado no último frame
        salvarEstadoOrdenacao(a, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }
}