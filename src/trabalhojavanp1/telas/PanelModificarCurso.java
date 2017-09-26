package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import javax.swing.JFrame;
import trabalhojavanp1.objetos.Curso;


public class PanelModificarCurso extends JFrame implements PadraoFrame{
    private Curso curso;
    
    public PanelModificarCurso(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
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
