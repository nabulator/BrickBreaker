import java.util.Date;


public class Stuff 
{
	public static void main(String args[])
	{
		Date now = new Date();
		Date end = new Date(new Date().getTime() + 6000);

		System.out.println(now.getTime());
		System.out.println(end.getTime());

	}
}
