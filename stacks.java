import java.util.Scanner;

public class stacks
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numDays = in.nextInt();
		for (int d = 1; d <= numDays; d++)
		{
			int numStacks = in.nextInt();
			int[] stacks = new int[numStacks];
			for(int i = 0; i < numStacks; i++)
				stacks[i] = in.nextInt();
			
			int minCoins = Integer.MAX_VALUE;
			for(int parity = 0; parity < 2; parity++)
			{
				int coins = 0;
				for (int s = 0; s < numStacks; s++)
				{
					int reqParity = (s + parity) % 2;
					if(reqParity != (stacks[s] % 2))
						coins++;
				}
				minCoins = Math.min(minCoins, coins);
			}
			System.out.printf("Row #%d: Jerry needs to add a minimum of %d coins%n", d, minCoins);
		}
	}
}