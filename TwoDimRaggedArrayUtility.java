/*
 * Class: CMSC203 
 * Instructor:
 * Description: an array utility class
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __________
*/

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility 
{

	/** reads a file and returns a ragged array of doubles.
	 *  @param file the file given by the user
	 *  @return output new double array of transfered data from file.
	 *  @throws FileNotFoundException if the file is not found  */
	public static double[][] readFile(File file) throws FileNotFoundException 
	{
		Scanner inputCount = new Scanner(file);
		// finding the the amount of lines the file has.
		int numRows = 0;
		while (inputCount.hasNextLine()) 
		{
			numRows++;
			inputCount.nextLine();
		} 
		// close file so we can start over.
		inputCount.close();

		Scanner input = new Scanner(file);
		double[][] output = new double[numRows][];
    
		// index to keep track of current row.
		int index = 0;
		while (input.hasNextLine()) 
		{
			String line = input.nextLine().strip();
			// tokenizes each word seperated by " ".
			String[] tokens = line.split(" ");
			// to hold the actual double values. it's the same length as tokens array.
			double[] rowArray = new double[tokens.length];
      
			// using for loop instead of for each so both arrays could access their values through col index.
			for (int col = 0; col < tokens.length; col++) 
				rowArray[col] = Double.parseDouble(tokens[col]);
     
			output[index] = rowArray;
			index++;
		}
    
		input.close();
		return output;
	}
	
	/** writes a ragged array of doubles into a file.
	 * @param data the ragged array of doubles to be written within file
	 * @param file the file to write to
	 * @throws IOException, if there is an error while writing to the file  */
	public static void writeToFile(double[][] data, File file) throws IOException 
	{
		PrintWriter out = new PrintWriter(file);
		for (int row = 0; row < data.length; row++) 
		{
			for (int col = 0; col < data[row].length; col++) 
				out.print(data[row][col] + " ");
      
			out.println();
		}
		out.close();
	  
	}
	
	/** returns the total of the ragged array; data.
	 * @param data the ragged array of doubles
	 * @return the total of the elements in the array  */
	public static double getTotal(double[][] data) 
	{
		double total = 0;
		for (int row = 0; row < data.length; row++) 
			for (int col = 0; col < data[row].length; col++) 
				total += data[row][col];
		return total;
	}
	
	/** returns the average in the ragged array; data.
	 * @param data the ragged array of doubles
	 * @return the average of the elements in the array  */
	public static double getAverage(double[][] data) 
	{
		int count = 0;
		double total = 0;
    
		for (int row = 0; row < data.length; row++)
			for (int col = 0; col < data[row].length; col++) 
			{
				total += data[row][col];
				count++;
			}
    
		return total / count;
	}
	
	/** returns the total in a row.
	 * @param data the ragged array of doubles
	 * @param row the index of the row to calculate the total of
	 * @return the total of the elements in the specified row  */
	public static double getRowTotal(double[][] data, int row) 
	{
		double total = 0;
		if (row >= 0 && row < data.length) 
			for (int col = 0; col < data[row].length; col++)
				total += data[row][col];
		return total;
	}
	
	/** returns the total a column.
	 * @param data the ragged array of doubles
	 * @param col the index of the column to calculate the total of
	 * @return the total of the elements in the specified column  */
	public static double getColumnTotal(double[][] data, int col) 
	{
		double total = 0;
		for (int row = 0; row < data.length; row++) 
			if (col >= 0 && col < data[row].length) total += data[row][col];
		
		return total;
	}
	
	/** returns the largest element in a row.
	 * @param data the ragged array of doubles
	 * @param row the index of the row to find the largest element in
	 * @return the largest element in the specified row  */
	public static double getHighestInRow(double[][] data, int row) 
	{
		double max = data[row][0];
		if (row >= 0 && row < data.length) 
			for (int col = 0; col < data[row].length; col++)
				if (data[row][col] > max) max = data[row][col];

		return max;
	}

	/** returns the index of the largest element in a row.
	 * @param data the ragged array of doubles
	 * @param row the index of the row to find the index of the largest element in
	 * @return the index of the largest element in the specified row  */
	public static int getHighestInRowIndex(double[][] data, int row) 
	{
		int maxIndex = -1;
		double max = data[row][0];
		if (row >= 0 && row < data.length)
			for (int col = 0; col < data[row].length; col++)
				if (data[row][col] > max) 
				{
					max = data[row][col];
					maxIndex = col;
				}
		return maxIndex;
	}
	
	/** returns the smallest element in a row.
	 * @param data the ragged array of doubles
	 * @param row the index of the row.
	 * @return lowest.  */
	public static double getLowestInRow(double[][] data, int row) 
	{
		double lowest = data[row][0];
      	for (int i = 1; i < data[row].length; i++)
      		if (data[row][i] < lowest) lowest = data[row][i];
      	
      	return lowest;
	}
	
	/** returns the index of the smallest element in a row.
	 * @param data the ragged array of doubles
	 * @param row, the index of the row.
	 * @return lowestIndex.  */
	public static int getLowestInRowIndex(double[][] data, int row) 
	{
		int lowestIndex = -1;
      
		for (int i = 1; i < data[row].length; i++)
			if (data[row][i] < data[row][lowestIndex]) lowestIndex = i;
      
		return lowestIndex;
	}
	
   /** returns the largest element in a column.
	 * @param data the ragged array of doubles
	 * @param col the index of the column.
	 * @return highest.  */
	public static double getHighestInColumn(double[][] data, int col) 
	{
		double highest = 0;
      
		for (int i = 0; i < data.length; i++)
			if (col < data[i].length && data[i][col] > highest) highest = data[i][col];
      
		return highest;
	}
	
   /** Returns the index of the largest element in a column.
	 * @param data the ragged array of doubles
	 * @param col the index of the column.
	 * @return highestIndex  */
	public static int getHighestInColumnIndex(double[][] data, int col) 
	{
		int highestIndex = 0;
		double highest;
		try
		{
			highest = data[0][col];
		} catch(ArrayIndexOutOfBoundsException e)
		{
			// if it catches the col index to be out of bounds, just return -2.
			return -2;
		}
      
		for (int i = 0; i < data.length; i++)
			if (col < data[i].length && data[i][col] > highest) 
			{
				highest = data[i][col];
				highestIndex = i;
			}	
		
		return highestIndex;
	}
	
	/** returns the smallest element in a column.
	 * when column in row does not contain a value, skip that column.
	 * @param data the ragged array of doubles
	 * @param col the column index
	 * @return lowest  */
	public static double getLowestInColumn(double[][] data, int col) 
	{
		double lowest = 0;
  
		for (int i = 0; i < data.length; i++)
			if (col < data[i].length && data[i][col] < lowest) lowest = data[i][col];
  
		return lowest;
	}
	  
	/** returns the index of the smallest element in that column.
	 * when column in row does not contain a value, skip that column.
	 * @param data the ragged array of doubles
	 * @param col the column index
	 * @return lowestIndex  */
	public static int getLowestInColumnIndex(double[][] data, int col) 
	{
		int lowestIndex = 0;
		double lowest;
		try
		{
			lowest = data[0][col];
		} catch(ArrayIndexOutOfBoundsException e)
		{
			// if it catches the col index to be out of bounds, just return -1.
			return -2;
		}
      
      
		for (int i = 0; i < data.length; i++) 
			if (col < data[i].length && data[i][col] < lowest) 
			{
				lowest = data[i][col];
              	lowestIndex = i;
			}
      
		return lowestIndex;
	}
	
	/** returns the largest element in data, the ragged array.
	 * @param data the ragged array of doubles
	 * @return highest the highest value in the whole array.  */
	public static double getHighestInArray(double[][] data) 
	{
		double highest = data[0][0];
      
		for (double[] col : data) // goes through all the columns within data.
			for (double value : col) // goes through the column array. value -> the current value.
				if (value > highest) highest = value;
		
		return highest;
	}
	
	/** returns the smallest element in data, the ragged array.
	 * @param data the ragged array of doubles
	 * @return lowest the lowest value in the whole array.  */
	public static double getLowestInArray(double[][] data) 
	{
		double lowest = data[0][0];
		for (double[] col : data) // goes through all the columns within data.
			for (double value : col) // goes through the column array. value -> the current value.
				if (value < lowest) lowest = value;

		return lowest;
	}
}
