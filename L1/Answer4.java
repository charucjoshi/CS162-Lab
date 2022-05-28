import java.util.*;
import java.lang.*;

public class Answer4{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int m,n;
		System.out.println("Enter the size of A1");
		m = s.nextInt();
		System.out.println("Enter the size of A2");
		n = s.nextInt();
		if(m < n)
			System.out.println("Size of A1 > Size of A2");
		else
		{
			System.out.println("Enter the elements of A1");
			int a1[] = new int[m];
			for(int i = 0; i < m ; ++i)
				a1[i] = s.nextInt();
				
			System.out.println("Enter the elements of A2");
			int a2[] = new int[n];
			for(int i = 0; i < n ; ++i)
				a2[i] = s.nextInt();
				
			boolean flag = false;
			
			for(int i = 0; i < m; i++)
				{
					int k=i;
					if(a1[i] == a2[0])
						for(int j = 0; j < n; j++,k++)
						{
							if(k >= n)
							{
								flag = false;
								break;
							}
							if(a1[k] == a2[j])
								flag = true;
							else
							{
								flag = false;
								break;
							}
						}
					if(flag) break;
				}		
				if(flag)
				{	
					System.out.println("Yes A2 is Sub Array of A1");
				}
				else
					System.out.println("No not a Sub Array");		
		}
	}
}
