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

import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;


public class PanelMostrarDisciplinasDoProfessor extends JPanel implements PadraoPanel, ActionListener{
    public static final String PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR = "PanelMostrarDisciplinasDoProfessor";        
    //COMPONENTES
    private JLabel labelTitulo,labelDisciplinasDoProfessor,labelRegistroDoProfessor;
    private JTextArea textAreaDisciplinasDoProfessor;
    private JTextField campoRegistroProfessor;
    private JButton botaoBuscar;
    //OBJECTS
    private Professor professor;
    
    public PanelMostrarDisciplinasDoProfessor(){
        this.initViews();
    }

    @Override
    public final void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR DISCIPLINAS DO PROFESSOR"));
        this.getLabelTitulo().setLocation(155,0);
        this.getLabelTitulo().setSize(275,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelDisciplinasDoProfessor(new JLabel("Abaixo todas as disciplinas do professor: "));
        this.getLabelDisciplinasDoProfessor().setLocation(175,170);
        this.getLabelDisciplinasDoProfessor().setSize(260,30);
        this.getLabelDisciplinasDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaDisciplinasDoProfessor(new JTextArea(""));
        this.getTextAreaDisciplinasDoProfessor().setLocation(50,210);
        this.getTextAreaDisciplinasDoProfessor().setSize(500,400);
        this.getTextAreaDisciplinasDoProfessor().setFont(new Font("Serif", Font.BOLD, 14));
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
        this.add(getLabelDisciplinasDoProfessor());
        this.add(getLabelDisciplinasDoProfessor());
        this.add(getTextAreaDisciplinasDoProfessor());
        this.add(getLabelRegistroDoProfessor());
        this.add(getCampoRegistroProfessor());
        this.add(getBotaoBuscar());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        //TODO MODFICAR LOGICA
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == this.botaoBuscar){
    		this.setProfessor((Professor) new Professor()
        	.buscarByKey(Integer.parseInt(this.getCampoRegistroProfessor().getText())));
    		this.inserirCursosDoProfessorNoTextArea();
    	}else{
            JOptionPane.showMessageDialog(null,"Aluno n�o removido.");
      }
    }

    
     private void inserirCursosDoProfessorNoTextArea(){
         if(this.getProfessor() == null){
            this.getTextAreaDisciplinasDoProfessor().setText("\n\n\n\n\n\n\n\n\n\n                               Busque um professor atraves do registro.");
        }else{
            String string = "";

            for(Integer key : this.professor.getDisciplinas().keySet()){
                string += ((Disciplina) new Disciplina().buscarByKey(key)).gerarString();
                string += "\n\n";
            }

            this.getTextAreaDisciplinasDoProfessor().setText(string);
        }
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
    
    public JLabel getLabelDisciplinasDoProfessor() {
        return labelDisciplinasDoProfessor;
    }
    public void setLabelDisciplinasDoProfessor(JLabel labelDisciplinasDoProfessor) {
        this.labelDisciplinasDoProfessor = labelDisciplinasDoProfessor;
    }
    
    public JTextArea getTextAreaDisciplinasDoProfessor() {
        return textAreaDisciplinasDoProfessor;
    }
    public void setTextAreaDisciplinasDoProfessor(JTextArea textAreaDisciplinasDoProfessor) {
        this.textAreaDisciplinasDoProfessor = textAreaDisciplinasDoProfessor;
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
