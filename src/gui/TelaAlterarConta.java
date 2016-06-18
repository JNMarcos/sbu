package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Professor;
import classes_basicas.Tecnico;
import classes_basicas.Usuario;
import excecao.ContaNaoEncontradaException;
import negocio.Fachada;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarConta extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordFieldNova;
	private Conta conta = null;
	private Conta contaDosDadosAlterados = null;
	private Usuario usuario;
	private static Fachada fachada = Fachada.getInstance();
	private JTextField textCpf;

	/**
	 * Launch the application.
	 */
	public void setConta(Conta conta){
		this.conta = conta;
	}
	
	public void setContaDadosAlterados(Conta conta){
		this.contaDosDadosAlterados = conta;
	}
	
	public TelaAlterarConta() {
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("Alterar Dados da Conta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Novo Login:");
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblLogin.setBounds(10, 81, 71, 14);
		contentPane.add(lblLogin);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNovaSenha.setBounds(10, 129, 71, 14);
		contentPane.add(lblNovaSenha);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(contaDosDadosAlterados.getUsuario() instanceof Aluno || contaDosDadosAlterados.getUsuario() instanceof Professor || contaDosDadosAlterados.getUsuario() instanceof Tecnico){
					if(textLogin.getText().equals("") || passwordFieldNova.getText().equals("")){
						JOptionPane.showMessageDialog(TelaAlterarConta.this, "Digite seu login e sua nova senha");
					}else{
						contaDosDadosAlterados = new Conta(contaDosDadosAlterados.getUsuario(), textLogin.getText(),passwordFieldNova.getText());
						try {
							fachada.alterarDadosConta(contaDosDadosAlterados);
						} catch (ContaNaoEncontradaException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						
							textLogin.setText("");
							passwordFieldNova.setText("");
							
						}
						
					}
				}
				
			}
		});
		btnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAtualizar.setBounds(88, 227, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(contaDosDadosAlterados); 
				telaPrincipalADMGeral.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.setBounds(250, 228, 89, 23);
		contentPane.add(btnCancelar);
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textLogin.setBounds(88, 78, 198, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		passwordFieldNova = new JPasswordField();
		passwordFieldNova.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordFieldNova.setBounds(91, 126, 195, 20);
		contentPane.add(passwordFieldNova);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCpf.setBounds(10, 25, 46, 14);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textCpf.setBounds(88, 23, 198, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conta conta = fachada.procurarConta(textCpf.getText());
				setContaDadosAlterados(conta);
				if(conta.getUsuario() instanceof Aluno || conta.getUsuario() instanceof Professor || conta.getUsuario() instanceof Tecnico){					
					textCpf.setEditable(false);
					textLogin.setText(conta.getLogin());
			}else{
				JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
				textCpf.setText("");
			}
		}});
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBuscar.setBounds(322, 22, 89, 23);
		contentPane.add(btnBuscar);
	}
}
