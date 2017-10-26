
public class ShellSort_Iterative {
	//find k so  (2^k - 1) < size
	//i = k; i >0; i--
	//increment 2^k -1
	//for loop
	//insertion sort
	public void ShellSort(int[] arraySort)
	{
		int size = arraySort.length;
		for (int i = size/2; i > 0; i/=2)
		{
			for(int j = i; j < size; j+= 1)
			{
				int temp = arraySort[j];
				int k;
				for (k=j; i>=i && arraySort[j-i] > temp; k -= i)
				{
					arraySort[k] = arraySort[k-i];
				}
				arraySort[k] = temp;
			}
		}
	}
}
