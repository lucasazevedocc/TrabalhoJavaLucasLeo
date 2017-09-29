package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import interfaces.PadraoPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhojavanp1.objetos.Disciplina;


public class PanelAdicionarDisciplina extends JPanel implements PadraoPanel{
    public static final String PANEL_ADICIONAR_DISCIPLINA = "PanelAdicionarDisciplina";
    private JLabel labelTeste;
    private Disciplina disciplina;
    
    public PanelAdicionarDisciplina(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTeste = new JLabel("PanelAdicionarDisciplina");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);
        this.setVisible(true);  
    }

    @Override
    public void initObjects() {
        this.disciplina = new Disciplina();
    }
    
    private boolean disciplinaIsValid(){
        if(false){
            return false;
        }else{
            this.disciplina = new Disciplina();
            //MONTAR DIscIPLINA
            return true;
        }
    }

    
    //GETTERS SETTERS
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
