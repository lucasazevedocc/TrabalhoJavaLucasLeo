package trabalhojavanp1.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.AlunoCursoDao;
import dao.AlunoDao;
import dao.CursoDao;
import interfaces.PadraoPanel;
import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Curso;

public class PanelModificarAluno extends JPanel implements PadraoPanel, ActionListener {
	public static final String PANEL_MODIFICAR_ALUNO = "PanelModificarAluno";
	// COMPONENTES
	private JLabel labelTitulo, labelDadosDoAluno, labelMatriculaAlunoBusca, labelNomeAluno, labelEnderecoAluno,
			labelModificarCursosDoAluno;
	private JTextField campoMatriculaAluno, campoNomeAluno, campoEnderecoAluno;
	private JButton botaoBuscar, botaoSalvar;
	private JPanel panelCheckBoxGroupCursos;

	// OBJECTS
	private Aluno aluno;

	public PanelModificarAluno() {
		initObjects();
		initViews();
	}

	@Override
	public final void initViews() {
		this.setLayout(null);

		this.setLabelTitulo(new JLabel("MODIFICAR ALUNO"));
		this.getLabelTitulo().setLocation(225, 0);
		this.getLabelTitulo().setSize(180, 30);
		this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelMatriculaAlunoBusca(new JLabel("Matricula do aluno: "));
		this.getLabelMatriculaAlunoBusca().setLocation(40, 65);
		this.getLabelMatriculaAlunoBusca().setSize(160, 30);
		this.getLabelMatriculaAlunoBusca().setFont(new Font("Serif", Font.BOLD, 14));

		this.setCampoMatriculaAluno(new JTextField());
		this.getCampoMatriculaAluno().setSize(190, 30);
		this.getCampoMatriculaAluno().setLocation(200, 65);
		this.getCampoMatriculaAluno().setFont(new Font("Serif", Font.BOLD, 18));

		this.setBotaoBuscar(new JButton("Buscar"));
		this.getBotaoBuscar().setSize(120, 30);
		this.getBotaoBuscar().setLocation(420, 65);
		this.getBotaoBuscar().setBackground(new Color(150, 220, 255));
		this.getBotaoBuscar().addActionListener(this);
		this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));

		this.setLabelDadosDoAluno(new JLabel("Busque acima o aluno que deseja modificar."));
		this.getLabelDadosDoAluno().setLocation(170, 115);
		this.getLabelDadosDoAluno().setSize(270, 30);
		this.getLabelDadosDoAluno().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelNomeAluno(new JLabel("Nome: "));
		this.getLabelNomeAluno().setLocation(30, 160);
		this.getLabelNomeAluno().setSize(200, 30);
		this.getLabelNomeAluno().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelEnderecoAluno(new JLabel("Endereco: "));
		this.getLabelEnderecoAluno().setLocation(30, 200);
		this.getLabelEnderecoAluno().setSize(200, 30);
		this.getLabelEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelModificarCursosDoAluno(new JLabel("Modificar os cursos do aluno: "));
		this.getLabelModificarCursosDoAluno().setLocation(210, 255);
		this.getLabelModificarCursosDoAluno().setSize(200, 30);
		this.getLabelModificarCursosDoAluno().setFont(new Font("Serif", Font.BOLD, 14));

		this.setCampoNomeAluno(new JTextField());
		this.getCampoNomeAluno().setSize(440, 30);
		this.getCampoNomeAluno().setLocation(120, 160);
		this.getCampoNomeAluno().setFont(new Font("Serif", Font.BOLD, 24));

		this.setCampoEnderecoAluno(new JTextField());
		this.getCampoEnderecoAluno().setSize(440, 30);
		this.getCampoEnderecoAluno().setLocation(120, 200);
		this.getCampoEnderecoAluno().setFont(new Font("Serif", Font.BOLD, 24));

		this.setBotaoSalvar(new JButton("Salvar Alteracões"));
		this.getBotaoSalvar().setSize(170, 40);
		this.getBotaoSalvar().setLocation(210, 570);
		this.getBotaoSalvar().setBackground(new Color(150, 220, 255));
		this.getBotaoSalvar().addActionListener(this);
		this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));

		this.add(getLabelTitulo());
		this.add(getLabelDadosDoAluno());
		this.add(getLabelMatriculaAlunoBusca());
		this.add(getCampoMatriculaAluno());
		this.add(getBotaoBuscar());
		this.add(getLabelNomeAluno());
		this.add(getLabelEnderecoAluno());
		this.add(getLabelModificarCursosDoAluno());
		this.add(getCampoNomeAluno());
		this.add(getCampoEnderecoAluno());
		this.add(getBotaoSalvar());

		this.setVisible(true);
	}

	private void gerarCursos(Aluno a) {
		
		if (this.getPanelCheckBoxGroupCursos() == null) {
			this.setPanelCheckBoxGroupCursos(new JPanel());
			this.getPanelCheckBoxGroupCursos()
					.setLayout(new BoxLayout(getPanelCheckBoxGroupCursos(), BoxLayout.Y_AXIS));
			this.getPanelCheckBoxGroupCursos().setSize(370, 400);
			this.getPanelCheckBoxGroupCursos().setLocation(110, 265);
			this.getPanelCheckBoxGroupCursos().setVisible(false);
		} else {
			this.remove(getPanelCheckBoxGroupCursos());
			this.setPanelCheckBoxGroupCursos(new JPanel());
			this.getPanelCheckBoxGroupCursos()
					.setLayout(new BoxLayout(getPanelCheckBoxGroupCursos(), BoxLayout.Y_AXIS));
			this.getPanelCheckBoxGroupCursos().setSize(370, 400);
			this.getPanelCheckBoxGroupCursos().setLocation(110, 265);
			this.getPanelCheckBoxGroupCursos().setVisible(false);
		}

		ArrayList<Object> listaCursos = new CursoDao().mostraCursos();
		HashMap<Integer, Curso> listaCursoEscolhido = new HashMap<>();
		ArrayList<Curso> listaCursoExistente = new AlunoCursoDao().mostraCursos(a);

		for (Object objeto : listaCursos) {
			JCheckBox checkbox = new JCheckBox("Curso: " + ((Curso) objeto).getNomeDoCurso());
			
			for (Curso curso : listaCursoExistente) {
				if(((Curso) objeto).getCodCurso() == curso.getCodCurso()) {
					checkbox.setSelected(true);
					break;
				}
			}
			
			checkbox.addActionListener((ActionEvent e) -> {
                            if(((JCheckBox) e.getSource()).isSelected()) {
                                listaCursoEscolhido.put(((Curso)objeto).getCodCurso(), (Curso) objeto);
                            }
                        });
			this.getPanelCheckBoxGroupCursos().add(checkbox);
		}	
		
		this.aluno = new Aluno(a.getMatricula(),
				this.getCampoNomeAluno().getText(),
				this.getCampoEnderecoAluno().getText(),
				listaCursoEscolhido
				);
		
		this.add(getPanelCheckBoxGroupCursos());
		this.getPanelCheckBoxGroupCursos().setVisible(true);
                this.labelModificarCursosDoAluno.setVisible(false);
		
	}


	@Override
	public final void initObjects() {
		// TODO MODFICAR LOGICA
		this.setAluno(null);
	}

	@Override
	public void initControles() {
		// this.salvando = false;
	}

        @Override
	public void actionPerformed(ActionEvent ae) {
		Aluno a = new AlunoDao().buscarPorId(Integer.parseInt(this.getCampoMatriculaAluno().getText()));
		if (ae.getSource() == this.botaoBuscar) {
			if (a == null) {
				JOptionPane.showMessageDialog(null, "Matricula n�o encontrada");
			} else {
				JOptionPane.showMessageDialog(null, "Aluno encontrado");
				this.gerarCursos(a);
			}
		} else {
			new AlunoDao().alterarAluno(
                                new Aluno(a.getMatricula(),
                                this.getCampoNomeAluno().getText(),
                                this.getCampoEnderecoAluno().getText(),
                                null));
			
			new AlunoCursoDao().deletaAlunoPorId(Integer.parseInt(this.getCampoMatriculaAluno().getText()));
			
			if(!this.aluno.getCursando().isEmpty()) {
                            this.aluno.getCursando().keySet().forEach((key) -> {
                                new AlunoCursoDao().inserirProId(this.aluno.getCursando().get(key).getCodCurso(), this.aluno.getMatricula());
                            });
			}
		}
	}

	public void atualizar() {
		initObjects();
		// inserirCursosDoProfessorNoTextArea();
	}

	// GETTERS SETTERS
	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public JLabel getLabelDadosDoAluno() {
		return labelDadosDoAluno;
	}

	public void setLabelDadosDoAluno(JLabel labelDadosDoAluno) {
		this.labelDadosDoAluno = labelDadosDoAluno;
	}

	public JLabel getLabelMatriculaAlunoBusca() {
		return labelMatriculaAlunoBusca;
	}

	public void setLabelMatriculaAlunoBusca(JLabel labelMatriculaAlunoBusca) {
		this.labelMatriculaAlunoBusca = labelMatriculaAlunoBusca;
	}

	public JTextField getCampoMatriculaAluno() {
		return campoMatriculaAluno;
	}

	public void setCampoMatriculaAluno(JTextField campoMatriculaAluno) {
		this.campoMatriculaAluno = campoMatriculaAluno;
	}

	public JButton getBotaoBuscar() {
		return botaoBuscar;
	}

	public void setBotaoBuscar(JButton botaoBuscar) {
		this.botaoBuscar = botaoBuscar;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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

	public JLabel getLabelModificarCursosDoAluno() {
		return labelModificarCursosDoAluno;
	}

	public void setLabelModificarCursosDoAluno(JLabel labelModificarCursosDoAluno) {
		this.labelModificarCursosDoAluno = labelModificarCursosDoAluno;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}

	public JPanel getPanelCheckBoxGroupCursos() {
		return panelCheckBoxGroupCursos;
	}

	public void setPanelCheckBoxGroupCursos(JPanel panelCheckBoxGroupCursos) {
		this.panelCheckBoxGroupCursos = panelCheckBoxGroupCursos;
	}

	public JTextField getCampoNomeAluno() {
		return campoNomeAluno;
	}

	public JTextField getCampoEnderecoAluno() {
		return campoEnderecoAluno;
	}

	public void setCampoNomeAluno(JTextField campoNomeAluno) {
		this.campoNomeAluno = campoNomeAluno;
	}

	public void setCampoEnderecoAluno(JTextField campoEnderecoAluno) {
		this.campoEnderecoAluno = campoEnderecoAluno;
	}
}
