package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 *
 * @author cayke
 */
public class Gui extends EngineFrame {
    
  
    
    public Gui(String titulo){
        
        
        super(800, 400, titulo, 60, true);
    }
    
    @Override
    public void create () {
        
    }

    @Override
    public void update ( double delta ) {
    
    }

    @Override
    public void draw () {
        fillCircle(50, 50, 50, PINK);
    }
    
    public static void main(String[] args) {
        new Gui("teste");
    }
}
