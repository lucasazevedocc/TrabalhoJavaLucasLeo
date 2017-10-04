package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

//TODO verificar se ja existe disciplinas adicionados antes de liberar a adicao dos professores
public class PanelAdicionarProfessor extends JPanel implements PadraoPanel,ActionListener{
    public static final String PANEL_ADICIONAR_PROFESSOR = "PanelAdicionarProfessor";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeProfessor,labelDisciplinasProfessor,labelFormacaoProfessor,labelNaoHaDisciplinas;
    private JTextField campoNomeProfessor;
    private JButton botaoSalvar;
    private JList listaDisciplinasExistentes;
    private JPanel panelButtonGroupFormacao,panelCheckBoxGroupDisciplinas;
    private ButtonGroup buttonGroupFormacaoProfessor;
    private JRadioButton radioButtonBacharelado,radioButtonMestrado,radioButtonDoutorado;
    //OBJETOS
    private Professor professor;
    private List<Object> disciplinas;

    //CONTROLES
    private boolean salvando;
    
    public PanelAdicionarProfessor(){
        initControles();
        initViews();
        initObjects();
        gerarDisciplinas();
    }

    @Override
    public void initViews() {
        this.setLayout(null);

        this.labelTitulo = new JLabel("ADICIONAR PROFESSOR");
        this.labelTitulo.setLocation(210,0);
        this.labelTitulo.setSize(170,30);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 14));
        
        this.labelNaoHaDisciplinas = new JLabel("           Carregando...");
        this.labelNaoHaDisciplinas.setLocation(185,260);
        this.labelNaoHaDisciplinas.setSize(235,30);
        this.labelNaoHaDisciplinas.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelNaoHaDisciplinas.setVisible(true);
        
        this.labelNomeProfessor = new JLabel("Nome do professor: ");
        this.labelNomeProfessor.setLocation(30,100);
        this.labelNomeProfessor.setSize(160,30);
        this.labelNomeProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelNomeProfessor.setVisible(false);
        
        this.labelFormacaoProfessor = new JLabel("Formacao do professor: ");
        this.labelFormacaoProfessor.setLocation(230,175);
        this.labelFormacaoProfessor.setSize(160,30);
        this.labelFormacaoProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelFormacaoProfessor.setVisible(false);
        
        this.labelDisciplinasProfessor = new JLabel("Selecione as disciplinas do professor:");
        this.labelDisciplinasProfessor.setLocation(185,265);
        this.labelDisciplinasProfessor.setSize(235,30);
        this.labelDisciplinasProfessor.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelDisciplinasProfessor.setVisible(false);

        this.setCampoNomeProfessor(new JTextField());
        this.getCampoNomeProfessor().setSize(400,30);
        this.getCampoNomeProfessor().setLocation(160,100);
        this.getCampoNomeProfessor().setFont(new Font("Serif", Font.BOLD, 24));
        this.getCampoNomeProfessor().setVisible(false);
        
        this.setPanelButtonGroupFormacao(new JPanel());
        this.getPanelButtonGroupFormacao().setLayout(new FlowLayout());
        this.getPanelButtonGroupFormacao().setSize(300,30);
        this.getPanelButtonGroupFormacao().setLocation(150,205);
        this.getPanelButtonGroupFormacao().setVisible(true);
        this.setButtonGroupFormacaoProfessor(new ButtonGroup());
        this.setRadioButtonBacharelado(new JRadioButton("Bacharelado",true));
        this.getRadioButtonBacharelado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                professor.setFormacao(((JRadioButton)ae.getSource()).getText());
            }
        });
        this.setRadioButtonDoutorado(new JRadioButton("Doutorado",false));
        this.getRadioButtonDoutorado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                professor.setFormacao(((JRadioButton)ae.getSource()).getText());
            }
        });
        this.setRadioButtonMestrado(new JRadioButton("Mestrado",false));
        this.getRadioButtonMestrado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                professor.setFormacao(((JRadioButton)ae.getSource()).getText());
            }
        });
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonBacharelado());
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonMestrado());
        this.getButtonGroupFormacaoProfessor().add(this.getRadioButtonDoutorado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonBacharelado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonMestrado());
        this.getPanelButtonGroupFormacao().add(this.getRadioButtonDoutorado());
        this.getPanelButtonGroupFormacao().setVisible(false);
        
        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        this.getBotaoSalvar().setVisible(false);
        
        this.add(this.labelTitulo);
        this.add(this.labelDisciplinasProfessor);
        this.add(this.labelFormacaoProfessor);
        this.add(this.labelNomeProfessor);
        this.add(this.labelNaoHaDisciplinas);
        this.add(this.getCampoNomeProfessor());
        this.add(this.getPanelButtonGroupFormacao());
        this.add(this.getBotaoSalvar());
        
        this.setVisible(true);
    }

    @Override
    public void initObjects() {
        this.professor = new Professor();
        this.professor.setFormacao(this.getRadioButtonBacharelado().getText());
        this.disciplinas =  new Disciplina().buscarTodos();
        
        //GABIARRA
        Disciplina dis1 = new Disciplina(1,"Matematica");
        this.disciplinas.add(dis1);
        Disciplina dis2 = new Disciplina(2,"Engenharia de Software");
        this.disciplinas.add(dis2);
        Disciplina dis3 = new Disciplina(3,"Engenharia Espacial");
        this.disciplinas.add(dis3);
        Disciplina dis4 = new Disciplina(4,"Meio Ambiente");
        this.disciplinas.add(dis4);
        Disciplina dis5 = new Disciplina(5,"Engenharia Civil");
        this.disciplinas.add(dis5);
        Disciplina dis6 = new Disciplina(6,"Ciencias da Computacao");
        this.disciplinas.add(dis6); 
    }
    
    @Override
    public void initControles() {
        this.salvando = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!salvando){
                this.salvando = true;
                this.professor.setNome(this.campoNomeProfessor.getText());
                if(!professorIsValid()){
                    JOptionPane.showMessageDialog(null,"Preencha os dados do professor corretamente.");
                }else{
                  if(professor.salvarAtual()){
                        JOptionPane.showMessageDialog(null,"Professor salvo.");
                        this.campoNomeProfessor.setText("");
                        this.getRadioButtonBacharelado().setSelected(true);
                        this.professor = new Professor();
                        this.professor.setFormacao(this.getRadioButtonBacharelado().getText());
                        gerarDisciplinas();
                  }else{
                        JOptionPane.showMessageDialog(null,"Professor nao foi salvo.");
                  }
                }
                this.salvando = false;
            }
    }
    
    private boolean professorIsValid(){
        if(this.professor != null && this.professor.getNome() != null && !this.professor.getNome().isEmpty() && this.professor.getFormacao() != null && !this.professor.getFormacao().isEmpty()
                                && this.professor.getDisciplinas() != null && this.professor.getDisciplinas().size() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void gerarDisciplinas(){
        liberarFormulario(false,"           Carregando...");

        if(getPanelCheckBoxGroupDisciplinas() == null){
            this.setPanelCheckBoxGroupDisciplinas(new JPanel());
            this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupDisciplinas().setSize(370,400);
            this.getPanelCheckBoxGroupDisciplinas().setLocation(110,300);
            this.getPanelCheckBoxGroupDisciplinas().setVisible(false);
        }else{
            this.remove(getPanelCheckBoxGroupDisciplinas());
            this.setPanelCheckBoxGroupDisciplinas(new JPanel());
            this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupDisciplinas().setSize(370,400);
            this.getPanelCheckBoxGroupDisciplinas().setLocation(110,300);
            this.getPanelCheckBoxGroupDisciplinas().setVisible(false);
        }
                
        if(this.disciplinas == null || this.disciplinas.size() == 0){
            liberarFormulario(false,"Cadastre as disciplinas primeiro.");
        }else{
            for(Iterator iterator = this.disciplinas.iterator();iterator.hasNext();){
                Disciplina disciplina = ((Disciplina)iterator.next());
                JCheckBox checkBox = new JCheckBox("código da disciplina: "+disciplina.getCodDisciplina()+"   --   nome: "+disciplina.getNomeDisciplina());
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(((JCheckBox) ae.getSource()).isSelected()){
                            professor.getDisciplinas().put(disciplina.getCodDisciplina(), disciplina);
                        }else{
                            professor.getDisciplinas().remove(disciplina.getCodDisciplina());
                        }
                    }
                });
                this.getPanelCheckBoxGroupDisciplinas().add(checkBox);
            }
            this.add(this.getPanelCheckBoxGroupDisciplinas());
            liberarFormulario(true,null);  
        }    
    }

    private void liberarFormulario(boolean liberar,String msg){
        if(!liberar && msg != null){
            this.labelNaoHaDisciplinas.setText(msg);
        }
        this.labelNomeProfessor.setVisible(liberar);
        this.labelFormacaoProfessor.setVisible(liberar);
        this.labelDisciplinasProfessor.setVisible(liberar);
        this.labelNaoHaDisciplinas.setVisible(!liberar);
        this.campoNomeProfessor.setVisible(liberar);
        this.botaoSalvar.setVisible(liberar);
        this.panelButtonGroupFormacao.setVisible(liberar);
        if(this.panelCheckBoxGroupDisciplinas != null){
            this.panelCheckBoxGroupDisciplinas.setVisible(liberar);
        }
    }
    
    //GETTERS SETTERS
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public JTextField getCampoNomeProfessor() {
        return campoNomeProfessor;
    }
    public void setCampoNomeProfessor(JTextField campoNomeProfessor) {
        this.campoNomeProfessor = campoNomeProfessor;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JList getListaDisciplinasExistentes() {
        return listaDisciplinasExistentes;
    }
    public void setListaDisciplinasExistentes(JList listaDisciplinasExistentes) {
        this.listaDisciplinasExistentes = listaDisciplinasExistentes;
    }

    public ButtonGroup getButtonGroupFormacaoProfessor() {
        return buttonGroupFormacaoProfessor;
    }
    public void setButtonGroupFormacaoProfessor(ButtonGroup buttonGroupFormacaoProfessor) {
        this.buttonGroupFormacaoProfessor = buttonGroupFormacaoProfessor;
    }
    
    public JRadioButton getRadioButtonBacharelado() {
        return radioButtonBacharelado;
    }
    public void setRadioButtonBacharelado(JRadioButton radioButtonBacharelado) {
        this.radioButtonBacharelado = radioButtonBacharelado;
    }

    public JRadioButton getRadioButtonMestrado() {
        return radioButtonMestrado;
    }
    public void setRadioButtonMestrado(JRadioButton radioButtonMestrado) {
        this.radioButtonMestrado = radioButtonMestrado;
    }

    public JRadioButton getRadioButtonDoutorado() {
        return radioButtonDoutorado;
    }
    public void setRadioButtonDoutorado(JRadioButton radioButtonDoutorado) {
        this.radioButtonDoutorado = radioButtonDoutorado;
    }

    public JPanel getPanelButtonGroupFormacao() {
        return panelButtonGroupFormacao;
    }
    public void setPanelButtonGroupFormacao(JPanel panelButtonGroupFormacao) {
        this.panelButtonGroupFormacao = panelButtonGroupFormacao;
    }

    public JPanel getPanelCheckBoxGroupDisciplinas() {
        return panelCheckBoxGroupDisciplinas;
    }
    public void setPanelCheckBoxGroupDisciplinas(JPanel panelCheckBoxGroupDisciplinas) {
        this.panelCheckBoxGroupDisciplinas = panelCheckBoxGroupDisciplinas;
    }   
}
