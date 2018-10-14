package partitions;

import java.util.Arrays;

public class Partitions {
	
	public static int partition(int [] nums) {
		int len = nums.length; 
		int left = 1, right = len - 1; 
		int pivot = nums[0]; 
		while (left <= right) {
			while (nums[left] <= pivot) {
				left++; 
			}
			while (nums[right] > pivot) {
				right--; 
			}
			if (left <= right) {
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
		if (k == mid) return mid; 
		if (k < mid) return select(Arrays.copyOfRange(a, 0, mid), mid, k); 
		if (k > mid) return select(Arrays.copyOfRange(a, mid, n - mid), mid, k - (mid -1));
		return mid;
	}
	
	public static void main (String [] args) {
		int [] arr = {1, 2, 3, -5, 8, -3, 7}; 
		int [] arr2 = {5, 8, -1, 4, 10, 2}; 
		int len = arr.length;
		int len2 = arr2.length;
		System.out.println(partition(arr)); 
		System.out.println(partition(arr2)); 
		System.out.println(select(arr, 7, 4));
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
