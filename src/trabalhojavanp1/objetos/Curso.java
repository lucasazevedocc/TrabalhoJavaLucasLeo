/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.objetos;

import interfaces.PadraoDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alessandra
 */
public class Curso implements PadraoDAO{
    private int codCurso;
    private String nomeDoCurso;
    private HashMap<Integer,Materia> materias;
    
    
    public Curso(){
        
    }
    
    public Curso(String nomeDoCurso, HashMap<Integer,Materia> materias){
        this.nomeDoCurso = nomeDoCurso;
        this.materias = materias;
    }
    
    
    
    @Override
    public void salvarAtual() {
    }

    @Override
    public void atualizarAtual() {
    }

    @Override
    public void deletarAtual() {
    }

    @Override
    public void deletarByKey(int key) {
    }

    @Override
    public Object buscarByKey(int key) {
        Curso curso = new Curso();
        return curso;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;    
    }
    
    
    //GETTERS SETTERS
    public int getCodCurso(){
        return this.codCurso;
    } 
    public void setCodCurso(int codCurso){
        this.codCurso = codCurso;
    }
    
    public String getNomeDoCurso(){
        return this.nomeDoCurso;
    } 
    public void setNomeDoCurso(String nomeDoCurso){
        this.nomeDoCurso = nomeDoCurso;
    }
    
    public HashMap<Integer,Materia> getMaterias(){
        return this.materias;
    } 
    public void setMaterias(HashMap<Integer,Materia> materias){
        this.materias = materias;
    }

}
