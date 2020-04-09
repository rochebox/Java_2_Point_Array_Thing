import java.awt.Point;

public class OurPoint {
	
	Point xyCoords;  //normal x, y coords
	int dx;   // speed along x axis 5 and -5
	int dy;   // speed along y axis 5 and -5
	
	//We would include ellipse equation points
	
	
	
	//constructor...
	public OurPoint(Point p) {
		// copy p into our class field
		xyCoords = p;
		
		// set dx to be between -5 and 5
		dx = (int)(Math.random() * 11) - 5;
		dy = (int)(Math.random() * 11) - 5;	
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
		
	}
	

}
