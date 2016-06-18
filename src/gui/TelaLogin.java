package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes_basicas.ADMBiblioteca;
import classes_basicas.ADMGeral;
import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Professor;
import classes_basicas.Tecnico;
import negocio.Fachada;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JTextField textSenha;
	private TelaPrincipalADMBiblioteca telaPrincipalADMBiblioteca;
    private TelaPrincipalADMGeral telaPrincipalADMGeral;
    private TelaPrincipalNaoADM telaPrincipalNaoADM;
    private TelaInicio telaPrincipal;
    private static Fachada fachada = Fachada.getInstance();
    private JPanel contentPane;
	


	public TelaLogin() {
		
		
		
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		
		contentPane = new JPanel();
		setBounds(0, 0, 418, 294);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblTitulo = new JLabel("$BU");
		lblTitulo.setFont(new Font("Verdana", Font.ITALIC, 26));
		lblTitulo.setBounds(179, 11, 65, 57);
		contentPane.add(lblTitulo);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(166, 91, 162, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(88, 94, 46, 14);
		contentPane.add(lblLogin);
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(88, 139, 46, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(166, 136, 162, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				Conta conta = null;
				
				try
				{
					
					conta = fachada.verificarLogin(txtLogin.getText(), textSenha.getText());
					
				
					
					if(conta.getUsuario() instanceof ADMGeral)
					{	
						
						telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta);
						telaPrincipalADMGeral.setVisible(true);
						dispose();
						
					}	
					else if(conta.getUsuario()  instanceof ADMBiblioteca)
					{	
						telaPrincipalADMBiblioteca = new TelaPrincipalADMBiblioteca(conta);
						contentPane.setVisible(false);
						telaPrincipalADMBiblioteca.setVisible(true);
						dispose();
						
					}
					else if(conta.getUsuario() instanceof Tecnico || conta.getUsuario() instanceof Aluno
							|| conta.getUsuario() instanceof Professor)
					{
						telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
						telaPrincipalNaoADM.setVisible(true);
						dispose();
					
					}
				
				}
				
				catch(Exception e)
				{
					
					JOptionPane.showMessageDialog(null, e.getMessage());
		
				}
							
				
				
			}
			
		});
		btnLogin.setBounds(88, 202, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
				telaPrincipal = new TelaInicio();
				telaPrincipal.setVisible(true);
			
			}
		});
		btnVoltar.setBounds(239, 202, 89, 23);
		contentPane.add(btnVoltar);
	}
}




