/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: a junit class to test TwoDimRaggedArrayUtility class 
 * Due: 4/22/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityStudentTest {

    private double[][] data = {{1.1, 2.2, 3.3}, {4.4, 5.5}, {6.6, 7.7, 8.8, 9.9}};

    @Test
    void testReadFile() throws FileNotFoundException 
    {
    	File file = new File("C:\\Users\\emily\\eclipse-workspace\\HolidayPayProject\\src\\dataSet3.txt");

        double[][] actual = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(data, actual);
    }

    @Test
    void testWriteToFile() throws IOException 
    {
        File file = new File("dataSet4.txt");

        TwoDimRaggedArrayUtility.writeToFile(data, file);
        double[][] actual = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(data, actual);
    }

    @Test
    void testGetTotal() 
    {
        double expected = 49.5;
        double actual = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void testGetAverage() 
    {
        double expected = 5.5;
        double actual = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void testGetRowTotal() 
    {
        double expected = 6.6;
        double actual = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void testGetColumnTotal() 
    {
        double expected = 15.4;
        double actual = TwoDimRaggedArrayUtility.getColumnTotal(data, 1);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void testGetHighestInRow() 
    {
        double expected = 3.3;
        double actual = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testGetHighestInRowIndex() 
    {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2));
    }

    @Test
    public void testGetLowestInRow() 
    {
        assertEquals(1.1, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.0);
        assertEquals(4.4, TwoDimRaggedArrayUtility.getLowestInRow(data, 1), 0.0);
        assertEquals(6.6, TwoDimRaggedArrayUtility.getLowestInRow(data, 2), 0.0);
    }

    @Test
    public void testGetLowestInRowIndex() 
    {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
    }

    @Test
    public void testGetHighestInColumn() 
    {
        assertEquals(6.6, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0));
        assertEquals(7.7, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1));
        assertEquals(8.8, TwoDimRaggedArrayUtility.getHighestInColumn(data, 2));
    }

    @Test
    public void testGetHighestInColumnIndex() 
    {
    	assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2));
    }
    
    @Test
    public void testGetLowestInColumn() 
    {
    	assertEquals(1.1, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0));
        assertEquals(2.2, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1));
        assertEquals(3.3, TwoDimRaggedArrayUtility.getLowestInColumn(data, 2));
    }

    @Test
    public void testGetLowestInColumnIndex() 
    {
    	assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2));
    }

    @Test
    public void testGetHighestInArray() 
    {
        double expected = 9.9;
        double result = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testGetLowestInArray() 
    {
        double expected = 1.1;
        double result = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals(expected, result, 0.0001);
    }
}
