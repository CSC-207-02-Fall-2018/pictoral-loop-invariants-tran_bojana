package partitions;

/**
 * The Partitions class provides methods to perform partition, selection of the k_th smallest number, 
 * finding the median and quickSort on an array of integers. 
 * Instances of Partitions have no fields. 
 * */
public class Partitions {
	
	public Partitions() {}

	/**
	 * Print every elements of an array of ints. 
	 * Pre-conditions: none
	 * Post-conditions: The array of ints is printed
	 * @param an array of ints
	 * @return nothing
	 * */
	public void printArray(int [] arr) {
		int len = arr.length; 
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	/**
	 * Method to perform partition on an array of ints. 
	 * Pre-conditions: left and right should be within the bounds of the array, left < right
	 * Post-conditions: the array is partitioned with the first element as the pivot, meaning the pivot
	 * is in its sorted position and every element before pivot is smaller than pivot, and every element
	 * after pivot is larger than pivot
	 * @param an array of ints, 2 indicies of the array
	 * @return an int which represents the index of the pivot after the partition
	 * */
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
			if (left < right) {
				int temp = nums[right]; 
				nums[right] = nums[left]; 
				nums[left] = temp; 
			}
		}
		nums[initial] = nums[right]; 
		nums[right] = pivot; 
		return right;
	}

	/**
	 * Select the k_th smallest number in an array
	 * Pre-conditions: k <= nums.length
	 * Post-conditions: method must return the k-smallest int in the array
	 * 					the element is in the input array
	 * @param nums - an array of ints to be selected from 
	 * @param k - an int to indicate the k_smallest int we want to select
	 * @return the k-smallest int in the array
	 * */
	public int select (int [] nums, int k) {
		return selectHelper(nums, k, 0, nums.length - 1); 
	}

	/**
	 * A helper method to select the k_th smallest number given a sub-array
	 * Pre-conditions: k <= nums.length, left and right should be legal indicies in the array, left < right
	 * Post-conditions: method must return the k-smallest element in the array
	 * 					the element is in the input array
	 * @param nums - an array of ints, 
	 * @param k - an int to indicate the k_smallest int we want to select
	 * @param left - the starting index of the sub-array (inclusive)
	 * @param right - the ending index of the sub-array (inclusive)
	 * @return the k-smallest element in the array
	 * */
	public int selectHelper(int [] nums, int k, int left, int right) {
		int middle = partition(nums, left, right); 
		while (middle != k - 1) {
			if (middle < k - 1) {
				middle = partition(nums, middle + 1, right); 
			}
			else if (middle > k - 1) {
				middle = partition(nums, left, middle - 1); 
			}
		}
		return nums[middle]; 
	}

	/**
	 * A method to find the median of an array
	 * Pre-conditions: none
	 * Post-conditions: return the median of the input array of ints
	 * 					if the array is of even length, either of the middle values is returned. 
	 * @param nums - an array of ints
	 * @return the median value of the array
	 * */
	public int median (int [] nums) {
		int middle = nums.length/2; 
		return select(nums, middle); 
	}

	/**
	 * A wrapper method to perform quick sort on an input array of ints.
	 * Pre-conditions: n = nums.length
	 * Post-conditions: the array will be sorted
	 * @param nums - an array of ints
	 * @param n - the length of the input array
	 * @return nothing
	 * */
	public void quickSort (int [] nums, int n) {
		quickSortKernel(nums, 0, n - 1); 
	}

	/**
	 * A helper method to perform quick sort on a sub-array
	 * Pre-conditions: start and end represent indicies in the array
	 * Post-conditions: the array will be sorted
	 * @param nums - an array of ints, 
	 * @param left - the starting index of the sub-array (inclusive)
	 * @param right - the ending index of the sub-array (inclusive)
	 * @return nothing
	 * */
	public void quickSortKernel(int [] nums, int left, int right) {
		if (left < right) {
			int mid = partition(nums, left, right); 
			quickSortKernel(nums, left, mid - 1); 
			quickSortKernel(nums, mid + 1, right); 
		}
	}


	public static void main (String [] args) {
		Partitions obj = new Partitions(); 
		
		//declare some arrays
		//Case 1) odd length array
		int [] arr = {1, -2, 4, 9, -10, 3, 7}; 
		//Case 2 and 4) even length array in ascending order 
		int [] arr2 = {1, 2, 3, 4, 5, 6, 7, 8}; 
		//Case 5) odd length array in descending order
		int [] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1}; 
		
		//partition test on sub-array
		System.out.println("Partition of arr l=3, r=6: \n");
		System.out.println(obj.partition(arr, 3, 6));
		System.out.println("Print arr after partition: \n");
		obj.printArray(arr);
		System.out.println();
		
		System.out.println("Partition of arr3 l=2, r=8: \n");
		System.out.println(obj.partition(arr3, 2, 8));
		System.out.println("Print arr3 after partition: \n");
		obj.printArray(arr3);
		System.out.println();
	
		//testing partition on the entire array: 
		System.out.println("Partition of arr l=0, r=6: \n");
		System.out.println(obj.partition(arr, 0, 6));
		System.out.println("Print arr after partition: \n");
		obj.printArray(arr);
		System.out.println();
		
		System.out.println("Partition of arr2 l=0, r=5: \n");
		System.out.println(obj.partition(arr2, 0, 7));
		System.out.println("Print arr2 after partition: \n");
		obj.printArray(arr2);
		System.out.println();
		
		//select test
		int select1 = obj.select(arr, 4); 
		System.out.println("4th smallest element of arr: \n");
		System.out.println(select1);
		System.out.println();
		
		//Case 3) k = length of array
		int select2 = obj.select(arr2, 8); 
		System.out.println("8th smallest element of arr2: \n");
		System.out.println(select2);
		System.out.println();
		
		//median test
		System.out.println("Median of arr: \n");
		int median = obj.median(arr);
		System.out.println(median);
		
		System.out.println("Median of arr2: \n");
		int median2 = obj.median(arr2);
		System.out.println(median2);

		//quick sort test
		obj.quickSort(arr, arr.length);
		obj.quickSort(arr2, arr2.length);
		obj.quickSort(arr3, arr3.length);
		System.out.println("Print arr after quickSort: \n");
		obj.printArray(arr);
		System.out.println();
		System.out.println("Print arr2 after quickSort: \n");
		obj.printArray(arr2);
		System.out.println();
		System.out.println("Print arr3 after quickSort: \n");
		obj.printArray(arr3);
		System.out.println();	
	}
}
