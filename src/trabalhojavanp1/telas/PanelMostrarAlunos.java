package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import trabalhojavanp1.objetos.Aluno;

public class PanelMostrarAlunos extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_ALUNOS = "PanelMostrarAlunos";        
    //COMPONENTES
    private JLabel labelTitulo,labelAlunosDaFaculdade;
    private JTextArea textAreaAlunosExistentes;
    //OBJECTS
    private List<Object> alunos;

    public PanelMostrarAlunos(){
        initViews();
        initObjects();
        inserirAlunosNoTextArea();    
    }

    @Override
    public void initViews() {
        this.setLayout(null);
        
        this.setLabelTitulo(new JLabel("MOSTRAR ALUNOS"));
        this.getLabelTitulo().setLocation(230,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelAlunosDaFaculdade(new JLabel("Abaixo todos os alunos da faculdade: "));
        this.getLabelAlunosDaFaculdade().setLocation(180,170);
        this.getLabelAlunosDaFaculdade().setSize(230,30);
        this.getLabelAlunosDaFaculdade().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaAlunosExistentes(new JTextArea("\n\n\n\n\n\n\n                         carregando..."));
        this.getTextAreaAlunosExistentes().setLocation(50,210);
        this.getTextAreaAlunosExistentes().setSize(500,400);
        this.getTextAreaAlunosExistentes().setFont(new Font("Serif", Font.BOLD, 14));
       
        this.add(getLabelTitulo());
        this.add(getLabelAlunosDaFaculdade());
        this.add(getLabelAlunosDaFaculdade());
        this.add(getTextAreaAlunosExistentes());

        this.setVisible(true);
    }
    

    @Override
    public void initObjects() {
        this.setAlunos(new Aluno().buscarTodos());
    }
    
    @Override
    public void initControles() {
    }
    
    private void inserirAlunosNoTextArea(){
        this.getTextAreaAlunosExistentes().setText("\n\n\n\n\n\n\n                         carregando...");
        if(this.getAlunos().size() == 0){
           this.getTextAreaAlunosExistentes().setText("\n\n\n\n\n\n\n\n\n\n                                         Não ha alunos cadastrados.");
        }else{
            String string = "";
            for(Iterator iterator = this.getAlunos().iterator(); iterator.hasNext();){
                Aluno aluno = (Aluno)iterator.next();
                string += aluno.gerarString();
                string += "\n\n";
            }
            this.getTextAreaAlunosExistentes().setText(string);

        }
    }
    
    public void refresh(){
        initObjects();
        inserirAlunosNoTextArea();
    }
        
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelAlunosDaFaculdade() {
        return labelAlunosDaFaculdade;
    }
    public void setLabelAlunosDaFaculdade(JLabel labelAlunosDaFaculdade) {
        this.labelAlunosDaFaculdade = labelAlunosDaFaculdade;
    }
    
    public List<Object> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Object> alunos) {
        this.alunos = alunos;
    }
    
    public JTextArea getTextAreaAlunosExistentes() {
        return textAreaAlunosExistentes;
    }
    public void setTextAreaAlunosExistentes(JTextArea textAreaAlunosExistentes) {
        this.textAreaAlunosExistentes = textAreaAlunosExistentes;
    }
}
