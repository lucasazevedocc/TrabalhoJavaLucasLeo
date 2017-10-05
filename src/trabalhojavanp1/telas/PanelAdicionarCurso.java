package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
import javax.swing.JTextField;
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
    public void initViews() {
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
    public void initObjects() {
        this.curso = new Curso();
        this.disciplinas =  new Disciplina().buscarTodos();
        this.professores =  new Professor().buscarTodos();
        this.hMTextObject = new HashMap<String,Object>();


        //GABIARRA
        /*Disciplina dis1 = new Disciplina(1,"Matematica");
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
        HashMap<Integer,Disciplina> ds = new HashMap<Integer,Disciplina>();
        Professor prof1 = new Professor();
        prof1.setRegistro(1);
        prof1.setNome("Lucas de Almeida Campos");
        ds.put(dis1.getCodDisciplina(),dis1);
        ds.put(dis2.getCodDisciplina(),dis2);
        ds.put(dis3.getCodDisciplina(),dis3);
        ds.put(dis4.getCodDisciplina(),dis4);
        ds.put(dis5.getCodDisciplina(),dis5);
        prof1.setDisciplinas(ds);
        this.professores.add(prof1);
        ds = new HashMap<Integer,Disciplina>();
        Professor prof2 = new Professor();
        prof2.setRegistro(2);
        prof2.setNome("Marcos Almeida Junior Santos");
        ds.put(dis1.getCodDisciplina(),dis1);
        ds.put(dis2.getCodDisciplina(),dis2);
        ds.put(dis3.getCodDisciplina(),dis3);
        prof2.setDisciplinas(ds);
        this.professores.add(prof2);
        ds = new HashMap<Integer,Disciplina>();
        Professor prof3 = new Professor();
        prof3.setRegistro(3);
        prof3.setNome("Antonio Filho Salgado");
        ds.put(dis3.getCodDisciplina(),dis3);
        ds.put(dis4.getCodDisciplina(),dis4);
        prof3.setDisciplinas(ds);
        this.professores.add(prof3);
        ds = new HashMap<Integer,Disciplina>();
        Professor prof4 = new Professor();
        prof4.setRegistro(4);
        prof4.setNome("Pedro Paulo Salgado");
        ds.put(dis3.getCodDisciplina(),dis3);
        ds.put(dis4.getCodDisciplina(),dis4);
        prof4.setDisciplinas(ds);
        this.professores.add(prof4);
        ds = new HashMap<Integer,Disciplina>();
        Professor prof5 = new Professor();
        prof5.setRegistro(5);
        prof5.setNome("Joao Azevedo Salgado");
        ds.put(dis3.getCodDisciplina(),dis3);
        ds.put(dis4.getCodDisciplina(),dis4);
        prof5.setDisciplinas(ds);
        this.professores.add(prof5);*/
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
                this.curso.setNomeDoCurso(this.campoNomeCurso.getText().toString());
                //this.curso.setMaterias(materias);

                if(!cursoIsValid()){
                    JOptionPane.showMessageDialog(null,"Preencha os dados do professor corretamente.");
                }else{
                  if(curso.salvarAtual()){
                        JOptionPane.showMessageDialog(null,"Curso salvo.");
                        this.campoNomeCurso.setText("");
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
                                && this.curso.getMaterias() != null && this.curso.getMaterias().size() != 0);
    }
    
    private void gerarDisciplinas(){
        liberarFormulario(false,"           Carregando...");
        this.hMTextObject = new HashMap<String,Object>();

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
                 
        if(this.disciplinas == null || this.disciplinas.size() == 0){
            liberarFormulario(false,"Cadastre as disciplinas primeiro.");
        }else{
           if(this.professores == null || this.professores.size() == 0){
                liberarFormulario(false,"Cadastre os professores primeiro.");
            }else{
                for(Iterator iterator = this.disciplinas.iterator();iterator.hasNext();){
                    Disciplina disciplina = ((Disciplina)iterator.next());
                    JCheckBox checkBox = new JCheckBox("código da disciplina: "+disciplina.getCodDisciplina()+"   --   nome: "+disciplina.getNomeDisciplina());
                    checkBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(((JCheckBox) ae.getSource()).isSelected()){
                                ArrayList<Professor> professoresComADisciplina = obterProfessoresDisponiveis((Disciplina) hMTextObject.get(((JCheckBox) ae.getSource()).getText()));
                                if(professoresComADisciplina != null && professoresComADisciplina.size() != 0){
                                    boolean selecionado = true;
                                    int cont = 1;
                                    ButtonGroup buttonGroup = new ButtonGroup();
                                    Object[] params = new Object[professoresComADisciplina.size()+1];
                                    params[0] = "Salvar este professor ?";
                                    for(Iterator it = professoresComADisciplina.iterator();it.hasNext();){
                                        Professor professor = (Professor)it.next();
                                        JCheckBox jCheckBox = new JCheckBox("registro do professor: "+professor.getRegistro()+"   --   nome: "+professor.getNome(),selecionado); 
                                        jCheckBox.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent ae) {
                                                professorEscolhido = professor;
                                            }
                                        });
                                        buttonGroup.add(jCheckBox);
                                        params[cont] = jCheckBox;
                                        cont++;
                                        if(selecionado){
                                          professorEscolhido = professor;
                                          selecionado = false;
                                        }
                                    }
                                    int n = JOptionPane.showConfirmDialog(null, params, "Selecione o professor da materia", JOptionPane.YES_NO_OPTION);
                                    if(n == 0){
                                        Materia materia = new Materia();
                                        materia.setDisciplina(disciplina);
                                        materia.setProfessor(professorEscolhido);
                                        curso.getMaterias().add(materia);
                                    }else{
                                        ((JCheckBox) ae.getSource()).setSelected(false);
                                    }
                                }else{
                                     JOptionPane.showMessageDialog(null,"Não existe professor disponível para esta disciplina");
                                    ((JCheckBox) ae.getSource()).setSelected(false);
                                }
                            }else{
                                for(Iterator it = curso.getMaterias().iterator();it.hasNext();){
                                    Materia materia = (Materia)it.next();
                                    if(materia.getDisciplina() != null && materia.getDisciplina().getCodDisciplina() == ((Disciplina) hMTextObject.get(((JCheckBox) ae.getSource()).getText())).getCodDisciplina()){
                                        curso.getMaterias().remove(materia);
                                        break;
                                    }
                                }    
                            }
                        }
                    });
                    this.getPanelCheckBoxGroupDisciplinas().add(checkBox);
                    this.hMTextObject.put(checkBox.getText(),disciplina);
               } 
                this.add(this.getPanelCheckBoxGroupDisciplinas());
                liberarFormulario(true,null);
           }
        }
    }
    
    private ArrayList<Professor> obterProfessoresDisponiveis(Disciplina disciplina){
        ArrayList<Professor> aL = new ArrayList<Professor>();
        for(Iterator iterator = this.professores.iterator();iterator.hasNext();){
            Professor professor = (Professor)iterator.next();
            if(professor.getDisciplinas() != null && professor.getDisciplinas().size() != 0 && professor.getDisciplinas().containsKey(disciplina.getCodDisciplina())){
                aL.add(professor);
            }
        }
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
