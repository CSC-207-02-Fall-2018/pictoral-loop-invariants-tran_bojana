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
		int left = start; 
		for (int right = start + 1; right <= end; right++) {
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
	
	public int select (int [] nums, int n, int k) {
		return selectKernel(nums, 0, n - 1, k); 
	}
	
	public int selectKernel(int [] nums, int start, int end, int k) {
		if (start == end) return nums[start]; 
		
		int mid = partition(nums, start, end); 
		System.out.println(mid);
		
		if (k == ((mid) - start + 1)) return nums[(mid)]; 
		if (k <= ((mid) - start)) return selectKernel(nums, start, (mid) - 1, k); 
		return selectKernel(nums, (mid) + 1, end, k - (mid - start) - 1); 
	}
	
	public int median (int [] nums, int n) {
		int middle = n/2; 
		return select(nums, n, middle); 
	}
	
	public void quickSort (int [] nums, int n) {
		quickSortKernel(nums, 0, n - 1); 
	}
	
	public void quickSortKernel(int [] nums, int start, int end) {
		if (start <= end) {
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
		
		
		obj.partition(arr, 0, 6); 
		obj.printArray(arr);
		System.out.println();
		
		int select1 = obj.select(arr, arr.length, 4); 
		System.out.println(select1);
		System.out.println();
		obj.quickSort(arr, arr.length);
		
	}
}
