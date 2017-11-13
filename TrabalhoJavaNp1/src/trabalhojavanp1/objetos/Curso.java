package trabalhojavanp1.objetos;

import java.util.ArrayList;
import java.util.List;

import dao.CursoDao;
import interfaces.PadraoDAO;

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
        return new CursoDao().mostrarPorIdComMateria(key);
    }

    @Override
    public List<Object> buscarTodos() {
        return new CursoDao().mostraCursos();   
    }
    
     public String gerarString(){
        String string = "";
        if( this.codCurso != 0){
            string += ("Codigo do curso: "+this.getCodCurso()+"\n");
        }
        if( this.nomeDoCurso != null && !this.nomeDoCurso.isEmpty()){
            string += ("Nome: "+this.getNomeDoCurso()+"\n");
        }
        if(this.materias != null && !this.materias.isEmpty()){
            string += ("Materias:");
            string = this.getMaterias().stream().map((m) -> "\n               "+m.getDisciplina().getNomeDisciplina()+"  professor -> "+m.getProfessor().getRegistro()).reduce(string, String::concat);
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

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
    
	public void setMateria(Materia materia) {
		if(this.materias == null) this.materias = new ArrayList<>();
		this.materias.add(materia);
	}

}
