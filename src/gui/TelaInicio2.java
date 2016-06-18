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

public class TelaInicio2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Servico.setPrecos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio2 frame = new TelaInicio2();
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
	public TelaInicio2() {
		setTitle("$BU - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnLogar.setBounds(114, 199, 89, 29);
		contentPane.add(btnLogar);
		
		JButton btnEntrarNoRu = new JButton("Entrar no RU");
		btnEntrarNoRu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaSimularRU telaSimularRU = new TelaSimularRU();
				telaSimularRU.setVisible(true);
			}
		});
		btnEntrarNoRu.setBounds(266, 197, 109, 32);
		contentPane.add(btnEntrarNoRu);
		
		JLabel lblSeuBancoUniversitario = new JLabel("Seu banco Universitario");
		lblSeuBancoUniversitario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSeuBancoUniversitario.setBounds(120, 129, 166, 14);
		contentPane.add(lblSeuBancoUniversitario);
	}
}


