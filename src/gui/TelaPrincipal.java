/**
 * 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import classes_basicas.Servico;

/**
 * @author JN
 *
 */
public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Servico.setPrecos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
