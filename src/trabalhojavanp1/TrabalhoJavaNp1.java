
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
import trabalhojavanp1.telas.PanelTeste;
import trabalhojavanp1.telas.TelaPrincipal;

public class TrabalhoJavaNp1 {
    private static TelaPrincipal telaPrincipal;
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



    private static PanelTeste panelTeste;


    
    
    public static void main(String[] args) {
        TrabalhoJavaNp1.setTelaPrincipal(new TelaPrincipal());
        TrabalhoJavaNp1.setPanelLogin(new PanelLogin());
        TrabalhoJavaNp1.setPanelTeste(new PanelTeste());
        TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelLogin());
        TrabalhoJavaNp1.getTelaPrincipal().show();
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

    public static PanelTeste getPanelTeste() {
        return panelTeste;
    }
    public static void setPanelTeste(PanelTeste aPanelTeste) {
        panelTeste = aPanelTeste;
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
}
