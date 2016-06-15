package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import excecao.ContaJaCadastradaException;
import excecao.CpfJaExistenteException;
import negocio.Fachada;

public class TelaCadastroAluno extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldSexo;
	private JTextField textFieldCpf;
	private JTextField textFieldIdentidade;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldMatricula;
	private JTextField textFieldCurso;
	private JTextField textFieldAdmissao;
	private JTextField textFieldPeriodoAtual;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAno;
	private Fachada fachada;
	private Aluno aluno;
	private JPanel panel;
	private Conta conta;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	/**
	 * Create the panel.
	 */
	public TelaCadastroAluno(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Cadastrar Professor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 543, 728);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(70, 85, 112, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(70, 126, 112, 14);
		panel.add(lblSexo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(70, 167, 112, 14);
		panel.add(lblCpf);
		
		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setBounds(70, 208, 112, 14);
		panel.add(lblIdentidade);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(70, 249, 112, 14);
		panel.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(70, 290, 112, 14);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(70, 331, 112, 14);
		panel.add(lblEmail);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(70, 372, 112, 14);
		panel.add(lblDataDeNascimento);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(70, 413, 112, 14);
		panel.add(lblMatricula);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(70, 454, 112, 14);
		panel.add(lblCurso);
		
		JLabel lblPeriodoAdmissao = new JLabel("Periodo de Admiss\u00E3o:");
		lblPeriodoAdmissao.setBounds(70, 495, 112, 14);
		panel.add(lblPeriodoAdmissao);
		
		JLabel lblPeriodoAtual = new JLabel("Periodo Atual:");
		lblPeriodoAtual.setBounds(70, 536, 112, 14);
		panel.add(lblPeriodoAtual);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(192, 82, 303, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(192, 123, 303, 20);
		panel.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(192, 164, 303, 20);
		panel.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldIdentidade = new JTextField();
		textFieldIdentidade.setBounds(192, 205, 303, 20);
		panel.add(textFieldIdentidade);
		textFieldIdentidade.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(192, 246, 303, 20);
		panel.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(192, 287, 303, 20);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(192, 328, 303, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(192, 410, 303, 20);
		panel.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(192, 451, 303, 20);
		panel.add(textFieldCurso);
		textFieldCurso.setColumns(10);
		
		textFieldAdmissao = new JTextField();
		textFieldAdmissao.setBounds(192, 492, 303, 20);
		panel.add(textFieldAdmissao);
		textFieldAdmissao.setColumns(10);
		
		textFieldPeriodoAtual = new JTextField();
		textFieldPeriodoAtual.setBounds(192, 533, 303, 20);
		panel.add(textFieldPeriodoAtual);
		textFieldPeriodoAtual.setColumns(10);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(192, 369, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panel.add(comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(280, 369, 28, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panel.add(comboBoxMes);
		
		comboBoxAno = new JComboBox<String>();
		comboBoxAno.setBounds(362, 369, 28, 20);
		Integer ano = 2000;
		String[] arrayAno = new String[84];
		for(int i=0; i<84; i++, ano--) {
			if(i != 0) {
				arrayAno[i] = ano.toString();						
				comboBoxAno.addItem(arrayAno[i]);
			}
			else {
				arrayAno[i] = "";
				comboBoxAno.addItem(arrayAno[i]);
			}		
		}
		panel.add(comboBoxAno);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(70, 577, 112, 14);
		panel.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(192, 574, 303, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(70, 618, 112, 14);
		panel.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(192, 615, 303, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(155, 669, 89, 23);
		panel.add(btnCadastrar);
		EventoCadastrar acaoCadastrar = new EventoCadastrar();
		btnCadastrar.addActionListener(acaoCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta); 
				telaPrincipalADMGeral.setVisible(true);
			}
		});
		btnCancelar.setBounds(386, 669, 89, 23);
		panel.add(btnCancelar);
		
		
	}

	private void setConta(Conta conta) {
		this.conta = conta;
	}
	
	private class EventoCadastrar implements ActionListener{			
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				if(textFieldNome.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldSexo.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Sexo' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldCpf.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'CPF' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldIdentidade.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Identidade' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldEndereco.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Endereco' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldTelefone.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Telefone' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldEmail.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Email' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldMatricula.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Matricula' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldCurso.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Curso' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldAdmissao.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Periodo de Admissão' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldPeriodoAtual.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Periodo Atual' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldLogin.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Login' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldSenha.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Senha' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Conta contaACadastrar;
					LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
					aluno = new Aluno(textFieldNome.getText(), textFieldSexo.getText().charAt(0),
							textFieldCpf.getText(),textFieldIdentidade.getText(), textFieldEndereco.getText(),
							textFieldTelefone.getText(), textFieldEmail.getText(), dataDeNascimento,
							textFieldMatricula.getText(),textFieldCurso.getText(),textFieldAdmissao.getText(),
							Integer.parseInt(textFieldPeriodoAtual.getText()));
					fachada.cadastrarUsuario(aluno);
					contaACadastrar = new Conta(aluno, textFieldLogin.getText(), textFieldSenha.getText());
					fachada.cadastrarConta(contaACadastrar);
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
					dispose();
					TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta); 
					telaPrincipalADMGeral.setVisible(true);
				}
			}catch(CpfJaExistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				textFieldCpf.setText("");
			}catch(ContaJaCadastradaException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}	
		}
	}
}


