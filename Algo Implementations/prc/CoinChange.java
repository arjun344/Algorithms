import java.util.Scanner;

public class CoinChange
{
	static int coinchange(int coins[],int total)
	{
		int matrix[][]=new int[coins.length+1][total+1];

		for(int i=0;i<=coins.length;i++)
		{
			matrix[i][0]=1;
		}
		for(int i=1;i<=coins.length;i++)
		{
			for(int j=1;j<=total;j++)
			{
				if(coins[i-1]>j)
				{
					matrix[i][j]=matrix[i-1][j];
				}
				else
				{
					matrix[i][j]=matrix[i][j-coins[i-1]]+matrix[i-1][j];
				}
			}
		}
		return matrix[coins.length][total];
	}

	public static void main(String... arg)
	{
		int coins[]={1,2,3};
		int total=5;

		System.out.println("No of Ways is : "+ coinchange(coins,total));
	}
}