package gui.telas;

import gui.componentesTela.Botao;
import java.awt.Color;

/**
 *
 * @author cayke
 */
public class MenuInicial implements InterfaceTela {
    
    
    private Botao selectionSort;
    private Botao bubbleSort;
    private Botao quickSort;
    private Botao shellSort;
    private Botao mergeSort;
    private Botao heapSort;
    private Botao insertionSort;
    
    private Color Vermelho = new Color(243,229,171);
    
    

    @Override
    public void create () {
        
        int posX = 100;
        int posY = 50;
        
        selectionSort = new Botao (posX, posY, "Selection Sort" );
        bubbleSort = new Botao(posX, posY + 50 , "Bubble Sort"); 
        quickSort = new Botao(posX, posY + 100, "Quick Sort");
        shellSort = new Botao(posX, posY + 150, "Shell Sort");
        heapSort = new Botao(posX, posY + 200, "Heap Sort");
        insertionSort = new Botao(posX, posY + 250, "Insertion Sort");
        mergeSort = new Botao(posX, posY + 300, "Merge Sort");
    }

    @Override
    public void update ( double delta , TelaAtual tela ) {
        
        int mouseX = tela.getMouseX ();
        int mouseY = tela.getMouseY ();
        
        
        if(selectionSort.checarColisao ( mouseX , mouseY )){
            
             if(tela.isMouseButtonPressed ( tela.MOUSE_BUTTON_LEFT )){
                 System.out.println ( "CLICOU" );
               tela.mudarTela ( new TelaSelectionSort() );
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
        
        tela.drawText("Projeto Estrutura de dados", tituloX + 25, tituloY + 100, 20, Vermelho);

    }

    @Override
    public String getTitulo () {
        return "Menu Inicial";
    }

    
}
