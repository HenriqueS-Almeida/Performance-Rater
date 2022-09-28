package grafico;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraficoPanel extends JPanel{

	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		g.fillRect(600, 400, 30, 50);
	}
}
