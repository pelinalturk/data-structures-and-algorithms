package sortingAlgorithms;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		
		int size;
		Scanner scanner = new Scanner(System.in);
		size = scanner.nextInt();
		int[] numbers = new int[size];
		
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		insertionSort(numbers, size);
		
		for (int i = 0; i < size; i++) {
			System.out.print(numbers[i] + " "); 
		}		
	}

	private static void insertionSort(int[] numbers, int size) {
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				
				if(numbers[j] < numbers[j-1]) {
					int temp = numbers[j];
					 numbers[j] = numbers[j-1];
					 numbers[j-1] = temp;
				}
			}
		}
		
	}
}
