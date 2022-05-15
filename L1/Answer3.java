import java.util.*;
import java.lang.*;

public class Answer3{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n;
		System.out.println("Enter the size of the array");
		n = s.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements");
		for(int i = 0; i < n; ++i)
			a[i] = s.nextInt();
		
		//Inputting x and y
		System.out.println("Enter the values of x and y");
		int x = s.nextInt();
		int y = s.nextInt();
		int posX , posY , diff = n+1;
		boolean flagX = false, flagY = false;
		for(int i = 0; i < n; ++i)	
		{
			if(a[i] == x)
			{
				flagX = true;
				posX = i;
				for(int j = 0; j < n; ++j)
					if(a[j] == y)
					{
						flagY = true;
						posY = j;
						int d = (posX > posY)? posX-posY : posY-posX;
						if(diff > d)
							diff = d;
					}
			}
			if(a[i] == y)
				flagY = true;		
		}
		if(flagY && flagX)
			System.out.println("Least distance between " + x + " and " + y + " is " + --diff);
		else
			if(flagX == true)
				System.out.println(y + " not present");
		else
			if(flagY == true)
				System.out.println(x + " not present");
		else
			System.out.println("Both not present");
	}
}
