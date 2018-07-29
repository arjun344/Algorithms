import java.util.Scanner;

public class CoinChange
{
	static int coinchange(int arr[],int total,int size)
	{
		int matrix[][]=new int[4][5];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(i==0&&j==0)
				{
					matrix[i][j]=1;
				}
				else if(i==0)
				{
					matrix[0][j]=0;
				}
				else
				{
					if(i>j)
					{
						matrix[i][j]=matrix[i-1][j];
					}
					else
					{
						matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
					}
				}
				
			}
		}

		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}


		return matrix[3][4];
	}

	public static void main(String... arg)
	{
		int arr[]={0,1,2,3,4,5};
		int total=4;

		System.out.println("Ways are : "+ coinchange(arr,total,3));
	}
}
