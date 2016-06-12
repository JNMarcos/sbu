package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes_basicas.Aluno;
import excecao.CpfJaExistenteException;
import negocio.Fachada;

public class TelaCadastroAluno extends JPanel {
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
	private Fachada fachada;
	private Aluno aluno;

	/**
	 * Create the panel.
	 */
	public TelaCadastroAluno() {
		setLayout(null);
		fachada = Fachada.getInstance();
		aluno = new Aluno();
		
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
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(70, 413, 112, 14);
		add(lblMatricula);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(70, 454, 112, 14);
		add(lblCurso);
		
		JLabel lblPeriodoAdmissao = new JLabel("Periodo de Admiss\u00E3o:");
		lblPeriodoAdmissao.setBounds(70, 495, 112, 14);
		add(lblPeriodoAdmissao);
		
		JLabel lblPeriodoAtual = new JLabel("Periodo Atual:");
		lblPeriodoAtual.setBounds(70, 536, 112, 14);
		add(lblPeriodoAtual);
		
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
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(192, 410, 303, 20);
		add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(192, 451, 303, 20);
		add(textFieldCurso);
		textFieldCurso.setColumns(10);
		
		textFieldAdmissao = new JTextField();
		textFieldAdmissao.setBounds(192, 492, 303, 20);
		add(textFieldAdmissao);
		textFieldAdmissao.setColumns(10);
		
		textFieldPeriodoAtual = new JTextField();
		textFieldPeriodoAtual.setBounds(192, 533, 303, 20);
		add(textFieldPeriodoAtual);
		textFieldPeriodoAtual.setColumns(10);
		
		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(192, 369, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		add(comboBoxDia);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(280, 369, 28, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
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
					else if(textFieldMatricula.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'Matricula' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else if(textFieldCurso.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'Curso' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else if(textFieldAdmissao.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'Periodo de Admiss�o' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else if(textFieldPeriodoAtual.equals("")){
						JOptionPane.showMessageDialog(null, "O campo 'Periodo Atual' se encontra vazio! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
					else{
						aluno.setNome(textFieldNome.getText());
						aluno.setSexo(textFieldSexo.getText().charAt(0));
						aluno.setCpf(textFieldCpf.getText());
						aluno.setIdentidade(textFieldIdentidade.getText());
						aluno.setEndereco(textFieldEndereco.getText());
						aluno.setTelefone(textFieldTelefone.getText());
						aluno.setEmail(textFieldEmail.getText());
						aluno.setnMatricula(textFieldMatricula.getText());
						aluno.setCurso(textFieldCurso.getText());
						aluno.setPeriodoAdmissao(textFieldAdmissao.getText());
						aluno.setPeriodoAtual(Integer.parseInt(textFieldPeriodoAtual.getText()));
						aluno.setDataNascimento(Integer.parseInt((String)comboBoxDia.getSelectedItem()), comboBoxMes.getSelectedIndex(), Integer.parseInt((String)comboBoxAno.getSelectedItem()));
						fachada.cadastrarUsuario(aluno);
						JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso!");
						
						
					}
				}catch(CpfJaExistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					textFieldCpf.setText("");
				}
			}
		});
		btnCadastrar.setBounds(152, 594, 89, 23);
		add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(384, 594, 89, 23);
		add(btnCancelar);
		
		

	}
}
