import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dinner
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for (int c = 1; c <= cases; c++)
		{
			ArrayList<String> valid = new ArrayList<String>();
			int rests = Integer.parseInt(in.nextLine());
			for (int r = 0; r < rests; r++)
			{
				String name = in.nextLine();
				if ((isPrime(name.length()) && vowelsOdd(name)) || areSquares(name))
					valid.add(name);
			}
			if (valid.size() > 0)
			{
				System.out.printf("Practice #%d: %d valid options%n", c, valid.size());
				for (int i = 0; i < valid.size(); i++)
					System.out.println(valid.get(i));
			}
			else
				System.out.printf("Practice #%d: It's hopeless!%n", c);
			System.out.println();
		}
	}
	
	static boolean isPrime(int n)
	{
	    for(int i = 2; 2 * i < n; i++)
	    {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	
	static boolean vowelsOdd(String s)
	{
	    double vowels = vowelsVal(s);
	    if (vowels % 2.0 == 1.0)
	    	return true;
	    return false;
	}
	
	static double vowelsVal(String s)
	{
		double vowels = 0;
	    for (int i = 0; i < s.length(); i++)
	    {
	    	char c = s.charAt(i);
	    	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
	    		vowels++;
	    	else if (c == 'y')
	    		vowels += 0.5;
	    }
	    return vowels;
	}
	
	static boolean areSquares(String s)
	{
	    double vowels = vowelsVal(s);
	    double length = s.length();
	    if (Math.sqrt(vowels) % 1.0 == 0.0 && Math.sqrt(length) % 1.0 == 0.0)
	    	return true;
	    return false;
	}
}