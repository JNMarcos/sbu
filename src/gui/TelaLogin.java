package gui;
/**
 * 
 * @author ramices
 * 
 */
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import classes_basicas.ADMBiblioteca;
import classes_basicas.ADMGeral;
import classes_basicas.Aluno;
import classes_basicas.Professor;
import classes_basicas.Tecnico;
import classes_basicas.Usuario;
import negocio.ControladorConta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JPanel {
	private JTextField txtCPF;
	private JTextField textSenha;


	public TelaLogin() {
		setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					usuario = controladorConta.verificarLogin(txtCPF.getText(), textSenha.getText());
					
					try
					{
						if(usuario instanceof ADMGeral)
							telaPrincipalADMGeral.setVisible(true);
					}
					catch(Exception e2)
					{
						
						try
						{
							if(usuario instanceof ADMBiblioteca)
								telaPrincipalADMBiblioteca.setVisible(true);
						}
						catch(Exception e3)
						{
							
							telaPrincipalNaoADM.setVisible(true);
							
						}
						
					}
					
					
					
				}
				catch(Exception e)
				{
					
					JOptionPane.showMessageDialog(null, e.getMessage());
					
					
				}
							
				
				
			}
		});
		btnLogin.setBounds(111, 218, 89, 23);
		add(btnLogin);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				telaPrincipal.setVisible(true);
		
			}
		});
		btnVoltar.setBounds(273, 218, 89, 23);
		add(btnVoltar);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(200, 62, 162, 20);
		add(txtCPF);
		txtCPF.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(200, 112, 162, 20);
		add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(111, 65, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(111, 115, 46, 14);
		add(lblNewLabel_1);

	}
}
