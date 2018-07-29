import java.util.Scanner;

public class EditDistance
{
	static int min(int x,int y,int z)
	{
		if(x<=y&&x<=z)
		{
			return x;
		}
		else if(y<=x&&y<=z)
		{
			return y;
		}
		else
		{
			return z;
		}
	}

	static int editdistance(String str1,String str2,int s1,int s2)
	{
		int distance[][];

		distance=new int[s1+1][s2+1];

		for(int i=0;i<=s1;i++)
		{
			for(int j=0;j<=s2;j++)
			{
				if(i==0)
				{
					distance[i][j]=j;
				}
				else if(j==0)
				{
					distance[i][j]=i;
				}
				else if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					distance[i][j]=distance[i-1][j-1];
				}
				else
				{
					distance[i][j]=1+min(distance[i-1][j],distance[i][j-1],distance[i-1][j-1]);
				}
			}
		}

		System.out.println("Operations required are : " + distance[s1-1][s2-1]);
		return 0;
	}
	public static void main(String... arg)
	{
		String str1="ababacdef";
		String str2="bacdef";

		int s1=str1.length();
		int s2=str2.length();

		editdistance(str1,str2,s1,s2);
	}
}