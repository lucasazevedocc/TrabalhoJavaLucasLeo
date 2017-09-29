
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelAdicionarAluno extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_ALUNO = "PanelAdicionarAluno";
    //private JLabel labelTeste;
    private JTextField campoNomeAluno;
    private JTextField campoEnderecoAluno;
    private JLabel labelTitulo;
    private JLabel labelNomeAluno;
    private JLabel labelEnderecoAluno;
    private JLabel labelCursosDoAluno;
    private JLabel labelCursosExistentes;
    private JLabel labelAdicionarCursosDoAluno;
    private JButton botaoSalvar;
    private JButton botaoAdicionarCurso;
    private JList listaCursosExistentes; 
    private DefaultListModel modelListaCursosExistentes;

    private Aluno aluno;
    
    public PanelAdicionarAluno(){
        initViews();
        initObjects();
    }
    
    @Override
    public void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(null);
        this.setLabelTitulo(new JLabel("ADICIONAR ALUNO"));
        this.getLabelTitulo().setLocation(230,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelNomeAluno(new JLabel("Nome: "));
        this.getLabelNomeAluno().setLocation(30,100);
        this.getLabelNomeAluno().setSize(200,30);
        this.getLabelNomeAluno().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelEnderecoAluno(new JLabel("Endereco: "));
        this.getLabelEnderecoAluno().setLocation(30,150);
        this.getLabelEnderecoAluno().setSize(200,30);
        this.getLabelEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCursosDoAluno(new JLabel("Cursos do aluno: "));
        this.getLabelCursosDoAluno().setLocation(450,255);
        this.getLabelCursosDoAluno().setSize(200,30);
        this.getLabelCursosDoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCursosExistentes(new JLabel("Cursos existentes: "));
        this.getLabelCursosExistentes().setLocation(30,255);
        this.getLabelCursosExistentes().setSize(200,30);
        this.getLabelCursosExistentes().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelAdicionarCursosDoAluno(new JLabel("Adicione os cursos do aluno: "));
        this.getLabelAdicionarCursosDoAluno().setLocation(210,225);
        this.getLabelAdicionarCursosDoAluno().setSize(200,30);
        this.getLabelAdicionarCursosDoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeAluno(new JTextField());
        this.getCampoNomeAluno().setSize(400,30);
        this.getCampoNomeAluno().setLocation(160,100);
        this.getCampoNomeAluno().setFont(new Font("Serif", Font.BOLD, 24));
      
        this.setCampoEnderecoAluno(new JTextField());
        this.getCampoEnderecoAluno().setSize(400,30);
        this.getCampoEnderecoAluno().setLocation(160,150);
        this.getCampoEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 24));
      
        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,550);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      

        this.setBotaoAdicionarCurso(new JButton("Adicionar Curso"));
        this.getBotaoAdicionarCurso().setSize(130,30);
        this.getBotaoAdicionarCurso().setLocation(230,345);
        this.getBotaoAdicionarCurso().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      
        
        this.setModelListaCursosExistentes(new DefaultListModel());
        this.getModelListaCursosExistentes().addElement("Administracao");
        this.getModelListaCursosExistentes().addElement("Ciencias da computacao");
        this.getModelListaCursosExistentes().addElement("Arquitetura");

        this.setListaCursosExistentes(new JList(this.getModelListaCursosExistentes()));
        this.getListaCursosExistentes().setSize(150,180);
        this.getListaCursosExistentes().setLocation(30,300);
        this.getListaCursosExistentes().setBackground(new Color(208,255,255));


        
        this.add(getLabelTitulo());
        this.add(getLabelNomeAluno());
        this.add(getLabelEnderecoAluno());
        this.add(getLabelAdicionarCursosDoAluno());
        this.add(getLabelCursosDoAluno());
        this.add(getLabelCursosExistentes());
        this.add(getCampoNomeAluno());
        this.add(getCampoEnderecoAluno());
        this.add(getBotaoSalvar());
        this.add(getBotaoAdicionarCurso());
        this.add(getListaCursosExistentes());



        /*this.labelTeste = new JLabel("PanelAdicionarAluno");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);*/
        this.setVisible(true);
    } 
    @Override
    public void initObjects(){
        this.aluno = new Aluno();
    }
    
    
    private boolean alunoIsValid(){
        if(false){
            return false;
        }else{
            this.aluno = new Aluno();
            //MONTAR ALUNO
            return true;
        }
    }
    
    //GETTERS SETTERS
    public Aluno getAluno() {
        return this.aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public JTextField getCampoNomeAluno() {
        return campoNomeAluno;
    }
    public void setCampoNomeAluno(JTextField campoNomeAluno) {
        this.campoNomeAluno = campoNomeAluno;
    }

    public JTextField getCampoEnderecoAluno() {
        return campoEnderecoAluno;
    }
    public void setCampoEnderecoAluno(JTextField campoEnderecoAluno) {
        this.campoEnderecoAluno = campoEnderecoAluno;
    }

    public JLabel getLabelNomeAluno() {
        return labelNomeAluno;
    }
    public void setLabelNomeAluno(JLabel labelNomeAluno) {
        this.labelNomeAluno = labelNomeAluno;
    }

    public JLabel getLabelEnderecoAluno() {
        return labelEnderecoAluno;
    }
    public void setLabelEnderecoAluno(JLabel labelEnderecoAluno) {
        this.labelEnderecoAluno = labelEnderecoAluno;
    }

    public JLabel getLabelCursosDoAluno() {
        return labelCursosDoAluno;
    }
    public void setLabelCursosDoAluno(JLabel labelCursosDoAluno) {
        this.labelCursosDoAluno = labelCursosDoAluno;
    }

    public JLabel getLabelCursosExistentes() {
        return labelCursosExistentes;
    }
    public void setLabelCursosExistentes(JLabel labelCursosExistentes) {
        this.labelCursosExistentes = labelCursosExistentes;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JList getListaCursosExistentes() {
        return listaCursosExistentes;
    }
    public void setListaCursosExistentes(JList listaCursosExistentes) {
        this.listaCursosExistentes = listaCursosExistentes;
    }

    public DefaultListModel getModelListaCursosExistentes() {
        return modelListaCursosExistentes;
    }
    public void setModelListaCursosExistentes(DefaultListModel modelListaCursosExistentes) {
        this.modelListaCursosExistentes = modelListaCursosExistentes;
    }

    public JButton getBotaoAdicionarCurso() {
        return botaoAdicionarCurso;
    }
    public void setBotaoAdicionarCurso(JButton botaoAdicionarCurso) {
        this.botaoAdicionarCurso = botaoAdicionarCurso;
    }

    public JLabel getLabelAdicionarCursosDoAluno() {
        return labelAdicionarCursosDoAluno;
    }
    public void setLabelAdicionarCursosDoAluno(JLabel labelAdicionarCursosDoAluno) {
        this.labelAdicionarCursosDoAluno = labelAdicionarCursosDoAluno;
    }
}


