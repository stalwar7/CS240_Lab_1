import java.util.Random;

public class MergeSort_Recursive {
    private int[] temp;
    private int[] temp2;

    private int index;

    public void sort(int[] values) {
        this.temp = values;
        index = values.length;
        this.temp2 = new int[index];
        Mergesort(0, index - 1);
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
            temp2[i] = temp[i];
     }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (temp2[i] <= temp2[j]) {
                temp[k] = temp2[i];
                i++;
            } else {
                temp[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = temp2[i];
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