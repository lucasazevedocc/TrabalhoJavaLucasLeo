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
    private final String usuarioAdmin = "admin";
    private final String senhaAdmin = "admin";
    //COMPONENTES
    private JLabel labelUsuario, labelSenha;
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
        
        this.labelUsuario = new JLabel("Usuario: ");
        this.labelUsuario.setLocation(50,50);
        this.labelUsuario.setSize(100,30);
        this.labelUsuario.setFont(new Font("Serif", Font.BOLD, 24));

        this.labelSenha = new JLabel("Senha: ");
        this.labelSenha.setLocation(50,100);
        this.labelSenha.setSize(100,30);
        this.labelSenha.setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setCampoUsuario(new JTextField(""));
        this.getCampoUsuario().setSize(100,30);
        this.getCampoUsuario().setLocation(150,50);
        this.getCampoUsuario().setFont(new Font("Serif", Font.BOLD, 24));

        this.setCampoSenha(new JPasswordField());
        this.getCampoSenha().setEchoChar('*');
        this.getCampoSenha().setSize(100,30);
        this.getCampoSenha().setLocation(150,100);
        this.getCampoSenha().setFont(new Font("Serif", Font.BOLD, 24));
        
        this.setBtnLogar(new JButton("Logar"));
        this.getBtnLogar().setLocation(85,150);
        this.getBtnLogar().setSize(100,30);
        this.getBtnLogar().addActionListener(this);

      
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
        if(verificarLogin(this.getCampoUsuario().getText(),this.getCampoSenha().getText())){
            JOptionPane.showMessageDialog(null,"Usuario Valido");
            TrabalhoJavaNp1.getTelaPrincipal().remove(TrabalhoJavaNp1.getPanelLogin());
            TrabalhoJavaNp1.getTelaPrincipal().add(TrabalhoJavaNp1.getPanelTeste());
            TrabalhoJavaNp1.getTelaPrincipal().show();
        }else{
            JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
    }
    
    private boolean verificarLogin(String usuario, String senha){
        return (usuario != null && senha != null && usuario.equals(this.usuarioAdmin) && senha.equals(this.senhaAdmin));
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
