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
public class Disciplina implements PadraoDAO{
    private int codDisciplina;
    private String nomeDisciplina;
    
    
    public Disciplina(){
        
    }
    
    public Disciplina(int codDisciplina, String nomeDisciplina){
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }
    
    
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
        Disciplina disciplina = new Disciplina();
        return disciplina;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;    
    }
    
     public String gerarString(){
        String string = "teste";
        /*if( this.matricula != 0){
            string += ("Matricula: "+this.matricula+"\n");
        }
        if( this.nome != null && !this.nome.isEmpty()){
            string += ("Nome: "+this.nome+"\n");
        }
        if( this.endereco != null && !this.endereco.isEmpty()){
            string += ("Endereco: "+this.endereco+"\n");
        }*/
        
        return string;
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
