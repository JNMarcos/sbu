package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Servico;
import excecao.ContaNaoEncontradaException;
import excecao.SaldoInsuficienteException;
import negocio.Fachada;
import negocio.IFachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

/**
 * @author JN
 *
 */

public class TelaComprarFichaRU extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;

	private IFachada fachada = Fachada.getInstance();
	private Conta conta;
	private JRadioButton rdbtnAlmoco;
	private JRadioButton rdbtnJantar;
	private JSpinner spinnerQtdTiquetes;
	private final ButtonGroup escolhaRefeicao = new ButtonGroup();
	private JButton btnCancelar;
	private JButton btnConfirmar;


	public TelaComprarFichaRU(Conta conta) {
		setConta(conta);
		setTitle("$BU - Comprar ficha do RU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de almo\u00E7o que quer comprar:");
		lblEscolhaOTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEscolhaOTipo.setBounds(28, 76, 309, 19);
		contentPane.add(lblEscolhaOTipo);

		rdbtnAlmoco = new JRadioButton("Almo\u00E7o");
		rdbtnAlmoco.setSelected(true);
		escolhaRefeicao.add(rdbtnAlmoco);
		rdbtnAlmoco.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnAlmoco.setBounds(44, 112, 109, 23);
		contentPane.add(rdbtnAlmoco);

		rdbtnJantar = new JRadioButton("Jantar");
		escolhaRefeicao.add(rdbtnJantar);
		rdbtnJantar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnJantar.setBounds(44, 141, 109, 23);
		contentPane.add(rdbtnJantar);

		JLabel lblQuantidadeDeTiquetes = new JLabel("Quantidade de t\u00EDquetes");
		lblQuantidadeDeTiquetes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblQuantidadeDeTiquetes.setBounds(152, 171, 163, 19);
		contentPane.add(lblQuantidadeDeTiquetes);

		spinnerQtdTiquetes = new JSpinner();
		spinnerQtdTiquetes.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinnerQtdTiquetes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spinnerQtdTiquetes.setBounds(312, 172, 29, 20);
		contentPane.add(spinnerQtdTiquetes);

		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Tahoma", Font.ITALIC, 21));
		lblR$.setBounds(255, 40, 39, 25);
		contentPane.add(lblR$);

		JLabel lblSaldo = new JLabel("0.0");
		lblSaldo.setText("" + conta.getSaldo());
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblSaldo.setForeground(new Color(0, 128, 0));
		lblSaldo.setBounds(297, 31, 114, 38);
		contentPane.add(lblSaldo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCancelar.setBounds(154, 214, 99, 23);
		contentPane.add(btnCancelar);

		EventoBotaoCancelar acaoCancelar = new EventoBotaoCancelar(); 
		btnCancelar.addActionListener(acaoCancelar);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnConfirmar.setBounds(285, 214, 109, 23);
		contentPane.add(btnConfirmar);

		EventoBotaoConfirmar acaoConfirmar = new EventoBotaoConfirmar(); 
		btnConfirmar.addActionListener(acaoConfirmar);
	}
	public void setConta(Conta conta){
		this.conta = conta;
	}
	private class EventoBotaoCancelar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose(); 
			TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta); 
			telaPrincipalNaoADM.setVisible(true);

		}
	}

	//faz a compra do tíquete
	private class EventoBotaoConfirmar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) {
			//se radiobutton de Almoço está selecionado é porque 
			//é para comprar um tíquete almoço
			boolean isAlmoco = rdbtnAlmoco.isSelected();
			String escolha;
			double valorServico;

			if (isAlmoco){
				escolha = "almoço";
				if (conta.getUsuario() instanceof Aluno)
					valorServico = Servico.getPrecos().get("almocoAlunoRU");
				else 
					valorServico = Servico.getPrecos().get("almocoFuncionarioRU");

			} else {
				escolha = "jantar";
				if (conta.getUsuario() instanceof Aluno)
					valorServico = Servico.getPrecos().get("jantaAlunoRU");
				else 
					valorServico = Servico.getPrecos().get("jantaFuncionarioRU");
			}

			int quantidadeTiquetes = (int) spinnerQtdTiquetes.getValue();
			try{
			
				fachada.comprarFichaRU(conta, isAlmoco, quantidadeTiquetes);
				JOptionPane.showMessageDialog(null, "Operação realizada com sucesso." + 
						" Você comprou " + quantidadeTiquetes + " tipo " + escolha + ". Valor total da operação: " 
					+  (valorServico*quantidadeTiquetes) + ". Seu saldo é: " + conta.getSaldo());
			
				fachada.alterarDadosConta(conta) ;
				dispose();
				TelaPrincipalNaoADM tela = new TelaPrincipalNaoADM(conta);
				tela.setVisible(true);
		} catch (SaldoInsuficienteException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			dispose();
			TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta); 
			telaPrincipalNaoADM.setVisible(true);
		} catch (ContaNaoEncontradaException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			dispose();
			TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta); 
			telaPrincipalNaoADM.setVisible(true);
		}
			
	}
}
}

