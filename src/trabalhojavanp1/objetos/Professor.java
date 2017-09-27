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


/**
 *
 * @author Alessandra
 */
public class Professor implements PadraoDAO{
    private int registro;
    private String nome;
    private String formacao;
    private HashMap<String,Materia> lecionando;
    private HashMap<String,Disciplina> disciplinas;


    public Professor(){
        
    }
    
    public Professor( String nome, String formacao, HashMap<String,Materia> lecionando, HashMap<String,Disciplina> disciplinas){
        this.nome = nome;
        this.formacao = formacao;
        this.lecionando = lecionando; 
        this.disciplinas = disciplinas;
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
    public void deletarByKey(String key) {
    }

    @Override
    public Object buscarByKey(String key) {
        Professor professor = new Professor();
        return professor;  
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;
    }
    
    
    
    //GETTERS SETTERS
    public int getRegistro(){
        return this.registro;
    } 
    public void setRegistro(int registro){
        this.registro = registro;
    }
    
    public String getNome(){
        return this.nome;
    } 
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getFormacao(){
        return this.formacao;
    } 
    public void setFormacao(String formacao){
        this.formacao = formacao;
    }
    
    public HashMap<String,Materia> getLecionando(){
        return this.lecionando;
    } 
    public void setLecionando(HashMap<String,Materia> lecionando){
        this.lecionando = lecionando;
    }

    public HashMap<String,Disciplina> getDisciplinas(){
        return this.disciplinas;
    } 
    public void setDisciplinas(HashMap<String,Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
}
