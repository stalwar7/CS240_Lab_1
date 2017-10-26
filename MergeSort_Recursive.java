import java.util.Random;

public class MergeSort_Recursive {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        Mergesort(0, number - 1);
    }

    private void Mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            Mergesort(low, middle);
            Mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) 
    {
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
     }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
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
		MergeSort_Recursive ms = new MergeSort_Recursive();
		ms.sort(arraySort);
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