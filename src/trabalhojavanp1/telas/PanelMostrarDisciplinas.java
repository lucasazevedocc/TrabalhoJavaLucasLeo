package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import trabalhojavanp1.objetos.Disciplina;

public class PanelMostrarDisciplinas extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_DISCIPLINAS = "PanelMostrarDisciplinas";
    //COMPONENTES
    private JLabel labelTitulo,labelDisciplinasDaFaculdade;
    private JTextArea textAreaDisciplinasExistentes;
    //OBJECTS
    private List<Object> disciplinas;
    
    public PanelMostrarDisciplinas(){
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR DISCIPLINAS"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelDisciplinasDaFaculdade(new JLabel("Abaixo todas as disciplinas da faculdade: "));
        this.getLabelDisciplinasDaFaculdade().setLocation(170,170);
        this.getLabelDisciplinasDaFaculdade().setSize(260,30);
        this.getLabelDisciplinasDaFaculdade().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaDisciplinasExistentes(new JTextArea(""));
        this.getTextAreaDisciplinasExistentes().setLocation(50,210);
        this.getTextAreaDisciplinasExistentes().setSize(500,400);
        this.getTextAreaDisciplinasExistentes().setFont(new Font("Serif", Font.BOLD, 14));
        inserirDisciplinasNoTextArea();     
       
        this.add(getLabelTitulo());
        this.add(getLabelDisciplinasDaFaculdade());
        this.add(getLabelDisciplinasDaFaculdade());
        this.add(getTextAreaDisciplinasExistentes());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        this.setDisciplinas(new Disciplina().buscarTodos());
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
     private void inserirDisciplinasNoTextArea(){
        if(this.getDisciplinas().size() == 0){
           this.getTextAreaDisciplinasExistentes().setText("\n\n\n\n\n\n\n\n\n\n                                      Não ha disciplinas cadastradas.");
        }else{
            String string = "";

            for(Iterator iterator = this.getDisciplinas().iterator(); iterator.hasNext();){
                Disciplina disciplina = (Disciplina)iterator.next();
                string += disciplina.gerarString();
                string += "\n\n";
            }

            this.getTextAreaDisciplinasExistentes().setText(string);
        }
    }
    
    public void atualizarTextArea(){
        initObjects();
        inserirDisciplinasNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelDisciplinasDaFaculdade() {
        return labelDisciplinasDaFaculdade;
    }
    public void setLabelDisciplinasDaFaculdade(JLabel labelDisciplinasDaFaculdade) {
        this.labelDisciplinasDaFaculdade = labelDisciplinasDaFaculdade;
    }

    public List<Object> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(List<Object> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public JTextArea getTextAreaDisciplinasExistentes() {
        return textAreaDisciplinasExistentes;
    }
    public void setTextAreaDisciplinasExistentes(JTextArea textAreaDisciplinasExistentes) {
        this.textAreaDisciplinasExistentes = textAreaDisciplinasExistentes;
    }
}
