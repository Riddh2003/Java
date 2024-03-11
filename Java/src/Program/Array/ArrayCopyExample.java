package Program.Array;

import java.util.*;
public class ArrayCopyExample {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Size of Array : ");
			int n = sc.nextInt();
			int arr1[] = new int[n];
			int arr2[] = new int[n];
			//input in array1
			System.out.println("Enter Value of Array1 : ");
			for(int i = 0;i<n;i++) {
				arr1[i] = sc.nextInt();
			}
			//output of array1 
			System.out.println("Output of Array1 : ");
			for(int i = 0;i<n;i++) {
				System.out.print(arr1[i]+" ");
			}
			System.out.println();
			//copy value from array1
			for(int i = 0;i<n;i++) {
				arr2[i] = arr1[i];
			}
			//output of array2
			System.out.println("Output of Array2 : ");
			for(int i = 0;i<n;i++) {
				System.out.print(arr2[i]+" ");
			}
		}
	}
}