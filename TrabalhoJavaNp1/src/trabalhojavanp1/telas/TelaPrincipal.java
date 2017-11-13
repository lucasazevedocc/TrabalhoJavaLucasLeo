package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    private JMenuItem sairLoginAction;
    private JMenuItem sairFecharAction;


    public TelaPrincipal(){
        initViews();
        initObjects();
    }

    @Override
    public final void initViews() {
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        //this.setLayout(new CardLayout());
                //this.setLayout(new BorderLayout());

        this.setTitle("TelaPrincipal");
        this.setSize(600,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
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
        removerMenu.add(removerAlunoAction);
        removerMenu.add(removerProfessorAction);
        removerMenu.add(removerDisciplinaAction);
        removerMenu.add(removerCursoAction);
        menuBar.add(removerMenu);
        //ITEM DO MENU SAIR
        JMenu sairMenu = new JMenu("Sair");
        this.sairLoginAction = new JMenuItem("Ir Login");
        this.sairLoginAction.addActionListener(this);
        this.sairFecharAction = new JMenuItem("Fechar");
        this.sairFecharAction.addActionListener(this);
        sairMenu.add(sairLoginAction);
        sairMenu.add(sairFecharAction);
        menuBar.add(sairMenu);
        
        menuBar.setVisible(false);
        this.setJMenuBar(menuBar);
    }

    @Override
    public final void initObjects() {
    }
    
    public static void main(String a[]){
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //CADASTRAR
        if(ae.getSource() == this.cadastrarAlunoAction){
            exibirPanel(PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO);
        }
        if(ae.getSource() == this.cadastrarProfessorAction){
            exibirPanel(PanelAdicionarProfessor.PANEL_ADICIONAR_PROFESSOR);       
        }
        if(ae.getSource() == this.cadastrarDisciplinaAction){
            exibirPanel(PanelAdicionarDisciplina.PANEL_ADICIONAR_DISCIPLINA);
        }
        if(ae.getSource() == this.cadastrarCursoAction){
            exibirPanel(PanelAdicionarCurso.PANEL_ADICIONAR_CURSO);
        }
        
        //MOSTRAR
        if(ae.getSource() == this.mostrarAlunosAction){
            exibirPanel(PanelMostrarAlunos.PANEL_MOSTRAR_ALUNOS);
        }
        if(ae.getSource() == this.mostrarProfessoresAction){
            exibirPanel(PanelMostrarProfessores.PANEL_MOSTRAR_PROFESSORES);
        }
        if(ae.getSource() == this.mostrarDisciplinasAction){
            exibirPanel(PanelMostrarDisciplinas.PANEL_MOSTRAR_DISCIPLINAS);
        }
        if(ae.getSource() == this.mostrarCursosAction){
            exibirPanel(PanelMostrarCursos.PANEL_MOSTRAR_CURSOS);
        }
        if(ae.getSource() == this.mostrarProfessoresDoCursoAction){
            exibirPanel(PanelMostrarProfessoresDoCurso.PANEL_MOSTRAR_PROFESSORES_DO_CURSO);
        }
        if(ae.getSource() == this.mostrarCursosDoProfessorAction){
            exibirPanel(PanelMostrarCursosDoProfessor.PANEL_MOSTRAR_CURSOS_DO_PROFESSOR);
        }
        if(ae.getSource() == this.mostrarDisciplinasDoProfessorAction){
            exibirPanel(PanelMostrarDisciplinasDoProfessor.PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR);
        }
        
        //MANUTENCAo
        if(ae.getSource() == this.modificarAlunoAction){
            exibirPanel(PanelModificarAluno.PANEL_MODIFICAR_ALUNO);
        }
        if(ae.getSource() == this.modificarCursoAction){
            exibirPanel(PanelModificarCurso.PANEL_MODIFICAR_CURSO);
        }
        if(ae.getSource() == this.modificarDisciplinaAction){
            exibirPanel(PanelModificarDisciplina.PANEL_MODIFICAR_DISCIPLINA);
        }
        if(ae.getSource() == this.modificarProfessorAction){
            exibirPanel(PanelModificarProfessor.PANEL_MODIFICAR_PROFESSOR);
        }
        
        //REMOVER
        if(ae.getSource() == this.removerAlunoAction){
            exibirPanel(PanelRemoverAluno.PANEL_REMOVER_ALUNO);
        }
        if(ae.getSource() == this.removerProfessorAction){
            exibirPanel(PanelRemoverProfessor.PANEL_REMOVER_PROFESSOR);
        }
        if(ae.getSource() == this.removerDisciplinaAction){
            exibirPanel(PanelRemoverDisciplina.PANEL_REMOVER_DISCIPLINA);
        }
        if(ae.getSource() == this.removerCursoAction){
            exibirPanel(PanelRemoverCurso.PANEL_REMOVER_CURSO);
        }
        
        //SAIR
        if(ae.getSource() == this.sairLoginAction){
            TrabalhoJavaNp1.getPanelLogin().limparCampos();
            exibirPanel(PanelLogin.PANEL_LOGIN);        
        }
        if(ae.getSource() == this.sairFecharAction){
            System.exit(0);
        }
    }
    
    public void exibirPanel(String tagPanel){
        CardLayout card = (CardLayout) TrabalhoJavaNp1.getPanelPrincipal().getLayout();
        switch(tagPanel){
            case PanelLogin.PANEL_LOGIN:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelLogin.PANEL_LOGIN);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(false);
                break;
            case PanelHome.PANEL_HOME:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelHome.PANEL_HOME);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelAdicionarCurso.PANEL_ADICIONAR_CURSO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelAdicionarCurso.PANEL_ADICIONAR_CURSO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelAdicionarDisciplina.PANEL_ADICIONAR_DISCIPLINA:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelAdicionarDisciplina.PANEL_ADICIONAR_DISCIPLINA);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelAdicionarProfessor.PANEL_ADICIONAR_PROFESSOR:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelAdicionarProfessor.PANEL_ADICIONAR_PROFESSOR);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelModificarAluno.PANEL_MODIFICAR_ALUNO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelModificarAluno.PANEL_MODIFICAR_ALUNO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelModificarCurso.PANEL_MODIFICAR_CURSO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelModificarCurso.PANEL_MODIFICAR_CURSO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelModificarDisciplina.PANEL_MODIFICAR_DISCIPLINA:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelModificarDisciplina.PANEL_MODIFICAR_DISCIPLINA);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelModificarProfessor.PANEL_MODIFICAR_PROFESSOR:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelModificarProfessor.PANEL_MODIFICAR_PROFESSOR);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelRemoverAluno.PANEL_REMOVER_ALUNO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelRemoverAluno.PANEL_REMOVER_ALUNO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelRemoverCurso.PANEL_REMOVER_CURSO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelRemoverCurso.PANEL_REMOVER_CURSO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelRemoverDisciplina.PANEL_REMOVER_DISCIPLINA:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelRemoverDisciplina.PANEL_REMOVER_DISCIPLINA);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelRemoverProfessor.PANEL_REMOVER_PROFESSOR:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelRemoverProfessor.PANEL_REMOVER_PROFESSOR);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarAlunos.PANEL_MOSTRAR_ALUNOS:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarAlunos.PANEL_MOSTRAR_ALUNOS);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarCursos.PANEL_MOSTRAR_CURSOS:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarCursos.PANEL_MOSTRAR_CURSOS);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarDisciplinas.PANEL_MOSTRAR_DISCIPLINAS:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarDisciplinas.PANEL_MOSTRAR_DISCIPLINAS);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarProfessores.PANEL_MOSTRAR_PROFESSORES:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarProfessores.PANEL_MOSTRAR_PROFESSORES);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarCursosDoProfessor.PANEL_MOSTRAR_CURSOS_DO_PROFESSOR:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarCursosDoProfessor.PANEL_MOSTRAR_CURSOS_DO_PROFESSOR);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarDisciplinasDoProfessor.PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarDisciplinasDoProfessor.PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            case PanelMostrarProfessoresDoCurso.PANEL_MOSTRAR_PROFESSORES_DO_CURSO:
                card.show(TrabalhoJavaNp1.getPanelPrincipal(), PanelMostrarProfessoresDoCurso.PANEL_MOSTRAR_PROFESSORES_DO_CURSO);
                TrabalhoJavaNp1.getTelaPrincipal().getJMenuBar().setVisible(true);
                break;
            default:
                break;
        }
    }
    
    private void removerTodosPanels(){
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelLogin());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelHome());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelAdicionarCurso());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelAdicionarAluno());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelAdicionarDisciplina());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelAdicionarProfessor());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelRemoverCurso());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelRemoverAluno());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelRemoverDisciplina());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelRemoverProfessor());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelModificarCurso());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelModificarAluno());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelModificarDisciplina());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelModificarProfessor());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarCursos());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarAlunos());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarDisciplinas());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarProfessores());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarProfessoresDoCurso());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarDisciplinasDoProfessor());
        TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelMostrarCursosDoProfessor());



    }
}
