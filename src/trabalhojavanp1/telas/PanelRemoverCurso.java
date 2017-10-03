
package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRemoverCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_REMOVER_CURSO = "PanelRemoverCurso";        
    //COMPONENTES
    private JLabel labelTitulo,labelCodigoDoCurso;
    private JTextField campoCodigoCurso;
    private JButton botaoRemover;     
    
    public PanelRemoverCurso(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("REMOVER CURSO"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCodigoDoCurso(new JLabel("Còdigo do curso: "));
        this.getLabelCodigoDoCurso().setLocation(30,285);
        this.getLabelCodigoDoCurso().setSize(160,30);
        this.getLabelCodigoDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoCodigoCurso(new JTextField());
        this.getCampoCodigoCurso().setSize(400,30);
        this.getCampoCodigoCurso().setLocation(160,285);
        this.getCampoCodigoCurso().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoRemover(new JButton("Remover"));
        this.getBotaoRemover().setSize(150,40);
        this.getBotaoRemover().setLocation(220,340);
        this.getBotaoRemover().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoRemover().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.getLabelTitulo());
        this.add(this.getLabelCodigoDoCurso());
        this.add(this.getCampoCodigoCurso());
        this.add(this.getBotaoRemover());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JLabel getLabelCodigoDoCurso() {
        return labelCodigoDoCurso;
    }
    public void setLabelCodigoDoCurso(JLabel labelCodigoDoCurso) {
        this.labelCodigoDoCurso = labelCodigoDoCurso;
    }

    public JTextField getCampoCodigoCurso() {
        return campoCodigoCurso;
    }
    public void setCampoCodigoCurso(JTextField campoCodigoCurso) {
        this.campoCodigoCurso = campoCodigoCurso;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }
    public void setBotaoRemover(JButton botaoRemover) {
        this.botaoRemover = botaoRemover;
    }
    
}
