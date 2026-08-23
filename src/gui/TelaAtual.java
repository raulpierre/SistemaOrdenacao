package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 *
 * @author cayke
 */

public class TelaAtual extends EngineFrame {
    
    private Botao[] botoes;
    
    public TelaAtual ( String titulo ) {
        super(800, 450, titulo ,60 ,true);
    }
    
    @Override
    public void create () {
        
    }

    @Override
    public void update ( double delta ) {
        
    }

    @Override
    public void draw () {
       
    }
    
    public static void main ( String[] args ) {
        
        MenuInicial telaAtual = new MenuInicial();
        
    }
}
