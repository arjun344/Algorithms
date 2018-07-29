import java.util.Scanner;


public class Palindromic
{
	static int param;
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

	static int Longest(String str1,int s1)
	{
		int matrix[][]=new int[s1][s1];
		int temp=0;

		for(int i=0;i<s1;i++)
		{
			matrix[i][i]=1;
		}

		for(int i=0;i<s1;i++)
		{
			for(int j=0;j<s1;j++)
			{
				if(j<i)
				{
					matrix[i][j]=0;
				}
			}
		}

		for(int i=0;i<s1;i++)
		{
			for(int j=1;j<s1;j++)
			{
			    param=i;
				if(i!=j)
				{
					if(str1.charAt(param)==str1.charAt(j))
					{
						matrix[param][j]=matrix[param+1][j-1]+2;
						temp=matrix[param][j];
						System.out.println("in" + param + j);
					}
					else
					{
						matrix[param][j]=max(matrix[param][j-1],matrix[param+1][j]);
						System.out.println("in" + param + j);
					
					}
					
					
				}
				param=param+1;
			}
			
		}

		return temp;


	}

	 public static void main(String[] args) {

	 	
	 	String str1="abab";

	 	int s1=str1.length();
	 	

	 	System.out.println("Sequence plaindrome is : "+ Longest(str1,s1));

		
	}
}