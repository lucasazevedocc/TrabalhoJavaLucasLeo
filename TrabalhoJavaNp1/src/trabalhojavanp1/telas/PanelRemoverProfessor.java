
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

import dao.ProfessorDao;

public class PanelRemoverProfessor extends JPanel implements PadraoPanel, ActionListener{
    public static final String PANEL_REMOVER_PROFESSOR = "PanelRemoverProfessor";
    //COMPONENTES
    private JLabel labelTitulo,labelRegistroProfessor;
    private JTextField campoRegistroProfessor;
    private JButton botaoRemover;  

    public PanelRemoverProfessor(){
        this.initViews();
    }

    @Override
    public final void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("REMOVER PROFESSOR"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelRegistroProfessor(new JLabel("Registro do professor: "));
        this.getLabelRegistroProfessor().setLocation(30,285);
        this.getLabelRegistroProfessor().setSize(160,30);
        this.getLabelRegistroProfessor().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoRegistroProfessor(new JTextField());
        this.getCampoRegistroProfessor().setSize(385,30);
        this.getCampoRegistroProfessor().setLocation(175,285);
        this.getCampoRegistroProfessor().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoRemover(new JButton("Remover"));
        this.getBotaoRemover().setSize(150,40);
        this.getBotaoRemover().setLocation(220,340);
        this.getBotaoRemover().setBackground(new Color(150,220,255));
        this.getBotaoRemover().addActionListener(this);
        this.getBotaoRemover().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.getLabelTitulo());
        this.add(this.getLabelRegistroProfessor());
        this.add(this.getCampoRegistroProfessor());
        this.add(this.getBotaoRemover());

        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
    	
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == this.botaoRemover){
    		new ProfessorDao()
        	.deletarProfessorProId(Integer.parseInt(this.getCampoRegistroProfessor().getText()));
    	}else{
            JOptionPane.showMessageDialog(null,"Aluno n�o removido.");
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

    public JLabel getLabelRegistroProfessor() {
        return labelRegistroProfessor;
    }
    public void setLabelRegistroProfessor(JLabel labelRegistroProfessor) {
        this.labelRegistroProfessor = labelRegistroProfessor;
    }

    public JTextField getCampoRegistroProfessor() {
        return campoRegistroProfessor;
    }
    public void setCampoRegistroProfessor(JTextField campoRegistroProfessor) {
        this.campoRegistroProfessor = campoRegistroProfessor;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }
    public void setBotaoRemover(JButton botaoRemover) {
        this.botaoRemover = botaoRemover;
    }
}
