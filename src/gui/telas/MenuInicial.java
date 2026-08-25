package gui.telas;

import gui.componentesTela.Botao;

/**
 *
 * @author cayke
 */
public class MenuInicial implements InterfaceTela {
    
    Botao selectionSort;

    @Override
    public void create () {
        selectionSort = new Botao (50, 50, "Selection Sort" );
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        int mouseX = tela.getMouseX ();
        int mouseY = tela.getMouseY ();
        
        boolean colisao = mouseX >= selectionSort.getPosX () 
                && mouseX <= selectionSort.getPosX() + selectionSort.getLargura () 
                && mouseY >= selectionSort.getPosY() 
                && mouseY <= selectionSort.getPosY() + selectionSort.getAltura () ? 
                true : false;
        
        if(colisao){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaBubbleSort() );
            }
        }
    }

    @Override
    public void draw ( TelaAtual tela ) {
       selectionSort.desenhaBotao ( tela );
    }

    @Override
    public String getTitulo () {
        return "Menu Inicial";
    }

    
}
