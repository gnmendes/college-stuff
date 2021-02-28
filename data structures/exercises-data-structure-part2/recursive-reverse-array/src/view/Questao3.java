package view;

import java.util.Arrays;

public class Questao3 {

	public static void main(String[] args) {
		int arr[] = new int[10];

		int length = arr.length;

		for (int i = 0; i < length; i++)
			arr[i] = (int) ((Math.random() * 7401) + 17);

		System.out.println(Arrays.toString(arr));
		
		arr = swap(arr, 0, length - 1);
	
		System.out.println(Arrays.toString(arr));
	}

	private static int[] swap(int[] arr, int i, int j) {
		if(i >= j)
			return arr;
		else {
			int swap = arr[i];
			arr[i] = arr[j];
			arr[j] = swap;
			
			return swap(arr, i+1, j-1);
		}
	}

}
