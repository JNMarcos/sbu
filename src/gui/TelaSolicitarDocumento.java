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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 499, 308); //AQUI � A SOLU��O
		setContentPane(panel); //AQUI � A SOLU��O
		//getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		if(conta.getUsuario() instanceof Aluno){
			JComboBox<String> comboBoxSolicitaDocumento = new JComboBox<String>();
			comboBoxSolicitaDocumento.setBounds(131, 85, 178, 20);
			String[] servicos = {"Comprovante de Matricula", "Diploma para Gradua��o", "Diploma para P�s Gradua��o",
									"Hist�rio Completo da Gradua��o", "Hist�rico Completo da P�s Gradua��o",
									"Certificado de Conclus�o de Curso", "Transferencia Interna",
									"Transferencia Externa", "Transferencia Para Outra Institui��o",
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
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                    		try
	                    		{
	                    			controladorServico.solicitarDocumento(conta, "comprovanteMatricula");
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		dispose();
	                    		
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
					}
					else if(escolhido.equals("Diploma para Gradua��o")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("diplomaGraduacao")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                    		try
	                    		{
	                    			controladorServico.solicitarDocumento(conta, "diplomaGraducao");;
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                    }    
	                   
					else if(escolhido.equals("Diploma para P�s Gradua��o")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("diplomaPosGraduacao")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						
	                    if (escolha == JOptionPane.YES_OPTION) {
	                   
	                    	
	                    		try
	                    		{	
	                    			controladorServico.solicitarDocumento(conta, "diplomaPosGraducao");
	                    			
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                    }    
						
					else if(escolhido.equals("Hist�rio Completo da Gradua��o")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("hist�rioCompletoGradua��o")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION);  
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                    
	                    		try
	                    		{
	                    			
	                    			controladorServico.solicitarDocumento(conta, "historicoCompletoGraducao");
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    
	                    }    
	                  

					else if(escolhido.equals("Hist�rico Completo da P�s Gradua��o")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("historioCompletoPosGradua��o")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
		
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                    		                    		
	                    		try
	                    		{
	                    			controladorServico.solicitarDocumento(conta, "historicoCompletoPosGraducao");
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                    }    
	                
					else if(escolhido.equals("Certificado de Conclus�o de Curso")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("certificadoConclusaoCurso")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						 
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                    	
	                    		try
	                    		{
	                    			controladorServico.solicitarDocumento(conta, "certificadoConclusaoCurso");
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                  						
					}
					else if(escolhido.equals("Transferencia Interna")){
						if(escolhido.equals("Transferencia Interna")){
							int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaInterna")+
									" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
							 
		                    if (escolha == JOptionPane.YES_OPTION) {
		                
		                    		try
		                    		{
		                    			controladorServico.solicitarDocumento(conta, "transderenciaInterna");
		                    			fachada.alterarDadosConta(conta);
		                    			JOptionPane.showMessageDialog(null,
			    								"Sucesso!");
		                    		}
		                    		catch(Exception e)
		                    		{
		                    			JOptionPane.showMessageDialog(null, e.getMessage());
		                    			
		                    		}
		                    		
		                    		
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                    						
					}
					else if(escolhido.equals("Transferencia Externa")){
						if(escolhido.equals("Transferencia Interna")){
							int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaExterna")+
									" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
				
		                    if (escolha == JOptionPane.YES_OPTION) {
		                   
		                    		try
		                    		{
		                    			controladorServico.solicitarDocumento(conta, "transderenciaExterna");
		                    			fachada.alterarDadosConta(conta);
		                    			JOptionPane.showMessageDialog(null,
			    								"Sucesso!");
		                    		}
		                    		catch(Exception e)
		                    		{
		                    			JOptionPane.showMessageDialog(null, e.getMessage());
		                    			
		                    		}
		                    		
		                    		
		                    		dispose();
		                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
		                    		telaPrincipalNaoADM.setVisible(true);
		                    	}
		                   
					}
						else  if(escolhido.equals("Transferencia Para Outra Institui��o")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("transferenciaParaOutraInstitui��o")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
			
	                    if (escolha == JOptionPane.YES_OPTION) {                                
	                    		
	                    		try
	                    		{
	                    			controladorServico.solicitarDocumento(conta, "transferenciaParaOutraInstituicao");
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	        
					}
					else if(escolhido.equals("Carteira de Estudante")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraEstudante")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
	
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    	
	                                    	
	                    		try
	                    		{
	                    			controladorServico.solicitarCarteira(conta);
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                   
					}
					else{
						JOptionPane.showMessageDialog(null, "Escolha uma a��o! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			  }
			});
			btnConfirmar.setBounds(118, 126, 95, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 95, 23);
			panel.add(btnCancelar);
		}
		
		else if(conta.getUsuario() instanceof Professor){
			JComboBox<String> comboBoxSolicitaDocumento = new JComboBox<String>();
			comboBoxSolicitaDocumento.addItem("Carteira de Professor");
			comboBoxSolicitaDocumento.setBounds(131, 85, 171, 20);
			panel.add(comboBoxSolicitaDocumento);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String escolhido = comboBoxSolicitaDocumento.getSelectedItem().toString();
					if(escolhido.equals("Carteira de Professor")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraProfessor")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
 
	                    if (escolha == JOptionPane.YES_OPTION) {
	                    		
	                    		try
	                    		{
	                    			controladorServico.solicitarCarteira(conta);
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                    }    
	                    
				
					else{
						JOptionPane.showMessageDialog(null, "Escolha uma a��o! ", "Mensagem de alerta", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnConfirmar.setBounds(118, 126, 95, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 95, 23);
			panel.add(btnCancelar);
		}
		else if(conta.getUsuario() instanceof Tecnico){
			JComboBox<String> comboBoxSolicitaDocumento = new JComboBox<String>();
			comboBoxSolicitaDocumento.setBounds(131, 85, 171, 20);
			comboBoxSolicitaDocumento.addItem("Carteira de T�cnico");
			panel.add(comboBoxSolicitaDocumento);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String escolhido = comboBoxSolicitaDocumento.getSelectedItem().toString();
					if(escolhido.equals("Carteira de Tecnico")){
						int escolha = JOptionPane.showConfirmDialog(null,"O documento custa R$ " + Servico.getPrecos().get("carteiraTecnico")+
								" Voc� deseja solicita-lo?","Solicitar",JOptionPane.YES_NO_CANCEL_OPTION); 
						 
	                    if (escolha == JOptionPane.YES_OPTION) {
	                  
	                    	
	                    		
	                    		try
	                    		{
	                    			controladorServico.solicitarCarteira(conta);
	                    			fachada.alterarDadosConta(conta);
	                    			JOptionPane.showMessageDialog(null,
		    								"Sucesso!");
	                    		}
	                    		catch(Exception e)
	                    		{
	                    			JOptionPane.showMessageDialog(null, e.getMessage());
	                    			
	                    		}
	                    		
	                    		dispose();
	                    		TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
	                    		telaPrincipalNaoADM.setVisible(true);
	                    	}
	                    	
	                    }    

				}
			});
			btnConfirmar.setBounds(118, 126, 95, 23);
			panel.add(btnConfirmar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					TelaPrincipalNaoADM telaPrincipalNaoADM = new TelaPrincipalNaoADM(conta);
					telaPrincipalNaoADM.setVisible(true);
				}
			});
			btnCancelar.setBounds(335, 126, 95, 23);
			panel.add(btnCancelar);
		}
		
		
		
		
		
	}
	private void setConta(Conta conta) {
		this.conta = conta;
		}	
}
