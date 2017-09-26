/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import java.awt.Color;
import javax.swing.JFrame;


public class TelaPrincipal extends JFrame implements PadraoFrame{
    public TelaPrincipal(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        
        this.setTitle("TelaPrincipal");
        this.setSize(600,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        this.setVisible(true);  
    }

    @Override
    public void initObjects() {
    }
    
    public static void main(String a[]){
        //TelaPrincipal tP = new TelaPrincipal(); 
    }
}
