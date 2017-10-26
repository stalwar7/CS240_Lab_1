
import java.util.Random;
public class SelectionSort_Recursive {
		/**
		 * Step One
		 * find minimum 
		 * swap it with initial
		 * Step Two
		 * Call it again - no for loop needed!		 * 
		 * @param arraySort
		 * @param initial
		 */
		public void SelectionSort(int[] arraySort, int initial)
		{
			int size = arraySort.length;
			if(initial >= size -1)
				return;
			int minimum = initial;
			for (int i = initial; i <size; i++)
			{
				if(arraySort[i] < arraySort[initial])
					minimum = i;
			}	
			int temp = arraySort[initial];
			arraySort[initial] = arraySort[minimum];
			arraySort[minimum] = temp;
			SelectionSort(arraySort, initial +1);
		}

		public static void main (String args[])
		{
			int arraySort[] = new int[10];
			Random randomObj = new Random();
			System.out.print("Unsorted Array: ");
			for (int i = 0; i< arraySort.length; i++)
			{
			   	int x = randomObj.nextInt(1000);
			   	arraySort[i] = x;
			   	System.out.print(arraySort[i] + " ");
			} 
			System.out.println();
			SelectionSort_Recursive ss = new SelectionSort_Recursive();
			ss.SelectionSort(arraySort, 0);
			System.out.print("Sorted Array: ");
			for(int i = 0; i < arraySort.length; i ++)
			{
				System.out.print(arraySort[i] + " ");
			}
			
		}
	}

