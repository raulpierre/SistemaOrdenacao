package gui.telas;

import static algoritmos.MergeSort.mergeSort;
import gui.componentesTela.BotaoVoltar;
import gui.componentesTela.ControleVelocidade;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.Grafico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cayke
 */
public class TelaMergeSort implements InterfaceTela {
   private BotaoVoltar botaoVoltar;
    private ControleVelocidade controleVelocidade;
    private int[] a;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    private Grafico grafico;
    private double contadorTempo;
    
    @Override
    public void create () {
        
        botaoVoltar = new BotaoVoltar();
        controleVelocidade = new ControleVelocidade();
        
        copias = new ArrayList<>();
        a = new int[]{9, 5, 4, 1, 2, 7, 6, 8, 3, 10};
        copiaAtual = 0;
        grafico = new Grafico();
        contadorTempo = 0;
        
        mergeSort(a, copias);
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        contadorTempo += delta;
        
        if(contadorTempo >= controleVelocidade.getTempoEspera()){
            if(copiaAtual < copias.size() - 1 ){
                copiaAtual++;
            }
            contadorTempo = 0;
        }
        
        botaoVoltar.update(tela);
        controleVelocidade.atualizar(tela);
    }
    
    @Override
    public void draw ( TelaAtual tela ) {
        
        int mX = tela.getMouseX();
        int mY = tela.getMouseY();
        
        grafico.desenharGraficoTeste( tela , copias.get( copiaAtual ));
        botaoVoltar.desenhaBotao(tela, mX, mY);
        controleVelocidade.desenhar(tela);
        
    }
    
    @Override
    public String getTitulo () {
        return "Merge Sort";
    }

}
