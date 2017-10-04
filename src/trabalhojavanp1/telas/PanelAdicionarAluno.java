package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Curso;

public class PanelAdicionarAluno extends JPanel implements PadraoPanel,ActionListener{
    public static final String PANEL_ADICIONAR_ALUNO = "PanelAdicionarAluno";
    //COMPONENTES
    private JTextField campoNomeAluno,campoEnderecoAluno;
    private JLabel labelTitulo,labelNomeAluno,labelEnderecoAluno,labelNaoHaCursos,labelAdicionarCursosDoAluno;
    private JPanel panelCheckBoxGroupCursos;
    private JButton botaoSalvar;
    //OBJETOS
    private Aluno aluno;
    private List<Object> cursosDisponiveis;
    //CONTROLES
    private boolean salvando;

    
    public PanelAdicionarAluno(){
        initControles();
        initViews();
        initObjects();
        gerarCursos();
    }
      
    @Override
    public void initViews(){
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(null);
        
        this.setLabelTitulo(new JLabel("ADICIONAR ALUNO"));
        this.getLabelTitulo().setLocation(230,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelNomeAluno(new JLabel("Nome: "));
        this.getLabelNomeAluno().setLocation(30,100);
        this.getLabelNomeAluno().setSize(200,30);
        this.getLabelNomeAluno().setFont(new Font("Serif", Font.BOLD, 14));
        this.getLabelNomeAluno().setVisible(false);

        this.labelNaoHaCursos = new JLabel("           Carregando...");
        this.labelNaoHaCursos.setLocation(200,260);
        this.labelNaoHaCursos.setSize(235,30);
        this.labelNaoHaCursos.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelNaoHaCursos.setVisible(true);
        
        this.setLabelEnderecoAluno(new JLabel("Endereco: "));
        this.getLabelEnderecoAluno().setLocation(30,150);
        this.getLabelEnderecoAluno().setSize(200,30);
        this.getLabelEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        this.getLabelEnderecoAluno().setVisible(false);
     
        this.setLabelAdicionarCursosDoAluno(new JLabel("Adicione os cursos do aluno: "));
        this.getLabelAdicionarCursosDoAluno().setLocation(210,200);
        this.getLabelAdicionarCursosDoAluno().setSize(200,30);
        this.getLabelAdicionarCursosDoAluno().setFont(new Font("Serif", Font.BOLD, 14));
        this.getLabelAdicionarCursosDoAluno().setVisible(false);

        this.setCampoNomeAluno(new JTextField());
        this.getCampoNomeAluno().setSize(430,30);
        this.getCampoNomeAluno().setLocation(130,100);
        this.getCampoNomeAluno().setFont(new Font("Serif", Font.BOLD, 24));
        this.getCampoNomeAluno().setVisible(false);

        this.setCampoEnderecoAluno(new JTextField());
        this.getCampoEnderecoAluno().setSize(430,30);
        this.getCampoEnderecoAluno().setLocation(130,150);
        this.getCampoEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 24));
        this.getCampoEnderecoAluno().setVisible(false);

        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));      
        this.getBotaoSalvar().setVisible(false);
        
        this.add(getLabelTitulo());
        this.add(this.labelNaoHaCursos);
        this.add(getLabelNomeAluno());
        this.add(getLabelEnderecoAluno());
        this.add(getLabelAdicionarCursosDoAluno());
        this.add(getCampoNomeAluno());
        this.add(getCampoEnderecoAluno());
        this.add(getBotaoSalvar());

        this.setVisible(true);
    } 
    
    @Override
    public void initObjects(){
        this.aluno = new Aluno();
        this.cursosDisponiveis = new ArrayList<Object>();
        
        //GAMBIARRA
        /*Curso curso1 = new Curso();
        curso1.setCodCurso(1);
        curso1.setNomeDoCurso("Engenharia Civil");
        Curso curso2 = new Curso();
        curso2.setCodCurso(2);
        curso2.setNomeDoCurso("Engenharia Eletrica");
        Curso curso3 = new Curso();
        curso3.setCodCurso(3);
        curso3.setNomeDoCurso("Engenharia Meio Ambiente");
        Curso curso4 = new Curso();
        curso4.setCodCurso(4);
        curso4.setNomeDoCurso("Ciencias da Computacao");
        Curso curso5 = new Curso();
        curso5.setCodCurso(5);
        curso5.setNomeDoCurso("Arquitetura");
        cursosDisponiveis.add(curso1);
        cursosDisponiveis.add(curso2);
        cursosDisponiveis.add(curso3);
        cursosDisponiveis.add(curso4);
        cursosDisponiveis.add(curso5);
        cursosDisponiveis.add(curso1);
        cursosDisponiveis.add(curso2);
        cursosDisponiveis.add(curso3);
        cursosDisponiveis.add(curso4);
        cursosDisponiveis.add(curso5);*/

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
                this.aluno.setNome(this.campoNomeAluno.getText());
                this.aluno.setEndereco(this.campoEnderecoAluno.getText());
                if(!alunoIsValid()){
                    JOptionPane.showMessageDialog(null,"Preencha os dados do aluno corretamente.");
                }else{
                  if(aluno.salvarAtual()){
                        JOptionPane.showMessageDialog(null,"Aluno salvo.");
                        this.campoNomeAluno.setText("");
                        this.campoEnderecoAluno.setText("");
                        this.aluno = new Aluno();
                        gerarCursos();
                  }else{
                        JOptionPane.showMessageDialog(null,"Aluno nao foi salvo.");
                  }
                }
                this.salvando = false;
            }
        }
    }
    
    private void liberarFormulario(boolean liberar, String msg){
        if(!liberar && msg != null){
            this.labelNaoHaCursos.setText(msg);
        }
        this.labelNomeAluno.setVisible(liberar);
        this.labelEnderecoAluno.setVisible(liberar);
        this.labelNaoHaCursos.setVisible(!liberar);
        this.campoNomeAluno.setVisible(liberar);
        this.labelAdicionarCursosDoAluno.setVisible(liberar);
        this.campoEnderecoAluno.setVisible(liberar);
        this.botaoSalvar.setVisible(liberar);
        if(this.panelCheckBoxGroupCursos != null){
            this.panelCheckBoxGroupCursos.setVisible(liberar);
        }
    }

    private boolean alunoIsValid(){
        if(this.aluno != null && this.aluno.getNome() != null && !this.aluno.getNome().isEmpty() && this.aluno.getEndereco() != null && !this.aluno.getEndereco().isEmpty()
                                && this.aluno.getCursando() != null && this.aluno.getCursando().size() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    private void gerarCursos(){  
        liberarFormulario(false,"           Carregando...");

        if(getPanelCheckBoxGroupCursos() == null){
            this.setPanelCheckBoxGroupCursos(new JPanel());
            this.getPanelCheckBoxGroupCursos().setLayout(new BoxLayout(getPanelCheckBoxGroupCursos(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupCursos().setSize(350,325);
            this.getPanelCheckBoxGroupCursos().setLocation(120,230);
            this.getPanelCheckBoxGroupCursos().setVisible(false);
        }else{
            this.remove(getPanelCheckBoxGroupCursos());
            this.setPanelCheckBoxGroupCursos(new JPanel());
            this.getPanelCheckBoxGroupCursos().setLayout(new BoxLayout(getPanelCheckBoxGroupCursos(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupCursos().setSize(350,325);
            this.getPanelCheckBoxGroupCursos().setLocation(120,230);
            this.getPanelCheckBoxGroupCursos().setVisible(false);
        }
                
        if(this.cursosDisponiveis == null || this.cursosDisponiveis.size() == 0){
            liberarFormulario(false,"Cadastre os cursos primeiro.");
        }else{
            for(Iterator iterator = this.cursosDisponiveis.iterator();iterator.hasNext();){
                Curso curso = ((Curso)iterator.next());
                JCheckBox checkBox = new JCheckBox("código do curso: "+curso.getCodCurso()+"   --   nome: "+curso.getNomeDoCurso());
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(((JCheckBox) ae.getSource()).isSelected()){
                            aluno.getCursando().put(curso.getCodCurso(), curso);
                        }else{
                            aluno.getCursando().remove(curso.getCodCurso());
                        }
                    }
                });
                this.getPanelCheckBoxGroupCursos().add(checkBox);
            }
            this.add(this.getPanelCheckBoxGroupCursos());
            liberarFormulario(true,null);  
        } 
    }
    
    //GETTERS SETTERS
    public Aluno getAluno() {
        return this.aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public JTextField getCampoNomeAluno() {
        return campoNomeAluno;
    }
    public void setCampoNomeAluno(JTextField campoNomeAluno) {
        this.campoNomeAluno = campoNomeAluno;
    }

    public JTextField getCampoEnderecoAluno() {
        return campoEnderecoAluno;
    }
    public void setCampoEnderecoAluno(JTextField campoEnderecoAluno) {
        this.campoEnderecoAluno = campoEnderecoAluno;
    }

    public JLabel getLabelNomeAluno() {
        return labelNomeAluno;
    }
    public void setLabelNomeAluno(JLabel labelNomeAluno) {
        this.labelNomeAluno = labelNomeAluno;
    }

    public JLabel getLabelEnderecoAluno() {
        return labelEnderecoAluno;
    }
    public void setLabelEnderecoAluno(JLabel labelEnderecoAluno) {
        this.labelEnderecoAluno = labelEnderecoAluno;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelAdicionarCursosDoAluno() {
        return labelAdicionarCursosDoAluno;
    }
    public void setLabelAdicionarCursosDoAluno(JLabel labelAdicionarCursosDoAluno) {
        this.labelAdicionarCursosDoAluno = labelAdicionarCursosDoAluno;
    }
    
    public JPanel getPanelCheckBoxGroupCursos() {
        return panelCheckBoxGroupCursos;
    }
    public void setPanelCheckBoxGroupCursos(JPanel panelCheckBoxGroupCursos) {
        this.panelCheckBoxGroupCursos = panelCheckBoxGroupCursos;
    }
}


