class BinarySearch {

	public static void main(String[] args) {
		int[] array = {1, 3, 5, 5, 6, 17, 19, 30};
		int target = 5;
		int result = binarySearch(array, target);
		System.out.println(result);
	}

	static int binarySearch(int[] array, int target) {
		/* Binary search is a searching alogrithm which searches the target element by breaking the array into 
		two parts in every iteration.
		This time complexity of this algorithem is log2n.
		We need to have a start and end pointer.
		Start pointer will be equal to 0 and end pointer will be equal to array.length - 1. */

		int start = 0;
		int end = array.length - 1;

		/* Here we could have just taken (start + end) / 2 but the problem with this is if we have very huge
		numbers, adding those two huge numbers will result in even bigger numbers which cannot be stored in
		int and int may overflow. So, to avoid that problem we can tweak the mid formula as 
		start + (end - start) / 2. */

		while(start <= end) {
			int mid = start + (end - start) / 2;

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

			/* if target is equal to the element at the mid index of the array then just return the mid
			variable */
			
			if(target == array[mid]) {
				return mid;
			}
		}
		
		return -1;

	}

}

