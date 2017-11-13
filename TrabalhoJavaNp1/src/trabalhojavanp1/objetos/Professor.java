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
        String string = "";
        if( this.registro != 0){
            string += ("Registro: "+this.registro+"\n");
        }
        if( this.nome != null && !this.nome.isEmpty()){
            string += ("Nome: "+this.nome+"\n");
        }
        if( this.formacao != null && !this.formacao.isEmpty()){
            string += ("Formacao: "+this.formacao+"\n");
        }
        if(this.disciplinas != null && !this.disciplinas.isEmpty()){
            string += ("Disciplinas:");
            string = this.disciplinas.keySet().stream().map((key) -> this.disciplinas.get(key)).map((disciplina) -> "\n               "+disciplina.getNomeDisciplina()).reduce(string, String::concat);
            string += "\n";
        }else{
            string += ("Disciplinas: \n               O professor nao leciona nenhuma materia.\n");
        }
        if(this.disciplinas != null && !this.disciplinas.isEmpty()){
            string += ("Lecionando:");
            string = this.lecionando.keySet().stream().map((key) -> this.lecionando.get(key)).map((materia) -> "\n               "+materia.getDisciplina().getNomeDisciplina()+"  curso -> "+materia.getCurso().getNomeDoCurso()).reduce(string, String::concat);
        }else{
            string += ("Lecionando: \n               O professor nao leciona nenhuma materia.\n");
        }
        
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
        if(this.disciplinas == null) this.disciplinas = new HashMap<>();
        
        return this.disciplinas;
    } 
    public void setDisciplinas(HashMap<Integer,Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
}
