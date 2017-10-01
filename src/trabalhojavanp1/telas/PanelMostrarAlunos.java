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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import trabalhojavanp1.objetos.Aluno;

public class PanelMostrarAlunos extends JPanel implements PadraoPanel{
    public static final String PANEL_MOSTRAR_ALUNOS = "PanelMostrarAlunos";        
    //COMPONENTES
    private JLabel labelTitulo,labelAlunosDaFaculdade;
    private JTextArea textAreaAlunosExistentes;
    //private JPanel panelAlunosDaFaculdade;
    //OBJECTS
    private List<Object> alunos;

    public PanelMostrarAlunos(){
        initObjects();
        initViews();
    }

    @Override
    public void initViews() {
        this.setLayout(null);
        
        this.setLabelTitulo(new JLabel("MOSTRAR ALUNOS"));
        this.getLabelTitulo().setLocation(230,0);
        this.getLabelTitulo().setSize(200,30);
        this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));
        
        this.setLabelAlunosDaFaculdade(new JLabel("Abaixo todos os alunos da faculdade: "));
        this.getLabelAlunosDaFaculdade().setLocation(180,170);
        this.getLabelAlunosDaFaculdade().setSize(230,30);
        this.getLabelAlunosDaFaculdade().setFont(new Font("Serif", Font.BOLD, 14));
       
        
       /* this.setLabelNaoHaAlunos(new JLabel("Não ha alunos adicionados."));
        this.getLabelNaoHaAlunos().setSize(200,30);
        this.getLabelNaoHaAlunos().setFont(new Font("Serif", Font.BOLD, 14));*/

        /*this.setPanelAlunosDaFaculdade(new JPanel());
        this.getPanelAlunosDaFaculdade().setLayout(new BoxLayout(getPanelAlunosDaFaculdade(),BoxLayout.Y_AXIS));
        this.getPanelAlunosDaFaculdade().setSize(590,250);
        this.getPanelAlunosDaFaculdade().setLocation(5,300);
        this.getPanelAlunosDaFaculdade().setVisible(true);*/
         
        this.setTextAreaAlunosExistentes(new JTextArea(""));
        this.getTextAreaAlunosExistentes().setLocation(50,210);
        this.getTextAreaAlunosExistentes().setSize(500,400);
        this.getTextAreaAlunosExistentes().setFont(new Font("Serif", Font.BOLD, 14));
        inserirAlunosNoTextArea();

        /*JButton btn = new JButton("teste");
        btn.setSize(150,40);
        btn.setLocation(220,560);
        btn.setBackground(new Color(150,220,255));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atualizarAlunosNoPanel();
            }
        });
        btn.setFont(new Font("Times New Roman", Font.BOLD, 16));  */      
       
        this.add(getLabelTitulo());
        this.add(getLabelAlunosDaFaculdade());
        this.add(getLabelAlunosDaFaculdade());
        this.add(getTextAreaAlunosExistentes());
        //this.add(this.getPanelAlunosDaFaculdade());
        //this.add(btn);

        this.setVisible(true);
    }
    

    @Override
    public void initObjects() {
        this.setAlunos(new Aluno().buscarTodos());
    }
    
    private void inserirAlunosNoTextArea(){
        if(this.getAlunos().size() == 0){
           // this.getPanelAlunosDaFaculdade().add(this.getLabelNaoHaAlunos());
           this.getTextAreaAlunosExistentes().setText("\n\n\n\n\n\n\n\n\n\n                                         Não ha alunos cadastrados.");
        }else{
            String string = "";

            for(Iterator iterator = this.getAlunos().iterator(); iterator.hasNext();){
                //System.out.println("entrou");
                Aluno aluno = (Aluno)iterator.next();
                string += aluno.gerarString();
                string += "\n\n";

                /*JLabel labelMatricula = new JLabel("Matricula: "+aluno.getMatricula());
                JLabel labelNome = new JLabel("Nome: "+aluno.getNome());
                JLabel labelEndereco = new JLabel("Endereco: "+aluno.getEndereco());
                JLabel labelPulaLinha1 = new JLabel(" ");
                JLabel labelPulaLinha2 = new JLabel(" ");*/

                /*this.getPanelAlunosDaFaculdade().add(labelMatricula);
                this.getPanelAlunosDaFaculdade().add(labelNome);
                this.getPanelAlunosDaFaculdade().add(labelEndereco);
                this.getPanelAlunosDaFaculdade().add(labelPulaLinha1);
                this.getPanelAlunosDaFaculdade().add(labelPulaLinha2);*/

            }

            this.getTextAreaAlunosExistentes().setText(string);

        }
    }
    
    public void atualizarTextArea(){
        initObjects();
        inserirAlunosNoTextArea();
        
        
        
                   //this.getTextAreaAlunosExistentes().setText("btn teste");

        //initObjects();
        //Aluno aluno = new Aluno(1,"Lucas","av nossa",null);
        //this.alunos.add(aluno);
        //RESETA O PANEL ALUNOS DA FACULDADE
        /*this.remove(getPanelAlunosDaFaculdade());
        this.setPanelAlunosDaFaculdade(new JPanel());
        this.getPanelAlunosDaFaculdade().setLayout(new BoxLayout(getPanelAlunosDaFaculdade(),BoxLayout.Y_AXIS));
        this.getPanelAlunosDaFaculdade().setSize(590,390);
        this.getPanelAlunosDaFaculdade().setLocation(5,300);
        this.getPanelAlunosDaFaculdade().setVisible(true);*/
        
        //inserirAlunosNoPanel();
        
        //this.add(this.getPanelAlunosDaFaculdade());
          //      this.getPanelAlunosDaFaculdade().repaint();

        //this.repaint();
    }
        
    
        
    
    //GETTERS SETTERS
    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }
    
    public JLabel getLabelAlunosDaFaculdade() {
        return labelAlunosDaFaculdade;
    }
    public void setLabelAlunosDaFaculdade(JLabel labelAlunosDaFaculdade) {
        this.labelAlunosDaFaculdade = labelAlunosDaFaculdade;
    }
    
    /*public JPanel getPanelAlunosDaFaculdade() {
        return panelAlunosDaFaculdade;
    }
    public void setPanelAlunosDaFaculdade(JPanel panelAlunosDaFaculdade) {
        this.panelAlunosDaFaculdade = panelAlunosDaFaculdade;
    }*/
    
    public List<Object> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Object> alunos) {
        this.alunos = alunos;
    }
    
    /*public JLabel getLabelNaoHaAlunos() {
        return labelNaoHaAlunos;
    }
    public void setLabelNaoHaAlunos(JLabel labelNaoHaAlunos) {
        this.labelNaoHaAlunos = labelNaoHaAlunos;
    }*/
    
    public JTextArea getTextAreaAlunosExistentes() {
        return textAreaAlunosExistentes;
    }
    public void setTextAreaAlunosExistentes(JTextArea textAreaAlunosExistentes) {
        this.textAreaAlunosExistentes = textAreaAlunosExistentes;
    }
}
