package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ProfessorDao;
import trabalhojavanp1.objetos.Professor;

public class PanelMostrarCursosDoProfessor extends JPanel implements PadraoPanel, ActionListener{
    public static final String PANEL_MOSTRAR_CURSOS_DO_PROFESSOR = "PanelMostrarCursosDoProfessor";        
    //COMPONENTES
    private JLabel labelTitulo,labelCursosDoProfessor,labelRegistroDoProfessor;
    private JTextArea textAreaCursosDoProfessor;
    private JTextField campoRegistroProfessor;
    private JButton botaoBuscar;
    //OBJECTS
    private Professor professor;
    
    public PanelMostrarCursosDoProfessor(){
        this.initViews();
    }
    
    @Override
    public final void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR CURSOS DO PROFESSOR"));
        this.getLabelTitulo().setLocation(170,0);
        this.getLabelTitulo().setSize(250,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCursosDoProfessor(new JLabel("Abaixo todos os cursos do professor: "));
        this.getLabelCursosDoProfessor().setLocation(185,170);
        this.getLabelCursosDoProfessor().setSize(260,30);
        this.getLabelCursosDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaCursosDoProfessor(new JTextArea(""));
        this.getTextAreaCursosDoProfessor().setLocation(50,210);
        this.getTextAreaCursosDoProfessor().setSize(500,400);
        this.getTextAreaCursosDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
        inserirCursosDoProfessorNoTextArea();     
        
        this.setLabelRegistroDoProfessor(new JLabel("Registro do Professor: "));
        this.getLabelRegistroDoProfessor().setLocation(50,90);
        this.getLabelRegistroDoProfessor().setSize(160,30);
        this.getLabelRegistroDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoRegistroProfessor(new JTextField());
        this.getCampoRegistroProfessor().setSize(200,30);
        this.getCampoRegistroProfessor().setLocation(200,90);
        this.getCampoRegistroProfessor().setFont(new Font("Serif", Font.BOLD, 18));
        
        this.setBotaoBuscar(new JButton("Buscar"));
        this.getBotaoBuscar().setSize(120,30);
        this.getBotaoBuscar().setLocation(430,90);
        this.getBotaoBuscar().setBackground(new Color(150,220,255));
        this.getBotaoBuscar().addActionListener(this);
        this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));
       
        this.add(getLabelTitulo());
        this.add(getLabelCursosDoProfessor());
        this.add(getTextAreaCursosDoProfessor());
        this.add(getLabelRegistroDoProfessor());
        this.add(getCampoRegistroProfessor());
        this.add(getBotaoBuscar());

        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {}
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
     private void inserirCursosDoProfessorNoTextArea(){
         if(this.getProfessor() == null){
            this.getTextAreaCursosDoProfessor().setText("\n\n\n\n\n\n\n\n\n\n                              Busque um professor atraves do registro.");
        }else{
            String string = "";

            for(Integer key : this.getProfessor().getLecionando().keySet()){
                string += this.getProfessor().getLecionando().get(key).getCurso().gerarString();
                string += "\n\n";
            }

            this.getTextAreaCursosDoProfessor().setText(string);
        }
    }
     
    @Override
     public void actionPerformed(ActionEvent ae) {
     	if(ae.getSource() == this.botaoBuscar){
     		this.setProfessor((Professor) new ProfessorDao()
     				.mostrarProfessorDoCurso(Integer.parseInt(this.getCampoRegistroProfessor().getText())));
     		this.inserirCursosDoProfessorNoTextArea();
     	}else{
             JOptionPane.showMessageDialog(null,"Aluno n�o removido.");
       }
     }
    
    public void atualizarTextArea(){
        inserirCursosDoProfessorNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelCursosDoProfessor() {
        return labelCursosDoProfessor;
    }
    public void setLabelCursosDoProfessor(JLabel labelCursosDoProfessor) {
        this.labelCursosDoProfessor = labelCursosDoProfessor;
    }
    
    public JTextArea getTextAreaCursosDoProfessor() {
        return textAreaCursosDoProfessor;
    }
    public void setTextAreaCursosDoProfessor(JTextArea textAreaCursosDoProfessor) {
        this.textAreaCursosDoProfessor = textAreaCursosDoProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public JLabel getLabelRegistroDoProfessor() {
        return labelRegistroDoProfessor;
    }
    public void setLabelRegistroDoProfessor(JLabel labelRegistroDoProfessor) {
        this.labelRegistroDoProfessor = labelRegistroDoProfessor;
    }

    public JTextField getCampoRegistroProfessor() {
        return campoRegistroProfessor;
    }
    public void setCampoRegistroProfessor(JTextField campoRegistroProfessor) {
        this.campoRegistroProfessor = campoRegistroProfessor;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }
    public void setBotaoBuscar(JButton botaoBuscar) {
        this.botaoBuscar = botaoBuscar;
    }
}
