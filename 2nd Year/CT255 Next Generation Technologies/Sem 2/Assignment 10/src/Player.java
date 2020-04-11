
import java.awt.Graphics;
import java.awt.Image;


public class Player {

	Image myImage;
	int x=0,y=0;
	int xSpeed=0, ySpeed=0;

	public Player( Image i ) {
		myImage=i;
		x=20;
		y=10;
	}
	
	public void setXSpeed( int x ) {
		xSpeed=x;
	}
	
	public void setYSpeed( int y ) {
		ySpeed=y;
	}
	
	public void move(boolean map[][]) {
		int newx=x+xSpeed;
		int newy=y+ySpeed;
		if (!map[newx][newy]) {
			x=newx;
			y=newy;
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}
