package gui.telas;

import static algoritmos.InsertionSort.insertionSort;
import gui.componentesTela.Botao;
import gui.componentesTela.BotaoVoltar;
import gui.componentesTela.ControleVelocidade;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.Desenhos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cayke
 */
public class TelaInsertionSort implements InterfaceTela {
    
    private Botao botaoRecomecar;
    private BotaoVoltar botaoVoltar;
    private ControleVelocidade controleVelocidade;
    private int[] a;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    private Desenhos grafico;
    private double contadorTempo;
    
    @Override
    public void create () {
        
        botaoRecomecar = new Botao(20, 60, "Recomeçar");
        botaoVoltar = new BotaoVoltar();
        controleVelocidade = new ControleVelocidade();
        
        copias = new ArrayList<>();
        a = new int[]{9, 5, 4, 1, 2, 7, 6, 8, 3, 10};
        copiaAtual = 0;
        grafico = new Desenhos();
        contadorTempo = 0;
        
        insertionSort(a, copias);
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        contadorTempo += delta;
        
        if (botaoRecomecar.checarColisao(tela.getMouseX(), tela.getMouseY())) {
            if (tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)) {
                copiaAtual = 0;
                contadorTempo = 0;
            }
        }
        
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
        grafico.desenharLegenda(tela);
        grafico.desenharGraficoTeste( tela , copias.get( copiaAtual ));
        botaoVoltar.desenhaBotao(tela, mX, mY);
        controleVelocidade.desenhar(tela);
        botaoRecomecar.desenhaBotao(tela, tela.getMouseX(), tela.getMouseY());
    }
    
    @Override
    public String getTitulo () {
        return "Insertion Sort";
    }
   
}
