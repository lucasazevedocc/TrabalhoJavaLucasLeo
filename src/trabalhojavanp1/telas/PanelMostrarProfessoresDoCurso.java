package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

public class PanelMostrarProfessoresDoCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_PROFESSORES_DO_CURSO = "PanelMostrarProfessoresDoCurso";        
    //COMPONENTES
    private JLabel labelTitulo,labelProfessoresDoCurso,labelCodigoDoCurso;
    private JTextArea textAreaProfessoresDoCurso;
    private JTextField campoCodigoDoCurso;
    private JButton botaoBuscar;
    //OBJECTS
    private Curso curso;
    
    public PanelMostrarProfessoresDoCurso(){
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR PROFESSORES DO CURSO"));
        this.getLabelTitulo().setLocation(165,0);
        this.getLabelTitulo().setSize(250,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelProfessoresDoCurso(new JLabel("Abaixo todas os professores do curso: "));
        this.getLabelProfessoresDoCurso().setLocation(180,170);
        this.getLabelProfessoresDoCurso().setSize(260,30);
        this.getLabelProfessoresDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaProfessoresDoCurso(new JTextArea(""));
        this.getTextAreaProfessoresDoCurso().setLocation(50,210);
        this.getTextAreaProfessoresDoCurso().setSize(500,400);
        this.getTextAreaProfessoresDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        inserirCursosDoProfessorNoTextArea();     
        
        this.setLabelCodigoDoCurso(new JLabel("Codigo do curso: "));
        this.getLabelCodigoDoCurso().setLocation(50,90);
        this.getLabelCodigoDoCurso().setSize(160,30);
        this.getLabelCodigoDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoCodigoDoCurso(new JTextField());
        this.getCampoCodigoDoCurso().setSize(240,30);
        this.getCampoCodigoDoCurso().setLocation(165,90);
        this.getCampoCodigoDoCurso().setFont(new Font("Serif", Font.BOLD, 18));
        
        this.setBotaoBuscar(new JButton("Buscar"));
        this.getBotaoBuscar().setSize(120,30);
        this.getBotaoBuscar().setLocation(430,90);
        this.getBotaoBuscar().setBackground(new Color(150,220,255));
        //this.getBotaoSalvar().addActionListener(this);
        this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));
       
        this.add(getLabelTitulo());
        this.add(getLabelProfessoresDoCurso());
        this.add(getLabelProfessoresDoCurso());
        this.add(getTextAreaProfessoresDoCurso());
        this.add(getLabelCodigoDoCurso());
        this.add(getCampoCodigoDoCurso());
        this.add(getBotaoBuscar());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        //TODO MODFICAR LOGICA
        this.setCurso(null);

    }
    
     private void inserirCursosDoProfessorNoTextArea(){
         if(this.getCurso() == null){
            this.getTextAreaProfessoresDoCurso().setText("\n\n\n\n\n\n\n\n\n\n                            Busque um curso atraves do codigo do curso.");
        }
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
    
    public void atualizarTextArea(){
        initObjects();
        inserirCursosDoProfessorNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelProfessoresDoCurso() {
        return labelProfessoresDoCurso;
    }
    public void setLabelProfessoresDoCurso(JLabel labelProfessoresDoCurso) {
        this.labelProfessoresDoCurso = labelProfessoresDoCurso;
    }
    
    public JTextArea getTextAreaProfessoresDoCurso() {
        return textAreaProfessoresDoCurso;
    }
    public void setTextAreaProfessoresDoCurso(JTextArea textAreaProfessoresDoCurso) {
        this.textAreaProfessoresDoCurso = textAreaProfessoresDoCurso;
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
     public JLabel getLabelCodigoDoCurso() {
        return labelCodigoDoCurso;
    }
    public void setLabelCodigoDoCurso(JLabel labelCodigoDoCurso) {
        this.labelCodigoDoCurso = labelCodigoDoCurso;
    }

    public JTextField getCampoCodigoDoCurso() {
        return campoCodigoDoCurso;
    }
    public void setCampoCodigoDoCurso(JTextField campoCodigoDoCurso) {
        this.campoCodigoDoCurso = campoCodigoDoCurso;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }
    public void setBotaoBuscar(JButton botaoBuscar) {
        this.botaoBuscar = botaoBuscar;
    }
}
