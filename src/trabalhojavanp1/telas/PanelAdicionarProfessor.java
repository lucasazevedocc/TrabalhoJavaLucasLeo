package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Professor;

//TODO verificar se ja existe disciplinas adicionados antes de liberar a adicao dos professores
public class PanelAdicionarProfessor extends JPanel implements PadraoPanel{
    private Professor professor;
    
    public PanelAdicionarProfessor(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
    }

    @Override
    public void initObjects() {
        this.professor = new Professor();
    }
    
    private boolean professorIsValid(){
        if(false){
            return false;
        }else{
            this.professor = new Professor();
            //MONTAR PROFESSOR
            return true;
        }
    }

    
    //GETTERS SETTERS
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
