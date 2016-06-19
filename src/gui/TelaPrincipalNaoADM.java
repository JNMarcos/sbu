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
import javax.swing.border.EmptyBorder;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Tecnico;
import negocio.Fachada;

public class TelaPrincipalNaoADM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fachada fachada;
	private Conta conta;
	private JPanel panel;
	private JComboBox<String> comboBoxServico;
	private TelaLogin telaLogin;
	
	
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
		//panel.setBounds(0, 0, 444, 271); O PROBLEMA ESTÁ AQUI
		setBounds(100, 100, 444, 272); //AQUI É A SOLUÇÃO
		setContentPane(panel); //AQUI É A SOLUÇÃO
		//getContentPane().add(panel);  O PROBLEMA ESTÁ AQUI
		panel.setLayout(null);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		lblR$.setBounds(237, 30, 37, 20);
		panel.add(lblR$);
		
		JLabel lblSaldo = new JLabel("");
		lblSaldo.setForeground(new Color(0, 204, 0));
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblSaldo.setBounds(284, 29, 117, 19);
		panel.add(lblSaldo);
		
		comboBoxServico = new JComboBox<String>();
		comboBoxServico.setBounds(38, 96, 166, 20);
		String[] opcoes = {"Comprar Ficha do R.U", "Pagar Multa da Biblioteca",
							"Solicitar Documentos", "Inserir Credito", "Ver Movimentações", "Exibir Informações"};
		
		for(int i = 0; i<6;i++)
			comboBoxServico.addItem(opcoes[i]);
		panel.add(comboBoxServico);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String escolhido = comboBoxServico.getSelectedItem().toString();
				if(escolhido.equals("Comprar Ficha do R.U")){
					
					TelaComprarFichaRU telaComprarFichaRU = new TelaComprarFichaRU(conta); 
					telaComprarFichaRU.setVisible(true);
					dispose();
				}
				else if(escolhido.equals("Pagar Multa da Biblioteca")){
					
					TelaPagarDivida telaPagarDivida = new TelaPagarDivida(conta);
					telaPagarDivida.setVisible(true);
					dispose();
				}
				else if(escolhido.equals("Solicitar Documentos")){
					
					TelaSolicitarDocumento telaSolicitarDocumento = new TelaSolicitarDocumento(conta);
					telaSolicitarDocumento.setVisible(true);
					dispose();
				}
				else if(escolhido.equals("Inserir Credito")){
					
					TelaInserirCredito telaInserirCredito = new TelaInserirCredito(conta);
					telaInserirCredito.setVisible(true);
					dispose();
				}
				else if(escolhido.equals("Ver Movimentações")){
					
					TelaMovimentacao telaMovimentacao = new TelaMovimentacao(conta);
					telaMovimentacao.setVisible(true);
					dispose();
				}
				else if(escolhido.equals("Exibir Informações")){
					//dispose();
					TelaExibirInfoUsuario telaExibirInfoUsuario = new TelaExibirInfoUsuario(conta);
					telaExibirInfoUsuario.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Escolha uma ação! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmar.setBounds(282, 95, 101, 23);
		panel.add(btnConfirmar);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				dispose();
				
			}
		});
		btnLogout.setBounds(282, 174, 101, 23);
		panel.add(btnLogout);
		
		JLabel lblNrFichasAlmoco = new JLabel();
		lblNrFichasAlmoco.setBounds(44, 159, 201, 14);
		lblNrFichasAlmoco.setText("Numero de fichas de almo\u00E7o: " + conta.getnPorcoes()[0]);
		panel.add(lblNrFichasAlmoco);
		
		JLabel lblNrDeFichasJantar = new JLabel();
		lblNrDeFichasJantar.setBounds(44, 197, 201, 14);
		lblNrDeFichasJantar.setText("Numero de fichas de jantar: " + conta.getnPorcoes()[1]);
		panel.add(lblNrDeFichasJantar);
		
		
		
		
		
			
		}
	
		
	
	private void setConta(Conta conta) {
		this.conta = conta;
		}	
}
