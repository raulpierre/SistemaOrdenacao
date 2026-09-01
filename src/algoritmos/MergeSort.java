package algoritmos;

import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.EstadoOrdenacao.TipoAcao;
import static gui.componentesTela.EstadoOrdenacao.salvarEstadoOrdenacao;
import java.util.List;

public class MergeSort {

    public static void mergeSort(int[] array, List<EstadoOrdenacao> copias) {
        int length = array.length;
        // Array para controlar a cor cinza (true) ou laranja (false)
        boolean[] ordenados = new boolean[length];
        
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
        
        topDown(array, 0, length - 1, copias, ordenados);
        
        // No final de tudo, marca o array inteiro como definitivamente ordenado
        for (int i = 0; i < length; i++) {
            ordenados[i] = true;
        }
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.ORDENADO, ordenados);
    }

    private static void topDown(int[] array, int start, int end, List<EstadoOrdenacao> copias, boolean[] ordenados) {
        if (start < end) {
            int middle = (start + end) / 2;
            topDown(array, start, middle, copias, ordenados);
            topDown(array, middle + 1, end, copias, ordenados);
            merge(array, start, middle, end, copias, ordenados);
        }
    }

    private static void merge(int[] array, int start, int middle, int end, List<EstadoOrdenacao> copias, boolean[] ordenados) {
        
        // Reseta o status visual para laranja (false) toda vez que um novo merge começa
        for (int m = start; m <= end; m++) {
            ordenados[m] = false;
        }

        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            
            // Destaca os ponteiros sendo comparados (Verde e Azul) antes da junção
            salvarEstadoOrdenacao(array, copias, i, j, TipoAcao.COMPARACAO, ordenados);

            if (array[i] <= array[j]) {
                // A barra já está na posição correta. Apenas pintamos de cinza e avançamos
                ordenados[i] = true;
                salvarEstadoOrdenacao(array, copias, i, -1, TipoAcao.TROCA, ordenados);
                i++;
            } else {
                // A barra em 'j' é menor. Precisamos puxá-la para a posição 'i'
                int value = array[j];
                int index = j;

                // Empurra (desloca) todos os elementos entre i e j-1 para a direita
                while (index != i) {
                    array[index] = array[index - 1];
                    index--;
                }
                
                // Insere a menor barra na posição correta
                array[i] = value;

                // Elemento recém-juntado ganha o status de ordenado neste escopo (Cinza)
                ordenados[i] = true;
                
                // Salva o estado com destaque de troca (Vermelho)
                salvarEstadoOrdenacao(array, copias, i, -1, TipoAcao.TROCA, ordenados);

                // Como empurramos as barras, os limites precisam ser atualizados
                i++;
                middle++;
                j++;
            }
        }
        
        // As barras restantes do lado esquerdo que já estavam no lugar
        // também precisam ficar cinzas visualmente para fechar o bloco
        while (i <= end) {
            ordenados[i] = true;
            salvarEstadoOrdenacao(array, copias, i, -1, TipoAcao.TROCA, ordenados);
            i++;
        }
        
        // Frame neutro para exibir o bloco totalmente cinza antes do algoritmo voltar e resetar
        salvarEstadoOrdenacao(array, copias, -1, -1, TipoAcao.NENHUMA, ordenados);
    }
}