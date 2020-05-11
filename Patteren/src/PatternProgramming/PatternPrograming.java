package PatternProgramming;
import java.util.Scanner;
public class PatternPrograming
{

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a no");
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if(j<=i) {
					System.out.println(j+1);
				}
				else if(j>i) {
					System.out.println(i+1);
				}
			}
			for (int j=0;j<n;j++)
			{
				if(j<=n-i-1) {
					System.out.println(i+1);
				}
				else if(j>n-i-1) {
					System.out.println(n-j-1);
				}
			}
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if(j<=i) {
					System.out.println(j+1);
				}
				else if(j>i) {
					System.out.println(i+1);
				}
			}
			for (int j=0;j<n;j++)
			{
				if(j<=n-i-1) {
					System.out.println(i+1);
				}
				else if(j>n-i-1) {
					System.out.println(n-j-1);
				}
			}
			System.out.println();
		}
	}

}
