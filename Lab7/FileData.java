import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileData
{
	private String inName;
	private List<Float> fileDigitList = new ArrayList<Float>();

	public FileData(String in)
	{
		this.inName = in;
		
	}

	public void make()
	{
		try
		{
			File file = new File(inName);
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String st;
			while((st = bf.readLine()) != null)
			{
				float digit = Float.parseFloat(st);
				fileDigitList.add(digit);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku lub nie mozna go otworzyc");
			return;
		}
		catch(IOException e)
		{
			System.out.println("Wystapil blad przy otwarciu pliku");
			return;
		}

		countAverage();
	}

	private void countAverage()
	{
		float sum = 0;
		if(fileDigitList.size() == 0)
			throw new NullPointerException();
		for(int i = 0; i < fileDigitList.size(); i++)
		{
			sum += fileDigitList.get(i);
		}
		if(sum == 0)
			throw new ArithmeticException();
		float average = sum/fileDigitList.size();
		System.out.println("Srednia liczba w pliku: " + average);
		
	}

}