package gui.telas;

import static algoritmos.BubbleSort.bubbleSort;
import gui.componentesTela.BotaoVoltar;
import gui.componentesTela.ControleVelocidade;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.Grafico;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cayke
 */

public class TelaBubbleSort implements InterfaceTela {
    
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
        
        bubbleSort(a, copias);
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
        
        tela.clearBackground ( new Color(181,199,235) );
        
        botaoVoltar.desenhaBotao(tela, mX, mY);
        controleVelocidade.desenhar(tela);
        grafico.desenharGraficoTeste( tela , copias.get( copiaAtual ));
    }

    @Override
    public String getTitulo () {
        return "Bubble Sort";
    }
}