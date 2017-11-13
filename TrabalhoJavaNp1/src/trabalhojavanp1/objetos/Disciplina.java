package trabalhojavanp1.objetos;

import java.util.List;

import dao.DisciplinaDao;
import interfaces.PadraoDAO;

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
        return new DisciplinaDao().inserirDisciplina(this);
    }

    @Override
    public boolean atualizarAtual() {
        return false;
    }

    @Override
    public boolean deletarAtual() {
        return new DisciplinaDao().deletarDisciplina(this);
    }

    @Override
    public boolean deletarByKey(int key) {
        return new DisciplinaDao().deletarDisciplinaPorId(key);
    }

    @Override
    public Object buscarByKey(int key) {
        return new DisciplinaDao().mostrarPorId(key);
    }

    @Override
    public List<Object> buscarTodos() {
        return new DisciplinaDao().mostraDisciplinas();    
    }
    
     public String gerarString(){
        String string = "";
        if( this.codDisciplina != 0){
            string += ("Matricula: "+this.codDisciplina+"\n");
        }
        if( this.nomeDisciplina != null && !this.nomeDisciplina.isEmpty()){
            string += ("Nome: "+this.nomeDisciplina+"\n");
        }
        
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
    public void setNomeDisciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }
}
