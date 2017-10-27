import java.util.Random;

public class InsertionSort_Iterative {

	public void InsertionSort(int arraySort[], int[] array)
    {
        for (int i=1; i<arraySort.length - 1; ++i)
        {
            int min = arraySort[i];
            int j = i-1;
            for(int k = i+1; k < arraySort.length; k++)
            {
            if (j>=0 && arraySort[j] > min)
            {
                arraySort[j+1] = arraySort[j];
                j = j-1;
                array[0] =+ 1; //countCompare
            }
            arraySort[j+1] = min;
            array[1] += 1; //countMove
        }
        }
    }
	public static void main (String args[])
	{
		int arraySort[] = new int[1000];
		int array[] = new int[2];
		Random randomObj = new Random();	
		for (int i = 0; i< arraySort.length; i++)
		{
		   	int x = randomObj.nextInt(1000);
		   	arraySort[i] = x;
		   	System.out.print(arraySort[i] + " ");
		} 
		System.out.println();
		InsertionSort_Iterative ss = new InsertionSort_Iterative();
		long startTime = System.nanoTime();
		ss.InsertionSort(arraySort, array);
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
