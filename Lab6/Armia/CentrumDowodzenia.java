package Armia;

import java.util.List;
import java.util.ArrayList;

interface Wykonaj
{
	void wydajRozkaz(String numer, Rozkaz rozkaz);
}

public class CentrumDowodzenia implements Wykonaj
{
	private List<Czolg> czolgList = new ArrayList<Czolg>();
	public CentrumDowodzenia()
	{

	}

	public void zarejestrujCzolg(Czolg tank)
	{
		czolgList.add(tank);
	} 

	public void wydajRozkaz(String numer, Rozkaz rozkaz)
	{
		czolgList.get(Integer.parseInt(numer) - 1).dodajRozkaz(rozkaz);
	}

	public String toString()
	{
		System.out.println("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:");
		for(int i=0; i < czolgList.size(); i++)
		{
			System.out.println("Czolg nr " + (i+1) + " otrzymal rozkazy:");
			czolgList.get(i).wypiszRozkazy();
			System.out.println();
		}

		return "";
	}

}