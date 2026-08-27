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
        
        boolean colisao =   mouseX >= selectionSort.getPosX () 
                            && mouseX <= selectionSort.getPosX() + selectionSort.getLargura () 
                            && mouseY >= selectionSort.getPosY() 
                            && mouseY <= selectionSort.getPosY() + selectionSort.getAltura () ? 
                            true : false;
        
        if(colisao){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaSelectionSort() );
            }
        }
    }

    @Override
    public void draw ( TelaAtual tela ) {
<<<<<<< Updated upstream
       selectionSort.desenhaBotao ( tela );
=======
        
        tela.clearBackground ( new Color(181,199,235) );
        
        int mX = tela.getMouseX ();
        int mY = tela.getMouseY ();
        
        selectionSort.desenhaBotao ( tela, mX , mY );
        bubbleSort.desenhaBotao ( tela, mX , mY );
        mergeSort.desenhaBotao ( tela, mX , mY );
        shellSort.desenhaBotao ( tela, mX , mY );
        quickSort.desenhaBotao ( tela, mX , mY );
        insertionSort.desenhaBotao ( tela, mX , mY );
        heapSort.desenhaBotao ( tela, mX , mY );
        
        //Titulo:
        int tituloX = 350; 
        int tituloY = 150; 
        
        tela.drawText("Algoritmos de", tituloX, tituloY, 45, tela.WHITE);
        
        tela.drawText("Ordenação", tituloX + 50, tituloY + 50, 45, tela.WHITE);
        
        tela.drawText("Projeto de Estrutura de Dados", tituloX + 5, tituloY + 100, 20, Vermelho);

>>>>>>> Stashed changes
    }

    @Override
    public String getTitulo () {
        return "Menu Inicial";
    }

    
}
