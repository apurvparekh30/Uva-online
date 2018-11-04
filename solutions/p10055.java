import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLong()){
			long a = scan.nextLong();
			long b = scan.nextLong();
			System.out.println(Math.abs(b-a));
		}
	}
}