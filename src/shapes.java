import java.util.Scanner;

public class shapes
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numM = in.nextInt();
		for (int m = 1; m <= numM; m++)
		{
			int sides = in.nextInt();
			if (sides > 4)
				System.out.printf("Shape #%d: Johnny will not be pleased with this one.%n", m);
			else
				System.out.printf("Shape #%d: Johnny's favorite!%n", m);
		}
	}
}
