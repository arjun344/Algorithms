import java.util.Scanner;

public class BellManFord
{
	static int evaluation(int arr[][],int numberofvertices,int src)
	{
		int distance[]=new int[numberofvertices+1];
		for(int i=0;i<=numberofvertices;i++)
		{
			distance[i]=99;
		}
		distance[src]=0;

		for(int param=1;param<=numberofvertices-1;param++)
		{
			for(int source=1;source<=numberofvertices;source++)
			{
				for (int destination=1;destination<=numberofvertices;destination++ ) 
				{

					if(arr[source][destination]!=99)
					{
						if(distance[destination]>distance[source]+arr[source][destination])
						{
							distance[destination]=distance[source]+arr[source][destination];
						}
					}
				}
			}
		}

		for(int source=1;source<=numberofvertices;source++)
		{
			for(int destination=1;destination<=numberofvertices;destination++)
			{
				if(arr[source][destination]!=99)
				{
					if(distance[destination]>distance[source]+arr[source][destination])
						{
							System.out.println("This Graph has a Negative Cycle :");
						}
				}
			}
		}
	}
}
