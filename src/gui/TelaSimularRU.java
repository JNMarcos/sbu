package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.ContaNaoEncontradaException;
import excecao.FichasInsuficientesException;
import excecao.SenhaIncorretaException;
import excecao.UsuarioNaoEncontradoException;
import negocio.Fachada;
import negocio.IFachada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSimularRU extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private static final long serialVersionUID = 1L;

	private IFachada fachada = Fachada.getInstance();
	private JRadioButton rdbtnAlmoco;
	private final ButtonGroup escolhaRefeicaoo = new ButtonGroup();

	public TelaSimularRU() {
		setTitle("$BU - Simular RU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnConfirmar.setBounds(162, 176, 100, 23);
		contentPane.add(btnConfirmar);
		
		EventoBotaoConfirmar acaoConfirmar = new EventoBotaoConfirmar();
		btnConfirmar.addActionListener(acaoConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnVoltar.setBounds(286, 176, 100, 23);
		contentPane.add(btnVoltar);
		
		EventoBotaoVoltar acaoVoltar = new EventoBotaoVoltar();
		btnVoltar.addActionListener(acaoVoltar);
		
		JRadioButton rdbtnAlmoco = new JRadioButton("Almo\u00E7o");
		escolhaRefeicaoo.add(rdbtnAlmoco);
		rdbtnAlmoco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnAlmoco.setBounds(19, 114, 109, 23);
		contentPane.add(rdbtnAlmoco);
		
		JRadioButton rdbtnJantar = new JRadioButton("Jantar");
		escolhaRefeicaoo.add(rdbtnJantar);
		rdbtnJantar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnJantar.setBounds(130, 114, 109, 23);
		contentPane.add(rdbtnJantar);
		
		JLabel lblInsiraSeuLogin = new JLabel("Insira seu login");
		lblInsiraSeuLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInsiraSeuLogin.setBounds(19, 44, 109, 23);
		contentPane.add(lblInsiraSeuLogin);
		
		JLabel lblInsiraSuaSenha = new JLabel("Insira sua senha");
		lblInsiraSuaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInsiraSuaSenha.setBounds(19, 78, 109, 29);
		contentPane.add(lblInsiraSuaSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldLogin.setBounds(162, 45, 164, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(162, 82, 164, 20);
		contentPane.add(textFieldSenha);
	}
	private class EventoBotaoConfirmar implements ActionListener { 
		public void actionPerformed(ActionEvent evento) { 
			dispose();
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
			TelaInicio telaPrincipal = new TelaInicio(); 
			telaPrincipal.setVisible(true);

		}
	}
}
