import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class OurPoint3 {
	
	Point xyCoords;  //normal x, y coords
	int startX, startY;  //the place where you clicked
	int centerX, centerY; //a center point picked to the left of the start coordinate
	int dy, dx;   // speed along y axis 5 and -5
	
	//We would include ellipse equation points
	
	int radiusSize;
	int angleSpeed;  //degrees per frame (up to 35 but at least 5 + or -
	int currentAngle;  // where you are on the circle
	
	
	
	//constructor...
	public OurPoint3(Point p) {
		// copy p into our class field
		
		xyCoords = p;
		startX = xyCoords.x;
		startY = xyCoords.y;
		radiusSize = (int)(Math.random() * 40) + 15;
		centerX = startX - radiusSize ;
		centerY = startY;
		
		
		currentAngle = 0;  //we can change this
		angleSpeed = (int)(Math.random() * 30) + 5;
		//angleSpeed = 10;
		//with this its never 0
		if((int) (Math.random() * 100) + 1 > 50) {
			angleSpeed *= -1;
		}
		//System.out.println("angle speed is " + angleSpeed);

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
		
		//New way to move a point 
		
		currentAngle = (currentAngle + angleSpeed)% 360;
		//System.out.println("Current angle is " + currentAngle);
		double currentRad = currentAngle * (Math.PI/180.0);
		//System.out.println("Current radians is " + currentRad);
		
		xyCoords.x = (int)(centerX + ((Math.cos(currentRad)) * radiusSize));
		xyCoords.y = (int)(centerY + ((Math.sin(currentRad)) * radiusSize));
	 
		/* 
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
		*/
		
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
		
		dx = dx * -1;
		dy = dy * -1;
		
		
		
		
		/*
		System.out.println("Current dx " + dx);
		System.out.println("Current dy " + dy);
		
		double angleRad = Math.atan(
				((xyCoords.y - startY)* 1.0)/((xyCoords.x -startX)*1.0)
				);
		System.out.println( "the angle in radians is: " + angleRad );
		
		double newAngleRad = angleRad + (((int)(Math.random() * 5) - 2) * oneRadian);
		
		System.out.println( "the new angle in radians is: " + newAngleRad );
		
		double newDY = Math.sin(newAngleRad) * 5;
		double newDX = Math.cos(newAngleRad) * 5;
		
		System.out.println("newDX is " + newDX);
		System.out.println("newDY is " + newDY);
		
		dx = (int)(newDX * -1.0);
		dy = (int)(newDY * -1.0);
		
		System.out.println("New dx " + dx);
		System.out.println("New dy " + dy);
		
		xyCoords.x += dx;
		xyCoords.y += dy;	
		*/
		
		

	}
	
	
	
	
	//
	public void drawOuterCircle(Graphics g) {
		//draws a circle around the point
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		g2.setColor(Color.GRAY);
		g2.drawOval(
				centerX - radiusSize, 
				centerY - radiusSize, 
				radiusSize * 2, radiusSize * 2);
			
		
	}
	


}
