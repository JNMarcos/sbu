/**
 * 
 */
package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Servico;
import excecao.SaldoInsuficienteException;
import gui.TelaPrincipalNaoADM;
import negocio.Fachada;
import negocio.IFachada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

/**
 * @author JN
 *
 */
public class TelaComprarFichaRU extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IFachada fachada = Fachada.getInstance();
	private Conta conta;

	private JPanel panel ;
	private JLabel lblQuantidadeDeTiquetes;
	private JRadioButton rdbtnAlmoco;
	private JRadioButton rdbtnJantar;
	private ButtonGroup escolhaRefeicao;
	private JButton btnComprar;
	private JButton btnCancelar;
	private JSpinner spinnerQtdTiquetes;

	public TelaComprarFichaRU(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("Comprar Ficha do RU");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 444, 271);
		getContentPane().add(panel);
		panel.setLayout(null);

		rdbtnAlmoco = new JRadioButton("Almoço");
		rdbtnAlmoco.setSelected(true);
		rdbtnAlmoco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnAlmoco.setBounds(29, 105, 109, 23);
		panel.add(rdbtnAlmoco);

		rdbtnJantar = new JRadioButton("Jantar");
		rdbtnJantar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnJantar.setBounds(29, 137, 109, 23);
		panel.add(rdbtnJantar);

		escolhaRefeicao = new ButtonGroup();
		escolhaRefeicao.add(rdbtnAlmoco);
		escolhaRefeicao.add(rdbtnJantar);

		spinnerQtdTiquetes = new JSpinner();
		spinnerQtdTiquetes.setModel(new SpinnerNumberModel(new Short((short) 1), new Short((short) 1), new Short((short) 3), new Short((short) 1)));
		spinnerQtdTiquetes.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		spinnerQtdTiquetes.setBounds(351, 177, 41, 20);
		panel.add(spinnerQtdTiquetes);

		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de refei\u00E7\u00E3o que deseja comprar:");
		lblEscolhaOTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEscolhaOTipo.setBounds(29, 78, 381, 23);
		panel.add(lblEscolhaOTipo);

		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnComprar.setBounds(334, 237, 89, 23);
		panel.add(btnComprar);
		
		EventoBotaoConfirmar acaoConfirmar = new EventoBotaoConfirmar(); 
		btnComprar.addActionListener(acaoConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancelar.setBounds(211, 237, 89, 23);
		panel.add(btnCancelar);

		EventoBotaoCancelar acaoCancelar = new EventoBotaoCancelar(); 
		btnCancelar.addActionListener(acaoCancelar); 


		lblQuantidadeDeTiquetes = new JLabel("Quantidade de tíquetes");
		lblQuantidadeDeTiquetes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblQuantidadeDeTiquetes.setBounds(198, 180, 143, 14);
		panel.add(lblQuantidadeDeTiquetes);

		JLabel lblSaldo = new JLabel("SALDO");
		lblSaldo.setForeground(new Color(0, 204, 0));
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblSaldo.setBounds(323, 35, 100, 29);
		panel.add(lblSaldo);

		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		lblR$.setBounds(288, 37, 25, 28);
		panel.add(lblR$);
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

	//faz a compra do tíquete
	private class EventoBotaoConfirmar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose();
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

			short quantidadeTiquetes = (Short) spinnerQtdTiquetes.getValue();
			JOptionPane painel;
			try{
				painel = new JOptionPane("Você deseja confirmar a compra de " 
						+ quantidadeTiquetes + " do tipo " + escolha + "?", 
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
				painel.setVisible(true);
				Object valor = painel.getValue();
				if (valor instanceof Integer){
					if (((Integer) valor).intValue() == JOptionPane.YES_OPTION){
						fachada.comprarFichaRU(conta, isAlmoco);
						JOptionPane.showMessageDialog(null, "Operação realizada com sucesso." + 
								" Você comprou " + quantidadeTiquetes + " tipo " + escolha + ". Valor total da operação: " 
								+  (valorServico*quantidadeTiquetes) + ". Seu saldo é: " + conta.getSaldo());
					}
				}
			} catch (SaldoInsuficienteException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
				dispose();
				telaPrincipalNaoADM = new TelaPrincipalNaoADM(); 
				telaPrincipalNaoADM.setVisible(true);
			}
		}
	}
}