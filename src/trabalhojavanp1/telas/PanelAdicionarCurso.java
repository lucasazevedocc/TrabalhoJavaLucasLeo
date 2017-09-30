package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Curso;

//TODO verificar se ja existe professores adicionados antes de liberar a adicao dos cursos
public class PanelAdicionarCurso extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_CURSO = "PanelAdicionarCurso";
    //COMPONENTES
    private JLabel labelTeste;
    //OBJECTS
    private Curso curso;
    
    public PanelAdicionarCurso(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTeste = new JLabel("PanelAdicionarCurso");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);
        
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
}
