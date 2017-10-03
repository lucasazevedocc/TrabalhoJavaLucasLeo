/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.List;

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
        return false;
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return false;
    }

    @Override
    public boolean deletarByKey(int key) {
        return false;
    }

    @Override
    public Object buscarByKey(int key) {
        Materia materia = new Materia();
        return materia;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;    
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
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }
    public int getCodMateria() {
        return codMateria;
    }     

}