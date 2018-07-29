
import java.util.Scanner;

public class EditDistance
{
	static int min(int x,int y,int z)
	{
		if(x<=y && x<=z)return x;
		if(y<=x && y<=z)return y;
		else
			return z;
	}

	static int editDistance(String str1,String str2,int s1,int s2)
	{
		if(s1==0)
		{
			return s2;
		}
		if(s2==0)
		{
			return s1;
		}

		if(str1.charAt(s1-1) == str2.charAt(s2-1))
		{
			return editDistance(str1,str2,s1-1,s2-1);
		}

		return 1 + min(editDistance(str1,str2,s1,s2-1),
						editDistance(str1,str2,s1-1,s2),
						editDistance(str1,str2,s1-1,s2-1)
						);
	}

	public static void main(String... arg)
	{
		String str1="";
		String str2="Saturday";

		System.out.println(editDistance(str1,str2,str1.length(),str2.length()));
	}
}
