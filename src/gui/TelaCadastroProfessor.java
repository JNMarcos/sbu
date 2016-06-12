package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes_basicas.Professor;
import excecao.CpfJaExistenteException;
import negocio.Fachada;

public class TelaCadastroProfessor extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public TelaCadastroProfessor() {
		setLayout(null);
		fachada = Fachada.getInstance();
		professor = new Professor();
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(70, 85, 112, 14);
		add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(70, 126, 112, 14);
		add(lblSexo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(70, 167, 112, 14);
		add(lblCpf);
		
		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setBounds(70, 208, 112, 14);
		add(lblIdentidade);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(70, 249, 112, 14);
		add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(70, 290, 112, 14);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(70, 331, 112, 14);
		add(lblEmail);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(70, 372, 112, 14);
		add(lblDataDeNascimento);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(192, 82, 303, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(192, 123, 303, 20);
		add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(192, 164, 303, 20);
		add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldIdentidade = new JTextField();
		textFieldIdentidade.setBounds(192, 205, 303, 20);
		add(textFieldIdentidade);
		textFieldIdentidade.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(192, 246, 303, 20);
		add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(192, 287, 303, 20);
		add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(192, 328, 303, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(70, 413, 112, 14);
		add(lblDepartamento);
		
		JLabel lblNprofessor = new JLabel("nProfessor:");
		lblNprofessor.setBounds(70, 454, 112, 14);
		add(lblNprofessor);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setBounds(192, 410, 303, 20);
		add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);
		
		textFieldNprofessor = new JTextField();
		textFieldNprofessor.setBounds(192, 451, 303, 20);
		add(textFieldNprofessor);
		textFieldNprofessor.setColumns(10);
		
		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(192, 369, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		add(comboBoxDia);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(280, 369, 28, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		add(comboBoxMes);
		
		JComboBox comboBoxAno = new JComboBox();
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
		add(comboBoxAno);
		
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
					else if(textFieldDepartamento.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'Departamento' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else if(textFieldNprofessor.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'nProfessor' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else{
						professor.setNome(textFieldNome.getText());
						professor.setSexo(textFieldSexo.getText().charAt(0));
						professor.setCpf(textFieldCpf.getText());
						professor.setIdentidade(textFieldIdentidade.getText());
						professor.setEndereco(textFieldEndereco.getText());
						professor.setTelefone(textFieldTelefone.getText());
						professor.setEmail(textFieldEmail.getText());
						professor.setDepartamento(textFieldDepartamento.getText());
						professor.setnProfessor(textFieldNprofessor.getText());
						professor.setDataNascimento(Integer.parseInt((String)comboBoxDia.getSelectedItem()), comboBoxMes.getSelectedIndex(), Integer.parseInt((String)comboBoxAno.getSelectedItem()));
						fachada.cadastrarUsuario(professor);
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						
						
					}
				}catch(CpfJaExistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					textFieldCpf.setText("");
				}
			}
		});
		btnCadastrar.setBounds(146, 518, 89, 23);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(375, 518, 89, 23);
		add(btnCancelar);
		
		
		
		

	}
}
