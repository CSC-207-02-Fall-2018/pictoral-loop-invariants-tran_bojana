package partitions;

import java.util.Arrays;

public class Partitions {
	
	public static int partition(int [] nums) {
		int len = nums.length; 
		int left = 1, right = len - 1; 
		int pivot = nums[0]; 
		while (left <= right) {
			while (left <= right && nums[left] <= pivot) {
				left++; 
			}
			while (nums[right] > pivot) {
				right--; 
			}
			if (left < right) {
				int temp = nums[right]; 
				nums[right] = nums[left]; 
				nums[left] = temp; 
				left++; right--; 
			}
		}
		nums[0] = nums[right]; 
		nums[right] = pivot; 
		return right; 
	}
	
	public static int select (int a[], int n, int k) {
		int mid = partition(a); 
		if (k > n || k == 0) {
			throw new IndexOutOfBoundsException("k cannot be larger than array's size or equal to 0."); 
		}
		if (k == mid + 1) return a[mid]; 
		if (k < mid + 1) {
			int [] arr = Arrays.copyOfRange(a, 0, mid);
			return select(arr, mid, k); 
		}
		if (k > mid + 1) {
			int [] arr = Arrays.copyOfRange(a, mid + 1, n); 
			return select(arr, n - mid - 1, k - mid - 1);
		}
		return a[mid];
	}
	
	public static int median (int a[], int n) {
		int mid = (n%2 == 0)? n/2 : (n+1)/2;
		return select(a, n, mid); 
	}
	
	public static void quickSort(int a[], int n) {
		if(n > 1) {
			int mid = partition(a); 
			int [] arrRight = Arrays.copyOfRange(a, mid + 1, n);
			quickSort(arrRight, n - mid - 1); 
			int [] arrLeft = Arrays.copyOfRange(a, 0, mid - 1);
			quickSort(arrLeft, mid - 1); 
		}
	}
	
	public static void main (String [] args) {
		int [] arr = {1, 2, 3, -5, 8, -3, 7}; 
		int [] arr3 = {100, 50, 30, 20, 10}; 
		int [] arr4 = {1, 2, 3 , 4, 5, 6}; 
		int [] arr2 = {5, 8, -1, 4, 10, 2}; 
		int len = arr.length;
		int len2 = arr2.length;
		/**
		System.out.println(partition(arr)); 
		System.out.println(partition(arr2)); 
		System.out.println(select(arr, 7, 1));
		System.out.println(select(arr2, 6, 5));
		System.out.println(median(arr, 7));
		System.out.println(median(arr2, 6));
		*/
		quickSort(arr2, len2); 
		System.out.println(); 
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(); 
		for (int i = 0; i < len2; i++) {
			System.out.println(arr2[i]);
		}

	}
}
