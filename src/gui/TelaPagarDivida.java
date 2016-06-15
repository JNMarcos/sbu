package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import classes_basicas.Conta;
import classes_basicas.Divida;
import negocio.Fachada;

public class TelaPagarDivida extends JFrame {

	private JPanel panel;
	private Fachada fachada;
	private Conta conta;
	private JTable table;
	

	
	public TelaPagarDivida(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Multas da Biblioteca");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 466, 330);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		int numeroDeDividas = conta.getDividas().size();
		table = new JTable(numeroDeDividas,6);
		table.setBounds(356, 62, -249, 207);
		panel.add(table);
		
	}
	private void setConta(Conta conta) {
		this.conta = conta;
		}	
}
