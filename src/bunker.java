import java.util.ArrayList;
import java.util.Scanner;

public class bunker
{
	static ArrayList<Integer> primes;
	static ArrayList<String> primesS;
	
	public static void main(String[] args) //the key is to check sum of distances from each point to all other points, take the min
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int d = 1; d <= cases; d++)
		{
			int radius = in.nextInt();
			int numAngles = in.nextInt();
			double[] angles = new double[numAngles];
			for (int i = 0; i < numAngles; i++)
				angles[i] = in.nextDouble();
			
			double dist = Double.MAX_VALUE;
			for (int i = 0; i < numAngles; i++)
			{
				double tempDist = 0;
				for (int j = 0; j < numAngles; j++)
					if (i != j)
						tempDist += 2 * Math.PI * radius * (angleDist(angles[i], angles[j]) / 360.0);
				dist = Math.min(dist, tempDist);
			}
			System.out.printf("Tree #%d: %.3f%n", d, dist);
		}
	}
	
	static double angleDist(double a1, double a2)
	{
		double poss1 = Math.abs(a1 - a2);
		double poss2 = (a1 < a2) ? (a1 + 360.0) - a2 : (a2 + 360.0) - a1;
		return Math.min(poss1, poss2);
	}
}