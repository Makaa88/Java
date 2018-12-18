import java.util.Scanner;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Dictionary implements Serializable
{
	Map<String,String> dict;


	public Dictionary()
	{
		dict  = new HashMap<String,String>();
	}


	public void MakeAChange(String operation, String wordOne, String wordTwo)
	{
		if(operation.equals("add"))
		{
			dict.put(wordOne,wordTwo);
			System.out.println("Dodano!");
		}
		else if(operation.equals("del") && dict.containsKey(wordOne))
		{
			dict.remove(wordOne);
			System.out.println("Usunieto");
		}
		else 
			System.out.println("Brak w slowniku");
	}

	public String GetValue(String key)
	{
		if(dict.containsKey(key))
			return dict.get(key);
		else return "Brak w slowniku";
	}
}