package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import classes_basicas.Conta;

import javax.swing.JFrame;
import javax.swing.JLabel;

import negocio.Fachada;
import negocio.IFachada;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class TelaInserirCredito extends JFrame {

	/**
	 * @author Marcos Inacio de Paula Lima
	 */
	
	private static final long serialVersionUID = 1L;

	private IFachada fachada = Fachada.getInstance();
	private Conta conta;
	
	private JPanel panel ;
	private JLabel lblEscolhaOValor;
	private ButtonGroup escolhaValor;
	private JRadioButton rdbtnR;
	private JRadioButton rdbtnR_1;
	private JRadioButton rdbtnR_2;
	private JRadioButton rdbtnR_3;
	private JRadioButton rdbtnR_4;
	private JButton btnInserir;
	private JButton btnCancelar;
	
	public TelaInserirCredito() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("Inserir Credito");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 271);
		getContentPane().add(panel);
		panel.setLayout(null);

		rdbtnR = new JRadioButton("R$ 5,00");
		rdbtnR.setSelected(true);
		rdbtnR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnR.setBounds(41, 135, 109, 23);
		panel.add(rdbtnR);
		
		rdbtnR_1 = new JRadioButton("R$ 10,00");
		rdbtnR_1.setSelected(true);
		rdbtnR_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnR_1.setBounds(41, 157, 109, 23);
		panel.add(rdbtnR_1);
		
		rdbtnR_2 = new JRadioButton("R$ 20,00");
		rdbtnR_2.setSelected(true);
		rdbtnR_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnR_2.setBounds(41, 180, 109, 23);
		panel.add(rdbtnR_2);
		
		rdbtnR_3 = new JRadioButton("R$ 50,00");
		rdbtnR_3.setSelected(true);
		rdbtnR_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnR_3.setBounds(41, 203, 109, 23);
		panel.add(rdbtnR_3);
		
		rdbtnR_4 = new JRadioButton("R$ 2,00");
		rdbtnR_4.setSelected(true);
		rdbtnR_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnR_4.setBounds(41, 114, 109, 23);
		panel.add(rdbtnR_4);
		
		lblEscolhaOValor = new JLabel("Escolha o valor desejado:");
		lblEscolhaOValor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEscolhaOValor.setBounds(38, 90, 164, 14);
		panel.add(lblEscolhaOValor);
		
		btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnInserir.setBounds(345, 237, 89, 23);
		panel.add(btnInserir);
		
		EventoBotaoInserir acaoInserir = new EventoBotaoInserir(); 
		btnInserir.addActionListener(acaoInserir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancelar.setBounds(231, 237, 89, 23);
		panel.add(btnCancelar);
		
		EventoBotaoCancelar acaoCancelar = new EventoBotaoCancelar(); 
		btnCancelar.addActionListener(acaoCancelar); 
		
		escolhaValor = new ButtonGroup();
		escolhaValor.add(rdbtnR);
		escolhaValor.add(rdbtnR_1);
		escolhaValor.add(rdbtnR_2);
		escolhaValor.add(rdbtnR_3);
		escolhaValor.add(rdbtnR_4);
		
	}
	
	public void setConta(Conta conta){
		this.conta = conta;
	}
	
	private class EventoBotaoCancelar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose(); 
			telaPrincipalNaoADM = new TelaPrincipalNaoADM(); 
			telaPrincipalNaoADM.setVisible(true);

		}
	}
	
	private class EventoBotaoInserir implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose();
			double valorEscolhido;
			if(rdbtnR.isSelected()){
				valorEscolhido = 5.00;
				conta.getSaldo();
				conta.setSaldo(conta.getSaldo()+valorEscolhido);
			}
			else if(rdbtnR_1.isSelected()){
				valorEscolhido = 10.00;
				conta.getSaldo();
				conta.setSaldo(conta.getSaldo()+valorEscolhido);
			}
			else if(rdbtnR_2.isSelected()){
				valorEscolhido = 20.00;
				conta.getSaldo();
				conta.setSaldo(conta.getSaldo()+valorEscolhido);
			}
			else if(rdbtnR_3.isSelected()){
				valorEscolhido = 50.00;
				conta.getSaldo();
				conta.setSaldo(conta.getSaldo()+valorEscolhido);
			}
			else{
				valorEscolhido = 2.00;
				conta.getSaldo();
				conta.setSaldo(conta.getSaldo()+valorEscolhido);
			}
			//TA INCOMPLETO ESTÁ PARTE
		}
	}	
}
