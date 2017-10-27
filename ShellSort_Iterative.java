import java.util.Random;

public class ShellSort_Iterative {
	//find k so  (2^k - 1) < size
	//i = k; i >0; i--
	//increment 2^k -1
	//for loop
	//then insertion sort - basically
	public static void ShellSort(int[] arraySort, int[] array)
	{
		int size = arraySort.length;
		
		for (int gap = (int) Math.pow(2, arraySort.length); gap > 0; gap /= 2 )
		{
			for(int j = gap; j < size; j+= 1)
			{
				int temp = arraySort[j];
				int k;
				for (k=j; gap >= gap && arraySort[j-gap] > temp; k -= gap)
				{
					arraySort[k] = arraySort[k-gap];
					array[0] =+ 1; //countCompare
				}
				arraySort[k] = temp;
				array[1] += 3; //countMove
				
			}
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
        ShellSort(arraySort, array);        
        System.out.println("Sorted Array: ");        
        for (int i = 0; i < arraySort.length; i++)
        {
            System.out.print(arraySort[i] + " ");   
        }
        System.out.println("Num Moved: " + array[1]);
		System.out.println("Num Compared: " + array[0]);
    }
                     
}
