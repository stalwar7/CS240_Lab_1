import java.util.Random;

public class ShellSort_Recursive {
	public int[] sort(int[] arraySort, int index) {
		
	    if (arraySort.length == 0 || index <= 0)
	        return arraySort;
	    int[][]temp = new int[10][0];  
	    int[] size = new int[10];
	    int i, j;
	    for (j = 0; j < arraySort.length; j++) 
	    {
	        i = (arraySort[j] / index) % 10;
	        size[i]++;
	        temp[i] = addToBucket(temp[i], arraySort[j]);
	    }
	    for (i = 0; i < 10; i++) 
	    {
	        temp[i] = sort(temp[i], index / 10); 
	    }
	    int k = 0;
	    for (i = 0; i < 10; i++) 
	    {
	        for (j = 0; j < size[i]; j++) 
	        {
	            arraySort[k] = temp[i][j];
	            k++;
	       }
	    }
	    return arraySort; 
	}

	private static int[] addToBucket(int[] bucket, int number) 
	{

	    int[] temp = new int[bucket.length+1];


	    for (int i = 1; i < temp.length; i++) 
	    {
	        temp[i] = bucket[i-1];
	    }
	    temp[0] = number;

	    return temp;

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
		ShellSort_Recursive ms = new ShellSort_Recursive();
		ms.sort(arraySort, 3);
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
