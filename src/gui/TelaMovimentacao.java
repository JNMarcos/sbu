package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import classes_basicas.Conta;
import classes_basicas.Movimentacao;
import negocio.Fachada;
import negocio.IFachada;

public class TelaMovimentacao extends JFrame {
	
	/**
	 * @author Marcos Inacio de Paula Lima
	 */

	private IFachada fachada = Fachada.getInstance();
	private Conta conta;
	
	private JList lista;
	private JButton btnCancelar;
	private JScrollPane painel;
	private JPanel panel;
	private List<Movimentacao> historico;
	public TelaMovimentacao(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Movimentações");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		setBounds(0, 0, 445, 315);
		setContentPane(panel);
		panel.setLayout(null);
		
		painel = new JScrollPane();
		painel.setBounds(10, 46, 419, 147);
		panel.add(painel);
		
		
		historico = conta.getHistorico();
		String[] nomeServicos = new String[historico.size()];
		String[] descricao = new String[historico.size()];
		LocalDateTime[] data = new LocalDateTime[historico.size()];
		Movimentacao movimentacao;
		String[] total = new String[historico.size()];
		int contador = 0;
		for(int i = historico.size()-1; i > 0 ;i--){
			movimentacao = historico.get(i);
			nomeServicos[i] = movimentacao.getNomeServico();
			descricao[i] = movimentacao.getDescricao();
			data[i] = movimentacao.getDataHora();
			total[contador] =  nomeServicos[i] +", "+ descricao[i] + " " + data[i].toString()+"\n";
			contador++;
		}
		
		lista = new JList(total);
		painel.setViewportView(lista);
		lista.setVisibleRowCount(4);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(176, 232, 87, 23);
		EventoBotaoCancelar acaoCancelar = new EventoBotaoCancelar(); 
		btnCancelar.addActionListener(acaoCancelar);
		panel.add(btnCancelar);
	}
	private void setConta(Conta conta) {
		this.conta = conta;
	}
	private class EventoBotaoCancelar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose(); 
			TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
			telaPrincipalNaoADM.setVisible(true);
		}
	}
}
