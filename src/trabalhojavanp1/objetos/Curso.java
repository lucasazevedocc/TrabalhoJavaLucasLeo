package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.CursoDao;
import interfaces.PadraoDAO;

public class Curso implements PadraoDAO{
    private int codCurso;
    private String nomeDoCurso;
    private HashMap<Integer,Materia> materias;
    
    
    public Curso(){
        
    }
    
    public Curso(int codCurso, String nomeDoCurso, HashMap<Integer,Materia> materias){
        this.codCurso = codCurso;
        this.nomeDoCurso = nomeDoCurso;
        this.materias = materias;
    }
   
    @Override
    public boolean salvarAtual() {
        return new CursoDao().inserirCurso(this);
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return new CursoDao().deletarCurso(this);
    }

    @Override
    public boolean deletarByKey(int key) {
        return new CursoDao().deletarCursoProId(key);
    }

    @Override
    public Object buscarByKey(int key) {
        return new CursoDao().mostrarPorId(key);
    }

    @Override
    public List<Object> buscarTodos() {
        return new CursoDao().mostraCursos();   
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
