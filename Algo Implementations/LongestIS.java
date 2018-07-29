import java.util.Scanner;

public class LongestIS
{
	static int Longest(int arr[],int n)
	{
		int lis[]=new int[n];

		for(int i=0;i<n;i++)
		{
			lis[i]=1;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i]>arr[j] && lis[i]<lis[j]+1)
				{
					lis[i]=lis[j]+1;
				}
			}
		}

		int max=0;
		for(int i=0;i<n;i++)
		{
			if(lis[i]>max)
			{
				max=lis[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		
		int arr[]={3,4,-1,0,6,2,3};
		int n=arr.length;

		System.out.println("Longest subsequnece legth is " + Longest(arr,n));
	}
}