package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes_basicas.Conta;
import classes_basicas.Professor;
import excecao.ContaJaCadastradaException;
import excecao.CpfJaExistenteException;
import negocio.Fachada;

public class TelaCadastroProfessor extends JFrame {
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
	private Fachada fachada;
	private Professor professor;
	private JTextField textFieldDepartamento;
	private JTextField textFieldNprofessor;
	private JPanel panel;
	private Conta conta;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAno;
	/**
	 * Create the panel.
	 */
	public TelaCadastroProfessor(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Cadastrar Professor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		
		panel = new JPanel();
		setBounds(0, 0, 565, 744);
		setContentPane(panel);
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
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(70, 413, 112, 14);
		panel.add(lblDepartamento);
		
		JLabel lblNprofessor = new JLabel("nProfessor:");
		lblNprofessor.setBounds(70, 454, 112, 14);
		panel.add(lblNprofessor);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setBounds(192, 410, 303, 20);
		panel.add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);
		
		textFieldNprofessor = new JTextField();
		textFieldNprofessor.setBounds(192, 451, 303, 20);
		panel.add(textFieldNprofessor);
		textFieldNprofessor.setColumns(10);
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(192, 369, 41, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panel.add(comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(280, 369, 41, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panel.add(comboBoxMes);
		
		comboBoxAno = new JComboBox<String>();
		comboBoxAno.setBounds(362, 369, 41, 20);
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
		lblLogin.setBounds(70, 495, 112, 14);
		panel.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(192, 492, 303, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(70, 536, 112, 14);
		panel.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(192, 533, 303, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		EventoCadastrar acaoCadastrar = new EventoCadastrar();
		btnCadastrar.addActionListener(acaoCadastrar);
		btnCadastrar.setBounds(144, 615, 101, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta); 
				telaPrincipalADMGeral.setVisible(true);
			}
		});
		btnCancelar.setBounds(362, 615, 101, 23);
		panel.add(btnCancelar);
	}

	private void setConta(Conta conta) {
	this.conta = conta;
	}
	
	private class EventoCadastrar implements ActionListener{
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
				else if(textFieldDepartamento.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Departamento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldNprofessor.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'nProfessor' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldLogin.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Login' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else if(textFieldSenha.equals("")){
					JOptionPane.showMessageDialog(null, "O campo 'Senha' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Conta contaASerCadastrada;

					DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					
					int mesInteiro = comboBoxMes.getSelectedIndex();
					String mes;
					
					if(mesInteiro < 10)
						mes ="0" + Integer.toString(mesInteiro);
					else
						mes = Integer.toString(mesInteiro);
					
					LocalDate dataDeNascimento = LocalDate.parse( ((String)comboBoxAno.getSelectedItem()) + "-" + mes + "-" + ((String)comboBoxDia.getSelectedItem()), formato);
					
					professor = new Professor(textFieldNome.getText(), textFieldSexo.getText().charAt(0),
							textFieldCpf.getText(),textFieldIdentidade.getText(), textFieldEndereco.getText(),
							textFieldTelefone.getText(), textFieldEmail.getText(), dataDeNascimento,
							textFieldDepartamento.getText(),textFieldNprofessor.getText());
					fachada.cadastrarUsuario(professor);
					contaASerCadastrada = new Conta(professor, textFieldLogin.getText(), textFieldSenha.getText());
					fachada.cadastrarConta(contaASerCadastrada);
					JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
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
