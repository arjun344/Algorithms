import java.util.Scanner;

public class FloydWarshall
{
	static int distance(int arr[][],int numberofvertices)
	{
		int adjacencymatrix[][]=new int[numberofvertices+1][numberofvertices+1];
		int path[][]=new int[numberofvertices+1][numberofvertices+1];

		for(int i=1;i<=numberofvertices;i++)
		{
			for(int j=1;j<=numberofvertices;j++)
			{
				adjacencymatrix[i][j]=arr[i][j];
			}
		}

		for(int intermediate=1;intermediate<=numberofvertices;intermediate++)
		{
			for(int source=1;source<=numberofvertices;source++)
			{
				for(int destination=1;destination<=numberofvertices;destination++)
				{
					if(adjacencymatrix[source][intermediate]+adjacencymatrix[intermediate][destination]<adjacencymatrix[source][destination])
					{
						adjacencymatrix[source][destination]=adjacencymatrix[source][intermediate]+adjacencymatrix[intermediate][destination];
						path[source][destination]=intermediate;
					}
				}
			}
		}

		System.out.println("Updated shortest distance matrix is : ");
		for(int i=1;i<=numberofvertices;i++)
		{
			System.out.print("\tV"+i);
		}
		System.out.println();

		for(int i=1;i<=numberofvertices;i++)
		{
			for(int j=1;j<=numberofvertices;j++)
			{
				System.out.print("\t" + adjacencymatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("Updated shortest path matrix is : ");
		for(int i=1;i<=numberofvertices;i++)
		{
			for(int j=1;j<=numberofvertices;j++)
			{
				System.out.print("\t" + path[i][j]);
			}
			System.out.println();
		}

		return 0;
	}

	public static void main(String... arg)
	{
		int arr[][];
		int numberofvertices;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the no of vertices : ");
		numberofvertices=scan.nextInt();
		arr=new int[numberofvertices+1][numberofvertices+1];

		System.out.println("Enter the graph matrix : ");
		for(int i=1;i<=numberofvertices;i++)
		{
			for(int j=1;j<=numberofvertices;j++)
			{
				arr[i][j]=scan.nextInt();
				if(i==j)
				{
					arr[i][j]=0;
				}
				else if(arr[i][j]==0 && i!=j)
				{
					arr[i][j]=99;
				}

			}
		}

		distance(arr,numberofvertices);


	}
}