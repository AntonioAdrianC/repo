/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is to calculate the amount of bonus a store could earn. 
 * Due: 4/22/23
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public class HolidayBonus 
{

	public static final double HIGHEST_BONUS = 5000.0;
	public static final double REGULAR_BONUS = 2000.0;
	public static final double LOWEST_BONUS = 1000.0;
	
	/** calculates the holiday bonus for each store in the district based on their sales data.
	@param salesData a ragged array of doubles holding the sales data for stores in the district.
	@return outputArray representing the holiday bonuses for each store in the district.  */
	public static double[] calculateHolidayBonus(double[][] salesData) 
	{
		// to collect bonuses for the stores.
		double[] outputArray = new double[salesData.length];

		// while lowestColumn exists, continue looping. A try/catch block is used to check if the array is out of bounds.
		// it returns -1 if an ArrayIndexOutOfBoundsException is caught.
		double lowest = 0.0;
		double highest = 0.0;
		int lowestStoreIndex = 0;
		int highestStoreIndex = 0;
		int colIndex = 0;

		// while loop to keep the jagged array in check.
		while(TwoDimRaggedArrayUtility.getLowestInColumnIndex(salesData, colIndex) != -2)
		{
			// find lowest in current column and it's index
			lowest = TwoDimRaggedArrayUtility.getLowestInColumn(salesData, colIndex);
			lowestStoreIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(salesData, colIndex);
			// check if it's negative. if true, skip.
			if(lowest > 0)
				// now add to store. lowestStoreIndex is the index where we can reach the specific store.
				outputArray[lowestStoreIndex] += LOWEST_BONUS;			

			
			// find highest in current column and it's index
			highest = TwoDimRaggedArrayUtility.getHighestInColumn(salesData, colIndex);
			highestStoreIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(salesData, colIndex);
			// check if it's negative. if true, skip.
			if(highest > 0)
				// now add to store. highestStoreIndex is the index where we can reach the specific store.
				outputArray[highestStoreIndex] += HIGHEST_BONUS;

			
			// fill every thing else with the regular bonus if it's not negative.
			int rowIndex = 0;
			while(rowIndex < salesData.length && colIndex < salesData[rowIndex].length)
			{
				int rowLength = salesData[rowIndex].length;
				// already filled in the lower indexes in outputArray.
				if(rowIndex != highestStoreIndex && rowIndex != lowestStoreIndex)
					if(rowIndex < rowLength)
						if(salesData[rowIndex][colIndex] > 0) outputArray[rowIndex] += REGULAR_BONUS;
				rowIndex++;
			}
			colIndex++;
		}
		return outputArray;
	}
	
	/** calculates the total holiday bonus for the district based on the sales data for all stores.
	@param salesData a two-dimensional ragged array of doubles representing the sales data for stores in the district.
	@return a double representing the total of all holiday bonuses for the district.  */
	public static double calculateTotalHolidayBonus(double[][] salesData) 
	{
		double[] bonusArray = calculateHolidayBonus(salesData);
		
		double total = 0.0;
		for(double d : bonusArray)
			total += d;
		return total;
	}
}