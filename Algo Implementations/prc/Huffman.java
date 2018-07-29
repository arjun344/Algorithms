import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

class HuffmanNode
{
	int data;
	char c;

	HuffmanNode left;
	HuffmanNode right;
}

class Mycomparator implements Comparator<HuffmanNode>
{
	public  int compare(HuffmanNode x,HuffmanNode y)
	{
		return x.data - y.data;
	}
}

public class Huffman
{
	static void encoding(HuffmanNode root,String s)
	{
		if(root.left==null && root.right==null && Character.isLetter(root.c))
		{
			System.out.println(root.c+ " : " + s);
			return;
		}
		
		encoding(root.left,s + "0");
		encoding(root.right,s + "1");
	}

	public static void main(String... arg)
	{
		char charArray[]={'a','b','c','d','e'};
		int charFreq[]={10,20,30,12,9};

		PriorityQueue<HuffmanNode> q=new PriorityQueue<HuffmanNode>(5,new Mycomparator());

		HuffmanNode root=null;

		for(int i=0;i<5;i++)
		{
			HuffmanNode hn=new HuffmanNode();

			hn.data=charFreq[i];
			hn.c=charArray[i];

			hn.left=null;
			hn.right=null;

			q.add(hn);
		}

		while(q.size() > 1)
		{
			HuffmanNode x=q.peek();
			q.poll();

			HuffmanNode y=q.peek();
			q.poll();

			HuffmanNode f=new HuffmanNode();
			f.data=x.data+y.data;
			f.c='-';

			f.left=x;
			f.right=y;

			root=f;

			q.add(f);

			
		}
		encoding(root,"");
	}
}