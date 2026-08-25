package gui.telas;

import static algoritmos.QuickSort.quickSort;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.Grafico;
import java.util.ArrayList;
import java.util.List;


public class TelaQuickSort implements InterfaceTela {
    
    private int[] array;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    private Grafico grafico;
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    @Override
    public void create() {
        
        copias = new ArrayList<>();
        array = new int[]{9, 5, 4, 1, 2, 7, 6, 8, 3, 10};
        copiaAtual = 0;
        grafico = new Grafico();
        
        tempoParaMudar = 1;
        contadorTempo = 0;
        
        quickSort(array,0,array.length-1, copias);
        System.out.println(copias.size());
    }

    
    @Override
    public void update( double delta, TelaAtual tela ) {
        
        contadorTempo += delta;
        
        if(contadorTempo >= tempoParaMudar){
            if(copiaAtual< copias.size() -1 ){
                copiaAtual++;
            }
            contadorTempo = 0;
        }
        
    }
    
    @Override
    public void draw(TelaAtual tela) {
        
        grafico.desenharGrafico( tela , copias.get( copiaAtual ));
    
    }

    @Override
    public String getTitulo () {
        return "Quick Sort";
    }
   
}
