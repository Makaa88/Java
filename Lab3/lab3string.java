public class lab3string
{
	public static int dlugosc(String napis)
	{
		return napis.length();
	}

	public static int ile_razy_literka_wystepuje(String napis, char znak)
	{
		int dlugosc = napis.length();
		int ilosc = 0;
		for(int i = 0; i < dlugosc; i++)
		{
			if(napis.charAt(i) == znak) ilosc++;
		}
		return ilosc;
	}

	public static boolean czy_takie_same(String napis1, String napis2)
	{
		return napis1.equals(napis2);
	}

	public static String wspak(String napis)
	{
		String odwrotny = "";
		int dlugosc = napis.length();
		for(int i = dlugosc-1; i>=0; i--)
		{
			odwrotny += napis.charAt(i);
		}
		return odwrotny;
	}

	public static boolean czy_plaindrom(String napis)
	{
		return czy_takie_same(napis, wspak(napis));
	}

	public static boolean czy_abecadlowe(String napis)
	{
		for(int i = 0; i < dlugosc(napis) - 1; i++)
		{
			if(napis.charAt(i) > napis.charAt(i+1))
			{
				return false;
			}
		}

		return true;
	}

	public static String rot13(String napis)
	{
		String nowy = "";
		for(int i = 0; i < dlugosc(napis); i++)
		{
			char znak = napis.charAt(i);
			if(znak >= 'A' && znak <= 'Z')
			{
				int temp = (int)znak +  13;
				if(temp > 'Z') temp = 'A' + (temp - 'Z') - 1;
				nowy += (char)temp;
			}
			else if(znak >= 'a' && znak <= 'z')
			{
				int temp = (int)znak +  13;
				if(temp > 'z') temp = 'a' + (temp - 'z') - 1;
				nowy += (char)temp;
			}
			else nowy += znak;
		}

		return nowy;
	}
}