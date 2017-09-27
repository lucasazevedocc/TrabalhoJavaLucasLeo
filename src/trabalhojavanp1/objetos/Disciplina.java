/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.objetos;

import interfaces.PadraoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Alessandra
 */
public class Disciplina implements PadraoDAO{
    private int codDisciplina;
    private String nomeDisciplina;
    
    
    public Disciplina(){
        
    }
    
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
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
        Disciplina disciplina = new Disciplina();
        return disciplina;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;    
    }
    
    //GETTERS SETTERS
    public int getCodDisciplina(){
        return this.codDisciplina;
    } 
    public void setCodDisciplina(int codDisciplina){
        this.codDisciplina = codDisciplina;
    }
    
    public String getNomeDisciplina(){
        return this.nomeDisciplina;
    } 
    public void setNome(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }
}
