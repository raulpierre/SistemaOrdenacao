package gui;

/**
 *
 * @author cayke
 */
public interface InterfaceTela {
    
    public void create();
    public void update(double delta, TelaAtual janela);
    public void draw(TelaAtual janela);
    
    public String getTitulo();
}
