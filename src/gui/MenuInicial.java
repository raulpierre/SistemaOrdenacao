package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 *
 * @author cayke
 */
public class MenuInicial extends EngineFrame {
    
    
    
    public MenuInicial(){
        super(800,450,"Menu Inicial", 60,true);
    }

    @Override
    public void create () {
        
    }

    @Override
    public void update ( double delta ) {
    
    }

    @Override
    public void draw () {
        fillRectangle(50, 50, 50, 30, PINK);
    }
    
    
    
}
