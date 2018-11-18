import java.util.Random;

public class lab2
{
 public static void main(String args[])
 {
  Rnd x=new Rnd(10,100);
  x.Print();
  System.out.println("minimum = "+x.Min());
  System.out.println("maksimum = "+x.Max());
  System.out.println("avg = "+x.Average());
  x.Draw();
 }
}

class Rnd
{
	double [] array;
	int size;

	Rnd(int size, int numberOfMult)
	{
		Random rand = new Random();
		this.array = new double[size];
		this.size = size;

		for(int index = 0; index < size; index++)
		{
			for(int i = 0; i < numberOfMult; i++)
			{
				array[index] += rand.nextDouble();
			}
		}		

	}

	public void Print()
	{
		int i = 0;

		for(double element : array)
		{
			System.out.println("[" + i + "]" + " = " + element);
			i++;
		}
	}

	public double Min() 
	{
		double min = array[0];

		for(double element : array)
		{
			if(element < min)
			{
				min = element;
			}
		}

		return min;
	}

	public double Max() 
	{
		double max = array[0];

		for(double element : array)
		{
			if(element > max)
			{
				max = element;
			}
		}

		return max;
	}

	public double Average()
	{
		double sum = 0;
		for(double element : array)
		{
			sum += element;
		}

		return sum / size;
	}

	public void Draw()
	{
		double max = Max();
		double min = Min();
		double diff = max - min;

		int i = 0;
		for(double element : array)
		{
			System.out.print("[" + i + "]" + " = " );
			for(int k = 0; k < (((element - min) / diff) * 50); k++)
			{
				System.out.print("*");
			}
			i++;
		}
	}

}