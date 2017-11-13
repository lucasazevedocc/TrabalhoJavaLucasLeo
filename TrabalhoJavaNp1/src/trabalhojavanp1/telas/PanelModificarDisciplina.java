
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

import dao.DisciplinaDao;
import trabalhojavanp1.objetos.Disciplina;

public class PanelModificarDisciplina extends JPanel implements PadraoPanel, ActionListener {
	public static final String PANEL_MODIFICAR_DISCIPLINA = "PanelModificarDisciplina";
	private JLabel labelTitulo, labelDadosDaDisciplina, labelCodigoDisciplina, labelNomeDiscipliina;
	private JTextField campoCodigoDisciplina, campoNomeDisciplina;
	private JButton botaoBuscar, botaoSalvar;
	// OBJETCS
	private Disciplina disciplina;

	public PanelModificarDisciplina() {
		this.initViews();
	}

	@Override
	public final void initViews() {
		this.setLayout(null);

		this.setLabelTitulo(new JLabel("MODIFICAR DISCIPLINA"));
		this.getLabelTitulo().setLocation(210, 0);
		this.getLabelTitulo().setSize(180, 30);
		this.getLabelTitulo().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelCodigoDisciplina(new JLabel("Codigo da disciplina: "));
		this.getLabelCodigoDisciplina().setLocation(40, 160);
		this.getLabelCodigoDisciplina().setSize(160, 30);
		this.getLabelCodigoDisciplina().setFont(new Font("Serif", Font.BOLD, 14));

		this.setCampoCodigoDisciplina(new JTextField());
		this.getCampoCodigoDisciplina().setSize(200, 30);
		this.getCampoCodigoDisciplina().setLocation(190, 160);
		this.getCampoCodigoDisciplina().setFont(new Font("Serif", Font.BOLD, 18));

		this.setBotaoBuscar(new JButton("Buscar"));
		this.getBotaoBuscar().setSize(120, 30);
		this.getBotaoBuscar().setLocation(420, 160);
		this.getBotaoBuscar().setBackground(new Color(150, 220, 255));
		this.getBotaoBuscar().addActionListener(this);
		this.getBotaoBuscar().setFont(new Font("Times New Roman", Font.BOLD, 16));

		this.setLabelDadosDaDisciplina(new JLabel("Busque acima a disciplina que deseja modificar."));
		this.getLabelDadosDaDisciplina().setLocation(150, 230);
		this.getLabelDadosDaDisciplina().setSize(300, 30);
		this.getLabelDadosDaDisciplina().setFont(new Font("Serif", Font.BOLD, 14));

		this.setLabelNomeDiscipliina(new JLabel("Nome da disciplina: "));
		this.getLabelNomeDiscipliina().setLocation(30, 300);
		this.getLabelNomeDiscipliina().setSize(200, 30);
		this.getLabelNomeDiscipliina().setFont(new Font("Serif", Font.BOLD, 14));

		this.setCampoNomeDisciplina(new JTextField());
		this.getCampoNomeDisciplina().setSize(390, 30);
		this.getCampoNomeDisciplina().setLocation(160, 300);
		this.getCampoNomeDisciplina().setFont(new Font("Serif", Font.BOLD, 24));

		this.setBotaoSalvar(new JButton("Salvar Alteracões"));
		this.getBotaoSalvar().setSize(170, 40);
		this.getBotaoSalvar().setLocation(210, 570);
		this.getBotaoSalvar().setBackground(new Color(150, 220, 255));
		this.getBotaoSalvar().addActionListener(this);
		this.getBotaoSalvar().setFont(new Font("Times New Roman", Font.BOLD, 16));

		this.add(getLabelTitulo());
		this.add(getLabelDadosDaDisciplina());
		this.add(getLabelCodigoDisciplina());
		this.add(getCampoCodigoDisciplina());
		this.add(getBotaoBuscar());
		this.add(getLabelNomeDiscipliina());
		this.add(getCampoNomeDisciplina());
		this.add(getBotaoSalvar());

		this.setVisible(true);
	}

	@Override
	public void initObjects() {
	}

        @Override
	public void actionPerformed(ActionEvent ae) {
		Disciplina d = (Disciplina) new DisciplinaDao()
				.mostrarPorId(Integer.parseInt(this.getCampoCodigoDisciplina().getText()));
		if (ae.getSource() == this.botaoBuscar) {
			if(d == null) {
				JOptionPane.showMessageDialog(null, "disciplina n�o encontrada");
			}else {
				JOptionPane.showMessageDialog(null, "disciplina encontrada");
			}
		} else {
			Disciplina disc = new Disciplina(d.getCodDisciplina(), this.getCampoNomeDisciplina().getText());
			new DisciplinaDao().alteraNomeDisciplina(disc);
		}
	}

	@Override
	public void initControles() {
		// this.salvando = false;
	}

	// GETTERS SETTERS
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

	public JLabel getLabelDadosDaDisciplina() {
		return labelDadosDaDisciplina;
	}

	public void setLabelDadosDaDisciplina(JLabel labelDadosDaDisciplina) {
		this.labelDadosDaDisciplina = labelDadosDaDisciplina;
	}

	public JLabel getLabelCodigoDisciplina() {
		return labelCodigoDisciplina;
	}

	public void setLabelCodigoDisciplina(JLabel labelCodigoDisciplina) {
		this.labelCodigoDisciplina = labelCodigoDisciplina;
	}

	public JLabel getLabelNomeDiscipliina() {
		return labelNomeDiscipliina;
	}

	public void setLabelNomeDiscipliina(JLabel labelNomeDiscipliina) {
		this.labelNomeDiscipliina = labelNomeDiscipliina;
	}

	public JTextField getCampoCodigoDisciplina() {
		return campoCodigoDisciplina;
	}

	public void setCampoCodigoDisciplina(JTextField campoCodigoDisciplina) {
		this.campoCodigoDisciplina = campoCodigoDisciplina;
	}

	public JTextField getCampoNomeDisciplina() {
		return campoNomeDisciplina;
	}

	public void setCampoNomeDisciplina(JTextField campoNomeDisciplina) {
		this.campoNomeDisciplina = campoNomeDisciplina;
	}

	public JButton getBotaoBuscar() {
		return botaoBuscar;
	}

	public void setBotaoBuscar(JButton botaoBuscar) {
		this.botaoBuscar = botaoBuscar;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}
}
