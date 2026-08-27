package gui.telas;

import gui.componentesTela.Botao;
import java.awt.Color;

/**
 *
 * @author cayke
 */
public class MenuInicial implements InterfaceTela {
    
    
    Botao selectionSort;
    Botao bubbleSort;
    Botao quickSort;
    Botao shellSort;
    Botao mergeSort;
    Botao heapSort;
    Botao insertionSort;
    

    @Override
    public void create () {
        
        int posX = 100;
        int posY = 50;
        
        selectionSort = new Botao (posX, posY, "Selection Sort" );
        bubbleSort = new Botao(posX, posY + 50 , "Bubble Sort"); 
        quickSort = new Botao(posX, posY + 100, "quickSort");
        shellSort = new Botao(posX, posY + 150, "shellSort");
        heapSort = new Botao(posX, posY + 200, "heapSort");
        insertionSort = new Botao(posX, posY + 250, "insertionSort");
        mergeSort = new Botao(posX, posY + 300, "mergeSort");
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        int mouseX = tela.getMouseX ();
        int mouseY = tela.getMouseY ();
        
        
        if(selectionSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaShellSort() );
            }
        }
        
        if(bubbleSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaBubbleSort() );
            }
        }
        if(quickSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaQuickSort() );
            }
        }
        if(shellSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaShellSort() );
            }
        }
        if(mergeSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaMergeSort() );
            }
        }
        if(insertionSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaInsertionSort() );
            }
        }
        if(heapSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaHeapSort() );
            }
        }
        
    }

    @Override
    public void draw ( TelaAtual tela ) {
        
        tela.clearBackground ( new Color(210,10,46) );
        
        selectionSort.desenhaBotao ( tela );
        bubbleSort.desenhaBotao ( tela );
        mergeSort.desenhaBotao ( tela );
        shellSort.desenhaBotao ( tela );
        quickSort.desenhaBotao ( tela );
        insertionSort.desenhaBotao ( tela );
        heapSort.desenhaBotao ( tela );

    }

    @Override
    public String getTitulo () {
        return "Menu Inicial";
    }

    
}
