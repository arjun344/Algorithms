import java.util.Scanner;

public class CommonSequence
{

	static int max(int x,int y)
	{
		if(x<=y)
		{
			return y;
		}
		else
		{
			return x;
		}
	}
	static int common(String str1,String str2,int s1,int s2)
	{
		int track[][]=new int[s1+1][s2+1];
		int temp=0;

		for(int i=0;i<=s1;i++)
		{
			if(i==0)
			{
				track[0][i]=0;
			}
		}

		for(int i=0;i<=s2;i++)
		{
			if(i==0)
			{
				track[i][0]=0;
			}
		}

		for(int i=1;i<=s1;i++)
		{
			for(int j=1;j<=s2;j++)
			{
				if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					track[i][j]=track[i-1][j-1]+1;
					temp=track[i][j];
					System.out.println(str2.charAt(j-1));

				}
				else
				{
					track[i][j]=max(track[i][j-1],track[i-1][j]);
				}
			}
		}
		System.out.println();

		return temp;

	}
	public static void main(String... arg)
	{
		String str1="bqdrcvefgh";
		String str2="abcvefgh";

		int s1=str1.length();
		int s2=str2.length();
		System.out.println("Size of longest common subsequence is : " +common(str1,str2,s1,s2));
	}
}