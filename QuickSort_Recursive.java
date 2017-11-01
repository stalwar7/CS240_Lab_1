/**
   An recursive version of the Quick Sort Algorithm
   @author Sana Talwar
   @version 1.0
*/
import java.util.Random;

public class QuickSort_Recursive{
	public int pivot(int arraySort[], int first, int last)
	{
		int point = arraySort[last];
		int i = first-1;
		for (int j = first; j < last; j++)
		{
			if(arraySort[j] <= point)
			{
				i++;
				int temp = arraySort[i];
				arraySort[i] = arraySort[j];
				arraySort[j] = temp;
			}
		}
		int temp = arraySort[i+1];
		arraySort[i+1] = arraySort[last];
		arraySort[last] = temp;
		return i+1;
	}
	
	public void sort(int arraySort[], int first, int last)
	{
		if (first < last)
		{
			int index = pivot(arraySort, first, last);
			sort(arraySort, first, index);
			sort(arraySort, index+1, last);
			
		}
	}
	public static void main (String args[])
	{
		int arraySort[] = new int[1000];
		Random randomObj = new Random();	
		for (int i = 0; i< arraySort.length; i++)
		{
		   	int x = randomObj.nextInt(1000);
		   	arraySort[i] = x;
		   	System.out.print(arraySort[i] + " ");
		} 
		System.out.println();
		long startTime = System.nanoTime();
		QuickSort_Recursive ms = new QuickSort_Recursive();
		ms.sort(arraySort, 0, arraySort.length -1);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Sorted Array ");
		for(int i = 0; i < arraySort.length; i ++)
		{
			System.out.print(arraySort[i] + " ");
		}
		System.out.println();
		System.out.println(duration);
		
	}
}
