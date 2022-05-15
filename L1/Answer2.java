import java.lang.*;
import java.util.*;

public class Answer2 {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		double a,b,c;
		System.out.println("Quadratic Equation : ax^2 + bx + c = 0 ");
		System.out.println("Enter the values of a,b and c");
		a = s.nextDouble();
		b = s.nextDouble();
		c = s.nextDouble();
		
		if(b*b - 4*a*c < 0)
			System.out.println("Complex Roots");
		else
		{
			double D = Math.sqrt(b*b - 4*a*c);
			double x1 = (-b + D)/2*a;
			double x2 = (-b - D)/2*a;
			System.out.println("Root 1 : " + x1);
			System.out.println("Root 2 : " + x2);
		}
	}
}
