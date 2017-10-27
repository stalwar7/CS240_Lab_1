import java.util.Random;

public class RadixSort_Iterative
{	
	
	public static void RadixSort(int[] arraySort)
    {
        int top = arraySort[0]; 
        int exponent = 1;
        int size = arraySort.length;
        int[] b = new int[10];
        // find max number
        for (int i = 1; i < size; i++)
            if (arraySort[i] > top)
                top = arraySort[i];

        //sort values in buckets 
        while (top / exponent > 0)
        {
            int[] bucket = new int[10];
 
            for (int i = 0; i < size; i++)
                bucket[(arraySort[i] / exponent) % 10]++;
            for (int i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (int i = size - 1; i >= 0; i--)
                b[--bucket[(arraySort[i] / exponent) % 10]] = arraySort[i];
            for (int i = 0; i < size; i++)
                arraySort[i] = b[i];
            exponent *= 10;        
        }
    }
	public static void main(String[] args) 
    {
		int arraySort[] = new int[100];		
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
        RadixSort(arraySort);  
        long endTime = System.nanoTime();
		long duration = (endTime - startTime);
        System.out.println("Sorted Array: ");        
        for (int i = 0; i < arraySort.length; i++)
        {
            System.out.print(arraySort[i] + " ");   
        }
        System.out.println();
        System.out.println(duration);             
    }  
}
