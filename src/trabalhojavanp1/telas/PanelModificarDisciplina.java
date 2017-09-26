/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import javax.swing.JFrame;
import trabalhojavanp1.objetos.Disciplina;

/**
 *
 * @author Alessandra
 */
public class PanelModificarDisciplina extends JFrame implements PadraoFrame{
    private Disciplina disciplina;
    
    public PanelModificarDisciplina(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
    }

    @Override
    public void initObjects() {
        this.disciplina = new Disciplina();
    }

    private boolean disciplinaIsValid(){
        if(false){
            return false;
        }else{
            this.disciplina = new Disciplina();
            //MONTAR DIscIPLINA
            return true;
        }
    }
    
    
    //GETTERS SETTERS
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
