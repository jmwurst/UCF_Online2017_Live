import java.util.*;

public class wipeout_INCOMPLETE //Time Limit Exceeded - djikstra???
{
	static int time;
	static int platformGoal;
	static ArrayList<Obstacle>[] platforms;
	
	public static class Obstacle
	{
		public int from, to, stamina, time;
		
		public Obstacle(int f, int t, int s, int ti)
		{
			from = f;
			to = t;
			stamina = s;
			time = ti;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int d = 1; d <= cases; d++)
		{
			int numPlatforms = in.nextInt();
			int numObstacles = in.nextInt();
			int initStamina = in.nextInt();
			platformGoal = numPlatforms - 1;
			platforms = new ArrayList[numPlatforms];
			for (int i = 0; i < numPlatforms; i++)
				platforms[i] = new ArrayList<Obstacle>();
			for (int i = 0; i < numObstacles; i++)
			{
				int from = in.nextInt() - 1;
				int to = in.nextInt() - 1;
				int stamcost = in.nextInt();
				int timecost = in.nextInt();
				platforms[from].add(new Obstacle(from, to, stamcost, timecost));
			}
			boolean[] visited = new boolean[numPlatforms];
			Arrays.fill(visited, false);
			visited[0] = true;
			time = -1;
			wipo(initStamina, 0, 0, visited);
			if (time == -1)
				System.out.printf("Episode #%d: Wipeout!%n", d);
			else
				System.out.printf("Episode #%d: %d%n", d, time);
		}
	}
	
	static void wipo(int staminaRemaining, int curPlatform, int curTime, boolean[] visited)
	{
		if (curPlatform == platformGoal || staminaRemaining < 0)
		{
			if (staminaRemaining >= 0)
			{
				if (time == -1)
					time = curTime;
				else
					time = Math.min(time, curTime);
			}
			return;
		}
		for (int i = 0; i < platforms[curPlatform].size(); i++)
		{
			Obstacle ob = platforms[curPlatform].get(i);
			if (!visited[ob.to])
			{
				visited[ob.to] = true;
				wipo(staminaRemaining - ob.stamina, ob.to, curTime + ob.time, visited);
				visited[ob.to] = false;
			}
		}
	}
}