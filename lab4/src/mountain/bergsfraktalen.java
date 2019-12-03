package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class bergsfraktalen extends Fractal {
	private int length;
	Point[]points;

	/**
	 * Creates an object that handles Koch's fractal.
	 * 
	 * @param length the length of the triangle side
	 */
	public bergsfraktalen(int length) {
		super();
		this.length = length;
		points= new Point[3];
	}

	/**
	 * Returns the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return "bergsfraktalen triangel";
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
		points[2] = new Point((int) points[0].getX() + length / 2 - 160, points[0].getY() - length);
		fractalLine(turtle, order, points);

	}

	/*
	 * Recursive method: Draws a recursive line of the triangle.
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point[] points) {

		if (order == 0) {
			turtle.moveTo(points[0].getX(), points[0].getY());
			turtle.penDown();
			for (int i = points.length - 1; i >= 0; i--) {
				turtle.forwardTo(points[i].getX(), points[i].getY());
			}
			turtle.penUp();
		} else {
			Point temp1[] = new Point[3];
			Point temp2[] = new Point[3];
			Point temp3[] = new Point[3];
			Point temp4[] = new Point[3];

			temp1[0] = new Point((points[2].getX() + points[0].getX()) / 2, (points[2].getY() + points[0].getY()) / 2);
			temp1[1] = new Point((points[2].getX() + points[1].getX()) / 2, (points[2].getY() + points[1].getY()) / 2);
			temp1[2] = new Point((points[1].getX() + points[0].getX()) / 2, (points[1].getY() + points[0].getY()) / 2);

			temp2[0] = points[0];
			temp2[1] = temp1[0];
			temp2[2] = temp1[2];

			temp3[0] = temp1[0];
			temp3[1] = points[2];
			temp3[2] = temp1[1];

			temp4[0] = temp1[2];
			temp4[1] = temp1[1];
			temp4[2] = points[1];

			fractalLine(turtle, order - 1, temp1);
			fractalLine(turtle, order - 1, temp2);
			fractalLine(turtle, order - 1, temp3);
			fractalLine(turtle, order - 1, temp4);

		}
	}

}