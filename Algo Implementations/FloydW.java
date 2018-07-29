import java.util.Scanner;

public class FloydW
{
	int distancematrix[][];
	int numberofvertices;

	public FloydW(int numberofvertices)
	{
		distancematrix=new int[numberofvertices+1][numberofvertices+1];
		this.numberofvertices=numberofvertices;
	}

	public void FloydWimplem(int adjacencymatrix[][])
	{
		for(int source=1;source <=numberofvertices;source++)
		{
			for(int destination=1;destination<=numberofvertices;destination++)
			{
				distancematrix[source][destination]=adjacencymatrix[source][destination];
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

					}

				}
			}

		}

		System.out.println("The graph Matrix is : ");

		for(int source=1;source<=numberofvertices;source++)
		{
			System.out.print("\t" + source);
		}
		System.out.println();
		for(int source=1;source<=numberofvertices;source++)
		{
				System.out.print(source);
			for(int destination=1;destination<=numberofvertices;destination++)
			{
				if(distancematrix[source][destination]==999)
				{
					System.out.print("\t" +"INF");
				}
				else
				{
					System.out.print("\t" + distancematrix[source][destination]);
				}
			}
			System.out.println();
		}





		System.out.println("The Shortes distance Matrix is : ");

		for(int source=1;source<=numberofvertices;source++)
		{
			System.out.print("\t" + source);
		}
		System.out.println();
		for(int source=1;source<=numberofvertices;source++)
		{
				System.out.print(source);
			for(int destination=1;destination<=numberofvertices;destination++)
			{
				
					System.out.print("\t" + adjacencymatrix[source][destination]);

			}
			System.out.println();
		}
	}


	public static void main(String... arg)
	{
		int numberofvertices;
		int distancematrix[][];

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the numbers of Vertices : ");
		numberofvertices=scan.nextInt();
		distancematrix=new int[numberofvertices+1][numberofvertices+1];
		System.out.println("Enter the Weighted Graph : ");
		for(int source=1;source<=numberofvertices;source++)
		{
			for(int destination=1;destination<=numberofvertices;destination++)
			{
				distancematrix[source][destination]=scan.nextInt();

				if(source==destination)
				{
					distancematrix[source][destination]=0;
					continue;
				}
				if(distancematrix[source][destination]==0)
				{
					distancematrix[source][destination]=999;
				}
			}
		}

		FloydW floyd=new FloydW(numberofvertices);

		floyd.FloydWimplem(distancematrix);
	}
}






