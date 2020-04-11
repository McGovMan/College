
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

public class BadGuy {
	
	Stack<Node> route = new Stack<>();
	Image myImage;
	int x=0,y=0;
	boolean hasPath=false;

	public BadGuy( Image i ) {
		myImage=i;
		x = 30;
		y = 10;
	}
	
	public void reCalcPath(boolean map[][],int targx, int targy) {
		// TO DO: calculate A* path to targx,targy, taking account of walls defined in map[][]
		// Init variables
		route = new Stack<>();
		LinkedList<Node> cList = new LinkedList<>();
		//boolean cList[][] = new boolean[40][40];
		LinkedList<Node> oList = new LinkedList<>();
		Node[][] nodes = new Node[40][40];
		Node curr = null, next = null;
		hasPath=false;

		// initialise the map state
		int a, b;
		for (a=0;a<40;a++) {
			for (b=0;b<40;b++) {
				nodes[a][b] = new Node(a, b);
			}
		}

		// Setting start node to base g off
		Node startNode = nodes[Math.floorMod(x, 39)][Math.floorMod(y, 39)];
		startNode.setParent(null);
		startNode.setG(0);
		startNode.setH(((Math.abs(targx - startNode.getX())) + (Math.abs(targy - startNode.getY()))) * 10);
		startNode.setF();
		oList.add(startNode);

		// Finding a route
		while (!oList.isEmpty() && !hasPath) {
			curr = oList.getFirst();

			for (Node n : oList) {
				if (n.f <= curr.f) {
					curr = n;
				}
			}

			oList.remove(curr);
			cList.add(curr);

			if (curr.getX() != targx || curr.getY() != targy) {
				for (int xx = -1; xx <= 1; xx++) {
					for (int yy = -1; yy <= 1; yy++) {
						if (xx != 0 || yy != 0) {
							int g;
							if (((xx == 1) && (yy == 1)) || ((xx == -1) && (yy == -1)) || ((xx == 1) && (yy == -1)) || ((xx == -1) && (yy == 1))) {
								g = 14;
							} else {
								g = 10;
							}

							//Node next = new Node(curr, curr.getX() + xx, curr.getY() + yy);
							next = nodes[Math.floorMod(curr.getX() + xx, 39)][Math.floorMod(curr.getY() + yy, 39)];

							if (!cList.contains(next)) {
								if (!map[next.getX()][next.getY()]) {
									if (!oList.contains(next)) {
										next.setParent(curr);
										next.setG(next.getParent().getG() + g);
										next.setH((Math.abs(targx - next.getX()) + Math.abs(targy - next.getY())) * 10);
										next.setF();
										oList.add(next);
									} else if (curr.getG() + g < next.getG()) {
										next.setParent(curr);
										next.setG(next.getParent().getG() + g);
										next.setH(((targx - next.getX()) + (targy - next.getY()) * 10));
										next.setF();
									}
								} else {
									cList.add(next);
								}
							}
						}
					}
				}
			} else {
				hasPath = true;
			}
		}

		while (curr.parent != null) {
			route.add(curr);
			curr = curr.getParent();
		}
	}

	public void move(boolean map[][],int targx, int targy) {
		reCalcPath(map, targx, targy);
		if (hasPath) {
			// TO DO: follow A* path, if we have one defined
			System.out.print("following path\n");
			//if (!route.isEmpty()) route.pop();
			if (!route.isEmpty()) {
				Node n = route.pop();
				//route.pop();
				x = n.x;
				y = n.y;
			}
		}
		else {
			// no path known, so just do a dumb 'run towards' behaviour
			System.out.print("playing dumb\n");
			int newx=x, newy=y;
			if (targx<x)
				newx--;
			else if (targx>x)
				newx++;
			if (targy<y)
				newy--;
			else if (targy>y)
				newy++;
			if (!map[newx][newy]) {
				x=newx;
				y=newy;
			}
		}

	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}

