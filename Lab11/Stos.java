public class Stos<T>
{
	private Unit<T> head;

	public Stos()
	{
		head = null;
	}

	public void push(T value)
	{
		Unit<T> unit = new Unit<T>(value);
		unit.next = head;
		head = unit;
	}

	public void pop()
	{
		head = head.next;
	}

	public String toString()
	{
		Unit<T> unit = head;
		String output = "";
		while(unit != null)
		{
			output += "{"+unit.value+"} ";
			unit = unit.next;
		}

		//System.out.println();
		return output;
	}
}