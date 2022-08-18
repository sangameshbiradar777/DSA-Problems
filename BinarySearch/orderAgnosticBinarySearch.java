class BinarySearch {

	public static void main(String[] args) {
		int[] array = {1, 3, 5, 5, 6, 17, 19, 30};
		int target = 5;
		int result = orderAgnosticBinarySearch(array, target);
		System.out.println(result);
	}

	static int orderAgnosticBinarySearch(int[] array, int target) {
        /* In the order agnostic binary search we may be given with both ascending and descending order
        arrays so we need to make our code work for both the cases. */
        
        /* A simple way to check if an array is an ascending array or not we can check the first and 
        second elements of the array, if first element is less than the second element we can say that 
        the given array is an ascending order array */
        
        /* But the above solution does not work for every array, what if our array is [2, 2, 2, 2, 1]
        here both the first and second elements are same, we cannot conclude that the given array is
        ascending or descending by checking the first two elements of the array. So, it's always good to
        check the first and last elements of the array */
        
        boolean isAscending = array[0] < array[array.length - 1];

		int start = 0;
		int end = array.length - 1;

		/* Here we could have just taken (start + end) / 2 but the problem with this is if we have very huge
		numbers, adding those two huge numbers will result in even bigger numbers which cannot be stored in
		int and int may overflow. So, to avoid that problem we can tweak the mid formula as 
		start + (end - start) / 2. */

		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			/* if target is equal to the element at the mid index of the array then just return the mid
			variable */
			
			if(target == array[mid]) {
				return mid;
			}
			
			// code to search if the array is ascending
			if(isAscending) {
			   /* if target is greater than the element at mid index of the array then search in the array from 
    			mid + 1 to end. */
    
    			if(target > array[mid]) {
    				start = mid + 1;
    			}
    
    			/* if target is less than the element at the mid index of the array then search in the array
    			from start to mid - 1 */
    
    			if(target < array[mid]) {
    				end = mid - 1;
    			} 
			}
			// code to search if the array is descending
			else {
			    /* if target is greater than the element at mid index of the array then search in the array from 
    			start to mid - 1. */
    
    			if(target > array[mid]) {
    				end = mid - 1;
    			}
    
    			/* if target is less than the element at the mid index of the array then search in the array
    			from mid + 1 to end */
    
    			if(target < array[mid]) {
    				start = mid + 1;
    			} 
			}			
		}
		
		return -1;

	}

}

