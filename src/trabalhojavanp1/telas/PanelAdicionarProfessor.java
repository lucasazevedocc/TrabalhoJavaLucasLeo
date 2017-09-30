package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Professor;

//TODO verificar se ja existe disciplinas adicionados antes de liberar a adicao dos professores
public class PanelAdicionarProfessor extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_PROFESSOR = "PanelAdicionarProfessor";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeProfessor,labelDisciplinasProfessor,labelFormacaoProfessor;
    private JTextField campoNomeProfessor;
    private JButton botaoSalvar;
    private JList listaDisciplinasExistentes;
    private JPanel panelButtonGroupFormacao,panelCheckBoxGroupDisciplinas;
    private ButtonGroup buttonGroupFormacaoProfessor;
    private JRadioButton radioButtonBacharelado,radioButtonMestrado,radioButtonDoutorado;
    //OBJETOS
    private Professor professor;
    
    public PanelAdicionarProfessor(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTitulo = new JLabel("ADICIONAR PROFESSOR");
        this.labelTitulo.setLocation(210,0);
        this.labelTitulo.setSize(170,30);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelNomeProfessor = new JLabel("Nome do professor: ");
        this.labelNomeProfessor.setLocation(30,100);
        this.labelNomeProfessor.setSize(160,30);
        this.labelNomeProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelFormacaoProfessor = new JLabel("Formacao do professor: ");
        this.labelFormacaoProfessor.setLocation(230,185);
        this.labelFormacaoProfessor.setSize(160,30);
        this.labelFormacaoProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelDisciplinasProfessor = new JLabel("Selecione as disciplinas do professor: ");
        this.labelDisciplinasProfessor.setLocation(185,300);
        this.labelDisciplinasProfessor.setSize(235,30);
        this.labelDisciplinasProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeProfessor(new JTextField());
        this.getCampoNomeProfessor().setSize(400,30);
        this.getCampoNomeProfessor().setLocation(160,100);
        this.getCampoNomeProfessor().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setPanelButtonGroupFormacao(new JPanel());
        this.getPanelButtonGroupFormacao().setLayout(new FlowLayout());
        this.getPanelButtonGroupFormacao().setSize(300,100);
        this.getPanelButtonGroupFormacao().setLocation(150,215);
        this.getPanelButtonGroupFormacao().setVisible(true);
        this.setButtonGroupFormacaoProfessor(new ButtonGroup());
        this.setRadioButtonBacharelado(new JRadioButton("Bacharelado",true));
        this.setRadioButtonDoutorado(new JRadioButton("Doutorado",false));
        this.setRadioButtonMestrado(new JRadioButton("Mestrado",false));
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonBacharelado());
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonMestrado());
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonDoutorado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonBacharelado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonMestrado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonDoutorado());
        
        this.setPanelCheckBoxGroupDisciplinas(new JPanel());
        this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
        this.getPanelCheckBoxGroupDisciplinas().setSize(230,400);
        this.getPanelCheckBoxGroupDisciplinas().setLocation(180,335);
        this.getPanelCheckBoxGroupDisciplinas().setVisible(true);
        gerarDisciplinas();

        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        
        
        this.add(this.labelTitulo);
        this.add(this.labelDisciplinasProfessor);
        this.add(this.labelFormacaoProfessor);
        this.add(this.labelNomeProfessor);
        this.add(this.getCampoNomeProfessor());
        this.add(this.getPanelButtonGroupFormacao());
        this.add(this.getBotaoSalvar());
        this.add(this.getPanelCheckBoxGroupDisciplinas());


        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        this.professor = new Professor();
    }
    
    private boolean professorIsValid(){
        if(false){
            return false;
        }else{
            this.professor = new Professor();
            //MONTAR PROFESSOR
            return true;
        }
    }
    
    private void gerarDisciplinas(){
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Geometria"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Banco de dados"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Java"));
    }

    
    //GETTERS SETTERS
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public JTextField getCampoNomeProfessor() {
        return campoNomeProfessor;
    }
    public void setCampoNomeProfessor(JTextField campoNomeProfessor) {
        this.campoNomeProfessor = campoNomeProfessor;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JList getListaDisciplinasExistentes() {
        return listaDisciplinasExistentes;
    }
    public void setListaDisciplinasExistentes(JList listaDisciplinasExistentes) {
        this.listaDisciplinasExistentes = listaDisciplinasExistentes;
    }

    public ButtonGroup getButtonGroupFormacaoProfessor() {
        return buttonGroupFormacaoProfessor;
    }
    public void setButtonGroupFormacaoProfessor(ButtonGroup buttonGroupFormacaoProfessor) {
        this.buttonGroupFormacaoProfessor = buttonGroupFormacaoProfessor;
    }
    
    public JRadioButton getRadioButtonBacharelado() {
        return radioButtonBacharelado;
    }
    public void setRadioButtonBacharelado(JRadioButton radioButtonBacharelado) {
        this.radioButtonBacharelado = radioButtonBacharelado;
    }

    public JRadioButton getRadioButtonMestrado() {
        return radioButtonMestrado;
    }
    public void setRadioButtonMestrado(JRadioButton radioButtonMestrado) {
        this.radioButtonMestrado = radioButtonMestrado;
    }

    public JRadioButton getRadioButtonDoutorado() {
        return radioButtonDoutorado;
    }
    public void setRadioButtonDoutorado(JRadioButton radioButtonDoutorado) {
        this.radioButtonDoutorado = radioButtonDoutorado;
    }

    public JPanel getPanelButtonGroupFormacao() {
        return panelButtonGroupFormacao;
    }
    public void setPanelButtonGroupFormacao(JPanel panelButtonGroupFormacao) {
        this.panelButtonGroupFormacao = panelButtonGroupFormacao;
    }

    public JPanel getPanelCheckBoxGroupDisciplinas() {
        return panelCheckBoxGroupDisciplinas;
    }
    public void setPanelCheckBoxGroupDisciplinas(JPanel panelCheckBoxGroupDisciplinas) {
        this.panelCheckBoxGroupDisciplinas = panelCheckBoxGroupDisciplinas;
    }
    
}
