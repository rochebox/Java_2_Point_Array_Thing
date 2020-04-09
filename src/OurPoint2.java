import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class OurPoint2 {
	
	Point xyCoords;  //normal x, y coords
	int startX, startY;
	int dx;   // speed along x axis 5 and -5
	int dy;   // speed along y axis 5 and -5
	
	//We would include ellipse equation points
	
	int radiusSize;
	
	
	
	//constructor...
	public OurPoint2(Point p) {
		// copy p into our class field
		xyCoords = p;
		startX = xyCoords.x;
		startY = xyCoords.y;
		
		// set dx to be between -5 and 5
		dx = (int)(Math.random() * 11) - 5;
		dy = (int)(Math.random() * 11) - 5;	
		
		radiusSize = (int)(Math.random() * 40) + 15;
	}
	
	//Access Methods
	public int getX() {
		return xyCoords.x;
	}
	
	public int getY() {
		return xyCoords.y;
	}
	
	public int getdX() {
		return dx;
	}
	
	public int getdY() {
		return dy;
	}
	
	//set up mutator methods  -- setters
	public void setX(int newX) {
		xyCoords.x = newX;
	}
	
	public void setY(int newY) {
		xyCoords.y = newY;
	}
	// changes the x and y value by the dx and dy
	public void movePoint() {
		xyCoords.x += dx;
		xyCoords.y += dy;	
		//now check to see if they are out of the circle	
		
		if (
				getDistance(xyCoords.x, xyCoords.y, startX, startY)
				>=
				radiusSize
				) {
			
			//move point back
			xyCoords.x -= dx;
			xyCoords.y -= dy;	
			//System.out.println("I need to change direction.");
			changeDirection();
		}
		
	}
	
	//this uses pythagorean theorem to compute distance
	public int getDistance(int x1, int y1, int x2, int y2) {
		
		int dist = (int) (Math.sqrt(
				((x2-x1)*(x2-x1)* 1.00) + ((y2-y1)*(y2-y1)*1.00)	
				
				));
		
		
		
		return dist;
	}
	
	//this is a routine to the dx and dy of the point
	private void changeDirection() {
		double oneRadian = 0.0174533;
		
		
		
		//Make this be better  -- You program this
		
		if(dx >= 0) {
			dx = (int)(Math.random() * -6) -2;
		} else {
			dx = (int)(Math.random() * 6) +2;
		}
		
		if(dy >= 0) {
			dy = (int)(Math.random() * -6) -2;
		} else {
			dy = (int)(Math.random() * 6) +2;
		}
	
		
		
		//this move the point back into the circle
		xyCoords.x += dx;
		xyCoords.y += dy;	

	}
	
	
	
	
	//
	public void drawOuterCircle(Graphics g) {
		//draws a circle around the point
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		g2.setColor(Color.GRAY);
		g2.drawOval(
				startX - radiusSize, 
				startY - radiusSize, 
				radiusSize * 2, radiusSize * 2);
			
		
	}
	


}
