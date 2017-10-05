package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import interfaces.PadraoDAO;
import java.util.Iterator;

public class Curso implements PadraoDAO{
    private int codCurso;
    private String nomeDoCurso;
    private List<Materia> materias;
    
    
    public Curso(){
    }
    
    public Curso(int codCurso, String nomeDoCurso, List<Materia> materias){
        this.codCurso = codCurso;
        this.nomeDoCurso = nomeDoCurso;
        this.materias = materias;
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
        Curso curso = new Curso();
        return curso;
    }

    @Override
    public List<Object> buscarTodos() {
        List<Object> list = new ArrayList<Object>();
        return list;    
    }
    
     public String gerarString(){
        String string = "";
        if( this.codCurso != 0){
            string += ("Codigo do curso: "+this.codCurso+"\n");
        }
        if( this.nomeDoCurso != null && !this.nomeDoCurso.isEmpty()){
            string += ("Nome: "+this.nomeDoCurso+"\n");
        }
        if(this.materias != null && this.materias.size() != 0){
            string += ("Materias:");
            for(Iterator it = this.materias.iterator();it.hasNext();){
                Materia materia = (Materia)it.next();
                string += "\n               "+materia.getDisciplina().getNomeDisciplina()+"  professor -> "+materia.getProfessor().getNome();
            }
        }else{
            string += ("Materias: \n               O curso nao possui nenhuma materia.");
        }
        
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
    
    public List<Materia> getMaterias(){
        if(this.materias == null){
            this.materias = new ArrayList<Materia>();
        }
        return this.materias;
    } 
    public void setMaterias(List<Materia> materias){
        this.materias = materias;
    }

}
