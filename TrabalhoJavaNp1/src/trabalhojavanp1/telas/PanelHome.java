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


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelHome extends JPanel implements PadraoPanel{
    public static final String PANEL_HOME = "PanelHome";
    //COMPONENTES
    private JLabel labelTitulo;
    private JLabel labelDesenvolvido;
    private JLabel labelProfessor;
    private JLabel labelTrabalho;
    private JLabel labelLucas;
    private JLabel labelLeonardo;
    private JLabel labelCurso;
    private JLabel labelMarcos;
    

    public PanelHome(){
        initViews();
        initObjects();
    }
    
    @Override
    public final void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(null);

        this.labelTitulo = new JLabel("Sistema De Cadastro Para Faculdade");
        this.labelTitulo.setLocation(105,250);
        this.labelTitulo.setSize(400,80);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.labelTrabalho = new JLabel("Trabalho de Java");
        this.labelTrabalho.setLocation(40,560);
        this.labelTrabalho.setSize(200,80);
        this.labelTrabalho.setFont(new Font("Serif", Font.BOLD, 12));
        
        this.labelCurso = new JLabel("Ciencias da Computacão");
        this.labelCurso.setLocation(40,580);
        this.labelCurso.setSize(200,80);
        this.labelCurso.setFont(new Font("Serif", Font.BOLD, 12));
        
        this.labelProfessor = new JLabel("Professor:");
        this.labelProfessor.setLocation(210,560);
        this.labelProfessor.setSize(200,80);
        this.labelProfessor.setFont(new Font("Serif", Font.BOLD, 12));
        
        this.labelMarcos = new JLabel("Marcos Pai");
        this.labelMarcos.setLocation(270,560);
        this.labelMarcos.setSize(200,80);
        this.labelMarcos.setFont(new Font("Serif", Font.PLAIN, 12));
        
        this.labelDesenvolvido = new JLabel("Desenvolvido por:");
        this.labelDesenvolvido.setLocation(360,560);
        this.labelDesenvolvido.setSize(200,80);
        this.labelDesenvolvido.setFont(new Font("Serif", Font.BOLD, 12));
        
        this.labelLucas = new JLabel("Lucas de Azevedo");
        this.labelLucas.setLocation(460,560);
        this.labelLucas.setSize(200,80);
        this.labelLucas.setFont(new Font("Serif", Font.PLAIN, 12));
        
        this.labelLeonardo = new JLabel("Leonardo Rocha");
        this.labelLeonardo.setLocation(460,580);
        this.labelLeonardo.setSize(200,80);
        this.labelLeonardo.setFont(new Font("Serif", Font.PLAIN, 12));
        
        
        
        this.add(this.labelTitulo);
        this.add(this.labelTrabalho);
        this.add(this.labelCurso);
        this.add(this.labelProfessor);
        this.add(this.labelDesenvolvido);
        this.add(this.labelMarcos);
        this.add(this.labelLucas);
        this.add(this.labelLeonardo);




        this.setVisible(true);
    } 
    @Override
    public final void initObjects(){
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    //GETTERS SETTERS
    
}


