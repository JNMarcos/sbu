package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes_basicas.Usuario;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarUsuario {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textSexo;
	private JTextField textCpf;
	private JTextField textIdentidade;
	private JTextField textEndereco;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textDataNascimento;
	private static Fachada fachada = Fachada.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarUsuario window = new TelaCadastrarUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(72, 81, 98, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(72, 120, 98, 14);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(72, 158, 98, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setBounds(72, 198, 98, 14);
		frame.getContentPane().add(lblIdentidade);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(72, 233, 98, 14);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(71, 270, 99, 14);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(71, 305, 99, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(70, 344, 100, 14);
		frame.getContentPane().add(lblDataNascimento);
		
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "T\u00E9cnico", "Professor"}));
		comboBoxUsuario.setBounds(259, 33, 28, 20);
		frame.getContentPane().add(comboBoxUsuario);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				
				
					if(textNome.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Nome' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textSexo.equals("") || !textSexo.equals("f") || !textSexo.equals("F") || 
							!textSexo.equals("m") || !textSexo.equals("M")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Sexo' se encontra Invalido! ", "Mensagem de alerta",
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textCpf.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'CPF' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textIdentidade.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Identidade' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textEndereco.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Endereco' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textTelefone.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Telefone' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textEmail.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'E-mail' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else if(textDataNascimento.equals("")){
						JOptionPane.showMessageDialog(null, 
								"O campo 'Data de Nascimento' se encontra vazio! ", "Mensagem de alerta", 
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						
						String nome = textNome.getText();
						char ch[] = textSexo.getText().toCharArray();
						char sexo = ch[0];//recebe o sexo 
						String cpf = textCpf.getText();
						String endereco = textEndereco.getText();
						String identidade = textIdentidade.getText();
						String telefone = textTelefone.getText();
						String email = textEmail.getText();
						String dataDeNascimento = textDataNascimento.getText();
						
						String tipoDeUsuario = (String)comboBoxUsuario.getSelectedItem();
						
						if(tipoDeUsuario.equals("Aluno")){
							Aluno aluno = new Aluno(nome, sexo, cpf, endereco, 
														identidade, telefone, email, 
													dataDeNascimento);
							fachada.cadastrarAluno(aluno);
							fachada.salvarAluno();
						}
						else if(tipoDeUsuario.equals("Professor")){
							Professor professor = new Professor(nome, sexo, cpf, endereco, 
														identidade, telefone, email, 
														dataDeNascimento);
							fachada.cadastrarProfessor(professor);
							fechada.salvarProfessor();
						}
						else {
							Tecnico tecnico = new Tecnico(nome, sexo, cpf, endereco, 
														identidade, telefone, email, 
														dataDeNascimento);
							fachada.cadastrarTecnico(tecnico);
							fachada.salvarProfessor();
						}
							
							JOptionPane.showMessageDialog(null,
								"Cliente cadastrado com sucesso!");
					}
				
				}
			}
			});
		
		btnCadastrar.setBounds(259, 406, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		textNome = new JTextField();
		textNome.setBounds(180, 78, 291, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textSexo = new JTextField();
		textSexo.setBounds(180, 117, 291, 20);
		frame.getContentPane().add(textSexo);
		textSexo.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(180, 155, 291, 20);
		frame.getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textIdentidade = new JTextField();
		textIdentidade.setText("");
		textIdentidade.setBounds(180, 195, 291, 20);
		frame.getContentPane().add(textIdentidade);
		textIdentidade.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(180, 226, 291, 20);
		frame.getContentPane().add(textEndereco);
		textEndereco.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setText("");
		textTelefone.setBounds(180, 267, 291, 20);
		frame.getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(180, 302, 291, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDataNascimento = new JTextField();
		textDataNascimento.setBounds(180, 341, 291, 20);
		frame.getContentPane().add(textDataNascimento);
		textDataNascimento.setColumns(10);
		
		
	}
}
