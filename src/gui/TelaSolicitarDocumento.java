package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes_basicas.Aluno;
import classes_basicas.Conta;
import classes_basicas.Professor;
import classes_basicas.Servico;
import classes_basicas.Tecnico;
import negocio.ControladorServico;
import negocio.Fachada;

public class TelaSolicitarDocumento extends JFrame {

	private JPanel panel;
	private Fachada fachada;
	private Conta conta;
	private ControladorServico controladorServico;
	
	
	public TelaSolicitarDocumento(Conta conta) {
		setConta(conta);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setTitle("$BU - Solicitar Documento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		fachada = Fachada.getInstance();
		controladorServico = new ControladorServico();
		
			
		panel = new JPanel();
		//panel.setBounds(0, 0, 534, 266);
		setBounds(100, 100, 413, 272); //AQUI É A SOLUÇÃO
		setContentPane(panel); //AQUI É A SOLUÇÃO
		//getContentPane().add(panel);
		panel.setLayout(null);
		
		
		if(conta.getUsuario() instanceof Aluno){
			JComboBox comboBoxSolicitaDocumento = new JComboBox();
			comboBoxSolicitaDocumento.setBounds(261, 84, 28, 20);
			String[] servicos = {"Comprovante de Matricula", "Diploma para Graduação", "Diploma para Pós Graduação",
									"Histório Completo da Graduação", "Histórico Completo da Pós Graduação",
									"Certificado de Conclusão de Curso", "Transferencia Interna",
									"Transferencia Externa", "Transferencia Para Outra Instituição",
									"Carteira de Estudante"};
			for(int i = 0; i < 10;i++){
				comboBoxSolicitaDocumento.addItem(servicos[i]);
			}
			panel.add(comboBoxSolicitaDocumento);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String escolhido = comboBoxSolicitaDocumento.getSelectedItem().toString();
					if(escolhido.equals("Comprovante de Matricula")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("comprovanteMatricula")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("comprovanteMatricula")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("comprovanteMatricula"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }
	                         
	                      else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                      }
	                          
					}
					if(escolhido.equals("Diploma para Graduação")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("diplomaGraduacao")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("diplomaGraduacao")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("diplomaGraduacao"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    }     
					}
					if(escolhido.equals("Diploma para Pós Graduação")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("diplomaPosGraduacao")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("diplomaPosGraduacao")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("diplomaPosGraduacao"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    }     
						
					}
					if(escolhido.equals("Histório Completo da Graduação")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("histórioCompletoGraduação")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("histórioCompletoGraduação")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("histórioCompletoGraduação"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    }   
					}

					if(escolhido.equals("Histórico Completo da Pós Graduação")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("historioCompletoPosGraduação")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("historioCompletoPosGraduação")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("historioCompletoPosGraduação"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    }   
					}
					if(escolhido.equals("Certificado de Conclusão de Curso")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("certificadoConclusaoCurso")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("certificadoConclusaoCurso")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("certificadoConclusaoCurso"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    } 
						
					}
					if(escolhido.equals("Transferencia Interna")){
						if(escolhido.equals("Transferencia Interna")){
							int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaInterna")+
									" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
							String message = null;  
		                    if (escolha == JOptionPane.YES_OPTION) {
		                    	message = "Yes"; 
		                    	if(conta.getSaldo()>= Servico.getPrecos().get("transferenciaInterna")){
		                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("transferenciaInterna"));
		                    		JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                    	else{
		                    		JOptionPane.showMessageDialog(null,
		    								"Saldo Insuficiente!");
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                    }    
		                    else if (escolha == JOptionPane.NO_OPTION) {
		                    	  message = "No";
		                    } 
						
					}
					if(escolhido.equals("Transferencia Externa")){
						if(escolhido.equals("Transferencia Interna")){
							int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaExterna")+
									" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
							String message = null;  
		                    if (escolha == JOptionPane.YES_OPTION) {
		                    	message = "Yes"; 
		                    	if(conta.getSaldo()>= Servico.getPrecos().get("transferenciaExterna")){
		                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("transferenciaExterna"));
		                    		JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                    	else{
		                    		JOptionPane.showMessageDialog(null,
		    								"Saldo Insuficiente!");
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                    }    
		                    else if (escolha == JOptionPane.NO_OPTION) {
		                    	  message = "No";
		                    } 
					}
					if(escolhido.equals("Transferencia Para Outra Instituição")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaParaOutraInstituição")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("transferenciaParaOutraInstituição")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("transferenciaParaOutraInstituição"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    } 
					}
					if(escolhido.equals("Carteira de Estudante")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraEstudante")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("carteiraEstudante")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("carteiraEstudante"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    } 
					}
					else{
						JOptionPane.showMessageDialog(null, "Escolha uma ação! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				}
			});
			btnConfirmar.setBounds(118, 126, 89, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 89, 23);
			panel.add(btnCancelar);
		}
		
		else if(conta.getUsuario() instanceof Professor){
			JComboBox comboBoxSolicitaDocumento = new JComboBox();
			comboBoxSolicitaDocumento.addItem("Carteira de Professor");
			comboBoxSolicitaDocumento.setBounds(261, 84, 28, 20);
			panel.add(comboBoxSolicitaDocumento);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String escolhido = comboBoxSolicitaDocumento.getSelectedItem().toString();
					if(escolhido.equals("Carteira de Professor")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraProfessor")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("carteiraProfessor")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("carteiraProfessor"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    } 
					}
					else{
						JOptionPane.showMessageDialog(null, "Escolha uma ação! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnConfirmar.setBounds(118, 126, 89, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 89, 23);
			panel.add(btnCancelar);
		}
		else if(conta.getUsuario() instanceof Tecnico){
			JComboBox comboBoxSolicitaDocumento = new JComboBox();
			comboBoxSolicitaDocumento.setBounds(261, 84, 28, 20);
			comboBoxSolicitaDocumento.addItem("Carteira de Técnico");
			panel.add(comboBoxSolicitaDocumento);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String escolhido = comboBoxSolicitaDocumento.getSelectedItem().toString();
					if(escolhido.equals("Carteira de Tecnico")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraTecnico")+
								" Você deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						String message = null;  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	message = "Yes"; 
	                    	if(conta.getSaldo()>= Servico.getPrecos().get("carteiraTecnico")){
	                    		conta.setSaldo(conta.getSaldo() - Servico.getPrecos().get("carteiraTecnico"));
	                    		JOptionPane.showMessageDialog(null,
	    								"Sucesso!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	else{
	                    		JOptionPane.showMessageDialog(null,
	    								"Saldo Insuficiente!");
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    }    
	                    else if (escolha == JOptionPane.NO_OPTION) {
	                    	  message = "No";
	                    } 
				}
				}
			});
			btnConfirmar.setBounds(118, 126, 89, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 89, 23);
			panel.add(btnCancelar);
		}
		
		
		
		
		
	}
	private void setConta(Conta conta) {
		this.conta = conta;
		}	
}
