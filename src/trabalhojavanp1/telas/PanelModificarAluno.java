package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Aluno;


public class PanelModificarAluno extends JPanel implements PadraoPanel{
    private Aluno aluno;

    public PanelModificarAluno(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
    }

    @Override
    public void initObjects() {
        this.aluno = new Aluno();
    }
    
    private boolean alunoIsValid(){
        if(false){
            return false;
        }else{
            this.aluno = new Aluno();
            //MONTAR ALUNO
            return true;
        }
    }
    
    //GETTERS SETTERS
    public Aluno getAluno() {
        return this.aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
