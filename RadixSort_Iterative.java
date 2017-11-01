/**
   An iterative version of the Radix Sort Algorithm
   @author Sana Talwar
   @version 1.0
*/

import java.util.Random;

public class RadixSort_Iterative
{	
	
	public static void RadixSort(int[] arraySort, int[] array)
    {
        int top = arraySort[0]; 
        int exponent = 1;
        int size = arraySort.length;
        int[] b = new int[10];
        // find max number
        for (int i = 1; i < size; i++)
        {
            if (arraySort[i] > top)
            {
                top = arraySort[i];
        		array[1] += 1;  //countCompare
            }
        }

        //sort values in buckets 
        while (top / exponent > 0)
        {
            int[] bucket = new int[arraySort.length];
 
            for (int i = 0; i < size; i++)
                bucket[(arraySort[i] / exponent) % arraySort.length]++;
            for (int i = 1; i < arraySort.length; i++)
            {
                bucket[i] += bucket[i - 1];
                array[0] += 1;  //countMove
            }
            for (int i = size - 1; i >= 0; i--)
            {
                b[--bucket[(arraySort[i] / exponent) % arraySort.length]] = arraySort[i];
                array[0] += 1;  //countMove
            }
            for (int i = 0; i < size; i++)
                arraySort[i] = b[i];
            exponent *= 10;        
        }
    }
	public static void main(String[] args) 
    {
		int arraySort[] = new int[10];		
		int array[] = new int[2];
		Random randomObj = new Random();
		System.out.println("Unsorted Array: ");
		for (int i = 0; i< arraySort.length; i++)
		{
		   	int x = randomObj.nextInt(1000);
		   	arraySort[i] = x;
		   	System.out.print(arraySort[i] + " ");
		} 
		System.out.println();  
		long startTime = System.nanoTime();
        RadixSort(arraySort,array);  
        long endTime = System.nanoTime();
		long duration = (endTime - startTime);
        System.out.println("Sorted Array: ");        
        for (int i = 0; i < arraySort.length; i++)
        {
            System.out.print(arraySort[i] + " ");   
        }
        System.out.println();
        System.out.println("Num Moved: " + array[0]);
		System.out.println("Num Compared: " + array[1]);
        System.out.println(duration);             
    }  
}
