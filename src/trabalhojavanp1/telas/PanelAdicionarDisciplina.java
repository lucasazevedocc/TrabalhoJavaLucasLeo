package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Disciplina;


public class PanelAdicionarDisciplina extends JPanel implements PadraoPanel,ActionListener{
    public static final String PANEL_ADICIONAR_DISCIPLINA = "PanelAdicionarDisciplina";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeDisciplina;
    private JTextField campoNomeDisciplina;
    private JButton botaoSalvar;
    //OBJETOS
    private Disciplina disciplina;
    //CONTROLES
    private boolean salvando;
    
    public PanelAdicionarDisciplina(){
        initControles();
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.setLabelTitulo(new JLabel("ADICIONAR DISCIPLINA"));
        this.getLabelTitulo().setLocation(210,0);
        this.getLabelTitulo().setSize(170,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelNomeDisciplina(new JLabel("Nome da disciplina: "));
        this.getLabelNomeDisciplina().setLocation(30,285);
        this.getLabelNomeDisciplina().setSize(160,30);
        this.getLabelNomeDisciplina().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setCampoNomeDisciplina(new JTextField());
        this.getCampoNomeDisciplina().setSize(400,30);
        this.getCampoNomeDisciplina().setLocation(160,285);
        this.getCampoNomeDisciplina().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        this.add(this.labelTitulo);
        this.add(this.labelNomeDisciplina);
        this.add(this.getCampoNomeDisciplina());
        this.add(this.getBotaoSalvar());
        
        this.setVisible(true);  
    }

    @Override
    public void initObjects() {
        this.disciplina = new Disciplina();
    }
    
    @Override
    public void initControles() {
        this.salvando = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.botaoSalvar){
            if(!salvando){
                this.salvando = true;
                this.disciplina = new Disciplina();
                this.disciplina.setNomeDisciplina(this.campoNomeDisciplina.getText().toString());

                if(!disciplinaIsValid()){
                   //TODO exibir mensagem preencher discipliina corretamente
                }else{
                  if(disciplina.salvarAtual()){
                        //TODO exibir mensagem disciplina salvo
                        this.campoNomeDisciplina.setText("");
                        this.salvando = false;
                  }else{
                        //TODO exibir mensagem disciplina nao salvo
                        this.salvando = false;
                  }
                }
            }    
        }
    }
    
    private boolean disciplinaIsValid(){
        if(this.disciplina != null && this.disciplina.getNomeDisciplina() != null && !this.disciplina.getNomeDisciplina().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    

    
    //GETTERS SETTERS
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JLabel getLabelNomeDisciplina() {
        return labelNomeDisciplina;
    }
    public void setLabelNomeDisciplina(JLabel labelNomeDisciplina) {
        this.labelNomeDisciplina = labelNomeDisciplina;
    }

    public JTextField getCampoNomeDisciplina() {
        return campoNomeDisciplina;
    }
    public void setCampoNomeDisciplina(JTextField campoNomeDisciplina) {
        this.campoNomeDisciplina = campoNomeDisciplina;
    }
    
    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }
}
