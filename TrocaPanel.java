package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrocaPanel extends JPanel{
	JButton g, m, a;
	
	public TrocaPanel() {
		setLayout(null);
		setBounds(0, 0, 800, 100);
		setVisible(true);
		setBackground(Color.GREEN);
		g = new JButton("Gráfico");		
		m = new JButton("Matérias");	
		a = new JButton("Agenda");	
		
		
		criarTela();
		
		
	}
	
	private void criarTela() {
		
		g.setBounds(300, 10, 100, 20);
		g.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TrocaPanel();
				remove(m);
			}
		});
		add(g);
		m.setBounds(410, 10, 100, 20);
		add(m);
		a.setBounds(520, 10, 100, 20);
		add(a);
	}
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(800,680);
		j.setVisible(true);
		
		TrocaPanel p = new TrocaPanel();
		j.add(p);

		
	}

}
