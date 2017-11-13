/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Aluno;


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelPrincipal extends JPanel implements PadraoPanel{
    public static final String PANEL_PRINCIPAL = "PanelPrincipal";
    private Aluno aluno;
    private JLabel labelTeste;

    
    public PanelPrincipal(){
        initViews();
        initObjects();
    }
    
    @Override
    public final void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(new CardLayout());
        //this.setLayout(null);

        /*this.labelTeste = new JLabel("PANEL PRINCIPAL");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);*/
        this.setVisible(true);
    } 
    @Override
    public final void initObjects(){
        this.aluno = new Aluno();
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    private boolean alunoIsValid(){
        if(false) {
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


