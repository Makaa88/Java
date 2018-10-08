import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Person 
{
	public boolean checkStatus(int peoplesAmmount)
	{
		Map<Integer,Integer> matchingDays = new HashMap<Integer,Integer>();
		Random rand = new Random();
		for(int i = 0; i < peoplesAmmount; i++)
		{
			
			int day = rand.nextInt(366);
			if(!matchingDays.containsKey(day))
			{
				matchingDays.put(day,1);
			}
			else
			{
				return true;
			}
		}
		return false;
	}
}