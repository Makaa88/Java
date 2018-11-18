public class Cube extends Square
{
	private double depth;

	public Cube(double depth, double x, double y)
	{
		super(depth,x,y);
		this.depth = depth;
	}

	String getName()
	{
		return "Cube";
	}

	public String toString()
	{
		String pre = super.toString();
		String next = "; depth = " + this.depth;
		return pre + next;
	}

	double area()
	{
		return 6 * super.area();
	}

	double volume()
	{
		return this.depth * super.area();
	}
}