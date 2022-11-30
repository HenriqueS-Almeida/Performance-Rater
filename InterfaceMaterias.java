
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfaceMaterias extends JFrame{
	JButton m, p, q, poo, bd, g;
	JLabel materia;
	
	public InterfaceMaterias() {
		super("Disciplinas");
		
		criarTela();
		trocaPanel();
		
		setLayout(null);
		setSize(800, 680);
		setVisible(true);
	}
	
	private void criarTela() {

		m = new JButton("Matemática");
		p = new JButton("Português");
		q = new JButton("Química");
		poo = new JButton("POO");
		bd = new JButton("Banco de dados");
		g = new JButton("Geografia");
		
		add(m);
		m.setBounds(20,150,200,125);
		add(p);
		p.setBounds(290,150,200,125);
		add(q);
		q.setBounds(560,150,200,125);
		add(poo);
		poo.setBounds(290,350,200,125);
		add(bd);
		bd.setBounds(560,350,200,125);
		add(g);
		g.setBounds(20,350,200,125);
		
		p.addActionListener(new Evento());
	}
	
	private void telaP() {
		materia = new JLabel("Português");
		add(materia);
		materia.setBounds(350,50,200,125);
		
		m = new JButton("Análise de discurso");
		p = new JButton("Interpretação de texto");
		q = new JButton("Gêneros textuais");
		poo = new JButton("Interpretação de texto não verbal");
		bd = new JButton("Domínio da normal culta");
		g = new JButton("Período composto");
		
		add(m);
		m.setBounds(20,150,200,125);
		add(p);
		p.setBounds(290,150,200,125);
		add(q);
		q.setBounds(560,150,200,125);
		add(poo);
		poo.setBounds(290,350,200,125);
		add(bd);
		bd.setBounds(560,350,200,125);
		add(g);
		g.setBounds(20, 350, 200, 125);
	}

	private void trocaPanel() {
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
	
	private class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==p) {
				remove(m);
				remove(poo);
				remove(q);
				remove(p);
				remove(bd);
				remove(g);
				
				telaP();
				
			}
		}
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
