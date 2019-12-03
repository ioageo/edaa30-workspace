package mountain;

public class Point {
	private int x, y;

	/** Constructs and initializes a point at the specified (x,y) location. */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** 
	 * Returns the x coordinate. 
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/** 
	 * Returns the y coordinate. 
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/** Indicates whether some other object is "equal to" this one.
	 * @param  obj the reference object with which to compare
	 * @return  true if this object is the same as the obj argument; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		} else {
			return false;
		}
	}

	
	
	/** set new X and Y
	 */
	public void Set_x_y(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}