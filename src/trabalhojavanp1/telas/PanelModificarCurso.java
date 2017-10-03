package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Curso;


public class PanelModificarCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_MODIFICAR_CURSO = "PanelModificarCurso";
    //COMPONENTES
    private JLabel labelTitulo,labelDadosDoCurso,labelCodigoDoCurso,labelNomeCurso,labelModificarDisciplinasDoCurso;
    private JTextField campoCodigoCurso,campoNomeCurso;
    private JButton botaoBuscar,botaoSalvar;
    private JPanel panelCheckBoxGroupDisciplinas;   
    //OBJECTS
    private Curso curso;
    
    public PanelModificarCurso(){
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MODIFICAR CURSO"));
        this.getLabelTitulo().setLocation(220,0);
        this.getLabelTitulo().setSize(180,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCodigoDoCurso(new JLabel("Codigo do curso: "));
        this.getLabelCodigoDoCurso().setLocation(40,85);
        this.getLabelCodigoDoCurso().setSize(160,30);
        this.getLabelCodigoDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoCodigoCurso(new JTextField());
        this.getCampoCodigoCurso().setSize(210,30);
        this.getCampoCodigoCurso().setLocation(180,85);
        this.getCampoCodigoCurso().setFont(new Font("Serif", Font.BOLD, 18));
        
        this.setBotaoBuscar(new JButton("Buscar"));
        this.getBotaoBuscar().setSize(120,30);
        this.getBotaoBuscar().setLocation(420,85);
        this.getBotaoBuscar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.setLabelDadosDoCurso(new JLabel("Busque acima o curso que deseja modificar."));
        this.getLabelDadosDoCurso().setLocation(160,145);
        this.getLabelDadosDoCurso().setSize(300,30);
        this.getLabelDadosDoCurso().setFont(new Font("Serif", Font.BOLD, 14));    
       
        this.setLabelNomeCurso(new JLabel("Nome: "));
        this.getLabelNomeCurso().setLocation(30,210);
        this.getLabelNomeCurso().setSize(200,30);
        this.getLabelNomeCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelModificarDisciplinasDoCurso(new JLabel("Modificar as disciplinas do curso: "));
        this.getLabelModificarDisciplinasDoCurso().setLocation(190,280);
        this.getLabelModificarDisciplinasDoCurso().setSize(250,30);
        this.getLabelModificarDisciplinasDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeCurso(new JTextField());
        this.getCampoNomeCurso().setSize(465,30);
        this.getCampoNomeCurso().setLocation(95,210);
        this.getCampoNomeCurso().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoSalvar(new JButton("Salvar Alteracões"));
        this.getBotaoSalvar().setSize(170,40);
        this.getBotaoSalvar().setLocation(210,570);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      

        this.setPanelCheckBoxGroupDisciplinas(new JPanel());
        this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
        this.getPanelCheckBoxGroupDisciplinas().setSize(230,400);
        this.getPanelCheckBoxGroupDisciplinas().setLocation(180,315);
        this.getPanelCheckBoxGroupDisciplinas().setVisible(true);
        gerarCursos();

        
        
        
        this.add(getLabelTitulo());
        this.add(getLabelDadosDoCurso());
        this.add(getLabelCodigoDoCurso());
        this.add(getCampoCodigoCurso());
        this.add(getBotaoBuscar());
        this.add(getLabelNomeCurso());
        this.add(getLabelModificarDisciplinasDoCurso());
        this.add(getCampoNomeCurso());
        this.add(getBotaoSalvar());
        this.add(getPanelCheckBoxGroupDisciplinas());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        this.curso = null;
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    private boolean cursoIsValid(){
        if(false){
            return false;
        }else{
            this.curso = new Curso();
            //MONTAR CURSO
            return true;
        }
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
    
    //GETTERS SETTERS
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelDadosDoCurso() {
        return labelDadosDoCurso;
    }
    public void setLabelDadosDoCurso(JLabel labelDadosDoCurso) {
        this.labelDadosDoCurso = labelDadosDoCurso;
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

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }
    public void setBotaoBuscar(JButton botaoBuscar) {
        this.botaoBuscar = botaoBuscar;
    }
    
    public JLabel getLabelNomeCurso() {
        return labelNomeCurso;
    }
    public void setLabelNomeCurso(JLabel labelNomeCurso) {
        this.labelNomeCurso = labelNomeCurso;
    }

    public JLabel getLabelModificarDisciplinasDoCurso() {
        return labelModificarDisciplinasDoCurso;
    }
    public void setLabelModificarDisciplinasDoCurso(JLabel labelModificarDisciplinasDoCurso) {
        this.labelModificarDisciplinasDoCurso = labelModificarDisciplinasDoCurso;
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
    
    public JTextField getCampoNomeCurso() {
        return campoNomeCurso;
    }
    public void setCampoNomeCurso(JTextField campoNomeCurso) {
        this.campoNomeCurso = campoNomeCurso;
    }
}
