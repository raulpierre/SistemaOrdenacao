package gui.componentesTela;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.font.FontUtils;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author cayke
 */
public class Botao {
    private int posX;
    private int posY;
    private double largura;
    private int altura = 30;
    private String textoBotao;
    private Color cinzaClaro = new Color(211,211,211);
    private Color Onyx = new Color(53,56,57);
    //private Font fonte;
    
    public Botao ( int posX , int posY , String textoBotao ) {
        
        this.textoBotao = textoBotao;
        this.posX = posX;
        this.posY = posY;
        //fonte = FontUtils.loadFont("src/Resources/Agbalumo-Regular.ttf") ;
    
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
        
       int fonteTam = 15;
       int larguraTexto = e.measureText ( textoBotao , fonteTam);
       this.largura = larguraTexto * 1.5;
       //e.setFont(this.fonte);
               
       
       e.fillRectangle ( posX, posY, largura , altura , cinzaClaro );
       e.drawRectangle ( posX , posY , largura , altura , EngineFrame.BLACK );
       e.drawText(textoBotao , posX + (largura - larguraTexto)/2 , posY + altura /2 - 5  , fonteTam , Onyx );
       //e.drawText(textoBotao, posX + (largura - larguraTexto)/2, posY + altura / 2 - 5, EngineFrame.WHITE);
    }
    
    public boolean checarColisao(int x, int y){
        
        if( x >= this.posX && x <= this.posX + this.largura && y >= this.posY && y <= this.posY + this.altura){
            return true;
        }
        else{
            return false;
        }
    }
}
