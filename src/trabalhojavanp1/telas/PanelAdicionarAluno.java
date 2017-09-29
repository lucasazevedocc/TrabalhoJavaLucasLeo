
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Aluno;


//TODO verificar se ja existe cursos adicionados antes de liberar a adicao dos alunos
public class PanelAdicionarAluno extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_ALUNO = "PanelAdicionarAluno";
    private JLabel labelTeste;
    private Aluno aluno;
    
    public PanelAdicionarAluno(){
        initViews();
        initObjects();
    }
    
    @Override
    public void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(null);

        this.labelTeste = new JLabel("PanelAdicionarAluno");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);
        this.setVisible(true);
    } 
    @Override
    public void initObjects(){
        this.aluno = new Aluno();
    }
    
    
    private boolean alunoIsValid(){
        if(false){
            return false;
        }else{
            this.aluno = new Aluno();
            //MONTAR ALUNO
            return true;
        }
    }
    
    //GETTERS SETTERS
    public Aluno getAluno() {
        return this.aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}


