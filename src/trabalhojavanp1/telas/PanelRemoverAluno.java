
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

public class PanelRemoverAluno extends JPanel implements PadraoPanel{
    public static final String PANEL_REMOVER_ALUNO = "PanelRemoverAluno";        
    //COMPONENTES
    private JLabel labelTitulo,labelCodigoDoAluno;
    private JTextField campoCodigoAluno;
    private JButton botaoRemover;    
    
    public PanelRemoverAluno(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("REMOVER ALUNO"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCodigoDoAluno(new JLabel("Matricula do aluno: "));
        this.getLabelCodigoDoAluno().setLocation(30,285);
        this.getLabelCodigoDoAluno().setSize(160,30);
        this.getLabelCodigoDoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoCodigoAluno(new JTextField());
        this.getCampoCodigoAluno().setSize(400,30);
        this.getCampoCodigoAluno().setLocation(160,285);
        this.getCampoCodigoAluno().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoRemover(new JButton("Remover"));
        this.getBotaoRemover().setSize(150,40);
        this.getBotaoRemover().setLocation(220,340);
        this.getBotaoRemover().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoRemover().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.getLabelTitulo());
        this.add(this.getLabelCodigoDoAluno());
        this.add(this.getCampoCodigoAluno());
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

    public JLabel getLabelCodigoDoAluno() {
        return labelCodigoDoAluno;
    }
    public void setLabelCodigoDoAluno(JLabel labelCodigoDoAluno) {
        this.labelCodigoDoAluno = labelCodigoDoAluno;
    }

    public JTextField getCampoCodigoAluno() {
        return campoCodigoAluno;
    }
    public void setCampoCodigoAluno(JTextField campoCodigoAluno) {
        this.campoCodigoAluno = campoCodigoAluno;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }
    public void setBotaoRemover(JButton botaoRemover) {
        this.botaoRemover = botaoRemover;
    }
    
}
