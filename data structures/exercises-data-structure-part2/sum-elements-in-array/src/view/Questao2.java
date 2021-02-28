package view;

import java.util.Arrays;

public class Questao2 {

	public static void main(String[] args) {
		
		int arr[] = new int [10];
		
		int length = arr.length;
		
		for(int i = 0; i <length; i++)
			arr[i] = (int) ((Math.random()* 10) + 1);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(sumElements(arr, 0, length - 1));
	}

	private static int sumElements(int[] arr, int i, int j) {
		if(i == j)
			return arr[i];
		else
			return arr[i] + sumElements(arr, i+1, j);
	}

}
