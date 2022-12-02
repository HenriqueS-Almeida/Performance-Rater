package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Materia;


public class InterfaceGráfico extends JFrame{
	
	public InterfaceGráfico() {
		super("Gráfico de performance");
		
		TrocaPanel t = new TrocaPanel();
		add(t);
		GraficoPanel panel = new GraficoPanel();
		add(panel);
		
		setLayout(null);
		setSize(800, 680);
		setVisible(true);
		
	}
	
	
	
	public static void main(String args[]) {
		  javax.swing.SwingUtilities.invokeLater(
				  new Runnable() {                    
	                	@Override
	                    public void run() {
	                    	JFrame.setDefaultLookAndFeelDecorated(true);
	                    	JDialog.setDefaultLookAndFeelDecorated(true);
	                    	InterfaceGráfico band = new InterfaceGráfico();
	                        band.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                        
	                        
	                	}
	        		}
				  );
	}
}
