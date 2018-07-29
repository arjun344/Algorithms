import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

class HuffmanNode
{
	int data;
	char c;

	HuffmanNode right;
	HuffmanNode left;
}

class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y)
	{
		return x.data - y.data;
	}
}


public class HuffManPrc
{
	public static void printcode(HuffmanNode root,String s)
	{
		if(root.left==null && root.right==null && Character.isLetter(root.c))
		{
			System.out.println(root.c + " : " + s);
			return;
		}

		printcode(root.left,s+"0");
		printcode(root.right,s+"1");
	}

	public static void main(String... arg)
	{
		Scanner scan=new Scanner(System.in);
		int numberofcharacters;
		System.out.println("Enter the no of characters : ");
		numberofcharacters=scan.nextInt();
		System.out.println("Enter the Character and its frequency : ");
		int charFreq[]=new int[numberofcharacters];
		char charArray[]=new char[numberofcharacters];

		for(int i=0;i<numberofcharacters;i++)
		{
			charArray[i]=scan.next().charAt(0);
			charFreq[i]=scan.nextInt();
		}

		PriorityQueue<HuffmanNode> q=new PriorityQueue<HuffmanNode>(numberofcharacters,new MyComparator());

		for(int i=0;i<numberofcharacters;i++)
		{
			HuffmanNode hn=new HuffmanNode();

			hn.data=charFreq[i];
			hn.c=charArray[i];

			hn.left=null;
			hn.right=null;

			q.add(hn);
		}

		HuffmanNode root=null;

		while(q.size() > 1)
		{
			HuffmanNode x=q.peek();
			q.poll();

			HuffmanNode y=q.peek();
			q.poll();

			HuffmanNode f= new HuffmanNode();

			f.data=x.data+y.data;
			f.c='-';

			f.left=x;
			f.right=y;

			root=f;

			q.add(f);

		}

		printcode(root,"");

	}
}