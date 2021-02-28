package view;

import java.util.Arrays;

public class Questao1 {

	public static void main(String[] args) {

		int[] arr = new int[10];

		int size = arr.length;

		for (int i = 0; i < size; i++) {
			arr[i] = (int) ((Math.random() * 7001) + 500);
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(getGreatest(arr, 0, size));
	}

	private static int getGreatest(int[] arr, int i, int length) {
		if(i == length - 1) 
			return arr[i];
		else {
			int gg = getGreatest(arr, i+1, length);
			
			if(arr[i] > gg)
				return arr[i];
			else
				return gg;
		}
	}
}
