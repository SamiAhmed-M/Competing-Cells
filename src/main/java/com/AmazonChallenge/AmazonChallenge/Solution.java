/**
 * Eight houses, represented as cells, are arranged in a straight line. Each day every cell
 * competes with its adjacent cells (neighbors). An integer value of 1 represents an active 
 * cell and a value of 0 represents an inactive cell. If the neighbors on both sides of a 
 * cell are either active or inactive, the cell becomes inactive on the next day, otherwise
 * the cell becomes active. The two cells on each end have a single adjacent cell, so assume 
 * that the unoccupied space on the opposite side is an inactive cell. Even after updating the 
 * cell state, consider its previous state when updating the state of other cells. The state
 * information of all cells should be updated simultaneously.
 */
package com.AmazonChallenge.AmazonChallenge;

import java.util.List;
import java.util.ArrayList;

public class Solution {
public List<Integer> cellCompete(int [] values, int days)
{
	// declare arrays for storing the old value and new value (state change)
	int [] oldValues = values;
	int [] newValues = new int[8];
	int newCellValue = 0;
	List<Integer> finalValue = new ArrayList<Integer>();
	for (int j=1; j<=days; j++)   // change everyday
	{
	for(int i=0; i<oldValues.length ; i++) // value change on daily basis
	{ // here the operation executes based on XOR operation
		if (i==0)
		{
			if (oldValues[i+1] == 0)
			{
			    newCellValue = 0;
			}
			else
			{
				newCellValue = 1;
			}
		}
		else if (i==7)
		{
			if (oldValues[i-1] == 0)
			{
			    newCellValue = 0;
			}
			else
			{
				newCellValue = 1;
			}
		}
		else
		{
			if (oldValues[i-1] == 0 && oldValues[i+1] == 0)
			{
			    newCellValue = 0;
			}
			else if (oldValues[i-1] == 0 && oldValues[i+1] == 1)
			{
				newCellValue = 1;
			}
			else if (oldValues[i-1] == 1 && oldValues[i+1] == 1)
			{
				newCellValue = 0;
			}
			else
			{
				newCellValue = 1;
			}
		}
		newValues[i] = newCellValue;    // saving cell value changes
		
	}                                   // nested for loop
	// oldValues = newValues;           // this will make both arrays to refer to same memory location
	for (int k=0; k<oldValues.length ; k++)  // copy the array elements with changed value into the old array 
	{
		oldValues[k] = newValues[k];
	}
	for (int x: oldValues)
	{
	System.out.print(x);
	}
	}                                   // outer for loop
	// Change the oldValue array into ArrayList 
	// finalValue = Arrays.asList(oldValues);       // type mismatch int vs Integer
	for (int k=0; k<oldValues.length; k++)
	{
		finalValue.add(oldValues[k]);
	}
	return finalValue;
}
}
