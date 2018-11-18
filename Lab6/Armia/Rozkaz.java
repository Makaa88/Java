package Armia;


public class Rozkaz
{
	private String rozkaz;
	
	public Rozkaz(String roz)
	{
		this.rozkaz = roz;
	}

	public String getRozkaz()
	{
		return this.rozkaz;
	}

	public String toString()
	{
		return rozkaz;
	}
}