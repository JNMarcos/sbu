package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import classes_basicas.Conta;
import classes_basicas.Divida;
import negocio.Fachada;

public class TelaPrincipalADMBiblioteca extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Conta conta;
	private TelaInicio telaPrincipal;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Fachada fachada = Fachada.getInstance();
	private JTextField txtValor;
	private JTextField txtDescricao;
	private JTextField txtCPF;
	private JPanel panelAdicionarDivida;
	
	
	public TelaPrincipalADMBiblioteca(Conta conta) {
		getContentPane().setLayout(null);
		
		this.conta = conta;
		
		panelAdicionarDivida = new JPanel();
		//panelAdicionarDivida.setVisible(false);
		setBounds(10, 11, 430, 358);
		setContentPane(panelAdicionarDivida);
		panelAdicionarDivida.setLayout(null);
		
		txtValor = new JTextField();
		txtValor.setBounds(132, 8, 180, 20);
		panelAdicionarDivida.add(txtValor);
		txtValor.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(132, 48, 180, 56);
		panelAdicionarDivida.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(74, 11, 47, 14);
		panelAdicionarDivida.add(lblValor);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(48, 48, 74, 14);
		panelAdicionarDivida.add(lblDescricao);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(132, 119, 180, 20);
		panelAdicionarDivida.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(91, 122, 28, 14);
		panelAdicionarDivida.add(lblCpf);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				telaPrincipal = new TelaInicio();
				telaPrincipal.setVisible(true);
				panelAdicionarDivida.setVisible(false);
				
				
			}
		});
		btnVoltar.setBounds(282, 285, 89, 23);
		panelAdicionarDivida.add(btnVoltar);
		
		JButton btnAdicionardivida = new JButton("AdicionarDivida");
		btnAdicionardivida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Divida divida;
				
				try
				{
					
					
					Conta conta = fachada.procurarConta(txtCPF.getText());
					
					divida = new Divida(conta, Double.parseDouble(txtValor.getText()), txtDescricao.getText());
					divida.setDataEmissao();
					divida.setHoraEmissao();
					
					fachada.adicionarDivida(divida);
					JOptionPane.showMessageDialog(null, "Divida cadastrada com sucesso.");
					dispose();
					TelaPrincipalADMBiblioteca telaPrincipalADMBiblioteca = new TelaPrincipalADMBiblioteca(conta);
					telaPrincipalADMBiblioteca.setVisible(true);
					//panelAdicionarDivida.setVisible(false);
					
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2.getMessage());
					
				}
			
			}
		});
		btnAdicionardivida.setBounds(132, 285, 124, 23);
		panelAdicionarDivida.add(btnAdicionardivida);
		
		JButton btnRemoverDivida = new JButton("Remover Divida");
		btnRemoverDivida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				int linhaSelecionada = table.getSelectedRow();
				
	            Divida div = null;
	           
	            
	            
	            if (table.getSelectedRow() < 0) {
	                    
	            	JOptionPane.showMessageDialog(null, "Nenhuma divida selecionada!");
	            
	            } else {
	                    
	            			try {
	            				 	ArrayList<Divida> dividas = (ArrayList<Divida>) fachada.listarDivida();
	            				 	div = dividas.get(linhaSelecionada);
	            				 	
	            				 	fachada.removerDivida(div);
	            				 	carregarTabela(modelo, (ArrayList<Divida>)fachada.listarDivida());
	            				 	
	            				 	JOptionPane.showMessageDialog(null, "Dívida removida com sucesso!");
								
	            				} 
	            				catch (Exception e1) {
							
	            					JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

	            				}
	                    
	                 
			}
				
			
			}
		});
		btnRemoverDivida.setBounds(13, 217, 109, 23);
		getContentPane().add(btnRemoverDivida);
		
		JButton btnAlterarDivida = new JButton("Alterar Divida");
		btnAlterarDivida.addActionListener(new ActionListener() {
			private Divida div;

			public void actionPerformed(ActionEvent arg0) {
			
				int linhaSelecionada = table.getSelectedRow();
				
	            div = null;
	           
	            
	            
	            if (table.getSelectedRow() < 0) {
	                    
	            	JOptionPane.showMessageDialog(null, "Nenhuma divida selecionada!");
	            
	            } else {
	                    
	            			try {
	            				 	ArrayList<Divida> dividas = (ArrayList<Divida>) fachada.listarDivida();
	            				 	
	            				 	div = new Divida(dividas.get(linhaSelecionada).getConta(),
	            				 					(double) table.getValueAt(linhaSelecionada, 0),
	            				 					  (String) table.getValueAt(linhaSelecionada, 1));
	            				 					 
	            				 	div.setHoraEmissao();
	            				 	div.setDataEmissao();
	            				 	
	            				 	
	            				 	fachada.alterarDadosDivida(div);
	            				 	
	            				 	
	            				 	carregarTabela(modelo, (ArrayList<Divida>)fachada.listarDivida());
	            				 	
	            				 	JOptionPane.showMessageDialog(null, "Dívida alterada com sucesso!");
								
	            				} 
	            				catch (Exception e1) {
							
	            					JOptionPane.showMessageDialog(null, e1.getMessage(), "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);

	            				}
	                    
	                 
			}
			
			}
		});
		btnAlterarDivida.setBounds(13, 251, 109, 23);
		getContentPane().add(btnAlterarDivida);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaPrincipal = new TelaInicio();
				telaPrincipal.setVisible(true);
			
			}
		});
		btnLogout.setBounds(10, 285, 89, 23);
		getContentPane().add(btnLogout);
		
		modelo.setRowCount(0);
		modelo.addColumn("Valor");
		modelo.addColumn("Descrição");
		modelo.addColumn("Data de Emissão");
		modelo.addColumn("Hora de emissão");
		
		table = new JTable(modelo);
		table.setBounds(148, 11, 269, 252);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(125, 150, 279, 113);
		getContentPane().add(barraRolagem);
		
		
		ArrayList<Divida> dividas = (ArrayList<Divida>) fachada.listarDivida();
		carregarTabela(modelo, dividas);

	}
	
	
	public void carregarTabela(DefaultTableModel modelo, ArrayList<Divida> dividas)
	{
		
		modelo.setRowCount(0);

		if (dividas != null) {

			for (Divida d : dividas) {
				if (d == null) {
					break;
				} else { 
					modelo.addRow(new Object[] {
							d.getValor(),
							d.getDescricao(),
							d.getHoraEmissao(),
							d.getDataEmissao()});
				}
			}
		}

	}
}

