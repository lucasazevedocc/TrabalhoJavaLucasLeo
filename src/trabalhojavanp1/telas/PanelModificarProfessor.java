/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Professor;


public class PanelModificarProfessor extends JPanel implements PadraoPanel{
    public static final String PANEL_MODIFICAR_PROFESSOR = "PanelModificarProfessor";        
    //COMPONENTES
    private JLabel labelTitulo,labelDadosDoProfessor,labelFormacaoProfessor,labelRegistroProfessorBusca,labelNomeProfessor,labelModificarDisciplinasDoProfessor;
    private JTextField campoMatriculaProfessor,campoNomeProfessor;
    private JButton botaoBuscar,botaoSalvar;
    private JPanel panelCheckBoxGroupDisciplinas,panelButtonGroupFormacao;
    private JRadioButton radioButtonBacharelado,radioButtonMestrado,radioButtonDoutorado;
    private ButtonGroup buttonGroupFormacaoProfessor;
    //OBJECTS
    private Professor professor;
    
    public PanelModificarProfessor(){
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MODIFICAR PROFESSOR"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(180,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelRegistroProfessorBusca(new JLabel("Registro do professor: "));
        this.getLabelRegistroProfessorBusca().setLocation(40,65);
        this.getLabelRegistroProfessorBusca().setSize(160,30);
        this.getLabelRegistroProfessorBusca().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoMatriculaProfessor(new JTextField());
        this.getCampoMatriculaProfessor().setSize(200,30);
        this.getCampoMatriculaProfessor().setLocation(190,65);
        this.getCampoMatriculaProfessor().setFont(new Font("Serif", Font.BOLD, 18));
        
        this.setBotaoBuscar(new JButton("Buscar"));
        this.getBotaoBuscar().setSize(120,30);
        this.getBotaoBuscar().setLocation(420,65);
        this.getBotaoBuscar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.setLabelDadosDoProfessor(new JLabel("Busque acima o professor que deseja modificar."));
        this.getLabelDadosDoProfessor().setLocation(160,115);
        this.getLabelDadosDoProfessor().setSize(300,30);
        this.getLabelDadosDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));    
       
        this.setLabelNomeProfessor(new JLabel("Nome: "));
        this.getLabelNomeProfessor().setLocation(30,160);
        this.getLabelNomeProfessor().setSize(200,30);
        this.getLabelNomeProfessor().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelModificarDisciplinasDoProfessor(new JLabel("Modificar as disciplinas do professor: "));
        this.getLabelModificarDisciplinasDoProfessor().setLocation(190,270);
        this.getLabelModificarDisciplinasDoProfessor().setSize(250,30);
        this.getLabelModificarDisciplinasDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeProfessor(new JTextField());
        this.getCampoNomeProfessor().setSize(465,30);
        this.getCampoNomeProfessor().setLocation(95,160);
        this.getCampoNomeProfessor().setFont(new Font("Serif", Font.BOLD, 24));
      
        this.labelFormacaoProfessor = new JLabel("Formacao do professor: ");
        this.labelFormacaoProfessor.setLocation(230,201);
        this.labelFormacaoProfessor.setSize(160,30);
        this.labelFormacaoProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setPanelButtonGroupFormacao(new JPanel());
        this.getPanelButtonGroupFormacao().setLayout(new FlowLayout());
        this.getPanelButtonGroupFormacao().setSize(300,40);
        this.getPanelButtonGroupFormacao().setLocation(150,229);
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
        
        this.setBotaoSalvar(new JButton("Salvar Alteracões"));
        this.getBotaoSalvar().setSize(170,40);
        this.getBotaoSalvar().setLocation(210,570);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      

        this.setPanelCheckBoxGroupDisciplinas(new JPanel());
        this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
        this.getPanelCheckBoxGroupDisciplinas().setSize(230,400);
        this.getPanelCheckBoxGroupDisciplinas().setLocation(180,305);
        this.getPanelCheckBoxGroupDisciplinas().setVisible(true);
        gerarCursos();

        
        
        
        this.add(getLabelTitulo());
        this.add(getLabelDadosDoProfessor());
        this.add(getLabelRegistroProfessorBusca());
        this.add(getCampoMatriculaProfessor());
        this.add(getBotaoBuscar());
        this.add(getLabelNomeProfessor());
        this.add(this.getPanelButtonGroupFormacao());
        this.add(this.labelFormacaoProfessor);
        this.add(getLabelModificarDisciplinasDoProfessor());
        this.add(getCampoNomeProfessor());
        this.add(getBotaoSalvar());
        this.add(getPanelCheckBoxGroupDisciplinas());

        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        //TODO MODFICAR LOGICA
        this.setAluno(null);
    }
    
    private void gerarCursos() {
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Arquitetura"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Ciencias da computacao aaabbbcccvvvaaabbbcccvvv"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Direito")); 
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Arquitetura"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Ciencias da computacao aaabbbcccvvvaaabbbcccvvv"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Direito"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Arquitetura"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Ciencias da computacao aaabbbcccvvvaaabbbcccvvv"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Direito"));
    }
    
     private void inserirDadosNosCampos(){
        /*if(this.getProfessor() == null){
         Abaixo todos os dados do aluno:
         
            this.getTextAreaCursosDoProfessor().setText("\n\n\n\n\n\n\n\n\n\n                              Busque um professor atraves do registro.");
        }*/
         /*else if(this.getProfessor().size() == 0){
           this.getTextAreaCursosDoProfessor().setText("\n\n\n\n\n\n\n\n\n\n                                      O professor não leciona em nehum curso.");
        }else{
            String string = "";

            for(Iterator iterator = this.getCursos().iterator(); iterator.hasNext();){
               /* Disciplina disciplina = (Disciplina)iterator.next();
                string += disciplina.gerarString();
                string += "\n\n";
            }

            this.getTextAreaCursosDoProfessor().setText(string);
        }*/
    }
    
    public void atualizar(){
        initObjects();
        //inserirCursosDoProfessorNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelDadosDoProfessor() {
        return labelDadosDoProfessor;
    }
    public void setLabelDadosDoProfessor(JLabel labelDadosDoProfessor) {
        this.labelDadosDoProfessor = labelDadosDoProfessor;
    }
    
    public JLabel getLabelRegistroProfessorBusca() {
        return labelRegistroProfessorBusca;
    }
    public void setLabelRegistroProfessorBusca(JLabel labelRegistroProfessorBusca) {
        this.labelRegistroProfessorBusca = labelRegistroProfessorBusca;
    }

    public JTextField getCampoMatriculaProfessor() {
        return campoMatriculaProfessor;
    }
    public void setCampoMatriculaProfessor(JTextField campoMatriculaProfessor) {
        this.campoMatriculaProfessor = campoMatriculaProfessor;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }
    public void setBotaoBuscar(JButton botaoBuscar) {
        this.botaoBuscar = botaoBuscar;
    }

    public Professor getAluno() {
        return professor;
    }
    public void setAluno(Professor professor) {
        this.professor = professor;
    }
    
    public JLabel getLabelNomeProfessor() {
        return labelNomeProfessor;
    }
    public void setLabelNomeProfessor(JLabel labelNomeProfessor) {
        this.labelNomeProfessor = labelNomeProfessor;
    }

    public JLabel getLabelModificarDisciplinasDoProfessor() {
        return labelModificarDisciplinasDoProfessor;
    }
    public void setLabelModificarDisciplinasDoProfessor(JLabel labelModificarDisciplinasDoProfessor) {
        this.labelModificarDisciplinasDoProfessor = labelModificarDisciplinasDoProfessor;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JPanel getPanelCheckBoxGroupDisciplinas() {
        return panelCheckBoxGroupDisciplinas;
    }
    public void setPanelCheckBoxGroupDisciplinas(JPanel panelCheckBoxGroupDisciplinas) {
        this.panelCheckBoxGroupDisciplinas = panelCheckBoxGroupDisciplinas;
    }
    
    public JTextField getCampoNomeProfessor() {
        return campoNomeProfessor;
    }
    public void setCampoNomeProfessor(JTextField campoNomeProfessor) {
        this.campoNomeProfessor = campoNomeProfessor;
    }
    
     public JLabel getLabelFormacaoProfessor() {
        return labelFormacaoProfessor;
    }
    public void setLabelFormacaoProfessor(JLabel labelFormacaoProfessor) {
        this.labelFormacaoProfessor = labelFormacaoProfessor;
    }

    public JPanel getPanelButtonGroupFormacao() {
        return panelButtonGroupFormacao;
    }
    public void setPanelButtonGroupFormacao(JPanel panelButtonGroupFormacao) {
        this.panelButtonGroupFormacao = panelButtonGroupFormacao;
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

    public ButtonGroup getButtonGroupFormacaoProfessor() {
        return buttonGroupFormacaoProfessor;
    }
    public void setButtonGroupFormacaoProfessor(ButtonGroup buttonGroupFormacaoProfessor) {
        this.buttonGroupFormacaoProfessor = buttonGroupFormacaoProfessor;
    }
}
