package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Disciplina;


public class PanelAdicionarDisciplina extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_DISCIPLINA = "PanelAdicionarDisciplina";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeDisciplina;
    private JTextField campoNomeDisciplina;
    private JButton botaoSalvar;
    //OBJETOS
    private Disciplina disciplina;
    
    public PanelAdicionarDisciplina(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("ADICIONAR DISCIPLINA"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelNomeDisciplina(new JLabel("Nome da disciplina: "));
        this.getLabelNomeDisciplina().setLocation(30,285);
        this.getLabelNomeDisciplina().setSize(160,30);
        this.getLabelNomeDisciplina().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeDisciplina(new JTextField());
        this.getCampoNomeDisciplina().setSize(400,30);
        this.getCampoNomeDisciplina().setLocation(160,285);
        this.getCampoNomeDisciplina().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.labelTitulo);
        this.add(this.labelNomeDisciplina);
        this.add(this.getCampoNomeDisciplina());
        this.add(this.getBotaoSalvar());
        
        this.setVisible(true);  
    }

    @Override
    public void initObjects() {
        this.disciplina = new Disciplina();
    }
    
    private boolean disciplinaIsValid(){
        if(false){
            return false;
        }else{
            this.disciplina = new Disciplina();
            //MONTAR DIscIPLINA
            return true;
        }
    }

    
    //GETTERS SETTERS
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JLabel getLabelNomeDisciplina() {
        return labelNomeDisciplina;
    }
    public void setLabelNomeDisciplina(JLabel labelNomeDisciplina) {
        this.labelNomeDisciplina = labelNomeDisciplina;
    }

    public JTextField getCampoNomeDisciplina() {
        return campoNomeDisciplina;
    }
    public void setCampoNomeDisciplina(JTextField campoNomeDisciplina) {
        this.campoNomeDisciplina = campoNomeDisciplina;
    }
    
    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }
}
