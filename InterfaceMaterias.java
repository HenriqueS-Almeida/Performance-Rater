package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class InterfaceMaterias extends JFrame{
	
	public InterfaceMaterias() {
		super("Disciplinas");
		TrocaPanel t = new TrocaPanel();
		add(t);
		MateriasPanel p = new MateriasPanel();
		add(p);
		JScrollPane barra = new JScrollPane(p);
		barra.setBounds(773,0,20,550);
		add(barra);
		
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
	                    	InterfaceMaterias mat = new InterfaceMaterias();
	                        mat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                        
	                        
	                	}
	        		}
				  );
	}
}
