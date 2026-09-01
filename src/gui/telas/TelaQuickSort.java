package gui.telas;

import static algoritmos.QuickSort.quickSort;
import gui.componentesTela.Botao;
import gui.componentesTela.EstadoOrdenacao;
import gui.componentesTela.Grafico;
import java.util.ArrayList;
import java.util.List;


public class TelaQuickSort implements InterfaceTela {
    
    private Botao botaoVoltar;
    private int[] a;
    private List<EstadoOrdenacao> copias;
    private int copiaAtual;
    private Grafico grafico;
    
    private double tempoParaMudar;
    private double contadorTempo;
    Botao mais;
    Botao menos;
    
    
    

    @Override
    public void create () {
        
        botaoVoltar = new Botao(20, 20, "Voltar");
        copias = new ArrayList<>();
        a = new int[]{9, 5, 4, 1, 2, 7, 6, 8, 3, 10};
        copiaAtual = 0;
        grafico = new Grafico();
        
        tempoParaMudar = 1;
        contadorTempo = 0;
        
        
        
        mais = new Botao(700, 50, 30,"+");
        menos = new Botao(620, 50, 30,"-");
       
        
        quickSort(a, copias);
        System.out.println(copias.size());
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        int mouseX = tela.getMouseX();
        int mouseY = tela.getMouseY();
        contadorTempo += delta;
        
        if(contadorTempo >= tempoParaMudar){
            if(copiaAtual< copias.size() -1 ){
                copiaAtual++;
            }
            contadorTempo = 0;
        }
        
        int MouseX = tela.getMouseX();
        int MouseY = tela.getMouseY();
        
        if(mais.checarColisao(MouseX, MouseY)){
            if(tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)){
                tempoParaMudar += 0.5;
            }
        }
        if(menos.checarColisao(MouseX, MouseY)){
            if(tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)){
                tempoParaMudar -= 0.5;
            }    
        }
        if (botaoVoltar.checarColisao(mouseX, mouseY)) {
            if (tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)) {
                tela.mudarTela(new MenuInicial());
            }
        }
        
            
    }
    

    @Override
    public void draw ( TelaAtual tela ) {
        
        int mX = tela.getMouseX();
        int mY = tela.getMouseY();
        
        menos.desenhaBotao(tela,mX,mY);
        mais.desenhaBotao(tela,mX,mY);
        tela.drawText(String.format("%.1f",tempoParaMudar), 665, 64, tela.BLACK);
        tela.drawText("Velocidade", 645, 40, tela.BLACK);
        
        grafico.desenharGraficoTeste( tela , copias.get( copiaAtual ));
        botaoVoltar.desenhaBotao(tela, mX, mY);
        
    }

    @Override
    public String getTitulo () {
        return "Quick Sort";
    }
   
}
