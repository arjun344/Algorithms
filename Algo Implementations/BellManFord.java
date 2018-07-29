import java.util.Scanner;

public class BellManFord
{
	private int distances[];
	private int numberofvertices;
	public static final int maxvalue=999;


	public BellManFord(int numberofvertices)
	{
		this.numberofvertices=numberofvertices;
		distances=new int[numberofvertices+1];

	}

	public void BellManFordEvaluation(int source,int adjacencymatrix[][])
	{

		for(int node=1;node<=numberofvertices;node++)
		{
			distances[node]=maxvalue;
		}

		distances[source]=0;

		for(int node=1;node<=numberofvertices-1;node++)
		{
			for(int sourcenode=1;sourcenode<=numberofvertices;sourcenode++)
			{
				for(int destinationnode=1;destinationnode<=numberofvertices;destinationnode++)
				{
					if(adjacencymatrix[sourcenode][destinationnode]!=maxvalue)
					{
						if(distances[destinationnode]>distances[sourcenode]+adjacencymatrix[sourcenode][destinationnode])
						{
							distances[destinationnode]=distances[sourcenode]+adjacencymatrix[sourcenode][destinationnode];

						}

					}
				}
			}
		}

		for(int sourcenode=1;sourcenode<=numberofvertices;sourcenode++)
		{
			for(int destinationnode=1;destinationnode<=numberofvertices;destinationnode++)
			{
				if(adjacencymatrix[sourcenode][destinationnode]!=maxvalue)
				{
					if(distances[destinationnode]>distances[sourcenode]+adjacencymatrix[sourcenode][destinationnode])
					{
						System.out.println("The Graph Has A negative Edge");
					}
				}
			}
		}

		for(int vertex=1;vertex<=numberofvertices;vertex++)
		{
			System.out.println("Distance of source " +source + " to "+vertex + " is "+distances[vertex]);

		}

	}

	public static void main(String... arg)
	{
		int numberofvertices=0;
		int source;
		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter the number of verices :");
		numberofvertices=scanner.nextInt();

		int adjacencymatrix[][]=new int[numberofvertices+1][numberofvertices+1];
		System.out.println("Enter the adjacency matrix : ");

		for(int sourcenode=1;sourcenode<=numberofvertices;sourcenode++)
			{
				for(int destinationnode=1;destinationnode<=numberofvertices;destinationnode++)
				{
					adjacencymatrix[sourcenode][destinationnode]=scanner.nextInt();

					if(sourcenode==destinationnode)
					{
						adjacencymatrix[sourcenode][destinationnode]=0;
						continue;
					}

					if(adjacencymatrix[sourcenode][destinationnode]==0)
					{
						adjacencymatrix[sourcenode][destinationnode]=maxvalue;
					}
				}
			}

			System.out.println("Enter the source vertex");
            source = scanner.nextInt();
            BellManFord bellmanford = new BellManFord(numberofvertices);
            bellmanford.BellManFordEvaluation(source, adjacencymatrix);
            scanner.close();

	}
}