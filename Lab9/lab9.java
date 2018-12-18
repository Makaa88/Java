public class lab9
{
	public static void main(String[] argc)
	{
		try
		{
			if(argc.length != 1) throw new SecurityException();
			FileData fd = new FileData(argc[0]);
			fd.make();
		}
		catch(SecurityException e)
		{
			System.out.println("Podala zla ilosc argumentow");
		}
	}

}