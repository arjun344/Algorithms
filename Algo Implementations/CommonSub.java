import java.util.Scanner;

public class CommonSub
{

	static int max(int x,int y)
	{
		if(x<y)
		{
			return y;
		}
		else
		{
			return x;
		}
	}

	static int Common(String str1,String str2,int s1,int s2)
	{
		int track[][]=new int[s1+1][s2+1];
		int temp=0;

		for(int i=0;i<=s2;i++)
		{
			track[0][i]=0;
		}
		for(int i=0;i<=s1;i++)
		{
			track[i][0]=0;
		}



		for(int i=1;i<s1;i++)
		{
			for(int j=1;j<s2;j++)
			{
				if(str1.charAt(i)==str2.charAt(j))
				{
					track[i][j]=track[i-1][j-1]+1;
					temp=track[i][j]+1;
					System.out.print(str1.charAt(i));
					System.out.println("");
				}
				else
				{
					track[i][j]=max(track[i-1][j],track[i][j-1]);

				}
			}
		}

		return temp;


	}

	public static void main(String... arg)
	{
		String str1="bqdrcvefgh";
		String str2="abcvefgh";

		int s1=str1.length();
		int s2=str2.length();

		System.out.println("Common sequence is : " +Common(str1,str2,s1,s2));

	}
}