package sortingAlgorithms;

import java.util.Scanner;
 
public class BubbleSort {
	public static void main(String[] args) {
		
		int size;
		Scanner scanner = new Scanner(System.in);
		size = scanner.nextInt();
		int[] numbers = new int[size];
		
		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		bubbleSort(numbers, size);
		
		for (int i = 0; i < size; i++) {
			System.out.print(numbers[i] + " "); 
		}		
	}

	private static void bubbleSort(int[] numbers, int size) {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size-1-i; j++) {
				
				if (numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
	}
}