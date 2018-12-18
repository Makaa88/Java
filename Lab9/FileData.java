import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileData
{
	private String fileInName;
	private String fileOutName;
	private int sizeX;
	private int sizeY;
	private List<Point> filePointsList = new ArrayList<Point>();

	public FileData(String name)
	{
		this.fileInName = name;
	}

	public void make()
	{
		try
		{
			File file = new File(fileInName);
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String st;
			st = bf.readLine();
			String[] tabString = st.split(" ");

			sizeX = Integer.parseInt(tabString[0]);
			sizeY = Integer.parseInt(tabString[1]);
			fileOutName = tabString[2];

			st = bf.readLine();
			int numberOfPoints = Integer.parseInt(st);

			for(int i = 0; i < numberOfPoints; i++)
			{
				st = bf.readLine();
				tabString = st.split(",");
				filePointsList.add(new Point(Integer.parseInt(tabString[0]),Integer.parseInt(tabString[1])));
			}

			calculateAndSave();
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
	}


	private void calculateAndSave()
	{
		double eps = 1e-6;
		System.out.println(eps);
		try
		{
			File file = new File(fileOutName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String st = sizeX + " " + sizeY;
			bw.write("P3");
			bw.newLine();
			bw.write("#Mateusz Libirt");
			bw.newLine();
			bw.write(sizeX + " " + sizeY);
			bw.newLine();
			bw.write("255"); 
			bw.newLine();

			for(int i = 0; i < sizeX; i++)
			{
				for(int j = 0; j < sizeY; j++)
				{
					for(int s = 0; s < filePointsList.size(); s++)
					{
						//double x1 = (double)Math.pow(filePointsList.get(s).x - i,2);
						//double y1 = (double)Math.pow(filePointsList.get(s).y - j,2);

						int index = getSecondpoint(s);
						//System.out.println(index);
						//double x2 = (double)Math.pow(filePointsList.get(index).x - i,2);
						//double y2 = (double)Math.pow(filePointsList.get(index).y - j,2);

						/*double d1 = x1 + y1;
						double d2 = x2 + y2;*/
						double d1 = Math.pow(filePointsList.get(s).x - j,2) + Math.pow(filePointsList.get(s).y - i,2);
						
						double d2 = Math.pow(filePointsList.get(index).x -j ,2) + Math.pow(filePointsList.get(index).y - i, 2);
						//System.out.println(d2-d1);
						if(Math.abs(d2-d1) < eps)
						{
							bw.write("0 0 0 ");
						}
						else if((Math.abs(d1) < eps) || (Math.abs(d2) < eps))
						{
							bw.write("255 0 0 ");
						}
						else
						{
							bw.write("255 255 255 ");
						}
					}
				}
			}

			bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Wystapil blad przy zapisie do pliku");
			return;
		}
	}


	private int getSecondpoint(int index)
	{
		
		int toret = index;
		double myD = Math.pow(filePointsList.get(index).x,2) + 
				Math.pow(filePointsList.get(index).y,2);
		double d = Math.abs((sizeY * sizeY * sizeX * sizeX) - (myD));
		for(int i = 0; i < filePointsList.size(); i++)
		{
			if(i != index)
			{
				double newD = Math.pow(filePointsList.get(i).x,2) + 
				Math.pow(filePointsList.get(i).y,2);
				if(Math.abs(myD - newD) < d)
				{
					d = newD;
					toret = i;
				}
			}
		}
		return toret;
	} 
}