import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class PointPanel extends JPanel implements ActionListener{

	
	
	OurPoint[] pList;
	int pWidth,  pHeight;
	int numPoints;
	Timer t;
	
	Color bColor = Color.CYAN;
	Color pColor = Color.BLACK;
	
	//Constructor
	public PointPanel(int w, int h, int howManyPoints) {
		
		pWidth = w ;
		pHeight = h;
		numPoints = howManyPoints;
		pList = new OurPoint[numPoints];
		
		t = new Timer(50, this);
		t.restart();
		
		
		generatePoints();
	}
	
	
	
	
	private void generatePoints() {
		/* Example
		Point p = new Point (
				(int)(Math.random() * pWidth), 
				(int)(Math.random() * pheight)
				);
		
		*/
		for(int i = 0 ; i  < numPoints; i++ ) {
			 pList[i] = new OurPoint (
					 new Point(
					 (int)(Math.random() * pWidth), 
					 (int)(Math.random() * pHeight)
					 )
					);
		}

	}
	
	
	
	public void paintComponent(Graphics g) {
		g.setColor(bColor);
		g.fillRect(0, 0, pWidth, pHeight);
		
		int pointR= 4;
		//int pointR = (int)(Math.random() * 3) + 2;
		g.setColor(pColor);
		for(int i = 0 ; i  < numPoints; i++ ) {
			g.fillOval(
					pList[i].getX()-pointR, 
					pList[i].getY()-pointR, 
					pointR * 2, pointR*2
					);
		}
		
		// lines -- we should make this more efficient
		for(int j = 0; j < numPoints; j++) {
			OurPoint startPoint = pList[j];
			
			for(int i = 0; i < numPoints; i++) {
				
				g.drawLine(
						startPoint.getX(), 
						startPoint.getY(), 
						
						pList[i].getX(),
						pList[i].getY());
			}
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hey I'm awake");
		
		//Pseudo Code
		// move all our points....
		
		moveAllPoints();
		// redraw...
		repaint();
	}
	
	private void moveAllPoints() {
		
		//move all the points on pList
		for(int i = 0; i < pList.length; i++)
		{
			//pList[i].movePoint();
		}
		
	}
	

}
