package mountain;

public class Side {
	public Point p1;
	public Point p2;
	public Point mid;

	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		mid=null;
	}
		
	public Point EndPoint1() {
		return p1;
	}
	
	public Point EndPoint2() {
		return p2;
	}
	public Point getMid() {
		return mid;
		
	}
	public void setMid(int x,int y) {
		mid= new Point (x,y);
	}
	
	public void setMid(Point p) {
		mid=p;
	}
	
	@Override
	public int hashCode() {
	    return  p1.hashCode() + p2.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side) obj;
			return (p1 == s.p1 && p2 == s.p2) || (p1 == s.p2 && p2 ==s.p1);
			
		} else {
			return false;
		}
	}

}