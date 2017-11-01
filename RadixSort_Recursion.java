/**
   An recursive version of the Radix Sort Algorithm
   @author Sana Talwar
   @version 1.0
*/
import java.util.Random;

public class RadixSort_Recursion {

	public static void radixSort(int[] array, int[] temp) {
		sortFirst(array, temp, 0, 0, 0);
		sortSecond(array, temp, 0, 0, 0);
		sortThird(array, temp, 0, 0, 0);
	}

	public static void sortFirst(int[] array, int[] temp, int j, int i, int a) {
		if (array[i] % 10 == a) {
			temp[j] = array[i];
			j++;
		}
		i++;
		if (i == array.length) {
			i = 0;
			a++;
		}
		if (a != 10) {
			sortFirst(array, temp, j, i, a);
		}
	}

	public static void sortSecond(int[] array, int[] temp, int p, int i, int a) {
		if (((temp[i] % 100) / 10) == a) {
			array[p] = temp[i];
			p++;
		}
		i++;
		if (i == array.length) {
			i = 0;
			a++;
		}
		if (a != 10) {
			sortSecond(array, temp, p, i, a);
		}
	}

	public static void sortThird(int[] array, int[] temp, int x, int i, int a) {
		if ((array[i] / 100) == a) {
			temp[x] = array[i];
			x++;
		}
		i++;
		if (i == array.length) {
			i = 0;
			a++;
		}
		if (a != 10) {
			sortThird(array, temp, x, i, a);
		}
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		int[] temp = new int[array.length];

		Random randomObj = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = randomObj.nextInt(1000);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		radixSort(array, temp);
		for (int d = 0; d < temp.length; d++) {
			System.out.print(temp[d] + " ");
		}
	}
}
