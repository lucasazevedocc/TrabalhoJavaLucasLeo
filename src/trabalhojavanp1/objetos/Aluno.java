package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Aluno aluno = new Aluno();
        return aluno;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;
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
        if(this.cursando != null && this.cursando.size() != 0){
            string += ("Cursos:");
            for(int key : this.cursando.keySet()){
                Curso curso = this.cursando.get(key);
                string += "\n               "+curso.getNomeDoCurso();
            }
        }else{
            string += ("Cursos: \n               O aluno nao esta em nenhum curso.");
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
        if(this.cursando == null){
            this.cursando = new HashMap<Integer,Curso>();
        }
        return this.cursando;
    } 
    public void setMatricula(HashMap<Integer,Curso> cursando){
        this.cursando = cursando;
    }

}
