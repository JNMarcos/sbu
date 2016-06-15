package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import classes_basicas.Conta;
import negocio.Fachada;
import classes_basicas.Divida;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaPrincipalADMBiblioteca extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Conta conta;
	private TelaPrincipal telaPrincipal;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Fachada fachada = Fachada.getInstance();
	
	
	public TelaPrincipalADMBiblioteca(Conta conta) {
		setLayout(null);
		
		this.conta = conta;
		
		JButton btnAdicionarDivida = new JButton("Adicionar Divida");
		btnAdicionarDivida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				
			}
		});
		btnAdicionarDivida.setBounds(10, 11, 109, 23);
		add(btnAdicionarDivida);
		
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
		btnRemoverDivida.setBounds(10, 54, 109, 23);
		add(btnRemoverDivida);
		
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
		btnAlterarDivida.setBounds(10, 99, 109, 23);
		add(btnAlterarDivida);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			
			}
		});
		btnLogout.setBounds(10, 240, 89, 23);
		add(btnLogout);
		
		modelo.setRowCount(0);
		modelo.addColumn("Valor");
		modelo.addColumn("Descrição");
		modelo.addColumn("Data de Emissão");
		modelo.addColumn("Hora de emissão");
		
		table = new JTable(modelo);
		table.setBounds(148, 11, 269, 252);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(125, 14, 315, 249);
		add(barraRolagem);
		
		
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

