import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class DisplayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Main main;
	
	public DisplayPanel(Main m){
		main=m;
	}
	
	public void paintComponent(Graphics g){
		/*
		g.setColor(Color.white);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		*/
		
		g.setColor(Color.black);
		g.drawRect(0, 0, 200, 200);
		g.fillOval(-2+(int)(main.input[0]*200), -2+(int)(main.input[1]*200), 5, 5);
		
		float val1, val2, val3; 
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				val1=main.SOM[i][j].weights[0]; 
				val2=main.SOM[i][j].weights[1]; 
				val3=main.SOM[i][j].weights[2]; 
				g.setColor(new Color (val1, val2, val3)); 
				g.fillRect(250+i*10,  j*10,  10,  10);
			}
		}
		
		g.setColor(Color.black);
		g.drawRect(500, 150, 250, 250);
		g.drawRect(600, 50, 250, 250);
		
		g.drawLine(500, 150, 600, 50);
		g.drawLine(650, 150, 850, 50);
		
		g.drawLine(500, 400, 600, 300);
		g.drawLine(750, 400, 850, 300);
		
		int px,py,pz;
		for (int i=0;i<20;i++){
			for (int j=0;j<20;j++){
				
				px=(int) (main.SOM[i][j].weights[0]*250);
				py=(int) (main.SOM[i][j].weights[1]*250);
				pz=(int) (main.SOM[i][j].weights[2]*100);
				
				g.fillOval(500+px+pz, 150+py-pz, 3, 3);
			}
		}
		
		int px2,py2,pz2;
		for (int i=0;i<19;i++){
			for (int j=0;j<20;j++){
				
				px=(int) (main.SOM[i][j].weights[0]*250);
				py=(int) (main.SOM[i][j].weights[1]*250);
				pz=(int) (main.SOM[i][j].weights[2]*100);
				
				px2=(int) (main.SOM[i+1][j].weights[0]*250);
				py2=(int) (main.SOM[i+1][j].weights[1]*250);
				pz2=(int) (main.SOM[i+1][j].weights[2]*100);
				
				g.drawLine(500+px+pz, 150+py-pz, 500+px2+pz2, 150+py2-pz2);
			}
		}
		
		for (int i=0;i<20;i++){
			for (int j=0;j<19;j++){
				
				px=(int) (main.SOM[i][j].weights[0]*250);
				py=(int) (main.SOM[i][j].weights[1]*250);
				pz=(int) (main.SOM[i][j].weights[2]*100);
				
				px2=(int) (main.SOM[i][j+1].weights[0]*250);
				py2=(int) (main.SOM[i][j+1].weights[1]*250);
				pz2=(int) (main.SOM[i][j+1].weights[2]*100);
				
				g.drawLine(500+px+pz, 150+py-pz, 500+px2+pz2, 150+py2-pz2);
				
			}
		}
	}
	
}
