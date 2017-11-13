
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CursoDao;

public class PanelRemoverCurso extends JPanel implements PadraoPanel, ActionListener{
    public static final String PANEL_REMOVER_CURSO = "PanelRemoverCurso";        
    //COMPONENTES
    private JLabel labelTitulo,labelCodigoDoCurso;
    private JTextField campoCodigoCurso;
    private JButton botaoRemover;     
    
    public PanelRemoverCurso(){
        this.initViews();
    }

    @Override
    public final void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("REMOVER CURSO"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelCodigoDoCurso(new JLabel("Còdigo do curso: "));
        this.getLabelCodigoDoCurso().setLocation(30,285);
        this.getLabelCodigoDoCurso().setSize(160,30);
        this.getLabelCodigoDoCurso().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoCodigoCurso(new JTextField());
        this.getCampoCodigoCurso().setSize(400,30);
        this.getCampoCodigoCurso().setLocation(160,285);
        this.getCampoCodigoCurso().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoRemover(new JButton("Remover"));
        this.getBotaoRemover().setSize(150,40);
        this.getBotaoRemover().setLocation(220,340);
        this.getBotaoRemover().setBackground(new Color(150,220,255));
        this.getBotaoRemover().addActionListener(this);
        this.getBotaoRemover().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.getLabelTitulo());
        this.add(this.getLabelCodigoDoCurso());
        this.add(this.getCampoCodigoCurso());
        this.add(this.getBotaoRemover());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == this.botaoRemover){
        	new CursoDao().deletarCursoProId(Integer.parseInt(this.getCampoCodigoCurso().getText()));
    	}else{
            JOptionPane.showMessageDialog(null,"Curso n�o removido.");
      }
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JLabel getLabelCodigoDoCurso() {
        return labelCodigoDoCurso;
    }
    public void setLabelCodigoDoCurso(JLabel labelCodigoDoCurso) {
        this.labelCodigoDoCurso = labelCodigoDoCurso;
    }

    public JTextField getCampoCodigoCurso() {
        return campoCodigoCurso;
    }
    public void setCampoCodigoCurso(JTextField campoCodigoCurso) {
        this.campoCodigoCurso = campoCodigoCurso;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }
    public void setBotaoRemover(JButton botaoRemover) {
        this.botaoRemover = botaoRemover;
    }
    
}
