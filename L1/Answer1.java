import java.lang.*;
import java.util.*;
public class Answer1 {
	public static void main(String[] args)
	{
		char c = 'n';
		do{
		Scanner s = new Scanner(System.in);
		int n; 
		System.out.println("Enter size of the array");
		n = s.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements of the array");
		for(int i = 0; i < n; ++i)
			a[i] = s.nextInt();
		Answer1 obj = new Answer1();
		int choice;
		System.out.println("Choose from the MENU : ");
		System.out.println("1. Reverse the Array");
		System.out.println("2. Find the Kth Largest and Kth Smallest Element of the Array.");
		System.out.println("3. Find the Subarray with given Sum");
		System.out.println("4. Move all the Negative Elements to One Side of Array");
		System.out.println("5. Find the First Repeating and the First Non-Repeating Element of the Array");
		choice = s.nextInt();
			switch(choice)
			{
				case 1 :obj.reverse(a);
						obj.display(a);
						break;
					
				case 2 :System.out.println("Enter k");
						int k = s.nextInt();
						obj.kElement(a,k);
						break;
					
				case 3 :System.out.println("Enter sum");
						int sum = s.nextInt();
						obj.subArray(a,sum);
						break;
					
				case 4 :obj.negative(a);
						System.out.println("The array after transformation is :");
						obj.display(a);
						break;
					
				case 5 :obj.repeating(a);
						break;
				
				default:System.out.println("Wrong Choice ");
						break;
			}
			System.out.println("\nDo you want to go again? (y/n)");
			c = s.next().charAt(0);
			
		}while(c == 'y' || c == 'Y');
	}
	public int[] reverse(int a[])
	{
		int j = a.length - 1;
		for(int i = 0; i < j; i++,j--)
		{
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		return a;
	}
	public void kElement(int[] a, int k)
	{
		int n = a.length;
		
		//Sorting the array uisng Insertion Sort
		for(int i = 1; i < n; ++i)
		{
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && key < a[j])
			{
				a[j+1] = a[j];
				j--;
			}
			a[++j] = key;
		}
		
		System.out.println("Largest " + k + " element =  " + a[n-k]);
		System.out.println("Smallest " + k + " element = " + a[k-1]);
	}
	
	public void subArray(int a[], int sum)
	{
		int i=0, j=0;
		boolean flag = false;
		for(i = 0; i < a.length; ++i)
		{
			int checkSum = 0;
			for(j = i; j < a.length; ++j)
				if(checkSum == sum)
					break;
				else
					checkSum += a[j];
			if(checkSum == sum)
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("Sub-Array for the give sum : ");
			for(int k = i; k < j; k++)
				System.out.print(a[k] + " ");
		}
		else
			System.out.println("No matching Sum-Array");
	}
	public int[] negative(int a[])
	{
		int n = a.length;
		for(int i = 1; i < n; ++i)
		{
			int key = a[i];
			int j = i-1;
			while(j >= 0 && key < a[j])
			{
				a[j+1] = a[j];
				j--;
			}
			a[++j] = key;
		}
		return a;
	}
	
	public void repeating(int a[])
	{
		boolean flagRep = true, flagNonRep = true;
		int n = a.length;
		int firRep=0, firNonRep=0;
		for(int i = 0; i < n-1; ++i)
		{
			for(int j = 0; j < n && j!=i; ++j)
				if(a[i] == a[j])
				{
					if(flagRep)
					{
						flagRep = false;
						firRep = a[i];
						break;
					}
				}
				else
				{
					if(flagNonRep)
					{
						flagNonRep = false;
						firNonRep = a[i];
						break;
					}	
				}
			
		}
		if(!flagRep)
			System.out.println("First Repating = " + firRep);
		else
			System.out.println("No Repeating Element");
		if(!flagNonRep)
			System.out.println("First Non Repating = " + firNonRep);
		else
			System.out.println("No Non-Repeating Element");
	}
	
	public void display(int[] a)
	{
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
	}
}
