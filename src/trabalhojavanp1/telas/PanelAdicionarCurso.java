package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
<<<<<<< HEAD

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
=======
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
>>>>>>> 9ec8f4109d365c5182dc4e0a9c47194cb9930720
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JTextField;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
=======
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Professor;
>>>>>>> 9ec8f4109d365c5182dc4e0a9c47194cb9930720

//TODO verificar se ja existe professores adicionados antes de liberar a adicao dos cursos
public class PanelAdicionarCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_CURSO = "PanelAdicionarCurso";
    //COMPONENTES

    private JLabel labelTitulo,labelNomeCurso,labelDisciplinasCurso;
    private JTextField campoNomeCurso;
    private JButton botaoSalvar;
    private JList listaDisciplinasExistentes;
    private JPanel panelCheckBoxGroupDisciplinas;
    //OBJETOS
    private Curso curso;
    
    public PanelAdicionarCurso(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
    	this.setLayout(null);

        this.labelTitulo = new JLabel("ADICIONAR CURSO");
        this.labelTitulo.setLocation(220,0);
        this.labelTitulo.setSize(170,30);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelNomeCurso = new JLabel("Nome do curso: ");
        this.labelNomeCurso.setLocation(30,125);
        this.labelNomeCurso.setSize(160,30);
        this.labelNomeCurso.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelDisciplinasCurso = new JLabel("Selecione as disciplinas do curso: ");
        this.labelDisciplinasCurso.setLocation(185,230);
        this.labelDisciplinasCurso.setSize(235,30);
        this.labelDisciplinasCurso.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeCurso(new JTextField());
        this.getCampoNomeCurso().setSize(400,30);
        this.getCampoNomeCurso().setLocation(160,125);
        this.getCampoNomeCurso().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setPanelCheckBoxGroupDisciplinas(new JPanel());
        this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
        this.getPanelCheckBoxGroupDisciplinas().setSize(230,400);
        this.getPanelCheckBoxGroupDisciplinas().setLocation(180,265);
        this.getPanelCheckBoxGroupDisciplinas().setVisible(true);
        gerarDisciplinas();

        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
               
        this.add(this.labelTitulo);
        this.add(this.labelDisciplinasCurso);
        this.add(this.labelNomeCurso);
        this.add(this.getCampoNomeCurso());
        this.add(this.getBotaoSalvar());
        this.add(this.getPanelCheckBoxGroupDisciplinas());
        
        this.setCampoNomeCurso(new JTextField());
        this.getCampoNomeCurso().setSize(400,30);
        this.getCampoNomeCurso().setLocation(160,285);
        this.getCampoNomeCurso().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.labelTitulo);
        this.add(this.labelNomeCurso);
        this.add(this.getCampoNomeCurso());
        this.add(this.getBotaoSalvar());
        
        this.setVisible(true);  
    }

    @Override
    public void initObjects() {
        this.curso = new Curso();
    }
    
    private boolean professorIsValid(){
        if(false){
            return false;
        }else{
            this.curso = new Curso();
            //MONTAR PROFESSOR
            return true;
        }
    }
    
    private void gerarDisciplinas(){
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Geometria"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Banco de dados"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Java"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Geometria"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Banco de dados"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Java"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Geometria"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Banco de dados"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Java"));
        this.getPanelCheckBoxGroupDisciplinas().add(new JCheckBox("Geometria"));
    }

    
    //GETTERS SETTERS
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public JTextField getCampoNomeCurso() {
        return campoNomeCurso;
    }
    public void setCampoNomeCurso(JTextField campoNomeCurso) {
        this.campoNomeCurso = campoNomeCurso;
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

    public JPanel getPanelCheckBoxGroupDisciplinas() {
        return panelCheckBoxGroupDisciplinas;
    }
    public void setPanelCheckBoxGroupDisciplinas(JPanel panelCheckBoxGroupDisciplinas) {
        this.panelCheckBoxGroupDisciplinas = panelCheckBoxGroupDisciplinas;
    }
    
}
