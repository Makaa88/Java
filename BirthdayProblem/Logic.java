

public class Logic
{
	public static void main(String[] args)
	{
		int n = 57;
		int times = 10000;
		int trueAnswers = 0;
		for(int i = 0; i < times; i++)
		{
			Person p = new Person();
			if(p.checkStatus(n)) trueAnswers++;
		}
		System.out.println((trueAnswers/(double)times) * 100);
	}
}