/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Aluno;


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelAdicionarAluno extends JPanel implements PadraoPanel{
    private Aluno aluno;
    
    public void FrameAdicionarAluno(){
        initViews();
        initObjects();
    }
    
    @Override
    public void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
    } 
    @Override
    public void initObjects(){
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


