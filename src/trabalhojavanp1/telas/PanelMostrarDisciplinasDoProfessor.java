
package trabalhojavanp1.telas;

import interfaces.PadraoFrame;
import interfaces.PadraoPanel;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelMostrarDisciplinasDoProfessor extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_DISCIPLINAS_DO_PROFESSOR = "PanelMostrarDisciplinasDoProfessor";        
    private JLabel labelTeste;
    
    public PanelMostrarDisciplinasDoProfessor(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTeste = new JLabel("PanelMostrarDisciplinasDoProfessor");
        this.labelTeste.setLocation(50,50);
        this.labelTeste.setSize(200,60);
        this.labelTeste.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.add(this.labelTeste);
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
    }
    
}
