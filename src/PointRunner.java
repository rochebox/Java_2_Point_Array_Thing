import javax.swing.JFrame;

public class PointRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sWidth  = 700;
		int sHeight = 500; 
		
		JFrame f = new JFrame("Point Array Thingy");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(sWidth, sHeight);
		
		PointPanel p = new PointPanel(sWidth, sHeight-22, 10); 
		f.add(p);
		
		f.setVisible(true);

	}

}
