package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class mountain extends Fractal {
	private int length;
	private int dev;
	private Point points[];
	private HashMap<Side, Point> sides;

	/**
	 * Creates an object that handles Koch's fractal.
	 * 
	 * @param length the length of the triangle side
	 */
	public mountain(int length, int dev) {
		super();
		this.length = length;
		points = new Point[3];
		sides = new HashMap<Side, Point>();
		this.dev = dev;
	}

	/**
	 * Returns the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return "mountain";
	}

	/**
	 * Draws the fractal.
	 * 
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		points[0] = new Point((int) (turtle.getWidth() / 2.0 - length / 2.0),
				(int) (turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0));
		points[1] = new Point((int) points[0].getX() + length, points[0].getY());
		points[2] = new Point((points[0].getX() + points[1].getX() / 2 - length), points[0].getY() - length);
		fractalLine(turtle, order, points, dev);

	}

	/**
	 * Recursive method: Draws a recursive line of the triangle.
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point[] points, int dev) {

		if (order == 0) {
			turtle.moveTo(points[0].getX(), points[0].getY());
			turtle.penDown();
			for (int i = points.length - 1; i >= 0; i--) {
				turtle.forwardTo(points[i].getX(), points[i].getY());
			}
			turtle.penUp();

		} else {

			Side s1 = new Side(points[0], points[1]);
			Side s2 = new Side(points[1], points[2]);
			Side s3 = new Side(points[2], points[0]);

			if (sides.containsKey(s1)) {
				s1.setMid(sides.get(s1));

			} else {
				s1.setMid((s1.EndPoint1().getX() + s1.EndPoint2().getX()) / 2,
						(int) ((s1.EndPoint1().getY() + s1.EndPoint2().getY()) / 2)
								- (int) (RandomUtilities.randFunc(dev)));

			}
			if (sides.containsKey(s2)) {

				s2.setMid(sides.get(s2));

			} else {
				s2.setMid((s2.EndPoint1().getX() + s2.EndPoint2().getX()) / 2,
						(int) ((s2.EndPoint1().getY() + s2.EndPoint2().getY()) / 2)
								- (int) (RandomUtilities.randFunc(dev)));

			}
			if (sides.containsKey(s3)) {
				s3.setMid(sides.get(s3));

			} else {
				s3.setMid((s3.EndPoint1().getX() + s3.EndPoint2().getX()) / 2,
						(int) ((s3.EndPoint1().getY() + s3.EndPoint2().getY()) / 2)
								- (int) (RandomUtilities.randFunc(dev)));

			}

			sides.put(s1, s1.getMid());
			sides.put(s2, s2.getMid());
			sides.put(s3, s3.getMid());


			points[0] = s1.EndPoint1();
			points[1] = sides.get(s1);
			points[2] = sides.get(s3);
			fractalLine(turtle, order - 1, points, dev / 2);

			points[0] = sides.get(s1);
			points[1] = s1.EndPoint2();
			points[2] = sides.get(s2);
			fractalLine(turtle, order - 1, points, dev / 2);
			
			points[0] = sides.get(s3);
			points[1] = sides.get(s2);
			points[2] = s2.EndPoint2();
			fractalLine(turtle, order - 1, points, dev / 2);
			
			points[0] = sides.get(s1);
			points[1] = sides.get(s2);
			points[2] = sides.get(s3);
			fractalLine(turtle, order - 1, points, dev / 2);

			
			

		}
	}

}