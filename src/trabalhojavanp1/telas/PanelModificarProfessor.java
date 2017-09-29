/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Professor;


public class PanelModificarProfessor extends JPanel implements PadraoPanel{
    public static final String PANEL_MODIFICAR_PROFESSOR = "PanelModificarProfessor";        
    private JLabel labelTeste;
    private Professor professor;
    
    public PanelModificarProfessor(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTeste = new JLabel("PanelModificarProfessor");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);
        this.setVisible(true);
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
