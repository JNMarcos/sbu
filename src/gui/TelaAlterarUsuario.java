package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes_basicas.Aluno;
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

public class TelaAlterarUsuario extends JFrame {
	private static Fachada fachada = Fachada.getInstance();
	private Aluno al;
	private Professor prof;
	private Tecnico tec;
	
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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarUsuario frame = new TelaAlterarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAlterarUsuario() {
		setTitle("Alterar Dados do Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("CPF:");
		label.setBounds(10, 10, 36, 22);
		contentPane.add(label);
		textMat.setVisible(false);
		textCurso.setVisible(false);
		textAd.setVisible(false);
		textAt.setVisible(false);
		textNum.setVisible(false);
		textArea.setVisible(false);
		textDep.setVisible(false);
		
				
		Button Buscar = new Button("Buscar");
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 if(fachada.procurarPorCpf(textCPF.getText()) instanceof Aluno){
						 	textMat.setVisible(true);
							textCurso.setVisible(true);
							textAd.setVisible(true);
							textAt.setVisible(true);
							textCPF.setVisible(false);
						 	textNome.setText(fachada.toString());
							textSexo.setText(fachada.toString());
							textID.setText(fachada.toString());
							textEnd.setText(fachada.toString());
							textTel.setText(fachada.toString());
							textEmail.setText(fachada.toString());
							textMat.setText(fachada.toString());
							textCurso.setText(fachada.toString());
							textAd.setText(fachada.toString());
							textAt.setText(fachada.toString());
							
							
						}else if(fachada.procurarPorCpf(textCPF.getText()) instanceof Professor){
							textNum.setVisible(true);							
							textDep.setVisible(true);
							textCPF.setVisible(false);
							textNome.setText(fachada.toString());
							textSexo.setText(fachada.toString());
							textID.setText(fachada.toString());
							textEnd.setText(fachada.toString());
							textTel.setText(fachada.toString());
							textEmail.setText(fachada.toString());
							textDep.setText(fachada.toString());
							textNum.setText(fachada.toString());
							
						}else if(fachada.procurarPorCpf(textCPF.getText()) instanceof Tecnico){
							textNum.setVisible(true);
							textArea.setVisible(true);
							textDep.setVisible(true);
							textCPF.setVisible(false);
							textNome.setText(fachada.toString());
							textSexo.setText(fachada.toString());
							textID.setText(fachada.toString());
							textEnd.setText(fachada.toString());
							textTel.setText(fachada.toString());
							textEmail.setText(fachada.toString());
							textDep.setText(fachada.toString());
							textArea.setText(fachada.toString());
							textNum.setText(fachada.toString());
						}
					else{
						 JOptionPane.showMessageDialog(null,"Usuario nao cadastrado!");
					 }
						 
				} catch (CpfJaExistenteException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		Buscar.setBounds(417, 10, 70, 22);
		contentPane.add(Buscar);
		
		Label label_1 = new Label("Nome:");
		label_1.setBounds(10, 38, 36, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Sexo:");
		label_2.setBounds(10, 66, 36, 22);
		contentPane.add(label_2);
		
		JLabel lblIdentdade = new JLabel("Identdade:");
		lblIdentdade.setBounds(10, 97, 63, 14);
		contentPane.add(lblIdentdade);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(116, 94, 273, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 133, 63, 14);
		contentPane.add(lblEndereo);
		
		textEnd = new JTextField();
		textEnd.setBounds(116, 130, 273, 20);
		contentPane.add(textEnd);
		textEnd.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 169, 46, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 201, 46, 14);
		contentPane.add(lblEmail);
		
		textTel = new JTextField();
		textTel.setBounds(116, 166, 273, 20);
		contentPane.add(textTel);
		textTel.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(116, 198, 273, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 240, 115, 14);
		contentPane.add(lblDataDeNascimento);
		
		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(116, 237, 28, 20);
		String[] arrayDia = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14","15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		for(int i = 0; i < 32; i++)
			comboBoxDia.addItem(arrayDia[i]);
		contentPane.add(comboBoxDia);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(168, 237, 36, 20);
		String[] arrayMes = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro"};
		for(int i=0; i<13; i++)
			comboBoxMes.addItem(arrayMes[i]);
		contentPane.add(comboBoxMes);
		
		JComboBox comboBoxAno = new JComboBox();
		comboBoxAno.setBounds(222, 237, 55, 20);
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
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja atualizar esse usuario?")==0){
					
						try{
							try {
								if(fachada.procurarPorCpf(textCPF.getText()) instanceof Aluno){
									al.setNome(textNome.getText());
									al.setSexo(textSexo.getText().charAt(0));							
									al.setEndereco(textEnd.getText());
									al.setTelefone(textTel.getText());
									al.setEmail(textEmail.getText());
									al.setnMatricula(textMat.getText());
									al.setCurso(textCurso.getText());
									al.setPeriodoAdmissao(textAd.getText());
									al.setPeriodoAtual(textAt.getText().charAt(0));
									LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
									al = new Aluno(textNome.getText(), textSexo.getText().charAt(0),
											textCPF.getText(),textID.getText(), textEnd.getText(),
											textTel.getText(), textEmail.getText(), dataDeNascimento,
											textMat.getText(),textCurso.getText(),textAd.getText(),
											Integer.parseInt(textAt.getText()));
									
									fachada.alterarDadosUsuario(al);
									JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
								}
								else if(fachada.procurarPorCpf(textCPF.getText()) instanceof Professor){
									prof.setNome(textNome.getText());
									prof.setSexo(textSexo.getText().charAt(0));								
									prof.setEndereco(textEnd.getText());
									prof.setTelefone(textTel.getText());
									prof.setEmail(textEmail.getText());
									prof.setDepartamento(textDep.getText());
									prof.setnProfessor(textNum.getText());
									LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
									prof = new Professor(textNome.getText(), textSexo.getText().charAt(0),
											textCPF.getText(),textID.getText(), textEnd.getText(),
											textTel.getText(), textEmail.getText(), dataDeNascimento,
											textDep.getText(),textNum.getText());
									
									fachada.alterarDadosUsuario(prof);
									JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");							
									
									
								}else if(fachada.procurarPorCpf(textCPF.getText()) instanceof Tecnico){
									tec.setNome(textNome.getText());
									tec.setSexo(textSexo.getText().charAt(0));
									
									tec.setEndereco(textEnd.getText());
									tec.setTelefone(textTel.getText());
									tec.setEmail(textEmail.getText());
									tec.setDepartamento(textDep.getText());
									tec.setArea(textArea.getText());
									tec.setnTecnico(textNum.getText());
									LocalDate dataDeNascimento = LocalDate.parse(((String)comboBoxDia.getSelectedItem()) + comboBoxMes.getSelectedIndex() + ((String)comboBoxAno.getSelectedItem()));
									tec = new Tecnico(textNome.getText(), textSexo.getText().charAt(0),
											textCPF.getText(),textID.getText(), textEnd.getText(),
											textTel.getText(), textEmail.getText(), dataDeNascimento,
											textDep.getText(),textArea.getText(), textNum.getText());
									
									fachada.alterarDadosUsuario(tec);
									JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
								}
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (CpfJaExistenteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}catch (UsuarioNaoEncontradoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							e1.printStackTrace();
						}
				}
					}
				
				}
		);
		btnAtualizar.setBounds(93, 550, 89, 23);
		contentPane.add(btnAtualizar);
		
		textSexo = new JTextField();
		textSexo.setBounds(116, 68, 273, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 271, 78, 14);
		contentPane.add(lblMatricula);
		
		textMat = new JTextField();
		textMat.setBounds(116, 265, 273, 20);
		contentPane.add(textMat);
		textMat.setColumns(10);
		
		JLabel lblCurco = new JLabel("Curso:");
		lblCurco.setBounds(10, 306, 46, 14);
		contentPane.add(lblCurco);
		
		JLabel lblAd = new JLabel("Per\u00EDodo de Admiss\u00E3o:");
		lblAd.setBounds(10, 339, 115, 14);
		contentPane.add(lblAd);
		
		textCurso = new JTextField();
		textCurso.setBounds(116, 303, 273, 20);
		contentPane.add(textCurso);
		textCurso.setColumns(10);
		
		textAd = new JTextField();
		textAd.setBounds(116, 336, 273, 20);
		contentPane.add(textAd);
		textAd.setColumns(10);
		
		JLabel lblPerodoAtual = new JLabel("Per\u00EDodo Atual:");
		lblPerodoAtual.setBounds(10, 368, 78, 14);
		contentPane.add(lblPerodoAtual);
		
		textAt = new JTextField();
		textAt.setBounds(116, 365, 273, 20);
		contentPane.add(textAt);
		textAt.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(116, 10, 273, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(116, 40, 273, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(335, 550, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 404, 46, 14);
		contentPane.add(lblNmero);
		
		textNum = new JTextField();
		textNum.setBounds(118, 401, 271, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(10, 435, 78, 14);
		contentPane.add(lblDepartamento);
		
		textDep = new JTextField();
		textDep.setEnabled(true);
		textDep.setBounds(116, 432, 273, 20);
		contentPane.add(textDep);
		textDep.setColumns(10);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setEnabled(true);
		lblArea.setBounds(10, 475, 46, 14);
		contentPane.add(lblArea);
		
		textArea = new JTextField();
		textArea.setEnabled(true);
		textArea.setBounds(116, 472, 273, 20);
		contentPane.add(textArea);
		textArea.setColumns(10);
		
		
		
	}
}
