import java.util.*;

public class coins
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for (int d = 1; d <= cases; d++)
		{
			String[] data = in.nextLine().split(" ");
			int coins = Integer.parseInt(data[0]);
			int k = Integer.parseInt(data[1]);
			String name = data[2];
			if (coins % (k + 1) == 0)
				System.out.printf("Game #%d: %s%n", d, otherName(name));
			else
				System.out.printf("Game #%d: %s%n", d, name);
		}
	}
	
	static String otherName(String s)
	{
		if (s.equals("Matthew"))
			return "Bill";
		return "Matthew";
	}
}
