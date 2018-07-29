import java.util.Scanner;

public class Edit
{
	static int min(int x,int y,int z)
	{
		if(x<=y&&x<=z)
		{
			return x;
		}
		if(y<=x&&y<=z)
		{
			return y;
		}
		else
			return z;
	}

	static int editDistance(String str1,String str2,int s1,int s2)
	{
		int dist[][]=new int[s1+1][s2+1];

		for(int i=0;i<=s1;i++)
		{
			for(int j=0;j<=s2;j++)
			{
				if(i==0)
				{
					dist[i][j]=j;
				}
				else if(j==0)
				{
					dist[i][j]=i;
				}
				else if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dist[i][j]=dist[i-1][j-1];
				}
				else 				//insert         //delete	    //replace
				{
					dist[i][j]=1+min( dist[i][j-1] , dist[i-1][j] , dist[i-1][j-1] );
				}
            } 
           

		}
			

		return dist[s1][s2];

	}

	public static void main(String... arg)
	{
		Scanner scan=new Scanner(System.in);

		String str1=scan.next();
		String str2=scan.next();

		System.out.println(editDistance(str1,str2,str1.length(),str2.length()));
	}
}