/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import trabalhojavanp1.TrabalhoJavaNp1;


public class TelaPrincipal extends JFrame implements PadraoFrame, ActionListener{
    private JMenuItem cadastrarAlunoAction;
    private JMenuItem cadastrarProfessorAction;
    private JMenuItem cadastrarDisciplinaAction;
    private JMenuItem cadastrarCursoAction;
    private JMenuItem mostrarAlunosAction;
    private JMenuItem mostrarProfessoresAction;
    private JMenuItem mostrarDisciplinasAction;
    private JMenuItem mostrarCursosAction;
    private JMenuItem mostrarProfessoresDoCursoAction;
    private JMenuItem mostrarCursosDoProfessorAction;
    private JMenuItem mostrarDisciplinasDoProfessorAction;
    private JMenuItem modificarAlunoAction;
    private JMenuItem modificarProfessorAction;
    private JMenuItem modificarDisciplinaAction;
    private JMenuItem modificarCursoAction;
    private JMenuItem removerAlunoAction;
    private JMenuItem removerProfessorAction;
    private JMenuItem removerDisciplinaAction;
    private JMenuItem removerCursoAction;
    private JMenuItem sairAction;

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
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        //ITEM DO MENU CADASTRAR
        JMenu cadastroMenu = new JMenu("Cadastrar");
        this.cadastrarAlunoAction = new JMenuItem("Aluno");
        this.cadastrarAlunoAction.addActionListener(this);
        this.cadastrarProfessorAction = new JMenuItem("Professor");
        this.cadastrarProfessorAction.addActionListener(this);
        this.cadastrarDisciplinaAction = new JMenuItem("Disciplina");
        this.cadastrarDisciplinaAction.addActionListener(this);
        this.cadastrarCursoAction = new JMenuItem("Curso");
        this.cadastrarCursoAction.addActionListener(this);
        cadastroMenu.add(cadastrarAlunoAction);
        cadastroMenu.add(cadastrarProfessorAction);
        cadastroMenu.add(cadastrarDisciplinaAction);
        cadastroMenu.add(cadastrarCursoAction);
        menuBar.add(cadastroMenu);
        //ITEM DO MENU MOSTRAR
        JMenu mostrarMenu = new JMenu("Mostrar");
        this.mostrarAlunosAction = new JMenuItem("Alunos");
        this.mostrarAlunosAction.addActionListener(this);
        this.mostrarProfessoresAction = new JMenuItem("Professores");
        this.mostrarProfessoresAction.addActionListener(this);
        this.mostrarDisciplinasAction = new JMenuItem("Disciplinas");
        this.mostrarDisciplinasAction.addActionListener(this);
        this.mostrarCursosAction = new JMenuItem("Cursos");
        this.mostrarCursosAction.addActionListener(this);
        this.mostrarProfessoresDoCursoAction = new JMenuItem("Professores do Curso");
        this.mostrarProfessoresDoCursoAction.addActionListener(this);
        this.mostrarCursosDoProfessorAction = new JMenuItem("Cursos do Professor");
        this.mostrarCursosDoProfessorAction.addActionListener(this);
        this.mostrarDisciplinasDoProfessorAction = new JMenuItem("Disciplinas do Professor");
        this.mostrarDisciplinasDoProfessorAction.addActionListener(this);
        mostrarMenu.add(mostrarAlunosAction);
        mostrarMenu.add(mostrarProfessoresAction);
        mostrarMenu.add(mostrarDisciplinasAction);
        mostrarMenu.add(mostrarCursosAction);
        mostrarMenu.add(mostrarProfessoresDoCursoAction);
        mostrarMenu.add(mostrarCursosDoProfessorAction);
        mostrarMenu.add(mostrarDisciplinasDoProfessorAction);
        menuBar.add(mostrarMenu);
        //ITEM DO MENU MANUTENCAO
        JMenu manutencaoMenu = new JMenu("Manutenção");
        this.modificarAlunoAction = new JMenuItem("Aluno");
        this.modificarAlunoAction.addActionListener(this);
        this.modificarProfessorAction = new JMenuItem("Professor");
        this.modificarProfessorAction.addActionListener(this);
        this.modificarDisciplinaAction = new JMenuItem("Disciplina");
        this.modificarDisciplinaAction.addActionListener(this);
        this.modificarCursoAction = new JMenuItem("Curso");
        this.modificarCursoAction.addActionListener(this);
        manutencaoMenu.add(modificarAlunoAction);
        manutencaoMenu.add(modificarProfessorAction);
        manutencaoMenu.add(modificarDisciplinaAction);
        manutencaoMenu.add(modificarCursoAction);
        menuBar.add(manutencaoMenu);
        //ITEM DO MENU REMOVER
        JMenu removerMenu = new JMenu("Remover");
        this.removerAlunoAction = new JMenuItem("Aluno");
        this.removerAlunoAction.addActionListener(this);
        this.removerProfessorAction = new JMenuItem("Professor");
        this.removerProfessorAction.addActionListener(this);
        this.removerDisciplinaAction = new JMenuItem("Disciplina");
        this.removerDisciplinaAction.addActionListener(this);
        this.removerCursoAction = new JMenuItem("Curso");
        this.removerCursoAction.addActionListener(this);
        cadastroMenu.add(removerAlunoAction);
        cadastroMenu.add(removerProfessorAction);
        cadastroMenu.add(removerDisciplinaAction);
        cadastroMenu.add(removerCursoAction);
        menuBar.add(removerMenu);
        //ITEM DO MENU SAIR
        JMenu sairMenu = new JMenu("Sair");
        this.sairAction = new JMenuItem("Ir Login");
        this.sairAction.addActionListener(this);
        sairMenu.add(sairAction);
        menuBar.add(sairMenu);
        menuBar.setVisible(true);
        this.setJMenuBar(menuBar);
    }

    @Override
    public void initObjects() {
    }
    
    public static void main(String a[]){
        //TelaPrincipal tP = new TelaPrincipal(); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //CADASTRAR
        if(ae.getSource() == this.cadastrarAlunoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.cadastrarProfessorAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.cadastrarDisciplinaAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.cadastrarCursoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        
        //MOSTRAR
        if(ae.getSource() == this.mostrarAlunosAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarProfessoresAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarDisciplinasAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarCursosAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarProfessoresDoCursoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarCursosDoProfessorAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.mostrarDisciplinasDoProfessorAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        
        //MANUTENCAo
        if(ae.getSource() == this.modificarAlunoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.modificarCursoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.modificarDisciplinaAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.modificarProfessorAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        
        //REMOVER
        if(ae.getSource() == this.removerAlunoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.removerProfessorAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.removerDisciplinaAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        if(ae.getSource() == this.removerCursoAction){
            JOptionPane.showMessageDialog(null, "Selected Item: " + ae.getActionCommand());
        }
        
        //SAIR
        if(ae.getSource() == this.sairAction){
            TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelTeste());
            TrabalhoJavaNp1.getPanelLogin().limparCampos();
            TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelLogin());
            TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(false);
            TrabalhoJavaNp1.getTelaPrincipal().show();        
        }
    }
}
