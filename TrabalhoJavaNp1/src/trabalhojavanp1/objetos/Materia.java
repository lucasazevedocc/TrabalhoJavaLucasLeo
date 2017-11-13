/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.List;

import dao.CursoDisciplinaProfessorDao;
import interfaces.PadraoDAO;

/**
 *
 * @author Alessandra
 */
public class Materia implements PadraoDAO{
    private int codMateria;
    private Disciplina disciplina;
    private Professor professor;
    private Curso curso;
    
    public Materia(){
        
    }
    
    public Materia(int codMateria, Disciplina disciplina, Professor professor, Curso curso){
        this.codMateria = codMateria;
        this.curso = curso;
        this.disciplina = disciplina;
        this.professor = professor;
    }
   
    //CONEXAO BD
    @Override
    public boolean salvarAtual() {
        return new CursoDisciplinaProfessorDao().inserir(this);
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return new CursoDisciplinaProfessorDao().deletaCurso(curso);
    }

    @Override
    public boolean deletarByKey(int key) {
        return new CursoDisciplinaProfessorDao().deletaCursoProId(key);
    }

    @Override
    public Object buscarByKey(int key) {
        return new CursoDisciplinaProfessorDao().buscarPorMateria(this.codMateria);
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<>();
        return list;    
    }

    public String gerarString(){
        String string = "";
        if(this.codMateria != 0){
            string += ("codMateria -> "+this.codMateria+"\n");
        }
        if(this.disciplina != null && this.disciplina.getCodDisciplina() != 0){
            string += ("codDisciplina -> "+this.disciplina.getCodDisciplina()+"\n");
        }
        if(this.disciplina != null && this.disciplina.getNomeDisciplina() != null && !this.disciplina.getNomeDisciplina().isEmpty()){
            string += ("nomeDisciplina -> "+this.disciplina.getNomeDisciplina()+"\n");
        } 
        if(this.professor != null && this.professor.getRegistro() != 0){
            string += ("registroProfessor -> "+this.professor.getRegistro()+"\n");
        }
        if(this.professor != null && this.professor.getNome() != null && !this.professor.getNome().isEmpty()){
            string += ("nomeProfessor -> "+this.professor.getNome()+"\n");
        }  
        return string;
    }
    
    //GETTERS SETTERS
    public Disciplina getDisciplina(){
        return this.disciplina;
    } 
    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }
    
    public Professor getProfessor(){
        return this.professor;
    } 
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Curso getCurso(){
        return this.curso;
    } 
    public void setCurso(Curso object){
        this.curso = object;
    }
    
    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }
    public int getCodMateria() {
        return codMateria;
    }     

}