
package gui.componentesTela;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLACK;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.BLUE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.ORANGE;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.YELLOW;
import java.awt.Color;

/**
 *
 * @author cayke
 */
public class Desenhos {
    
   // private int comprimento;// e definida pela soma das colunas e os espacamentos
    //private int altura;// e definida pelo maior elemento do array
    
//    public Desenhos(int comprimento, int altura){
//        this.comprimento = comprimento;
//        this.altura = altura;
//        
//    }
    
    public void desenharGrafico (EngineFrame e, EstadoOrdenacao estado){
        
        int[] a = estado.getArray();
        
        int tamanho = 30;
        int espacamento = 10;
        
        int iniX = e.getScreenWidth() / 4;
        int iniY = e.getScreenHeight() - 10;
        
        for(int i = 0; i < a.length; i++){
            int v =  a[i];
            int altura = v * tamanho;
            e.fillRectangle(iniX + i * (tamanho + espacamento), iniY - altura, tamanho, altura, ORANGE);
        }
        
//        
        
    }
    
    public void desenharGraficoTeste(EngineFrame e, EstadoOrdenacao estadoAtual){
        int[] arrayAtual = estadoAtual.getArray();
        boolean[] ordenadosAtual = estadoAtual.getOrdenados();
        
        int tamanho = 30;
        int espacamento = 10;
        
        
        
        int iniX = e.getScreenWidth() / 4;
        int iniY = e.getScreenHeight() - 10;
        
        Color cor;
        
        int larguraBorda = (arrayAtual.length * (tamanho + espacamento)) - espacamento + 40;
        int alturaBorda = iniY - 15;
        e.fillRectangle(iniX - 20, 15, larguraBorda, alturaBorda, new Color(255,255,227));
        e.drawRectangle(iniX - 20, 15, larguraBorda, alturaBorda, EngineFrame.BLACK);
                
        for (int i = 0; i < arrayAtual.length; i++) {
            
            // Regra de cores prioritária: Destaques primários > Destaques secundários > Itens finalizados > Itens pendentes
            if (i == estadoAtual.getIndicePrimario()) {
                if (estadoAtual.getAcao() == EstadoOrdenacao.TipoAcao.PIVO) {
                    cor = EngineFrame.YELLOW;
                } else if (estadoAtual.getAcao() == EstadoOrdenacao.TipoAcao.TROCA) {
                    cor = EngineFrame.RED; 
                } else {
                    cor = EngineFrame.GREEN; 
                }
            } else if (i == estadoAtual.getIndiceSecundario()) {
                cor = EngineFrame.BLUE; 
                
            } else if (ordenadosAtual != null && ordenadosAtual[i]) {
                // Se não está sofrendo nenhuma ação, mas está marcado como ordenado, fica cinza
                cor = EngineFrame.GRAY; 
                
            } else {
                // Elemento ainda não ordenado
                cor = EngineFrame.ORANGE; 
            }

            int v = arrayAtual[i];
            int altura = v * tamanho;
            e.fillRectangle(iniX + i * (tamanho + espacamento), iniY - altura, tamanho, altura, cor);
        }   
        
        
    }
    
    public void desenharLegenda(EngineFrame e) {
        int posX = 635; 
        int posY = 250; 
        int tamanhoCaixa = 15;
        int espacamentoY = 25; 
        int fonte = 12;

        
        e.fillRectangle(posX - 15, posY - 40, 170, 190, new Color(255,255,227));
        e.drawRectangle(posX - 15, posY - 40, 170, 190, EngineFrame.BLACK);
        e.drawText("Legenda de Cores:", posX - 5, posY - 20,fonte, EngineFrame.BLACK);
        
        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.ORANGE);
        e.drawText("Não Ordenado", posX + 25, posY,fonte, EngineFrame.BLACK);
        posY += espacamentoY;

        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.GREEN);
        e.drawText("Procura", posX + 25, posY,fonte, EngineFrame.BLACK);
        posY += espacamentoY;

        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.BLUE);
        e.drawText("Chave", posX + 25, posY,fonte, EngineFrame.BLACK);
        posY += espacamentoY;

        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.YELLOW);
        e.drawText("Pivô", posX + 25, posY,fonte, EngineFrame.BLACK);
        posY += espacamentoY;

        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.RED);
        e.drawText("Trocando", posX + 25, posY,fonte, EngineFrame.BLACK);
        posY += espacamentoY;

        e.fillRectangle(posX, posY, tamanhoCaixa, tamanhoCaixa, EngineFrame.GRAY);
        e.drawText("Ordenado", posX + 25, posY,fonte, EngineFrame.BLACK);
    }
}
