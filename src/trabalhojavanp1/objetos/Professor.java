package trabalhojavanp1.objetos;

import interfaces.PadraoDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.ProfessorDao;

public class Professor implements PadraoDAO{
    private int registro;
    private String nome;
    private String formacao;
    private HashMap<Integer,Materia> lecionando;
    private HashMap<Integer,Disciplina> disciplinas;


    public Professor(){
        
    }
    
    public Professor(int registro, String nome, String formacao, HashMap<Integer,Materia> lecionando, HashMap<Integer,Disciplina> disciplinas){
        this.registro = registro;
        this.nome = nome;
        this.formacao = formacao;
        this.lecionando = lecionando; 
        this.disciplinas = disciplinas;
    }
    
    
    @Override
    public boolean  salvarAtual() {
        return new ProfessorDao().inserirProfessor(this);
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return new ProfessorDao().deletarProfessor(this);
    }

    @Override
    public boolean deletarByKey(int key) {
        return new ProfessorDao().deletarProfessorProId(key);
    }

    @Override
    public Object buscarByKey(int key) {
        return new ProfessorDao().mostrarProfessorPorId(key);  
    }

    @Override
    public List<Object> buscarTodos() {
        return new ProfessorDao().mostraProfessores();
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
    
    public HashMap<Integer,Materia> getLecionando(){
        return this.lecionando;
    } 
    public void setLecionando(HashMap<Integer,Materia> lecionando){
        this.lecionando = lecionando;
    }

    public HashMap<Integer,Disciplina> getDisciplinas(){
        return this.disciplinas;
    } 
    public void setDisciplinas(HashMap<Integer,Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
}
