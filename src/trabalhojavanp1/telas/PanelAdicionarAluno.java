package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelAdicionarAluno extends JPanel implements PadraoPanel,ActionListener{
    public static final String PANEL_ADICIONAR_ALUNO = "PanelAdicionarAluno";
    //COMPONENTES
    private JTextField campoNomeAluno,campoEnderecoAluno;
    private JLabel labelTitulo,labelNomeAluno,labelEnderecoAluno,labelAdicionarCursosDoAluno;
    private JPanel panelCheckBoxGroupCursos;
    private JButton botaoSalvar;
    //OBJETOS
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
        
        this.setLabelAdicionarCursosDoAluno(new JLabel("Adicione os cursos do aluno: "));
        this.getLabelAdicionarCursosDoAluno().setLocation(210,270);
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
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      

        this.setPanelCheckBoxGroupCursos(new JPanel());
        this.getPanelCheckBoxGroupCursos().setLayout(new BoxLayout(getPanelCheckBoxGroupCursos(),BoxLayout.Y_AXIS));
        this.getPanelCheckBoxGroupCursos().setSize(230,400);
        this.getPanelCheckBoxGroupCursos().setLocation(180,300);
        this.getPanelCheckBoxGroupCursos().setVisible(true);
        gerarCursos();

        
        this.add(getLabelTitulo());
        this.add(getLabelNomeAluno());
        this.add(getLabelEnderecoAluno());
        this.add(getLabelAdicionarCursosDoAluno());
        this.add(getCampoNomeAluno());
        this.add(getCampoEnderecoAluno());
        this.add(getBotaoSalvar());
        this.add(this.getPanelCheckBoxGroupCursos());

        



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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.botaoSalvar){
           // exibirPanel(PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO);
        }
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
    
    private void gerarCursos(){
        this.getPanelCheckBoxGroupCursos().add(new JCheckBox("Arquitetura"));
        this.getPanelCheckBoxGroupCursos().add(new JCheckBox("Ciencias da computacao aaabbbcccvvvaaabbbcccvvv"));
        this.getPanelCheckBoxGroupCursos().add(new JCheckBox("Direito"));
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
    
    public JLabel getLabelAdicionarCursosDoAluno() {
        return labelAdicionarCursosDoAluno;
    }
    public void setLabelAdicionarCursosDoAluno(JLabel labelAdicionarCursosDoAluno) {
        this.labelAdicionarCursosDoAluno = labelAdicionarCursosDoAluno;
    }
    
    public JPanel getPanelCheckBoxGroupCursos() {
        return panelCheckBoxGroupCursos;
    }
    public void setPanelCheckBoxGroupCursos(JPanel panelCheckBoxGroupCursos) {
        this.panelCheckBoxGroupCursos = panelCheckBoxGroupCursos;
    }

    
}


