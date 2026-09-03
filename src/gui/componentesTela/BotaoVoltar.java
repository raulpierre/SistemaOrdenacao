package gui.componentesTela;

import gui.telas.MenuInicial;
import gui.telas.TelaAtual;

/**
 *
 * @author cayke
 */
public class BotaoVoltar extends Botao{

    public BotaoVoltar () {
        super ( 20 , 20 , "Voltar" );
    }
    
    public void update(TelaAtual tela) {
        int mouseX = tela.getMouseX();
        int mouseY = tela.getMouseY();

        if (checarColisao(mouseX, mouseY)) {
            if (tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)) {
                tela.mudarTela(new MenuInicial());
            }
        }
    }
}

