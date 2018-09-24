import java.util.Scanner;

public class optimal
{
	static int[] compare;
	static boolean valid;
	static int num;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int d = 1; d <= cases; d++)
		{
			num = in.nextInt();
			if (isPrime(num) && optimalPrime(num))
				System.out.printf("Battle #%d: Autobots, roll out!%n", d);
			else
				System.out.printf("Battle #%d: Oh no, the autobots are doomed!%n", d);
		}
	}
	
	static boolean isPrime(int n) //Could have used BigInteger and isProbablePrime
	{
	    for(int i = 2; i < (int)(Math.sqrt(n)) + 1; i++)
	    {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	static boolean optimalPrime(int n)
	{
		valid = false;
		String ns = n + "";
		compare = new int[ns.length()];
		for (int i = 0; i < ns.length(); i++)
			compare[i] = Integer.parseInt(ns.substring(i, i + 1));
		int[] perm = new int[ns.length()];
		boolean[] used = new boolean[ns.length()];
		permute(perm, used, 0);
		return valid;
	}

	public static void permute(int[] perm, boolean[] used, int k)
	{
		if (!valid)
		{
			if (k == perm.length)
			{
				if (compare[perm[0]] != 0)
				{
					String newnums = "";
					for (int i = 0; i < k; i++)
						newnums += compare[perm[i]] + "";
					int newnum = Integer.parseInt(newnums);
					if (newnum != num && isPrime(newnum))
						valid = true;
				}
			}
			for (int i = 0; i < perm.length; i++)
			{
				if (!used[i])
	 			{
					perm[k] = i;
					used[i] = true;
					permute(perm, used, k + 1);
					used[i] = false;
	 			}
			}
		}
	}

}