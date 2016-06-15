package gui;
/*
 * 
 * author @ramices
 * 
 */
import javax.swing.JPanel;

import classes_basicas.Conta;

import javax.swing.JButton;
import javax.swing.JList;

import negocio.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalADMGeral extends JPanel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fachada fachada = Fachada.getInstance();
	private TelaLogin telaLogin;
	private Conta conta;
	
	public TelaPrincipalADMGeral(Conta conta) {
		setLayout(null);
		
		this.conta = conta;
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Usuario");
		btnCadastrarUsuario.setBounds(264, 168, 133, 23);
		add(btnCadastrarUsuario);
		
		JButton btnRemoverUsuario = new JButton("Remover Usuario");
		btnRemoverUsuario.setBounds(264, 56, 133, 23);
		add(btnRemoverUsuario);
		
		JButton btnAlterarUsuario = new JButton("Alterar Usuario");
		btnAlterarUsuario.setBounds(264, 111, 133, 23);
		add(btnAlterarUsuario);
		
		JList list = new JList();
		list.setBounds(24, 59, 200, 132);
		
		add(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			
			}
		});
		btnVoltar.setBounds(81, 250, 89, 23);
		add(btnVoltar);

	}
}
