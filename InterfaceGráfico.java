package grafico;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class InterfaceGráfico extends JFrame{
	JLabel anual, atual, necessaria, nanual, natual, nnecessaria, e1, e2, e3, e4;
	FunçõesBase n = new FunçõesBase();
	JList lista = new JList();
	String materias[]= {"Matemática", "Português", "Geografia", "História", "Sociologia", "Filosofia", "Química", "Biologia", "Física"
	};
	GraficoPanel panel;
	
	public InterfaceGráfico() {
		super("Gráfico de performance");

		criarTela();
		
		setLayout(null);
		setSize(800, 680);
		setVisible(true);
		
	}
	
	private void criarTela() {

		
		anual = new JLabel("Média anual:");
		atual = new JLabel("Média atual:");
		necessaria = new JLabel("Nota para aprovação:");
		
		lista = new JList<String>(materias);
		lista.setSelectedIndex(0);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane barra = new JScrollPane(lista);
		
		add(barra);
		barra.setBounds(20, 50, 150, 20);
		add(anual);
		anual.setBounds(20, 150, 150, 20);
		add(atual);
		atual.setBounds(20, 200, 150, 20);
		add(necessaria);
		necessaria.setBounds(20, 250, 150, 20);
		
		nanual = new JLabel(n.getMediaAnual()+"");
		natual = new JLabel(n.calcularMedia()+"");
		nnecessaria = new JLabel(n.calcularAprovacao()+"");
		
		add(nanual);
		nanual.setBounds(100, 150, 150, 20);
		add(natual);
		natual.setBounds(100, 200, 250, 20);
		add(nnecessaria);
		nnecessaria.setBounds(150, 250, 150, 20);
		
		e1 = new JLabel("1° etapa");
		e2 = new JLabel("2° etapa");
		e3 = new JLabel("3° etapa");
		e4 = new JLabel("4° etapa");
		
		add(e1);
		e1.setBounds(300, 500, 150, 20);
		add(e2);
		e2.setBounds(400, 500, 150, 20);
		add(e3);
		e3.setBounds(500, 500, 150, 20);
		add(e4);
		e4.setBounds(600, 500, 150, 20);
		
	}
	private class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
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
