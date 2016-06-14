/**
 * 
 */
package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import excecao.ContaNaoEncontradaException;
import excecao.FichasInsuficientesException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;
import negocio.Fachada;
import negocio.IFachada;

/**
 * @author JN
 *
 */
public class TelaSimularRU extends JFrame {

	private static final long serialVersionUID = 1L;

	private IFachada fachada = Fachada.getInstance();
	private JPanel panel;
	private JButton btnConfirmar;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private JButton btnVoltar;
	private JRadioButton rdbtnAlmoco;
	private JRadioButton rdbtnJantar;
	private ButtonGroup escolhaRefeicao;

	public TelaSimularRU() {
		setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setResizable(false);
		setTitle("Simular RU");
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 444, 215);
		getContentPane().add(panel);
		panel.setLayout(null);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(167, 90, 208, 24);
		textFieldLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(167, 47, 208, 24);
		panel.add(textFieldSenha);

		JLabel lblInsiraSeuLogin = new JLabel("Insira seu login");
		lblInsiraSeuLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInsiraSeuLogin.setBounds(28, 50, 96, 18);
		panel.add(lblInsiraSeuLogin);

		JLabel lblInsiraSuaSenha = new JLabel("Insira sua senha");
		lblInsiraSuaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInsiraSuaSenha.setBounds(28, 93, 96, 18);
		panel.add(lblInsiraSuaSenha);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnConfirmar.setBounds(189, 181, 101, 23);
		panel.add(btnConfirmar);

		EventoBotaoConfirmar acaoConfirmar = new EventoBotaoConfirmar();
		btnConfirmar.addActionListener(acaoConfirmar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnVoltar.setBounds(321, 181, 89, 23);
		panel.add(btnVoltar);

		EventoBotaoVoltar acaoVoltar = new EventoBotaoVoltar();
		btnVoltar.addActionListener(acaoVoltar);

		rdbtnAlmoco = new JRadioButton("Almo\u00E7o");
		rdbtnAlmoco.setSelected(true);
		rdbtnAlmoco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnAlmoco.setBounds(28, 136, 109, 23);
		panel.add(rdbtnAlmoco);

		rdbtnJantar = new JRadioButton("Jantar");
		rdbtnJantar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnJantar.setBounds(154, 137, 109, 23);
		panel.add(rdbtnJantar);

		escolhaRefeicao = new ButtonGroup();
		escolhaRefeicao.add(rdbtnAlmoco);
		escolhaRefeicao.add(rdbtnJantar);
	}

	private class EventoBotaoConfirmar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			boolean isAlmoco = rdbtnAlmoco.isSelected();
			try {
				fachada.simularRU(fachada.verificarLogin(textFieldLogin.getText(), textFieldSenha.getText()),
						isAlmoco );
				JOptionPane.showMessageDialog(null, "Tudo certo, pode entrar na RUlândia!");
			} catch (SenhaIncorretaException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (ContaNaoEncontradaException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (FichasInsuficientesException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (UsuarioNaoEncontradoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			textFieldLogin.setText("");
			textFieldSenha.setText("");
		}
	}

	private class EventoBotaoVoltar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose();
			TelaPrincipal telaPrincipal = new TelaPrincipal(); 
			telaPrincipal.setVisible(true);

		}
	}
}
