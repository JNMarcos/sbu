package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_basicas.Servico;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaInicio extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setTitle("$BU - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnLogar.setBounds(73, 197, 110, 33);
		contentPane.add(btnLogar);
		
		JButton btnEntrarNoRu = new JButton("Entrar no RU");
		btnEntrarNoRu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEntrarNoRu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaSimularRU telaSimularRU = new TelaSimularRU();
				telaSimularRU.setVisible(true);
			}
		});
		btnEntrarNoRu.setBounds(232, 197, 148, 32);
		contentPane.add(btnEntrarNoRu);
		
		JLabel lblSeuBancoUniversitario = new JLabel("Seu banco Universit\u00E1rio");
		lblSeuBancoUniversitario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSeuBancoUniversitario.setBounds(114, 117, 166, 14);
		contentPane.add(lblSeuBancoUniversitario);
		
		JLabel label = new JLabel("$");
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(120, 67, 46, 51);
		contentPane.add(label);
		
		JLabel lblBu = new JLabel("BU");
		lblBu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		lblBu.setBounds(137, 81, 46, 29);
		contentPane.add(lblBu);
	}
}

