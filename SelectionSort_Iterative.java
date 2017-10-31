import java.util.Random;

public class SelectionSort_Iterative {
	int countMove = 0;
	int countCompare = 0;
	public SelectionSort_Iterative()
	{
		
	}		
	public void SelectionSort(int[] arraySort, int[] array)
	{
		int size = arraySort.length;
	
		for (int i = 0; i < size-1 ; i++)
		{
			int minimun = i;
			for (int j = i+1; j < size; j++)
			{
				if(arraySort[j] < arraySort[minimun])
				{
					minimun = j;
					array[0] += 1;				//countCompare -> increments when data is compared
					
				}
			}
			int temp = arraySort[minimun];
			arraySort[minimun] = arraySort[i];
			arraySort[i] = temp;
			array[1] += 1;						//countMove -> increments when data is moved
		}
	
	}
	public static void main (String args[])
	{
		int arraySort[] = new int[10];
		int array[] = new int[2];
		Random randomObj = new Random();	
		for (int i = 0; i< arraySort.length; i++)
		{
		   	int x = randomObj.nextInt(1000);
		   	arraySort[i] = x;
		   	System.out.print(arraySort[i] + " ");
		} 
		System.out.println();
		SelectionSort_Iterative ss = new SelectionSort_Iterative();
		long startTime = System.nanoTime();
		ss.SelectionSort(arraySort, array);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Sorted Array ");
		for(int i = 0; i < arraySort.length; i ++)
		{
			System.out.print(arraySort[i] + " ");
		}
		System.out.println();
		System.out.println("Num Moved: " + array[1]);
		System.out.println("Num Compared: " + array[0]);
		System.out.println(duration);
		
	}
}
