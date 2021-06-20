package com.AmazonChallenge.AmazonChallenge;

/**
 * Competing Cells
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        // request input
    	Scanner myObj = new Scanner(System.in);
    	System.out.println("Please enter state of the cell (0 or 1 ) as array for 8 cells separated by , or space");
    	String [] states = new String[8];
    	states = myObj.nextLine().split("[, ]+");
    	System.out.println("Please enter the number of days");
    	int numDays = myObj.nextInt();
    	myObj.close();
    	int [] values = new int[8];
    	for (int i = 0; i< states.length; i++)
    	{
    		values[i] = Integer.parseInt(states[i]);
    	}
    	List<Integer> result = new ArrayList<Integer>();
    	Solution sol = new Solution();
    	result = sol.cellCompete(values,numDays);
    	System.out.println(result);
    	
    }
}
