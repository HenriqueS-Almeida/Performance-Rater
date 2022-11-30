import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Materia;

public class InterfaceGráfico extends JFrame{
	JLabel anual, atual, necessaria, nanual, natual, nnecessaria, e1, e2, e3, e4;
	JButton b1, b2, b3, b4;
	Materia n = new Materia();
	JList lista = new JList();
	List<String> materias = new ArrayList<String>();
	List<JButton> bot = new ArrayList();
	
	public InterfaceGráfico() {
		criarTelaGrafico();
		
		setLayout(null);
		setBounds(0,0,800, 680);
		setVisible(true);
		
	}
	
	private void criarTelaGrafico() {
		materias.add("Matemática");
		materias.add("Português");
		materias.add("Química");
		materias.add("POO");
		materias.add("Banco de dados");

		trocaPanel();
		
		anual = new JLabel("Média anual:");
		atual = new JLabel("Média atual:");
		necessaria = new JLabel("Nota para aprovação:");
		
		lista = new JList<Object>(materias.toArray());
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
		e1.setBounds(250, 500, 150, 20);
		add(e2);
		e2.setBounds(375, 500, 150, 20);
		add(e3);
		e3.setBounds(500, 500, 150, 20);
		add(e4);
		e4.setBounds(625, 500, 150, 20);
		
		
		b1 = new JButton("Inserir nota");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nota = JOptionPane.showInputDialog("Insira a nota");
				Double m = Double.parseDouble(nota);
				n.alterarNota(1, m);
				natual.setText(n.calcularMedia()+"");
				nnecessaria.setText(n.calcularAprovacao()+"");
			}
		});
		b2 = new JButton("Inserir nota");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nota = JOptionPane.showInputDialog("Insira a nota");
				Double m = Double.parseDouble(nota);
				n.alterarNota(2, m);
				natual.setText(n.calcularMedia()+"");
				nnecessaria.setText(n.calcularAprovacao()+"");
			}
		});
		b3 = new JButton("Inserir nota");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nota = JOptionPane.showInputDialog("Insira a nota");
				Double m = Double.parseDouble(nota);
				n.alterarNota(3, m);
				natual.setText(n.calcularMedia()+"");
				nnecessaria.setText(n.calcularAprovacao()+"");
			}
		});
		b4 = new JButton("Inserir nota");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nota = JOptionPane.showInputDialog("Insira a nota");
				Double m = Double.parseDouble(nota);
				n.alterarNota(4, m);
				natual.setText(n.calcularMedia()+"");
				nnecessaria.setText(n.calcularAprovacao()+"");
			}
		});
		
		add(b1);
		b1.setBounds(225, 550, 100, 20);
		add(b2);
		b2.setBounds(350, 550, 100, 20);
		add(b3);
		b3.setBounds(475, 550, 100, 20);
		add(b4);
		b4.setBounds(600, 550, 100, 20);
	}
	public void trocaPanel() {
		JButton g, m, a;

		g = new JButton("Gráfico");		
		m = new JButton("Matérias");	
		a = new JButton("Agenda");	
		
		
		g.setBounds(300, 10, 100, 20);
		g.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfaceGráfico();
				dispose();
			}
		});
		add(g);
		m.setBounds(410, 10, 100, 20);
		m.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfaceMaterias();
				dispose();
			}
		});
		add(m);
		a.setBounds(520, 10, 100, 20);
		add(a);
		
		
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
