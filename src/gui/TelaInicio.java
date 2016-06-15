/**
 * 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import classes_basicas.Servico;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author JN
 *
 */

public class TelaInicio extends JFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Servico.setPrecos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaInicio() {
		setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setResizable(false);
		setTitle("$BU - In\u00EDcio");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 444, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("$");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(151, 38, 72, 82);
		label.setFont(new Font("Segoe UI", Font.BOLD, 90));
		panel.add(label);
		
		JLabel lblBu = new JLabel("BU");
		lblBu.setForeground(new Color(0, 128, 128));
		lblBu.setFont(new Font("Segoe UI", Font.PLAIN, 53));
		lblBu.setBounds(187, 38, 137, 98);
		panel.add(lblBu);
		
		JLabel lbleuBancoUniversitrio = new JLabel("$eu banco universit\u00E1rio.");
		lbleuBancoUniversitrio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbleuBancoUniversitrio.setBounds(118, 122, 153, 14);
		panel.add(lbleuBancoUniversitrio);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			}
		});
		btnLogar.setBounds(46, 202, 89, 23);
		panel.add(btnLogar);
		
		JButton btnEntrarNoRu = new JButton("Entrar no RU");
		btnEntrarNoRu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaSimularRU telaSimularRU = new TelaSimularRU();
				telaSimularRU.setVisible(true);
			}
		});
		btnEntrarNoRu.setBounds(284, 202, 126, 23);
		panel.add(btnEntrarNoRu);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
