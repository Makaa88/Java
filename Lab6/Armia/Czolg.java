package Armia;


import java.util.List;
import java.util.ArrayList;

public class Czolg
{
	List<Rozkaz> rozkazy = new ArrayList<Rozkaz>();	
	public Czolg()
	{

	}

	public void dodajRozkaz(Rozkaz roz)
	{
		rozkazy.add(roz);
	}

	public void wypiszRozkazy()
	{
		for(int i = 0; i < rozkazy.size(); i++)
		{
			System.out.println(rozkazy.get(i));
		}
	}

	public String ostatniRozkaz()
	{
		String ostatni = "Ostatni rozkaz do mnie: ";
		ostatni += rozkazy.get(rozkazy.size() - 1).getRozkaz();
		return ostatni;
	}

}