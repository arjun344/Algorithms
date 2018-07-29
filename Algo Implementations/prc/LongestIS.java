import java.util.Scanner;

public class LongestIS
{
	static int longest(int arr[],int n)
	{
		int list[]=new int[n];

		for(int i=0;i<n;i++)
		{
			list[i]=1;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i]>arr[j]&&list[i]<list[j]+1)
				{
					list[i]=list[j]+1;
				}
			}
		}

		int max=0;
		for(int i=0;i<n;i++)
		{
			if(list[i]>max)
			{
				max=list[i];
			}
		}

		return max;
	}

	public static void main(String... arg)
	{
		int arr[]={10,12,9,13,4,11,20};
		int n=7;

		System.out.println("longest is : " +longest(arr,n));
	}
}