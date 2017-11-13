package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import trabalhojavanp1.objetos.Professor;

public class PanelMostrarProfessores extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_PROFESSORES = "PanelMostrarProfessores";        
    //COMPONENTES
    private JLabel labelTitulo,labelProfessoresDaFaculdade;
    private JTextArea textAreaProfessoresExistentes;
    //OBJECTS
    private List<Object> professores;
    
    public PanelMostrarProfessores(){
        initObjects();
        initViews();
        inserirProfessoresNoTextArea();
    }

    @Override
    public final void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR PROFESSORES"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelProfessoresDaFaculdade(new JLabel("Abaixo todos os professores da faculdade: "));
        this.getLabelProfessoresDaFaculdade().setLocation(170,170);
        this.getLabelProfessoresDaFaculdade().setSize(260,30);
        this.getLabelProfessoresDaFaculdade().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaProfessoresExistentes(new JTextArea("\n\n\n\n\n\n\n                         carregando..."));
        this.getTextAreaProfessoresExistentes().setLocation(50,210);
        this.getTextAreaProfessoresExistentes().setSize(500,400);
        this.getTextAreaProfessoresExistentes().setFont(new Font("Serif", Font.BOLD, 14));
       
        this.add(getLabelTitulo());
        this.add(getLabelProfessoresDaFaculdade());
        this.add(getLabelProfessoresDaFaculdade());
        this.add(getTextAreaProfessoresExistentes());
        
        this.setVisible(true);
    }

    @Override
    public final void initObjects() {
        this.setProfessores(new Professor().buscarTodos());
    }
    
    @Override
    public void initControles() {
    }
    
    private void inserirProfessoresNoTextArea(){
        this.getTextAreaProfessoresExistentes().setText("\n\n\n\n\n\n\n                         carregando...");
        if(this.getProfessores().isEmpty()){
           this.getTextAreaProfessoresExistentes().setText("\n\n\n\n\n\n\n\n\n\n                                         Não ha professores cadastrados.");
        }else{
            String string = "";
            for(Iterator iterator = this.getProfessores().iterator(); iterator.hasNext();){
                Professor professor = (Professor)iterator.next();
                string += professor.gerarString();
                string += "\n\n";
            }
            this.getTextAreaProfessoresExistentes().setText(string);

        }
    }
    
    public void refresh(){
        initObjects();
        inserirProfessoresNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelProfessoresDaFaculdade() {
        return labelProfessoresDaFaculdade;
    }
    public void setLabelProfessoresDaFaculdade(JLabel labelProfessoresDaFaculdade) {
        this.labelProfessoresDaFaculdade = labelProfessoresDaFaculdade;
    }

    public List<Object> getProfessores() {
        return professores;
    }
    public void setProfessores(List<Object> professores) {
        this.professores = professores;
    }
    
    public JTextArea getTextAreaProfessoresExistentes() {
        return textAreaProfessoresExistentes;
    }
    public void setTextAreaProfessoresExistentes(JTextArea textAreaProfessoresExistentes) {
        this.textAreaProfessoresExistentes = textAreaProfessoresExistentes;
    }
}
