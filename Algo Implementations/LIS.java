import java.util.Scanner;

public class LIS
{
	static int lis(int arr[],int n)
	{
		int list[]=new int[n];
		int i,j,max=0;

		for(i=0;i<n;i++)
		{
			list[i]=1;
		}

		for(i=1;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(arr[i]>arr[j]&&list[i]<list[j]+1)
				{
					list[i]=list[j]+1;

				}
			}
		}
		for(i=0;i<n;i++)
		{
			if(max<list[i])
			{
				max=list[i];
			}
		}
		System.out.print(arr[max] + " ");

		return max;
	}

	public static void main(String... arg)
	{
		int arr[]={10,22,9,33,21,50,41,60};
		int n=arr.length;
		System.out.println("Length is "+lis(arr,n));
	}
}