import java.io.*;
import java.util.*;

public class lab10 implements Serializable
{
	public static void main(String[] argc)
	{
		File file = new File("slownik.ser");
		Dictionary dictionary = new Dictionary();
		if(file.exists())
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("slownik.ser"));
				dictionary.dict = (HashMap<String,String>) in.readObject();

				in.close();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}

		if(argc.length == 3)
		{

			String oper = argc[0];
			String w1 = argc[1];
			String w2 = argc[2];
			dictionary.MakeAChange(oper,w1,w2);
			try
			{
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("slownik.ser"));
				out.writeObject(dictionary.dict);
				out.close();
			}
			catch(Exception e)
			{
				System.out.println("Proba zapisu sie nie udala");
			}
		}
		else if(argc.length == 1)
		{
			String word = argc[0];
			System.out.println(dictionary.GetValue(word));
		}


	}
}