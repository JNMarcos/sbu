package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Tecnico;
import negocio.Fachada;

public class TelaPrincipalNaoADM extends JFrame {

	private Fachada fachada;
	private Conta conta;
	private JPanel panel;
	
	
	
	public TelaPrincipalNaoADM(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Sistema Bancário Universitário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();

		panel = new JPanel();
		panel.setBounds(0, 0, 543, 187);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		lblR$.setBounds(398, 30, 37, 20);
		panel.add(lblR$);
		
		JLabel lblSaldo = new JLabel("");
		lblSaldo.setForeground(new Color(0, 204, 0));
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblSaldo.setBounds(435, 29, 46, 19);
		panel.add(lblSaldo);
		
		JComboBox comboBoxServico = new JComboBox();
		comboBoxServico.setBounds(122, 126, 28, 20);
		String[] opcoes = {"Comprar Ficha do R.U", "Pagar Multa da Biblioteca",
							"Solicitar Documentos", "Inserir Credito, Ver Movimentações"};
		
		for(int i = 0; i<5;i++)
			comboBoxServico.addItem(opcoes[i]);
		panel.add(comboBoxServico);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String escolhido = comboBoxServico.getSelectedItem().toString();
				if(escolhido.equals("Comprar Ficha do R.U")){
					dispose();
					TelaComprarFichaRU telaComprarFichaRU = new TelaComprarFichaRU(conta); 
					telaComprarFichaRU.setVisible(true);
				}
				else if(escolhido.equals("Pagar Multa da Biblioteca")){
					dispose();
					TelaPagarDivida telaPagarDivida = new TelaPagarDivida(conta);
					telaPagarDivida.setVisible(true);
				}
				else if(escolhido.equals("Solicitar Documentos")){
					dispose();
					TelaSolicitarDocumento telaSolicitarDocumento = new TelaSolicitarDocumento(conta);
					telaSolicitarDocumento.setVisible(true);
				}
				else if(escolhido.equals("Inserir Credito")){
					dispose();
					TelaInserirCredito telaInserirCredito = new TelaInserirCredito(conta);
					telaInserirCredito.setVisible(true);
				}
				else if(escolhido.equals("Ver Movimentações")){
					dispose();
					TelaMovimentacao telaMovimentacao = new TelaMovimentacao(conta);
					telaMovimentacao.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Escolha uma ação! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmar.setBounds(310, 125, 89, 23);
		panel.add(btnConfirmar);
		
		
		
		
		
			
		}
	
		
	
	private void setConta(Conta conta) {
		this.conta = conta;
		}	
}
