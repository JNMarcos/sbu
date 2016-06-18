package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.DoublePredicate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import classes_basicas.Conta;
import classes_basicas.Divida;
import excecao.SaldoInsuficienteException;
import negocio.Fachada;
import javax.swing.JLabel;

public class TelaPagarDivida extends JFrame {

	private JPanel panel;
	private Fachada fachada;
	private Conta conta;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnPagar;
	private JButton btnCancelar;
	

	
	public TelaPagarDivida(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Multas da Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		
		modelo = new DefaultTableModel();
		modelo.setRowCount(0);
		modelo.addColumn("Descrição");
		modelo.addColumn("Data de Emissão");
		modelo.addColumn("Hora de Emissão");
		modelo.addColumn("Valor");
		
		
		panel = new JPanel();
		//panel.setBounds(0, 0, 590, 494);
		setBounds(100, 100, 413, 272); //AQUI É A SOLUÇÃO
		setContentPane(panel); //AQUI É A SOLUÇÃO
		//getContentPane().add(panel);
		panel.setLayout(null);
		
		
		table = new JTable(modelo);
		table.setFont(new Font("Gisha", Font.PLAIN, 13));
		carregarTabela(modelo, conta.getDividas());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 92, 523, 291);
		panel.add(scrollPane);
		
		JLabel lblSaldo = new JLabel("");
		lblSaldo.setForeground(new Color(0, 204, 0));
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblSaldo.setBounds(473, 36, 46, 23);
		panel.add(lblSaldo);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		lblR$.setBounds(417, 36, 36, 23);
		panel.add(lblR$);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = table.getSelectedRow();
				String descricao;
				LocalDate dataEmissao;
				LocalTime horaEmissao;
				double valor;
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null,
							"Nenhum produto selecionado! Selecione um para favoritar.");
				} else {
					double valorDivida = (double) table.getValueAt(linhaSelecionada, 3);
					if(valorDivida < conta.getSaldo()){
						double saldoAtual = conta.getSaldo() - valorDivida;
						conta.setSaldo(saldoAtual);
						dispose();
						TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
						telaPrincipalNaoADM.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null,
								"Saldo Insuficiente!");
					}
				}
				
				
				
			}
		});
		btnPagar.setBounds(106, 441, 89, 23);
		panel.add(btnPagar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
				telaPrincipalNaoADM.setVisible(true);
			}
		});
		btnCancelar.setBounds(409, 441, 89, 23);
		panel.add(btnCancelar);
		
		
		
	}
	private void setConta(Conta conta) {
		this.conta = conta;
		}
	public static void carregarTabela(DefaultTableModel modelo, List<Divida> dividas) {
		if (dividas != null) {
			for (Divida d : dividas) {
				if(d.estaPago() == false){
					modelo.addRow(new String[] {
							d.getDescricao(), "" + d.getDataEmissao(), "" + d.getHoraEmissao(), "" +d.getValor()});
				}
			}
			

		}
}
}
