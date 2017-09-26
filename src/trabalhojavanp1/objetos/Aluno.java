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
public class Aluno implements PadraoDAO{
    private String matricula;
    private String nome;
    private String endereco;
    private HashMap<String,Curso> cursando;
	private String senha;
    
    public Aluno(){
        
    }
    
    public Aluno(String nome, String senha,String endereco, HashMap<String,Curso> cursando){
        this.senha = senha; 
        this.nome = nome; 
        this.endereco = endereco; 
        this.cursando = cursando; 
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
        Aluno aluno = new Aluno();
        return aluno;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;
    }
    
    //GETTERS SETTERS
    public String getMatricula(){
        return this.matricula;
    } 
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getNome(){
        return this.nome;
    } 
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return this.endereco;
    } 
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public HashMap<String,Curso> getCursando(){
        return this.cursando;
    } 
    public void setMatricula(HashMap<String,Curso> cursando){
        this.cursando = cursando;
    }

	public String getSenha() {	
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
