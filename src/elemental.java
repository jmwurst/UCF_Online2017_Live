import java.util.*;

public class elemental
{
	static String[] elements;
	static String[] goal;
	
	static boolean isValid;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numElements = in.nextInt();
		int d = 1;
		while (numElements != 0)
		{
			in.nextLine();
			elements = in.nextLine().split(" ");
			goal = in.nextLine().split(" ");
			boolean[] valid = new boolean[goal.length];
			
			for (int i = 0; i < goal.length; i++)
			{	
				isValid = false;
				lookfor("", i);
				valid[i] = isValid;
			}
			boolean overall = true;
			for (int i = 0; i < valid.length; i++)
				if (!valid[i])
					overall = false;
			
			if (overall)
				System.out.printf("Phrase #%d: Elemental%n", d);
			else
				System.out.printf("Phrase #%d: Not Elemental%n", d);
			System.out.println();
			numElements = in.nextInt();
			d++;
		}
	}
	
	static void lookfor(String currentStr, int word)
	{
		if (currentStr.equals(goal[word]))
			isValid = true;
		
		for (int i = 0; i < elements.length; i++)
		{
			String newStr = currentStr + elements[i];
			if (newStr.length() <= goal[word].length() && newStr.equals(goal[word].substring(0, newStr.length())))
				lookfor(newStr, word);
		}
	}
}