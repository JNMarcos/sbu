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

import classes_basicas.ADMBiblioteca;
import classes_basicas.Conta;
import classes_basicas.Tecnico;
import excecao.CpfJaExistenteException;
import negocio.Fachada;

public class TelaCadastroTecnico extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fachada fachada;
	private Tecnico tecnico;
	private Conta conta;
	
	private JPanel panel;
	private JTextField textFieldNome;
	private JTextField textFieldSexo;
	private JTextField textFieldCpf;
	private JTextField textFieldIdentidade;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldArea;
	private JTextField textFieldDepartamento;
	private JTextField textFieldNtecnico;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;
	/**
	 * Create the panel.
	 */
	public TelaCadastroTecnico(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("Cadastrar Técnico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		fachada = Fachada.getInstance();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 473, 666);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNome.setBounds(32, 29, 52, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSexo.setBounds(32, 64, 52, 14);
		panel.add(lblSexo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCpf.setBounds(32, 101, 52, 14);
		panel.add(lblCpf);
		
		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblIdentidade.setBounds(32, 143, 70, 14);
		panel.add(lblIdentidade);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEndereco.setBounds(32, 181, 70, 14);
		panel.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefone.setBounds(33, 228, 112, 14);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmail.setBounds(32, 266, 112, 14);
		panel.add(lblEmail);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDataDeNascimento.setBounds(32, 307, 139, 14);
		panel.add(lblDataDeNascimento);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldNome.setBounds(94, 26, 340, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldSexo.setBounds(94, 61, 340, 20);
		panel.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldCpf.setBounds(94, 98, 340, 20);
		panel.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldIdentidade = new JTextField();
		textFieldIdentidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldIdentidade.setBounds(113, 140, 321, 20);
		panel.add(textFieldIdentidade);
		textFieldIdentidade.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldEndereco.setBounds(102, 178, 332, 20);
		panel.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldTelefone.setBounds(102, 226, 332, 20);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldEmail.setBounds(87, 264, 347, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblArea.setBounds(32, 353, 112, 14);
		panel.add(lblArea);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(32, 399, 90, 14);
		panel.add(lblDepartamento);
		
		JLabel lblNtecnico = new JLabel("Número Técnico:");
		lblNtecnico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNtecnico.setBounds(32, 437, 113, 14);
		panel.add(lblNtecnico);
		
		textFieldArea = new JTextField();
		textFieldArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldArea.setBounds(94, 351, 340, 20);
		panel.add(textFieldArea);
		textFieldArea.setColumns(10);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldDepartamento.setBounds(132, 397, 302, 20);
		panel.add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);
		
		textFieldNtecnico = new JTextField();
		textFieldNtecnico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldNtecnico.setBounds(142, 434, 292, 20);
		panel.add(textFieldNtecnico);
		textFieldNtecnico.setColumns(10);
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(185, 305, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		panel.add(comboBoxDia);
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(277, 305, 28, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		panel.add(comboBoxMes);
		
		JComboBox<String> comboBoxAno = new JComboBox<String>();
		comboBoxAno.setBounds(362, 305, 28, 20);
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
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(392, 559, 28, 20);
		String[] tipo = { "Administrador da biblioteca", "Técnico comum" };
		comboBoxTipo.addItem(tipo[0]);
		comboBoxTipo.addItem(tipo[1]);
		panel.add(comboBoxTipo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
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
					
					else{
						Conta conta;
						LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
						if(comboBoxTipo.getSelectedItem().equals(tipo[0])){
							tecnico = new ADMBiblioteca(textFieldNome.getText(), textFieldSexo.getText().charAt(0),
									textFieldCpf.getText(),textFieldIdentidade.getText(), textFieldEndereco.getText(),
									textFieldTelefone.getText(), textFieldEmail.getText(), dataDeNascimento,
									textFieldArea.getText(),textFieldDepartamento.getText(), textFieldNtecnico.getText());
							fachada.cadastrarUsuario(tecnico);
							conta = new Conta(tecnico, textFieldLogin.getText(), textFieldSenha.getText());
							fachada.cadastrarConta(conta);
							JOptionPane.showMessageDialog(null, "Técnico cadastrado com sucesso!");
							dispose();
							TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(this.conta); 
							telaPrincipalADMGeral.setVisible(true);
						}
						else if(comboBoxTipo.getSelectedItem().equals(tipo[1])){
							tecnico = new Tecnico(textFieldNome.getText(), textFieldSexo.getText().charAt(0),
									textFieldCpf.getText(),textFieldIdentidade.getText(), textFieldEndereco.getText(),
									textFieldTelefone.getText(), textFieldEmail.getText(), dataDeNascimento,
									textFieldArea.getText(),textFieldDepartamento.getText(), textFieldNtecnico.getText());
							fachada.cadastrarUsuario(tecnico);
							conta = new Conta(tecnico, textFieldLogin.getText(), textFieldSenha.getText());
							fachada.cadastrarConta(conta);
							JOptionPane.showMessageDialog(null, "Técnico cadastrado com sucesso!");
							dispose();
							TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(this.conta); 
							telaPrincipalADMGeral.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null, "Selecione tecnico comum ou administrador!", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
						}
					}
				}catch(CpfJaExistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					textFieldCpf.setText("");
				}
			}
		});
		btnCadastrar.setBounds(160, 610, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(this.conta); 
				telaPrincipalADMGeral.setVisible(true);
			}
		});
		btnCancelar.setBounds(345, 610, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipo.setBounds(237, 561, 41, 14);
		panel.add(lblTipo);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLogin.setBounds(32, 476, 46, 20);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSenha.setBounds(32, 517, 46, 20);
		panel.add(lblSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(87, 477, 347, 20);
		panel.add(textFieldLogin);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(87, 518, 347, 20);
		panel.add(textFieldSenha);
	}
	
	private void setConta(Conta conta) {
		this.conta=conta;
	}
}
