package gui;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

/**
 *
 * @author cayke
 */

public class TelaAtual extends EngineFrame {
    
    private InterfaceTela telaAtiva;
    
    public TelaAtual (  ) {
        super(800, 450, "Tela Atual" ,60 ,true);
    }
    
    @Override
    public void create () {
        telaAtiva = new MenuInicial();
        telaAtiva.create ();
        this.setTitle(telaAtiva.getTitulo());
    }

    @Override
    public void update ( double delta ) {
        telaAtiva.update ( delta , this );
        
    }

    @Override
    public void draw () {
       telaAtiva.draw ( this );
    }
    
    public void mudarTela(InterfaceTela telaMudar){
        
        this.telaAtiva = telaMudar;
        this.telaAtiva.create ();
        this.setTitle(telaAtiva.getTitulo());

    }
    
    public static void main ( String[] args ) {
        
        new TelaAtual();
        
    }
}
