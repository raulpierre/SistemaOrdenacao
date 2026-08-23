package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.KEY_A;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.KEY_X;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.PINK;
import java.awt.Color;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

/**
 *
 * @author cayke
 */
public class Botao {
    private int posX;
    private int posY;
    private double largura;
    private int altura = 30;
    private Color cor = EngineFrame.BLACK;
    private String textoBotao;
    
    public Botao ( int posX , int posY , String textoBotao ) {
        
        this.textoBotao = textoBotao;
        this.posX = posX;
        this.posY = posY;
    
    }

    public int getPosX () {
        return posX;
    }

    public int getPosY () {
        return posY;
    }

    public double getLargura () {
        return largura;
    }

    public int getAltura () {
        return altura;
    }
    
    
    public void desenhaBotao( EngineFrame e ){
       
       int fonte = 15;
       int larguraTexto = e.measureText ( textoBotao , fonte);
       largura = larguraTexto * 1.5;
               
       e.drawRectangle ( posX , posY , largura , altura , PINK );
       e.drawText(textoBotao , posX + (largura - larguraTexto)/2 , posY + altura /2 - 5  , fonte , PINK );
       
    }
}
