

public class lab8
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
	 		System.out.println("Podana zla ilosc argumentow");
	 	}
	 	catch(IllegalArgumentException  e)
	 	{
	 		System.out.println("Zla wartosc w pliku");
	 	}
	 	catch(NullPointerException e)
	 	{
	 		System.out.println("W pliku nie ma danych");
	 	}
	 	catch(ArithmeticException e)
	 	{
	 		System.out.println("Wystapil blad w obliczeniach");
	 	}
	 }
}