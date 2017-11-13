
package trabalhojavanp1;

import trabalhojavanp1.telas.PanelAdicionarAluno;
import trabalhojavanp1.telas.PanelAdicionarCurso;
import trabalhojavanp1.telas.PanelAdicionarDisciplina;
import trabalhojavanp1.telas.PanelAdicionarProfessor;
import trabalhojavanp1.telas.PanelLogin;
import trabalhojavanp1.telas.PanelModificarAluno;
import trabalhojavanp1.telas.PanelModificarCurso;
import trabalhojavanp1.telas.PanelModificarDisciplina;
import trabalhojavanp1.telas.PanelModificarProfessor;
import trabalhojavanp1.telas.PanelMostrarAlunos;
import trabalhojavanp1.telas.PanelMostrarCursos;
import trabalhojavanp1.telas.PanelMostrarCursosDoProfessor;
import trabalhojavanp1.telas.PanelMostrarDisciplinas;
import trabalhojavanp1.telas.PanelMostrarDisciplinasDoProfessor;
import trabalhojavanp1.telas.PanelMostrarProfessores;
import trabalhojavanp1.telas.PanelMostrarProfessoresDoCurso;
import trabalhojavanp1.telas.PanelRemoverAluno;
import trabalhojavanp1.telas.PanelRemoverCurso;
import trabalhojavanp1.telas.PanelRemoverDisciplina;
import trabalhojavanp1.telas.PanelRemoverProfessor;
import trabalhojavanp1.telas.PanelHome;
import trabalhojavanp1.telas.PanelPrincipal;
import trabalhojavanp1.telas.TelaPrincipal;

public class TrabalhoJavaNp1 {
    private static TelaPrincipal telaPrincipal;
    private static PanelPrincipal panelPrincipal;
    private static PanelLogin panelLogin;
    private static PanelAdicionarAluno panelAdicionarAluno;
    private static PanelAdicionarCurso panelAdicionarCurso;
    private static PanelAdicionarProfessor panelAdicionarProfessor;
    private static PanelAdicionarDisciplina panelAdicionarDisciplina;
    private static PanelModificarAluno panelModificarAluno;
    private static PanelModificarCurso panelModificarCurso;
    private static PanelModificarProfessor panelModificarProfessor;
    private static PanelModificarDisciplina panelModificarDisciplina;
    private static PanelMostrarAlunos panelMostrarAlunos;
    private static PanelMostrarCursos panelMostrarCursos;
    private static PanelMostrarProfessores panelMostrarProfessores;
    private static PanelMostrarDisciplinas panelMostrarDisciplinas;
    private static PanelMostrarCursosDoProfessor panelMostrarCursosDoProfessor;
    private static PanelMostrarDisciplinasDoProfessor panelMostrarDisciplinasDoProfessor;
    private static PanelMostrarProfessoresDoCurso panelMostrarProfessoresDoCurso;
    private static PanelRemoverAluno panelRemoverAluno;
    private static PanelRemoverCurso panelRemoverCurso;
    private static PanelRemoverProfessor panelRemoverProfessor;
    private static PanelRemoverDisciplina panelRemoverDisciplina;
    private static PanelHome panelHome;

    public static void main(String[] args) {
        initViews();
    }
    
    private static void initViews(){
        TrabalhoJavaNp1.setTelaPrincipal(new TelaPrincipal());
        TrabalhoJavaNp1.setPanelPrincipal(new PanelPrincipal());
        TrabalhoJavaNp1.setPanelLogin(new PanelLogin());
        TrabalhoJavaNp1.setPanelHome(new PanelHome());
        TrabalhoJavaNp1.setPanelAdicionarAluno(new PanelAdicionarAluno());
        TrabalhoJavaNp1.setPanelAdicionarCurso(new PanelAdicionarCurso());
        TrabalhoJavaNp1.setPanelAdicionarProfessor(new PanelAdicionarProfessor());
        TrabalhoJavaNp1.setPanelAdicionarDisciplina(new PanelAdicionarDisciplina());
        TrabalhoJavaNp1.setPanelModificarAluno(new PanelModificarAluno());
        TrabalhoJavaNp1.setPanelModificarCurso(new PanelModificarCurso());
        TrabalhoJavaNp1.setPanelModificarProfessor(new PanelModificarProfessor());
        TrabalhoJavaNp1.setPanelModificarDisciplina(new PanelModificarDisciplina());
        TrabalhoJavaNp1.setPanelRemoverAluno(new PanelRemoverAluno());
        TrabalhoJavaNp1.setPanelRemoverCurso(new PanelRemoverCurso());
        TrabalhoJavaNp1.setPanelRemoverProfessor(new PanelRemoverProfessor());
        TrabalhoJavaNp1.setPanelRemoverDisciplina(new PanelRemoverDisciplina());
        TrabalhoJavaNp1.setPanelMostrarAlunos(new PanelMostrarAlunos());
        TrabalhoJavaNp1.setPanelMostrarCursos(new PanelMostrarCursos());
        TrabalhoJavaNp1.setPanelMostrarProfessores(new PanelMostrarProfessores());
        TrabalhoJavaNp1.setPanelMostrarDisciplinas(new PanelMostrarDisciplinas());
        TrabalhoJavaNp1.setPanelMostrarCursosDoProfessor(new PanelMostrarCursosDoProfessor());
        TrabalhoJavaNp1.setPanelMostrarDisciplinasDoProfessor(new PanelMostrarDisciplinasDoProfessor());
        TrabalhoJavaNp1.setPanelMostrarProfessoresDoCurso(new PanelMostrarProfessoresDoCurso());
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelLogin(),PanelLogin.PANEL_LOGIN);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelHome(),PanelHome.PANEL_HOME);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarAluno(),PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarCurso(),PanelAdicionarCurso.PANEL_ADICIONAR_CURSO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarDisciplina(),PanelAdicionarDisciplina.PANEL_ADICIONAR_DISCIPLINA);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarProfessor(),PanelAdicionarProfessor.PANEL_ADICIONAR_PROFESSOR);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelModificarAluno(),PanelModificarAluno.PANEL_MODIFICAR_ALUNO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelModificarCurso(),PanelModificarCurso.PANEL_MODIFICAR_CURSO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelModificarProfessor(),PanelModificarProfessor.PANEL_MODIFICAR_PROFESSOR);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelModificarDisciplina(),PanelModificarDisciplina.PANEL_MODIFICAR_DISCIPLINA);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelRemoverAluno(),PanelRemoverAluno.PANEL_REMOVER_ALUNO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelRemoverCurso(),PanelRemoverCurso.PANEL_REMOVER_CURSO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelRemoverDisciplina(),PanelRemoverDisciplina.PANEL_REMOVER_DISCIPLINA);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelRemoverProfessor(),PanelRemoverProfessor.PANEL_REMOVER_PROFESSOR);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarAlunos(),PanelMostrarAlunos.PANEL_MOSTRAR_ALUNOS);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarCursos(),PanelMostrarCursos.PANEL_MOSTRAR_CURSOS);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarDisciplinas(),PanelMostrarDisciplinas.PANEL_MOSTRAR_DISCIPLINAS);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarProfessores(),PanelMostrarProfessores.PANEL_MOSTRAR_PROFESSORES);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarCursosDoProfessor(),PanelMostrarCursosDoProfessor.PANEL_MOSTRAR_CURSOS_DO_PROFESSOR);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarProfessoresDoCurso(),PanelMostrarProfessoresDoCurso.PANEL_MOSTRAR_PROFESSORES_DO_CURSO);
        TrabalhoJavaNp1.getPanelPrincipal().add(TrabalhoJavaNp1.getPanelMostrarDisciplinasDoProfessor(),PanelMostrarDisciplinasDoProfessor.PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR);
        TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelPrincipal());
        TrabalhoJavaNp1.getTelaPrincipal().setVisible(true);
//TrabalhoJavaNp1.getTelaPrincipal().pack();       
//TrabalhoJavaNp1.getTelaPrincipal().repaint();
        /*
        TrabalhoJavaNp1.setPanelModificarAluno(new PanelModificarAluno());
        TrabalhoJavaNp1.setPanelModificarProfessor(new PanelModificarProfessor());
        TrabalhoJavaNp1.setPanelModificarCurso(new PanelModificarCurso());
        TrabalhoJavaNp1.setPanelModificarDisciplina(new PanelModificarDisciplina());
        TrabalhoJavaNp1.setPanelMostrarAlunos(new PanelMostrarAlunos());
        TrabalhoJavaNp1.setPanelMostrarCursos(new PanelMostrarCursos());
        TrabalhoJavaNp1.setPanelMostrarProfessores(new PanelMostrarProfessores());
        TrabalhoJavaNp1.setPanelMostrarDisciplinas(new PanelMostrarDisciplinas());
        TrabalhoJavaNp1.setPanelMostrarCursosDoProfessor(new PanelMostrarCursosDoProfessor());
        TrabalhoJavaNp1.setPanelMostrarDisciplinasDoProfessor(new PanelMostrarDisciplinasDoProfessor());
        TrabalhoJavaNp1.setPanelMostrarProfessoresDoCurso(new PanelMostrarProfessoresDoCurso());
        TrabalhoJavaNp1.setPanelRemoverAluno(new PanelRemoverAluno());
        TrabalhoJavaNp1.setPanelRemoverCurso(new PanelRemoverCurso());
        TrabalhoJavaNp1.setPanelRemoverProfessor(new PanelRemoverProfessor());
        TrabalhoJavaNp1.setPanelRemoverDisciplina(new PanelRemoverDisciplina());
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelPrincipal(),PanelPrincipal.PANEL_PRINCIPAL);
                
        TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelLogin());
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelHome(),PanelHome.PANEL_HOME);
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarAluno(),PanelAdicionarAluno.PANEL_ADICIONAR_ALUNO);
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarCurso(),PanelAdicionarCurso.PANEL_ADICIONAR_CURSO);
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarDisciplina(),PanelAdicionarDisciplina.PANEL_ADICIONAR_DISCIPLINA);
        //TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelAdicionarProfessor(),PanelAdicionarProfessor.PANEL_ADICIONAR_PROFESSOR);

        TrabalhoJavaNp1.getTelaPrincipal().show();*/

    }
    
    
    //GETTERS SETTERS
    public static TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }
    public static void setTelaPrincipal(TelaPrincipal aTelaPrincipal) {
        telaPrincipal = aTelaPrincipal;
    }

    public static PanelLogin getPanelLogin() {
        return panelLogin;
    }
    public static void setPanelLogin(PanelLogin aPanelLogin) {
        panelLogin = aPanelLogin;
    }

    public static PanelHome getPanelHome() {
        return panelHome;
    }
    public static void setPanelHome(PanelHome aPanelTeste) {
        panelHome = aPanelTeste;
    }
    
    public static PanelAdicionarAluno getPanelAdicionarAluno() {
        return panelAdicionarAluno;
    }
    public static void setPanelAdicionarAluno(PanelAdicionarAluno aPanelAdicionarAluno) {
        panelAdicionarAluno = aPanelAdicionarAluno;
    }

    public static PanelAdicionarCurso getPanelAdicionarCurso() {
        return panelAdicionarCurso;
    }
    public static void setPanelAdicionarCurso(PanelAdicionarCurso aPanelAdicionarCurso) {
        panelAdicionarCurso = aPanelAdicionarCurso;
    }

    public static PanelAdicionarProfessor getPanelAdicionarProfessor() {
        return panelAdicionarProfessor;
    }
    public static void setPanelAdicionarProfessor(PanelAdicionarProfessor aPanelAdicionarProfessor) {
        panelAdicionarProfessor = aPanelAdicionarProfessor;
    }

    public static PanelAdicionarDisciplina getPanelAdicionarDisciplina() {
        return panelAdicionarDisciplina;
    }
    public static void setPanelAdicionarDisciplina(PanelAdicionarDisciplina aPanelAdicionarDisciplina) {
        panelAdicionarDisciplina = aPanelAdicionarDisciplina;
    }

    public static PanelModificarAluno getPanelModificarAluno() {
        return panelModificarAluno;
    }
    public static void setPanelModificarAluno(PanelModificarAluno aPanelModificarAluno) {
        panelModificarAluno = aPanelModificarAluno;
    }

    public static PanelModificarCurso getPanelModificarCurso() {
        return panelModificarCurso;
    }
    public static void setPanelModificarCurso(PanelModificarCurso aPanelModificarCurso) {
        panelModificarCurso = aPanelModificarCurso;
    }
    
    public static PanelModificarProfessor getPanelModificarProfessor() {
        return panelModificarProfessor;
    }
    public static void setPanelModificarProfessor(PanelModificarProfessor aPanelModificarProfessor) {
        panelModificarProfessor = aPanelModificarProfessor;
    }
    
    public static PanelModificarDisciplina getPanelModificarDisciplina() {
        return panelModificarDisciplina;
    }
    public static void setPanelModificarDisciplina(PanelModificarDisciplina aPanelModificarDisciplina) {
        panelModificarDisciplina = aPanelModificarDisciplina;
    }

    public static PanelMostrarAlunos getPanelMostrarAlunos() {
        return panelMostrarAlunos;
    }
    public static void setPanelMostrarAlunos(PanelMostrarAlunos aPanelMostrarAlunos) {
        panelMostrarAlunos = aPanelMostrarAlunos;
    }

    public static PanelMostrarCursos getPanelMostrarCursos() {
        return panelMostrarCursos;
    }
    public static void setPanelMostrarCursos(PanelMostrarCursos aPanelMostrarCursos) {
        panelMostrarCursos = aPanelMostrarCursos;
    }

    public static PanelMostrarProfessores getPanelMostrarProfessores() {
        return panelMostrarProfessores;
    }
    public static void setPanelMostrarProfessores(PanelMostrarProfessores aPanelMostrarProfessores) {
        panelMostrarProfessores = aPanelMostrarProfessores;
    }

    public static PanelMostrarDisciplinas getPanelMostrarDisciplinas() {
        return panelMostrarDisciplinas;
    }
    public static void setPanelMostrarDisciplinas(PanelMostrarDisciplinas aPanelMostrarDisciplinas) {
        panelMostrarDisciplinas = aPanelMostrarDisciplinas;
    }

    public static PanelMostrarCursosDoProfessor getPanelMostrarCursosDoProfessor() {
        return panelMostrarCursosDoProfessor;
    }
    public static void setPanelMostrarCursosDoProfessor(PanelMostrarCursosDoProfessor aPanelMostrarCursosDoProfessor) {
        panelMostrarCursosDoProfessor = aPanelMostrarCursosDoProfessor;
    }

    public static PanelMostrarDisciplinasDoProfessor getPanelMostrarDisciplinasDoProfessor() {
        return panelMostrarDisciplinasDoProfessor;
    }
    public static void setPanelMostrarDisciplinasDoProfessor(PanelMostrarDisciplinasDoProfessor aPanelMostrarDisciplinasDoProfessor) {
        panelMostrarDisciplinasDoProfessor = aPanelMostrarDisciplinasDoProfessor;
    }

    public static PanelMostrarProfessoresDoCurso getPanelMostrarProfessoresDoCurso() {
        return panelMostrarProfessoresDoCurso;
    }
    public static void setPanelMostrarProfessoresDoCurso(PanelMostrarProfessoresDoCurso aPanelMostrarProfessoresDoCurso) {
        panelMostrarProfessoresDoCurso = aPanelMostrarProfessoresDoCurso;
    }

    public static PanelRemoverAluno getPanelRemoverAluno() {
        return panelRemoverAluno;
    }
    public static void setPanelRemoverAluno(PanelRemoverAluno aPanelRemoverAluno) {
        panelRemoverAluno = aPanelRemoverAluno;
    }

    public static PanelRemoverCurso getPanelRemoverCurso() {
        return panelRemoverCurso;
    }
    public static void setPanelRemoverCurso(PanelRemoverCurso aPanelRemoverCurso) {
        panelRemoverCurso = aPanelRemoverCurso;
    }

    public static PanelRemoverProfessor getPanelRemoverProfessor() {
        return panelRemoverProfessor;
    }
    public static void setPanelRemoverProfessor(PanelRemoverProfessor aPanelRemoverProfessor) {
        panelRemoverProfessor = aPanelRemoverProfessor;
    }

    public static PanelRemoverDisciplina getPanelRemoverDisciplina() {
        return panelRemoverDisciplina;
    }
    public static void setPanelRemoverDisciplina(PanelRemoverDisciplina aPanelRemoverDisciplina) {
        panelRemoverDisciplina = aPanelRemoverDisciplina;
    }

    public static PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
    public static void setPanelPrincipal(PanelPrincipal aPanelPrincipal) {
        panelPrincipal = aPanelPrincipal;
    }
}
