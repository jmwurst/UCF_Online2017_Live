import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class unite
{	
	public static class Point
	{
		public int x, y, z;
		
		public Point(int f, int t, int c)
		{
			x = f;
			y = t;
			z = c;
		}
		
		public int costTo(Point o)
		{
			return (int)(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
		}
	}
	
	public static class Edge implements Comparable<Edge>
	{
		public int from, to, cost;
		
		public Edge(int f, int t, int c)
		{
			from = f;
			to = t;
			cost = c;
		}
		
		public int compareTo(Edge o)
		{
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int universes = in.nextInt();
		for (int u = 1; u <= universes; u++)
		{
			int numSys = in.nextInt();
			
			Point[] points = new Point[numSys];
			
			for (int i = 0; i < numSys; i++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				int z = in.nextInt();
				points[i] = new Point(x, y, z);
			}
			
			ArrayList<Edge>[] adj = new ArrayList[numSys];
			for (int i = 0; i < numSys; i++)
			{
				adj[i] = new ArrayList<Edge>();
				for (int j = 0; j < numSys; j++)
				{
					if (i != j)
						adj[i].add(new Edge(i, j, points[i].costTo(points[j])));
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			for (int i = 0; i < adj[0].size(); i++) //start at node 0 by adding all edges from node 0 to pq
				pq.add(adj[0].get(i));
			boolean[] visited = new boolean[numSys]; //records which nodes have been added to the MST already
			visited[0] = true;
			int ans = 0;
			while (pq.size() > 0)
			{
				Edge now = pq.poll(); //since pq is sorted by edge size, now is shortest edge that connects a node in the component
									  //to another node that may (or may not) be in the component
				if (visited[now.to])  //skip if node is already in the component
					continue;
				visited[now.to] = true; //mark node as present in the component
				ans += now.cost;
				for (int i = 0; i < adj[now.to].size(); i++) //all edges that come out of the new node are added to pq
					pq.add(adj[now.to].get(i));
			}
			System.out.printf("Universe #%d: %d%n", u, ans);
		}
		
	}
}