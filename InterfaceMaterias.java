package materia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfaceMaterias extends JFrame{
	JButton m, p, q, poo, bd;
	JLabel materia;
	
	public InterfaceMaterias() {
		super("Disciplinas");
		
		criarTela();
		
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
