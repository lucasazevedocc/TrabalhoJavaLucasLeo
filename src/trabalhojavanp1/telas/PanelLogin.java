/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavanp1.telas;

import interfaces.PadraoPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import trabalhojavanp1.TrabalhoJavaNp1;


public class PanelLogin extends JPanel  implements PadraoPanel, ActionListener{
    //ENUM
    public static final String PANEL_LOGIN = "PanelLogin";
    private final String usuarioAdmin = "admin";
    private final String senhaAdmin = "admin";
    //COMPONENTES
    private JLabel labelUsuario, labelSenha, labelTitulo;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton btnLogar;

    public PanelLogin(){
        initViews();
        initObjects();
    }

    @Override
    public void initViews() {
        //COLOCAR A CONSTRUCAO DA TELA AQUI
        this.setLayout(null);
        
        this.labelTitulo = new JLabel("Realize o login: ");
        this.labelTitulo.setLocation(215,150);
        this.labelTitulo.setSize(200,30);
        this.labelTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.labelUsuario = new JLabel("Usuario: ");
        this.labelUsuario.setLocation(90,250);
        this.labelUsuario.setSize(100,30);
        this.labelUsuario.setFont(new Font("Serif", Font.BOLD, 24));

        this.labelSenha = new JLabel("Senha: ");
        this.labelSenha.setLocation(320,250);
        this.labelSenha.setSize(100,30);
        this.labelSenha.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setCampoUsuario(new JTextField(""));
        this.getCampoUsuario().setSize(100,30);
        this.getCampoUsuario().setLocation(190,250);
        this.getCampoUsuario().setFont(new Font("Serif", Font.BOLD, 24));

        this.setCampoSenha(new JPasswordField());
        this.getCampoSenha().setEchoChar('*');
        this.getCampoSenha().setSize(100,30);
        this.getCampoSenha().setLocation(400,250);
        this.getCampoSenha().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBtnLogar(new JButton("Logar"));
        this.getBtnLogar().setLocation(242,320);
        this.getBtnLogar().setSize(100,30);
        this.getBtnLogar().addActionListener(this);


        this.add(this.labelTitulo);
        this.add(this.labelUsuario);
        this.add(this.labelSenha);
        this.add(this.campoSenha);
        this.add(this.campoUsuario);
        this.add(this.getBtnLogar());

        this.setVisible(true);
    }

    @Override
    public void initObjects() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(verificarLogin(this.getCampoUsuario().getText(),String.valueOf(this.getCampoSenha().getPassword()))){
            TrabalhoJavaNp1.getTelaPrincipal().exibirPanel(PanelHome.PANEL_HOME);
        }else{
            JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
    }
    
    private boolean verificarLogin(String usuario, String senha){
        return true;
        //return (usuario != null && senha != null && usuario.equals(this.usuarioAdmin) && senha.equals(this.senhaAdmin));
    }
    
    public void limparCampos(){
        this.campoUsuario.setText("");
        this.campoSenha.setText("");
    }
    
    @Override
    public void initControles() {
        //this.salvando = false;
    }
    
    //GETTERS SETTERS
    public JTextField getCampoUsuario() {
        return campoUsuario;
    }
    public void setCampoUsuario(JTextField campoUsuario) {
        this.campoUsuario = campoUsuario;
    }

    public JPasswordField getCampoSenha() {
        return campoSenha;
    }
    public void setCampoSenha(JPasswordField campoSenha) {
        this.campoSenha = campoSenha;
    }

    public JButton getBtnLogar() {
        return btnLogar;
    }
    public void setBtnLogar(JButton btnLogar) {
        this.btnLogar = btnLogar;
    }
}
