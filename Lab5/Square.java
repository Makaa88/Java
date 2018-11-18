public class Square extends Point
{
	private double side;

	public Square(double side, double x, double y)
	{
		super(x,y);
		this.side = side;
	}

	String getName()
	{
		return "Square";
	}

	public String toString()
	{
		String pre = "Corner = "  + super.toString();
		String next = "; side = " + this.side;
		return pre + next;
	}

	double area()
	{
		return this.side * this.side;
	}

}