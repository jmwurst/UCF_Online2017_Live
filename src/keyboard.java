import java.util.*;

public class keyboard
{
	public static String[] notes = new String[]{"C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B"};
	public static int[] vals = new int[]{0, 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11};

	public static HashMap<String, Integer> map;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		map = new HashMap<String, Integer>();
		for(int i = 0; i < notes.length; i++)
			map.put(notes[i], vals[i]);

		int numCases = in.nextInt();

		for(int caseN = 1; caseN <= numCases; caseN++)
		{
			int n = in.nextInt();

			int cur = map.get(in.next());

			int dist = 0;
			
			for (int i = 1; i < n; i++)
			{
				int next = map.get(in.next());
				int dif = Math.abs(next - cur); 
				dist += Math.min(dif, 12 - dif);
				cur = next;
			}

			System.out.printf("Song #%d: %d\n", caseN, dist);
		}
	}
}