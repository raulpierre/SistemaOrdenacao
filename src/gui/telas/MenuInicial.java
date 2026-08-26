package gui.telas;

import br.com.davidbuzatto.jsge.collision.aabb.AABB;
import gui.componentesTela.Botao;

/**
 *
 * @author cayke
 */
public class MenuInicial implements InterfaceTela {
    
    Botao selectionSort;
    
    Botao bubbleSort;
    

    @Override
    public void create () {
        int posX = 50;
        int posY = 50;
        selectionSort = new Botao (posX, posY, "Selection Sort" );
        bubbleSort = new Botao(posX, posY + 50 , "Bubble Sort"); 
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        int mouseX = tela.getMouseX ();
        int mouseY = tela.getMouseY ();
        
        
        if(selectionSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaHeapSort() );
            }
        }
        
        if(bubbleSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaBubbleSort() );
            }
        }
    }

    @Override
    public void draw ( TelaAtual tela ) {
       selectionSort.desenhaBotao ( tela );
       bubbleSort.desenhaBotao ( tela );
    }

    @Override
    public String getTitulo () {
        return "Menu Inicial";
    }

    
}
