package gui.componentesTela;

import gui.telas.TelaAtual;

/**
 *
 * @author cayke
 */

public class ControleVelocidade {

    private Botao mais;
    private Botao menos;
    private double velocidade;
    private int posX;
    private int posY;

    public ControleVelocidade() {
        this.posX = 665;
        this.posY = 50;
        this.velocidade = 1.0;

        this.menos = new Botao(this.posX, this.posY, "-");
        this.mais = new Botao(this.posX + 80, this.posY, "+");
    }

    public void atualizar(TelaAtual tela) {
        int mouseX = tela.getMouseX();
        int mouseY = tela.getMouseY();

        if (mais.checarColisao(mouseX, mouseY)) {
            if (tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)) {
                velocidade += 0.5;
            }
        }
        if (menos.checarColisao(mouseX, mouseY)) {
            if (tela.isMouseButtonPressed(tela.MOUSE_BUTTON_LEFT)) {
                if (velocidade > 0.5) {
                    velocidade -= 0.5;
                }
            }
        }
    }

    public void desenhar(TelaAtual tela) {
        int mouseX = tela.getMouseX();
        int mouseY = tela.getMouseY();

        menos.desenhaBotao(tela, mouseX, mouseY);
        mais.desenhaBotao(tela, mouseX, mouseY);

        tela.drawText(String.format("%.1fx", velocidade), posX + 30, posY + 10,15, tela.BLACK);
        tela.drawText("Velocidade", posX + 5 , posY - 13 ,15, tela.BLACK);
    }

    public double getTempoEspera() {
        return 1.0 / velocidade;
    }
}