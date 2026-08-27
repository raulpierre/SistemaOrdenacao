package gui.componentesTela;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 *
 * @author cayke
 */
public class Botao {
    
    private int posX;
    private int posY;
    private double largura = 0;
    private int altura = 30;
    private String textoBotao;
    
    public Botao ( int posX , int posY , String textoBotao ) {
        
        this.textoBotao = textoBotao;
        this.posX = posX;
        this.posY = posY;
    
    }
    public Botao ( int posX , int posY , double largura, String textoBotao ) {
        
        this.textoBotao = textoBotao;
        this.posX = posX;
        this.posY = posY;
        this.largura = largura;
    
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
       if(this.largura == 0){
           this.largura = larguraTexto * 1.5;
       }        
       
       e.fillRectangle ( posX, posY, largura , altura , EngineFrame.GRAY );
       e.drawRectangle ( posX , posY , largura , altura , EngineFrame.BLACK );
       e.drawText(textoBotao , posX + (largura - larguraTexto)/2 , posY + altura /2 - 5  , fonte , EngineFrame.WHITE );
       
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
