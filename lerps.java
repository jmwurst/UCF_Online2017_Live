import java.util.*;

public class lerps
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int nume = in.nextInt();
		for (int e = 1; e <= nume; e++)
		{
			int total = 0;
			int numLerps = in.nextInt();
			int[] lerps = new int[numLerps];
			int sum = 0;
			for (int i = 0; i < lerps.length; i++)
			{
				int temp = in.nextInt();
				lerps[i] = temp;
				sum += temp;
			}
			int optimal = Integer.MAX_VALUE;
			if (sum % 2 == 0)
				optimal = 0;
			else
			{
				for (int i = 0; i < lerps.length; i++)
					if (lerps[i] % 2 == 1)
					{
						int sumLeft = sumLeft(lerps, i);
						int sumRight = sumRight(lerps, i);
						if (sumLeft % 2 == 0 && sumRight % 2 == 0)
							optimal = Math.min(optimal, lerps[i]);
					}
			}
			System.out.printf("Environment #%d: %d lerps%n", e, sum - optimal);
		}
	}
	
	static int sumLeft(int[] ar, int target)
	{
		int sum = 0;
		for (int i = 0; i < target; i++)
			sum += ar[i];
		return sum;
	}
	
	static int sumRight(int[] ar, int target)
	{
		int sum = 0;
		for (int i = ar.length - 1; i > target; i--)
			sum += ar[i];
		return sum;
	}
}