package gui;

/**
 * 
 * @author ramices
 * 
 */


import java.awt.BorderLayout;

import gui.TelaPrincipalADMGeral;
import gui.TelaPrincipalADM;
import gui.TelaPrincipalNaoADM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import negocio.Fachada;
import classes_basicas.ADMBiblioteca;
import classes_basicas.ADMGeral;
import classes_basicas.Conta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField textSenha;
	private TelaPrincipalADM telaPrincipalADM;
    private TelaPrincipalADMGeral telaPrincipalADMGeral;
    private TelaPrincipalNaoADM TelaPrincipalNaoADM;
    private static Fachada fachada = Fachada.getInstance();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


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
		
		JLabel lblCPF = new JLabel("CPF:");
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
			
				Conta conta = null;
				
				try
				{
					
					conta = fachada.verificarLogin(txtCPF.getText(), textSenha.getText());
					
					if(conta.getUsuario() instanceof ADMGeral)
					{
						telaPrincipalADMGeral = new TelaPrincipalADMGeral();
						contentPane.setVisible(false);
						telaPrincipalADMGeral.setVisible(true);
					}	
					else if(conta.getUsuario()  instanceof ADMBiblioteca)
					{	
						telaPrincipalADMBiblioteca = new TelaPrincipalADMBiblioteca();
						contentPane.setVisible(false);
						telaPrincipalADMBiblioteca.setVisible(true);
				
					}
					else
					{
						telaPrincipalNaoADM = new TelaPrincipalNaoADM();
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
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.exit(0);
			
			}
		});
		btnFechar.setBounds(239, 202, 89, 23);
		contentPane.add(btnFechar);
	}
}
