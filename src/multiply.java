import java.util.Scanner;

public class multiply
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int d = 1; d <= cases; d++)
		{
			int first = in.nextInt();
			int last = in.nextInt();
			System.out.println(first * last);
		}
	}
}