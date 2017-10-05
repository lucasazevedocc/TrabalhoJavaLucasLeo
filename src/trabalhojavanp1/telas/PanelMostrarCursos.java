package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import interfaces.PadraoPanel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Curso;

public class PanelMostrarCursos extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_CURSOS = "PanelMostrarCursos";        
    //COMPONENTES
    private JLabel labelTitulo,labelCursosDaFaculdade;
    private JTextArea textAreaCursosExistentes;
    //OBJECTS
    private List<Object> cursos;
    
    public PanelMostrarCursos(){
        initViews();
        initObjects();
        inserirCursosNoTextArea();     

    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("MOSTRAR CURSOS"));
        this.getLabelTitulo().setLocation(230,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCursosDaFaculdade(new JLabel("Abaixo todos os cursos da faculdade: "));
        this.getLabelCursosDaFaculdade().setLocation(180,170);
        this.getLabelCursosDaFaculdade().setSize(230,30);
        this.getLabelCursosDaFaculdade().setFont(new Font("Serif", Font.BOLD, 14));
         
        this.setTextAreaCursosExistentes(new JTextArea("\n\n\n\n\n\n\n\n                         carregando..."));
        this.getTextAreaCursosExistentes().setLocation(50,210);
        this.getTextAreaCursosExistentes().setSize(500,400);
        this.getTextAreaCursosExistentes().setFont(new Font("Serif", Font.BOLD, 14));
       
        this.add(getLabelTitulo());
        this.add(getLabelCursosDaFaculdade());
        this.add(getLabelCursosDaFaculdade());
        this.add(getTextAreaCursosExistentes());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        this.setCursos(new Curso().buscarTodos());
    }
    
    @Override
    public void initControles() {
    }
    
    private void inserirCursosNoTextArea(){
        this.getTextAreaCursosExistentes().setText("\n\n\n\n\n\n\n                         carregando...");
        if(this.getCursos().size() == 0){
           this.getTextAreaCursosExistentes().setText("\n\n\n\n\n\n\n\n\n\n                                         Não ha cursos cadastrados.");
        }else{
            String string = "";
            for(Iterator iterator = this.getCursos().iterator(); iterator.hasNext();){
                Curso curso = (Curso)iterator.next();
                string += curso.gerarString();
                string += "\n\n";
            }
            this.getTextAreaCursosExistentes().setText(string);

        }
    }
    
    public void refresh(){
        initObjects();
        inserirCursosNoTextArea();
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelCursosDaFaculdade() {
        return labelCursosDaFaculdade;
    }
    public void setLabelCursosDaFaculdade(JLabel labelCursosDaFaculdade) {
        this.labelCursosDaFaculdade = labelCursosDaFaculdade;
    }

    public List<Object> getCursos() {
        return cursos;
    }
    public void setCursos(List<Object> cursos) {
        this.cursos = cursos;
    }
    
    public JTextArea getTextAreaCursosExistentes() {
        return textAreaCursosExistentes;
    }
    public void setTextAreaCursosExistentes(JTextArea textAreaCursosExistentes) {
        this.textAreaCursosExistentes = textAreaCursosExistentes;
    }
}
