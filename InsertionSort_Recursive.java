import java.util.Random;

public class InsertionSort_Recursive {

	public void InsertionSort(int arraySort[], int size)
    {
		if (size <= 1)	//base case
            return;
        InsertionSort(arraySort, size-1);
        int last = arraySort[size-1];
        int j = size-2;
      
        while (j >= 0 && arraySort[j] > last)
        {
            arraySort[j+1] = arraySort[j];
            j--;
        }
        arraySort[j+1] = last;
    }
	public static void main (String args[])
	{
		int arraySort[] = new int[10];
		Random randomObj = new Random();	
		for (int i = 0; i< arraySort.length; i++)
		{
		   	int x = randomObj.nextInt(1000);
		   	arraySort[i] = x;
		   	System.out.print(arraySort[i] + " ");
		} 
		System.out.println();
		InsertionSort_Recursive ss = new InsertionSort_Recursive();
		ss.InsertionSort(arraySort, 10);
		System.out.println("Sorted Array ");
		for(int i = 0; i < arraySort.length; i ++)
		{
			System.out.print(arraySort[i] + " ");
		}
		System.out.println();
		
	}
	
	
}
