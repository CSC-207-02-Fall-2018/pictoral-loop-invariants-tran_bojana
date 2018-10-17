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
	
	public int partition(int [] nums, int start, int end) { 
		int pivot = nums[0]; 
		int left = start + 1; 
		for (int right = left + 1; right < end; right++) {
			if (nums[right] <= pivot) {
				left++; 
				int temp = nums[right]; 
				nums[right] = nums[left]; 
				nums[left] = temp; 
			}
		}
		nums[0] = nums[left]; 
		nums[left] = pivot; 
		
		return left; 
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
		Partitions obj = new Partitions(); 
		obj.partition(arr, 0, arr.length); 
		obj.printArray(arr);
		obj.quickSort(arr, arr.length);
		obj.printArray(arr);
	}
}
