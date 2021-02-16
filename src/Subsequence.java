import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Subsequence 
{
	public static void controlledTest()
	{
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
	    test.add(1);
	    test.add(5);
	    test.add(14);
	    test.add(3);
	    test.add(8);
	    test.add(10);
	    test.add(21);
	    System.out.println("ArrayList: " + test);
	    findSubsequence(test, 8);
	}
	public static void randomTest()
	{
		@SuppressWarnings("resource")
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Enter the size of the ArrayList");
	    int input = myScan.nextInt();

		ArrayList<Integer> test = new ArrayList<Integer>();
		Random rand = new Random();
		int randInt;
		
		for(int i = 0; i < input; i++)
		{
			randInt = rand.nextInt(input) + 1; 
			test.add(randInt);
		}
		System.out.println("ArrayList: " + test);
	    findSubsequence(test, input);
	}
	
	static void findSubsequence(ArrayList<Integer> test, int n) 
    {
        int sequence[] = new int[n]; 
        int max = 0; 
  
        for(int i = 0; i < n; i++)
        {
        	sequence[i] = 1; 
        }
 
        for(int i = 1; i < n; i++)
        {
        	for (int j = 0; j < i; j++)
        	{
        		//(sequence[i] < sequence[j] + 1) will always be true for the first pass
        		if((test.get(i) > test.get(j)) && (sequence[i] < sequence[j] + 1)) 
        		{
        			sequence[i] = sequence[j] + 1; 
        		}
        	}     
        }

        for(int i = 0; i < n; i++)
        {
        	if(max < sequence[i])
        	{
        		max = sequence[i]; 
        	}   
        }
        System.out.println("The longest increasing subsequence is: " + max);
    }
	
	public static void main(String[] args) 
	{
		controlledTest();
		randomTest();
	}

}
