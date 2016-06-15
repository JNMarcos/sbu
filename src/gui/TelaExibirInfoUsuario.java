/**
 * 
 */
package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classes_basicas.ADMBiblioteca;
import classes_basicas.ADMGeral;
import classes_basicas.Conta;
import java.awt.Font;

/**
 * @author JN
 *
 */
public class TelaExibirInfoUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Conta conta;

	private JPanel panel;
	private JButton btnVoltar;

	public TelaExibirInfoUsuario(Conta conta){
		setConta(conta);

		setResizable(false); 
		setTitle("$BU - Dados cadastrais"); 
		getContentPane().setBackground(SystemColor.activeCaption); 
		setBounds(100, 100, 437, 405); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setLayout(null);; 

		panel = new JPanel(); 
		panel.setBounds(0, 0, 434, 379); 
		getContentPane().add(panel); 
		panel.setLayout(null); 

		JLabel lblInformaesDoVendedor = new JLabel("SOBRE"); 
		lblInformaesDoVendedor.setFont(new Font("Segoe UI", Font.PLAIN, 48));
		lblInformaesDoVendedor.setBounds(10, 11, 152, 53); 
		panel.add(lblInformaesDoVendedor); 
		lblInformaesDoVendedor.setHorizontalAlignment(SwingConstants.LEFT); 

		JLabel lblCpf = new JLabel("CPF"); 
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCpf.setBounds(31, 148, 378, 28); 
		lblCpf.setText(conta.getUsuario().getCpf()); 
		panel.add(lblCpf); 

		JLabel lblNome = new JLabel("NOME"); 
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNome.setBounds(31, 75, 363, 33); 
		lblNome.setText(conta.getUsuario().getNome()); 
		panel.add(lblNome); 

		btnVoltar = new JButton("Voltar"); 
		btnVoltar.setBounds(45, 345, 152, 23); 
		panel.add(btnVoltar); 

		EventoVoltar acaoVoltar = new EventoVoltar(); 
		btnVoltar.addActionListener(acaoVoltar); 


		JLabel lblEmail = new JLabel("E-MAIL"); 
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmail.setBounds(31, 260, 378, 26); 
		lblEmail.setText(conta.getUsuario().getEmail()); 
		panel.add(lblEmail); 


		JLabel lblSenha = new JLabel("SENHA"); 
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSenha.setBounds(31, 307, 200, 27); 
		lblSenha.setText(conta.getSenha()); 
		panel.add(lblSenha);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEndereco.setBounds(31, 222, 393, 27);
		lblEndereco.setText(conta.getUsuario().getEndereco());
		panel.add(lblEndereco);
		
		JLabel labelIdentidade = new JLabel("Identidade");
		labelIdentidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelIdentidade.setBounds(31, 186, 363, 25);
		labelIdentidade.setText(conta.getUsuario().getIdentidade());
		panel.add(labelIdentidade);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSexo.setBounds(31, 109, 363, 28);
		String sexo;
		if (conta.getUsuario().getSexo() == 'M') sexo = "Masculino";
		else sexo = "Feminino";
		lblSexo.setText(sexo);
		panel.add(lblSexo);
	}

	private class EventoVoltar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			if (conta.getUsuario() instanceof ADMBiblioteca){
				TelaPrincipalADMBiblioteca telaADMBiblio = new TelaPrincipalADMBiblioteca(conta);
				telaADMBiblio.setVisible(true);
			} else if (conta.getUsuario() instanceof ADMGeral){
				TelaPrincipalADMGeral telaADMGeral = new TelaPrincipalADMGeral(conta);
				telaADMGeral.setVisible(true);
			} else {
				TelaPrincipalNaoADM telaNaoADM  = new TelaPrincipalNaoADM(conta);
				telaNaoADM.setVisible(true);
			}
		}
	}

	private void setConta(Conta conta) {
		this.conta = conta;
	}

}
