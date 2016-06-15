package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Professor;
import classes_basicas.Tecnico;
import classes_basicas.Usuario;
import excecao.CpfJaExistenteException;
import excecao.UsuarioNaoEncontradoException;
import negocio.Fachada;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class TelaAlterarUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Fachada fachada = Fachada.getInstance();

	private Usuario usuario;
	//conta do 
	private Conta conta = null;
	private Conta contaDosDadosAlterados = null;

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textEnd;
	private JTextField textTel;
	private JTextField textEmail;
	private JTextField textSexo;
	private JTextField textMat;
	private JTextField textCurso;
	private JTextField textAd;
	private JTextField textAt;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textNum;
	private JTextField textDep;
	private JTextField textArea;


	public void setConta(Conta conta){
		this.conta = conta;
	}

	public void setContaDadosAlterados(Conta conta){
		this.contaDosDadosAlterados = conta;
	}

	public TelaAlterarUsuario(Conta conta) {
		setConta(conta);
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Alterar Dados do Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("CPF:");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label.setBounds(10, 10, 36, 22);
		contentPane.add(label);
		textMat.setVisible(false);
		textCurso.setVisible(false);
		textAd.setVisible(false);
		textAt.setVisible(false);
		textNum.setVisible(false);
		textArea.setVisible(false);
		textDep.setVisible(false);


		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(153, 238, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		contentPane.add(comboBoxDia);

		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(227, 238, 28, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		contentPane.add(comboBoxMes);

		JComboBox<String> comboBoxAno = new JComboBox<String>();
		comboBoxAno.setBounds(322, 238, 28, 20);
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
		contentPane.add(comboBoxAno);


		JButton Buscar = new JButton("Buscar");
		Buscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conta conta = fachada.procurarConta(textCPF.getText());
				setContaDadosAlterados(conta);
				if(conta.getUsuario() instanceof Aluno){
					textMat.setVisible(true);
					textCurso.setVisible(true);
					textAd.setVisible(true);
					textAt.setVisible(true);
					textCPF.setVisible(false);


				}else if(conta.getUsuario() instanceof Professor){
					textNum.setVisible(true);							
					textDep.setVisible(true);
					textCPF.setVisible(false);


				}else if(conta.getUsuario()  instanceof Tecnico){
					textNum.setVisible(true);
					textArea.setVisible(true);
					textDep.setVisible(true);
					textCPF.setVisible(false);

				}
				else{
					JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
					textCPF.setText("");
				}
			}
		});
		Buscar.setBounds(417, 10, 70, 22);
		contentPane.add(Buscar);

		Label label_1 = new Label("Nome:");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_1.setBounds(10, 38, 36, 22);
		contentPane.add(label_1);

		Label label_2 = new Label("Sexo:");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_2.setBounds(10, 66, 36, 22);
		contentPane.add(label_2);

		JLabel lblIdentdade = new JLabel("Identidade:");
		lblIdentdade.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblIdentdade.setBounds(10, 97, 63, 20);
		contentPane.add(lblIdentdade);

		textID = new JTextField();
		textID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textID.setBounds(116, 97, 273, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEndereo.setBounds(10, 133, 63, 17);
		contentPane.add(lblEndereo);

		textEnd = new JTextField();
		textEnd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textEnd.setBounds(116, 130, 273, 20);
		contentPane.add(textEnd);
		textEnd.setColumns(10);


		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 169, 78, 14);
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmail.setBounds(10, 201, 46, 14);
		contentPane.add(lblEmail);

		textTel = new JTextField();
		textTel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textTel.setBounds(116, 166, 273, 20);
		contentPane.add(textTel);
		textTel.setColumns(10);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textEmail.setBounds(116, 198, 273, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(10, 240, 115, 14);
		contentPane.add(lblDataDeNascimento);


		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja atualizar esse usuário?")==0){
					try{
						if(contaDosDadosAlterados.getUsuario() instanceof Aluno){

							LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
							usuario = new Aluno(textNome.getText(), textSexo.getText().charAt(0),
									textCPF.getText(),textID.getText(), textEnd.getText(),
									textTel.getText(), textEmail.getText(), dataDeNascimento,
									textMat.getText(),textCurso.getText(),textAd.getText(),
									Integer.parseInt(textAt.getText()));

							fachada.alterarDadosUsuario(usuario);
							JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");								
							dispose();
							TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(contaDosDadosAlterados); 
							telaPrincipalADMGeral.setVisible(true);
						}
						else if(contaDosDadosAlterados.getUsuario() instanceof Professor){

							LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
							usuario = new Professor(textNome.getText(), textSexo.getText().charAt(0),
									textCPF.getText(),textID.getText(), textEnd.getText(),
									textTel.getText(), textEmail.getText(), dataDeNascimento,
									textDep.getText(),textNum.getText());

							fachada.alterarDadosUsuario(usuario);
							JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");	
							dispose();
							TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(contaDosDadosAlterados); 
							telaPrincipalADMGeral.setVisible(true);


						}else if(contaDosDadosAlterados.getUsuario() instanceof Tecnico){

							LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
							usuario = new Tecnico(textNome.getText(), textSexo.getText().charAt(0),
									textCPF.getText(),textID.getText(), textEnd.getText(),
									textTel.getText(), textEmail.getText(), dataDeNascimento,
									textDep.getText(),textArea.getText(), textNum.getText());

							fachada.alterarDadosUsuario(usuario);
							JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
							dispose();
							TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(contaDosDadosAlterados); 
							telaPrincipalADMGeral.setVisible(true);
						}
					}catch (UsuarioNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						textCPF.setText("");
					}
				}
			}

		}
				);
		btnAtualizar.setBounds(93, 550, 89, 23);
		contentPane.add(btnAtualizar);

		textSexo = new JTextField();
		textSexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textSexo.setBounds(116, 68, 273, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMatricula.setBounds(10, 271, 78, 14);
		contentPane.add(lblMatricula);

		textMat = new JTextField();
		textMat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textMat.setBounds(116, 265, 273, 20);
		contentPane.add(textMat);
		textMat.setColumns(10);

		JLabel lblCurco = new JLabel("Curso:");
		lblCurco.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCurco.setBounds(10, 306, 46, 14);
		contentPane.add(lblCurco);

		JLabel lblAd = new JLabel("Per\u00EDodo de Admiss\u00E3o:");
		lblAd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAd.setBounds(10, 339, 115, 14);
		contentPane.add(lblAd);

		textCurso = new JTextField();
		textCurso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textCurso.setBounds(116, 303, 273, 20);
		contentPane.add(textCurso);
		textCurso.setColumns(10);

		textAd = new JTextField();
		textAd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textAd.setBounds(135, 337, 254, 18);
		contentPane.add(textAd);
		textAd.setColumns(10);

		JLabel lblPerodoAtual = new JLabel("Per\u00EDodo Atual:");
		lblPerodoAtual.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPerodoAtual.setBounds(10, 368, 78, 14);
		contentPane.add(lblPerodoAtual);

		textAt = new JTextField();
		textAt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textAt.setBounds(116, 365, 273, 20);
		contentPane.add(textAt);
		textAt.setColumns(10);

		textCPF = new JTextField();
		textCPF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textCPF.setBounds(116, 10, 273, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		textNome = new JTextField();
		textNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textNome.setBounds(116, 40, 273, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipalADMGeral telaPrincipalADMGeral = new TelaPrincipalADMGeral(conta); 
				telaPrincipalADMGeral.setVisible(true);
			}
		});
		btnCancelar.setBounds(335, 550, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNmero.setBounds(10, 404, 63, 14);
		contentPane.add(lblNmero);

		textNum = new JTextField();
		textNum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textNum.setBounds(116, 401, 273, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDepartamento.setBounds(10, 435, 96, 14);
		contentPane.add(lblDepartamento);

		textDep = new JTextField();
		textDep.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textDep.setEnabled(true);
		textDep.setBounds(116, 432, 273, 20);
		contentPane.add(textDep);
		textDep.setColumns(10);

		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblArea.setEnabled(true);
		lblArea.setBounds(10, 475, 46, 14);
		contentPane.add(lblArea);

		textArea = new JTextField();
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textArea.setEnabled(true);
		textArea.setBounds(116, 472, 273, 20);
		contentPane.add(textArea);
		textArea.setColumns(10);		
	}
}
