package partitions;

import java.util.Arrays;

public class Partitions {
	
	public Partitions() {}
	
	public void printArray(int [] arr) {
		int len = arr.length; 
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public int partition(int [] nums, int left, int right) { 
		int initial = left; 
 		int pivot = nums[left]; 
 		left++; 
 		while (left <= right) {
 			while (left <= right && nums[left] <= pivot) {
 				left++; 
 			}
 			while (left <= right && nums[right] > pivot) {
 				right--; 
 			}
 			if (left <= right) {
 				int temp = nums[right]; 
 	 			nums[right] = nums[left]; 
 	 			nums[left] = temp; 
 			}
 			
 		}
 			nums[initial] = nums[right]; 
 	 		nums[right] = pivot; 
 	 		return right;
	}
	
	public int select (int [] nums, int k) {
		return selectHelper(nums, k, 0, nums.length - 1); 
	}
	
	public int selectHelper(int [] nums, int k, int left, int right) {
		int middle = partition(nums, left, right); 
		if (middle - left == k - 1) return nums[middle]; 
		if (middle - left >= k) return selectHelper(nums, k, left, middle - 1); 
		return selectHelper(nums, k - (middle - left) - 1, middle + 1, right); 
	}
	
	public int median (int [] nums) {
		int middle = nums.length/2; 
		return select(nums, middle); 
	}
	
	public void quickSort (int [] nums, int n) {
		quickSortKernel(nums, 0, n - 1); 
	}
	
	public void quickSortKernel(int [] nums, int start, int end) {
		if (start < end) {
			int mid = partition(nums, start, end); 
			quickSortKernel(nums, start, mid - 1); 
			quickSortKernel(nums, mid + 1, end); 
		}
	}
	
	
	
	public static void main (String [] args) {
		int [] arr = {1, -2, 4, 9, -10, 3, 7}; 
		int [] arr2 = {1, 2, 3, 4, 5, 6, 7, 8}; 
		int [] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1}; 
		Partitions obj = new Partitions(); 
		
		
		int select1 = obj.select(arr, 6); 
		int select2 = obj.select(arr2, 2); 
		int select3 = obj.select(arr2, 6); 
		System.out.println(select1);
		System.out.println();
		System.out.println(select2);
		System.out.println();
		System.out.println(select3);
		System.out.println();
		obj.printArray(arr);
		System.out.println();
		
		obj.quickSort(arr, arr.length);
		obj.quickSort(arr2, arr2.length);
		obj.quickSort(arr3, arr3.length);
		obj.printArray(arr);
		System.out.println();
		obj.printArray(arr2);
		System.out.println();

		obj.printArray(arr3);
		System.out.println();

		
	}
}
