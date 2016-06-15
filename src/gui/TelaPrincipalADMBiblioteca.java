package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

import classes_basicas.Conta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalADMBiblioteca extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Conta conta;
	
	
	public TelaPrincipalADMBiblioteca(Conta conta) {
		setLayout(null);
		
		this.conta = conta;
		
		JButton btnAdicionarDivida = new JButton("Adicionar Divida");
		btnAdicionarDivida.setBounds(10, 11, 109, 23);
		add(btnAdicionarDivida);
		
		JButton btnRemoverDivida = new JButton("Remover Divida");
		btnRemoverDivida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoverDivida.setBounds(10, 54, 109, 23);
		add(btnRemoverDivida);
		
		JButton btnAlterarDivida = new JButton("Alterar Divida");
		btnAlterarDivida.setBounds(10, 99, 109, 23);
		add(btnAlterarDivida);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(10, 240, 89, 23);
		add(btnLogout);
		
		table = new JTable();
		table.setBounds(148, 11, 269, 252);
		add(table);

	}

}
