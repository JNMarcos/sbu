package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * 
 * author @ramices
 * 
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Professor;
import classes_basicas.Usuario;
import negocio.Fachada;

public class TelaPrincipalADMGeral extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fachada fachada = Fachada.getInstance();
	private TelaLogin telaLogin;
	private Conta conta;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private TelaCadastroAluno telaCadastrarAluno;
	private TelaCadastroProfessor telaCadastrarProfessor;
	private TelaCadastroTecnico telaCadastrarTecnico;
	private TelaAlterarUsuario telaAlterarUsuario;
	private JPanel panel;
	
	public TelaPrincipalADMGeral(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU");
		setResizable(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panel = new JPanel();
		setBounds(100, 100, 800, 550);
		setContentPane(panel);
		panel.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				telaCadastrarAluno = new TelaCadastroAluno(conta);
				telaCadastrarAluno.setVisible(true);
				
			}
		});
		btnCadastrarAluno.setBounds(641, 202, 133, 23);
		panel.add(btnCadastrarAluno);
		
		JButton btnRemoverUsuario = new JButton("Remover Usuario");
		btnRemoverUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				
	           	Usuario user = null;
	           
	            
	            
	            if (linhaSelecionada < 0) {
	                    
	            	JOptionPane.showMessageDialog(null, "Nenhum usuario selecionado!");
	            
	            } else {
	                    
	            			try {
	            				
	            					user = fachada.procurarPorCpf((String) table.getValueAt(linhaSelecionada, 2));
	            				 	
	            				 	fachada.removerUsuario(user);
	            				 	fachada.removerConta(fachada.exibirConta(user));
	            				 	carregarTabela(modelo, (ArrayList<Usuario>)fachada.listarUsuarios());
	            				 	
	            				 	JOptionPane.showMessageDialog(null, "Usuario removido com sucesso!");

								
	            				} 
	            				catch (Exception e1) {
							
	            					JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

	            				}
	                    
	                 
			}
			
			}
		});
		btnRemoverUsuario.setBounds(641, 34, 133, 23);
		panel.add(btnRemoverUsuario);
		
		JButton btnAlterarUsuario = new JButton("Alterar Usuario");
		btnAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	                    
	            			try {
	            				 	telaAlterarUsuario = new TelaAlterarUsuario(conta);
	            					
	            				
	            				} 
	            				catch (Exception e1) {
							
	            					JOptionPane.showMessageDialog(null, e1.getMessage());

	            				}
	                    
	                 
			}
			
		});
		btnAlterarUsuario.setBounds(641, 68, 133, 23);
		panel.add(btnAlterarUsuario);
		
		JButton btnVoltar = new JButton("Logout");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
		
				
			}
		});
		btnVoltar.setBounds(641, 446, 133, 23);
		panel.add(btnVoltar);
		
		
		modelo.setRowCount(0);
		modelo.addColumn("Nome");
		modelo.addColumn("Sexo");
		modelo.addColumn("CPF");
		modelo.addColumn("Identidade");
		modelo.addColumn("Endereco");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("dataNascimento");
		modelo.addColumn("tipo");
		
		table = new JTable(modelo);
		table.setBounds(25, 21, 229, 203);
		
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(24, 24, 607, 466);
		panel.add(barraRolagem);
		
		carregarTabela(modelo, (ArrayList<Usuario>) fachada.listarUsuarios());
		
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				telaCadastrarProfessor = new TelaCadastroProfessor(conta);
				telaCadastrarProfessor.setVisible(true);
				
			}
		});
		btnCadastrarProfessor.setBounds(641, 247, 133, 23);
		panel.add(btnCadastrarProfessor);
		
		JButton btnCadastrarTcnico = new JButton("Cadastrar T\u00E9cnico");
		btnCadastrarTcnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				telaCadastrarTecnico = new TelaCadastroTecnico(conta);
				telaCadastrarTecnico.setVisible(true);
				
			}
		});
		btnCadastrarTcnico.setBounds(638, 292, 136, 23);
		panel.add(btnCadastrarTcnico);
		
		
	
		
	}
	
	public void carregarTabela(DefaultTableModel modelo, ArrayList<Usuario> usuario)
	{
		modelo.setRowCount(0);

		if (usuario != null) {
			
			for (Usuario u : usuario) {
				if (u == null) {
					break;
				} else { 
					
					String tipo;
					
					if(u instanceof Aluno)
						tipo = new String("Aluno");
					else if(u instanceof Professor)
						tipo = new String("Professor");
					else
						tipo = new String("Tecnico");
					
					modelo.addRow(new Object[] {
							u.getNome(),
							u.getSexo(),
							u.getCpf(),
							u.getIdentidade(),
							u.getEndereco(),
							u.getTelefone(),
							u.getEmail(),
							u.getDataNascimento(),
							tipo});
				}
			}
		}

	}
	private void setConta(Conta conta) {
		this.conta = conta;
	}	
}
	