package trabalhojavanp1.telas;

import interfaces.PadraoPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;

//TODO verificar se ja existe professores adicionados antes de liberar a adicao dos cursos
public class PanelAdicionarCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_CURSO = "PanelAdicionarCurso";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeCurso;
    private JTextField campoNomeCurso;
    private JButton botaoSalvar;    
    
    //OBJECTS 
    private Curso curso ;
    
    public PanelAdicionarCurso(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
    	this.setLayout(null);

        this.setLabelTitulo(new JLabel("ADICIONAR CURSO"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelNomeCurso(new JLabel("Nome da curso: "));
        this.getLabelNomeCurso().setLocation(30,285);
        this.getLabelNomeCurso().setSize(160,30);
        this.getLabelNomeCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
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
    
    private boolean cursoIsValid(){
        if(false){
            return false;
        }else{
            this.curso = new Curso();
            //MONTAR CURSO
            return true;
        }
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

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}

	public JLabel getLabelNomeCurso() {
		return labelNomeCurso;
	}

	public void setLabelNomeCurso(JLabel labelNomeCurso) {
		this.labelNomeCurso = labelNomeCurso;
	}

	public JTextField getCampoNomeCurso() {
		return campoNomeCurso;
	}

	public void setCampoNomeCurso(JTextField campoNomeCurso) {
		this.campoNomeCurso = campoNomeCurso;
	}
}
