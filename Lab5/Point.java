public class Point extends Shape
{
	private double x;
	private double y;


	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	String getName()
	{
		return "Point";
	}

	public String toString()
	{
		return "[" + this.x + ", " + this.y +"]";
	}

	double area()
	{
		return 0.0;
	}

	double volume()
	{
		return 0.0;
	}

}