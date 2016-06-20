package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classes_basicas.Conta;
import negocio.Fachada;
import negocio.IFachada;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

public class TelaMovimentacao extends JFrame {
	
	/**
	 * @author Marcos Inacio de Paula Lima
	 */

	private IFachada fachada = Fachada.getInstance();
	private Conta conta;
	
	private JList lista;
	private JButton mbExibir;
	private static String[] nomes = {"Inserir Crédito", "Pagar Dívida", "Comprar Ficha RU", "Solicitar Documento DRCA"};
	private JScrollPane painel;
	private JPanel panel;

	public TelaMovimentacao(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Movimentações");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		setBounds(0, 0, 418, 343);
		setContentPane(panel);
		panel.setLayout(null);
		
		painel = new JScrollPane();
		painel.setBounds(41, 46, 151, 66);
		panel.add(painel);
		
		lista = new JList(nomes);
		painel.setViewportView(lista);
		lista.setVisibleRowCount(4);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		mbExibir = new JButton("Exibir");
		mbExibir.setBounds(225, 60, 87, 23);
		EventoBotaoExibir acaoExibir = new EventoBotaoExibir(); 
		mbExibir.addActionListener(acaoExibir);
		panel.add(mbExibir);
	}
	private void setConta(Conta conta) {
		this.conta = conta;
	}
	private class EventoBotaoExibir implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose(); 
			int index = lista.getSelectedIndex();
			if(index == 0){
				TelaInserirCredito telaInserirCredito = new TelaInserirCredito(conta);
				telaInserirCredito.setVisible(true);
			}
			else if(index == 1){
				TelaPagarDivida telaPagarDivida = new TelaPagarDivida(conta);
				telaPagarDivida.setVisible(true);
			}
			else if(index == 2){
				TelaComprarFichaRU telaComprarFichaRU = new TelaComprarFichaRU(conta);
				telaComprarFichaRU.setVisible(true);
			}
			else{
				TelaSolicitarDocumento telaSolicitarDocumento = new TelaSolicitarDocumento(conta);
				telaSolicitarDocumento.setVisible(true);
			}
		}
	}
}
