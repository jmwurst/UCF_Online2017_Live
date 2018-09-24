import java.util.*;

public class hyenas
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numM = in.nextInt();
		for (int m = 1; m <= numM; m++)
		{
			int numR = in.nextInt();
			in.nextInt();
			in.nextLine();
			int numH = 0;
			for (int i = 0; i < numR; i++)
			{
				String temp = in.nextLine();
				for (int j = 0; j < temp.length(); j++)
					if (temp.charAt(j) == 'H')
						numH++;
			}
			System.out.printf("Location #%d: %d%n", m, numH);
		}
	}
}
