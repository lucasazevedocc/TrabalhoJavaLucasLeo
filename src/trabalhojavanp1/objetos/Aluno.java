package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.AlunoDao;
import interfaces.PadraoDAO;

public class Aluno implements PadraoDAO{
    private int matricula;
    private String nome;
    private String endereco;
    private HashMap<Integer,Curso> cursando;
    
    public Aluno(){
        
    }
    
    public Aluno(int matricula, String nome, String endereco, HashMap<Integer,Curso> cursando){
        this.matricula = matricula;
        this.nome = nome; 
        this.endereco = endereco; 
        this.cursando = cursando; 
    }
    
    @Override
    public boolean salvarAtual() {
        return new AlunoDao().inserirAluno(this);
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return new AlunoDao().deletarAluno(this);
    }

    @Override
    public boolean deletarByKey(int key) {
        return new AlunoDao().deletarAlunoPorId(key);
    }

    @Override
    public Object buscarByKey(int key) {
        return new AlunoDao().buscarPorId(key);
    }

    @Override
    public List<Object> buscarTodos() {
        return new AlunoDao().mostraAlunos();
    }
    
    public String gerarString(){
        String string = "";
        if( this.matricula != 0){
            string += ("Matricula: "+this.matricula+"\n");
        }
        if( this.nome != null && !this.nome.isEmpty()){
            string += ("Nome: "+this.nome+"\n");
        }
        if( this.endereco != null && !this.endereco.isEmpty()){
            string += ("Endereco: "+this.endereco+"\n");
        }
        
        return string;
    }
    
    //GETTERS SETTERS
    public int getMatricula(){
        return this.matricula;
    } 
    public void setMatricula(int matricula){
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
    
    public HashMap<Integer,Curso> getCursando(){
        return this.cursando;
    } 
    public void setMatricula(HashMap<Integer,Curso> cursando){
        this.cursando = cursando;
    }

}
