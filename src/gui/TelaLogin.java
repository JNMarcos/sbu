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
import javax.swing.border.EmptyBorder;

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
	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField textSenha;
	private TelaPrincipalADMBiblioteca telaPrincipalADMBiblioteca;
    private TelaPrincipalADMGeral telaPrincipalADMGeral;
    private TelaPrincipalNaoADM telaPrincipalNaoADM;
    private TelaInicio telaPrincipal;
    private static Fachada fachada = Fachada.getInstance();
	


	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("$BU");
		lblTitulo.setFont(new Font("Verdana", Font.ITALIC, 26));
		lblTitulo.setBounds(179, 11, 65, 57);
		contentPane.add(lblTitulo);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(166, 91, 162, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblCPF = new JLabel("Login:");
		lblCPF.setBounds(88, 94, 46, 14);
		contentPane.add(lblCPF);
		
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
				dispose(); 
				Conta conta = null;
				
				try
				{
					
					conta = fachada.verificarLogin(txtCPF.getText(), textSenha.getText());
					
					if(conta.getUsuario() instanceof ADMGeral)
					{
						telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta);
						contentPane.setVisible(false);
						telaPrincipalADMGeral.setVisible(true);
					}	
					else if(conta.getUsuario()  instanceof ADMBiblioteca)
					{	
						telaPrincipalADMBiblioteca = new TelaPrincipalADMBiblioteca(conta);
						contentPane.setVisible(false);
						telaPrincipalADMBiblioteca.setVisible(true);
				
					}
					else if(conta.getUsuario() instanceof Tecnico || conta.getUsuario() instanceof Aluno
							|| conta.getUsuario() instanceof Professor)
					{
						telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
						contentPane.setVisible(false);
						telaPrincipalNaoADM.setVisible(true);
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
