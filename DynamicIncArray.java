import java.util.*;
class DynamicIncArray
{
	public static void main(String args[])throws Exception
	{
		int[][] a = new int[10][2];
		int i=0,j=0;
		for(i=0;i<10;i++)
			for(j=0;j<2;j++)
				a[i][j]=i+j;
		List <int[]>b = new ArrayList<int[]>();
		for(i=0;i<10;i++)
		{
			b.add(new int[]{a[i][0],a[i][1]});
		}
		for(int[] c: b)
			System.out.println(Arrays.toString(c));
	}
}