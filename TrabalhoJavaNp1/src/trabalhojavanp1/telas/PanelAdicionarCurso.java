package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CursoDisciplinaProfessorDao;
import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Materia;
import trabalhojavanp1.objetos.Professor;

//TODO verificar se ja existe professores adicionados antes de liberar a adicao dos cursos
public class PanelAdicionarCurso extends JPanel implements PadraoPanel,ActionListener{
    public static final String PANEL_ADICIONAR_CURSO = "PanelAdicionarCurso";
    //COMPONENTES
    private JLabel labelTitulo,labelNomeCurso,labelDisciplinasCurso,labelNaoHaDisciplinas;
    private JTextField campoNomeCurso;
    private JButton botaoSalvar;
    private JList listaDisciplinasExistentes;
    private JPanel panelCheckBoxGroupDisciplinas;
    //OBJETOS
    private Curso curso;
    private List<Object> disciplinas;
    private List<Object> professores;
    private HashMap<String,Object> hMTextObject;
    //CONTROLES
    private boolean salvando;
    private Professor professorEscolhido;

    
    public PanelAdicionarCurso(){
        initControles();
        initViews();
        initObjects();
        gerarDisciplinas();
    }

    @Override
    public final void initViews() {
        this.setLayout(null);

        this.labelTitulo = new JLabel("ADICIONAR CURSO");
        this.labelTitulo.setLocation(220,0);
        this.labelTitulo.setSize(170,30);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 14));     
        
        this.labelNomeCurso = new JLabel("Nome do curso: ");
        this.labelNomeCurso.setLocation(30,125);
        this.labelNomeCurso.setSize(160,30);
        this.labelNomeCurso.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelNomeCurso.setVisible(false);
        
        this.labelDisciplinasCurso = new JLabel("Selecione as disciplinas do curso: ");
        this.labelDisciplinasCurso.setLocation(185,230);
        this.labelDisciplinasCurso.setSize(235,30);
        this.labelDisciplinasCurso.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelDisciplinasCurso.setVisible(false);

        this.labelNaoHaDisciplinas = new JLabel("           Carregando...");
        this.labelNaoHaDisciplinas.setLocation(185,260);
        this.labelNaoHaDisciplinas.setSize(235,30);
        this.labelNaoHaDisciplinas.setFont(new Font("Serif", Font.BOLD, 14));
        this.labelNaoHaDisciplinas.setVisible(true);
        
        this.setCampoNomeCurso(new JTextField());
        this.getCampoNomeCurso().setSize(400,30);
        this.getCampoNomeCurso().setLocation(160,125);
        this.getCampoNomeCurso().setFont(new Font("Serif", Font.BOLD, 24));
        this.getCampoNomeCurso().setVisible(false);

        this.setBotaoSalvar(new JButton("Salvar"));
        this.getBotaoSalvar().setSize(150,40);
        this.getBotaoSalvar().setLocation(220,560);
        this.getBotaoSalvar().setBackground(new Color(150,220,255));
        this.getBotaoSalvar().addActionListener(this);
        this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));
        this.getBotaoSalvar().setVisible(false);
        
        this.add(this.labelTitulo);
        this.add(this.labelDisciplinasCurso);
        this.add(this.labelNomeCurso);
        this.add(this.labelNaoHaDisciplinas);
        this.add(this.getCampoNomeCurso());
        this.add(this.getBotaoSalvar());

        this.setVisible(true);
    }

    @Override
    public final void initObjects() {
        this.curso = new Curso();
        this.disciplinas =  new Disciplina().buscarTodos();
        this.professores =  new Professor().buscarTodos();
        this.hMTextObject = new HashMap<>();
    }
    
    @Override
    public final void initControles() {
        this.salvando = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.botaoSalvar){
           if(!salvando){
                this.salvando = true;
                this.curso.setNomeDoCurso(this.campoNomeCurso.getText());
                          
                if(!cursoIsValid()){
                    JOptionPane.showMessageDialog(null,"Preencha os dados do professor corretamente.");
                }else{
                  if(curso.salvarAtual()){
                        JOptionPane.showMessageDialog(null,"Curso salvo.");
                        this.campoNomeCurso.setText("");
                        this.curso.getMaterias().forEach((m) -> {
                            new CursoDisciplinaProfessorDao().inserir(m);
                      });
                        this.curso = new Curso();
                        gerarDisciplinas();              
                  }else{
                        JOptionPane.showMessageDialog(null,"Curso nao foi salvo.");
                  }
                }
                this.salvando = false;
            }
        }
    }
    
    private boolean cursoIsValid(){
        return (this.curso != null && this.curso.getNomeDoCurso() != null && !this.curso.getNomeDoCurso().isEmpty()
                                && this.curso.getMaterias() != null && !this.curso.getMaterias().isEmpty());
    }
    
    private void gerarDisciplinas(){
        liberarFormulario(false,"           Carregando...");
        this.hMTextObject = new HashMap<>();

        if(getPanelCheckBoxGroupDisciplinas() == null){
            this.setPanelCheckBoxGroupDisciplinas(new JPanel());
            this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupDisciplinas().setSize(370,400);
            this.getPanelCheckBoxGroupDisciplinas().setLocation(110,265);
            this.getPanelCheckBoxGroupDisciplinas().setVisible(false);
        }else{
            this.remove(getPanelCheckBoxGroupDisciplinas());
            this.setPanelCheckBoxGroupDisciplinas(new JPanel());
            this.getPanelCheckBoxGroupDisciplinas().setLayout(new BoxLayout(getPanelCheckBoxGroupDisciplinas(),BoxLayout.Y_AXIS));
            this.getPanelCheckBoxGroupDisciplinas().setSize(370,400);
            this.getPanelCheckBoxGroupDisciplinas().setLocation(110,265);
            this.getPanelCheckBoxGroupDisciplinas().setVisible(false);
        }
                 
        if(this.disciplinas == null || this.disciplinas.isEmpty()){
            liberarFormulario(false,"Cadastre as disciplinas primeiro.");
        }else{
           if(this.professores == null || this.professores.isEmpty()){
                liberarFormulario(false,"Cadastre os professores primeiro.");
            }else{
                for(Object d : this.disciplinas){
                    JCheckBox checkBox = new JCheckBox("código da disciplina: "+((Disciplina) d).getCodDisciplina()+"   --   nome: "+((Disciplina) d).getNomeDisciplina());
                    checkBox.addActionListener((ActionEvent ae) -> {
                        if(((JCheckBox) ae.getSource()).isSelected()){
                            ArrayList<Professor> professoresComADisciplina = obterProfessoresDisponiveis((Disciplina) hMTextObject.get(((JCheckBox) ae.getSource()).getText()));
                            if(professoresComADisciplina != null && !professoresComADisciplina.isEmpty()){
                                boolean selecionado = true;
                                int cont = 1;
                                ButtonGroup buttonGroup = new ButtonGroup();
                                Object[] params = new Object[professoresComADisciplina.size()+1];
                                params[0] = "Salvar este professor ?";
                                for(Professor p : professoresComADisciplina){
                                    JCheckBox jCheckBox = new JCheckBox("registro do professor: "+p.getRegistro()+"   --   nome: "+p.getNome(),selecionado);
                                    jCheckBox.addActionListener((ActionEvent ae1) -> {
                                        professorEscolhido = p;
                                    });
                                    buttonGroup.add(jCheckBox);
                                    params[cont] = jCheckBox;
                                    cont++;
                                    if(selecionado){
                                        professorEscolhido = p;
                                        selecionado = false;
                                    }
                                }
                                int n = JOptionPane.showConfirmDialog(null, params, "Selecione o professor da materia", JOptionPane.YES_NO_OPTION);
                                if(n == 0){
                                    Materia materia = new Materia();
                                    materia.setDisciplina((Disciplina) d);
                                    materia.setProfessor(professorEscolhido);
                                    materia.setCurso(curso);
                                    curso.setMateria(materia);
                                }else{
                                    ((JCheckBox) ae.getSource()).setSelected(false);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Não existe professor disponível para esta disciplina");
                                ((JCheckBox) ae.getSource()).setSelected(false);
                            }
                        }else{
                            for(Materia m : curso.getMaterias()){
                                
                                if(m.getDisciplina() != null && m.getDisciplina().getCodDisciplina() == ((Disciplina) hMTextObject.get(((JCheckBox) ae.getSource()).getText())).getCodDisciplina()){
                                    curso.getMaterias().remove(m);
                                    break;
                                }
                            }
                        }
                    });
                    this.getPanelCheckBoxGroupDisciplinas().add(checkBox);
                    this.hMTextObject.put(checkBox.getText(),d);
               } 
                this.add(this.getPanelCheckBoxGroupDisciplinas());
                liberarFormulario(true,null);
           }
        }
    }
    
    private ArrayList<Professor> obterProfessoresDisponiveis(Disciplina disciplina){
        ArrayList<Professor> aL = new ArrayList<>();
        this.professores.stream().filter((p) -> (((Professor) p).getDisciplinas() != null && !((Professor) p).getDisciplinas().isEmpty() && ((Professor) p).getDisciplinas().containsKey(disciplina.getCodDisciplina()))).forEachOrdered((p) -> {
            aL.add((Professor) p);
        });
        return aL;
    }
    
    private void liberarFormulario(boolean liberar, String msg){
        if(!liberar && msg != null){
            this.labelNaoHaDisciplinas.setText(msg);
        }
        this.labelNomeCurso.setVisible(liberar);
        this.labelDisciplinasCurso.setVisible(liberar);
        this.labelNaoHaDisciplinas.setVisible(!liberar);
        this.campoNomeCurso.setVisible(liberar);
        this.botaoSalvar.setVisible(liberar);
        if(this.panelCheckBoxGroupDisciplinas != null){
            this.panelCheckBoxGroupDisciplinas.setVisible(liberar);
        }
    }
    
    //GETTERS SETTERS
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public JTextField getCampoNomeCurso() {
        return campoNomeCurso;
    }
    public void setCampoNomeCurso(JTextField campoNomeCurso) {
        this.campoNomeCurso = campoNomeCurso;
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

    public JPanel getPanelCheckBoxGroupDisciplinas() {
        return panelCheckBoxGroupDisciplinas;
    }
    public void setPanelCheckBoxGroupDisciplinas(JPanel panelCheckBoxGroupDisciplinas) {
        this.panelCheckBoxGroupDisciplinas = panelCheckBoxGroupDisciplinas;
    }

    public JLabel getLabelNaoHaDisciplinas() {
        return labelNaoHaDisciplinas;
    }
    public void setLabelNaoHaDisciplinas(JLabel labelNaoHaDisciplinas) {
        this.labelNaoHaDisciplinas = labelNaoHaDisciplinas;
    }
}
