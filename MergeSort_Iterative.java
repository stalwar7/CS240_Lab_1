/**
   An iterative version of the Merge Sort Algorithm
   work - in - progress
   @author Sana Talwar
   @version 0.5 
*/

import java.util.Random;

public class MergeSort_Iterative {
	private int[] tempArray;
	private int size;

	public MergeSort_Iterative(int[] array) {

		tempArray = new int[10];
		size = array.length;
		mergeSort(array, size);
	}

	public void mergeSort(int[] arraySort, int sizeL) {
		int increment;
		int left;
		int endL;
		int right;
		int endR;
		int current;
		sizeL = arraySort.length;
		sizeL = size;

		increment = 1;
		current = 0;
		while (increment < size) {
			left = 0;
			right = increment;
			endL = right - 1;
			if (endL + increment < size) {
				endR = endL + increment;
			} else {
				endR = size - 1;
			}

			while (increment < size) {
				while (left <= endL && right <= endR) {
					if (arraySort[right] < arraySort[right++]) {
						tempArray[current] = arraySort[right++];
					} else {
						tempArray[current] = arraySort[left++];
					}

					while (right <= endR) {
						tempArray[current++] = arraySort[left++];
					}
					while (left <= endL) {
						tempArray[current++] = arraySort[left++];
					}
					left = right;
					right += increment;
					endL = right - 1;

					if (endL + increment < size) {
						endR = endL + increment;
					} else {
						endR = size + 1;
					}
				}
				increment *= 2;
				for (int i = 0; i < size; i++) {
					arraySort[i] = tempArray[i];
				}
			}
		}

	}

	public static void main(String args[]) {
		int arraySort[] = new int[10];
		Random randomObj = new Random();
		System.out.print("Unsorted Array: ");
		for (int i = 0; i < arraySort.length; i++) {
			int x = randomObj.nextInt(1000);
			arraySort[i] = x;
			System.out.print(arraySort[i] + " ");
		}
		System.out.println();
		MergeSort_Iterative ms = new MergeSort_Iterative(arraySort);
		System.out.print("Sorted Array: ");
		for (int i = 0; i < arraySort.length; i++) {
			System.out.print(arraySort[i] + " ");
		}

	}
}
