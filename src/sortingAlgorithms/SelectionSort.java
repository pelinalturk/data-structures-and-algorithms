package sortingAlgorithms;

import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		int size;
		Scanner scanner = new Scanner(System.in);
		size = scanner.nextInt();
		int[] numbers = new int[size];
		
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		selectionSort(numbers, size);
		
		for (int i = 0; i < size; i++) {
			System.out.print(numbers[i] + " "); 
		}		
	}

	private static void selectionSort(int[] numbers, int size) {
		
		for (int i = 0; i < size-1; i++) {
			
			int min = i;
			
			for (int j = i; j < size; j++) {
				
				if (numbers[min] > numbers[j]) {
					min = j;
				}
			}
			
			int temp = numbers[min];
			numbers[min] = numbers[i];
			numbers[i] = temp;
		}
	}
}
