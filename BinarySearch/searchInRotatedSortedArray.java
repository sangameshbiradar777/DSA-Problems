class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans = 0;
        if(pivot != -1) {
            ans = binarySearch(nums, 0, pivot, target);
            if(ans == -1)
                ans = binarySearch(nums, pivot + 1, nums.length - 1, target);
        } else 
            ans = binarySearch(nums, 0, nums.length - 1, target);
            
        return ans; 
    }
    
    static int findPivot(int[] array) {
        int start = 0; 
        int end = array.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midEl = array[mid];
            
            if(mid < end && midEl > array[mid + 1])
                return mid;
            
            if(mid > start && array[mid - 1] > midEl)
                return mid - 1;
            
            if(array[start] >= midEl)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        
        return -1;
    }
    
    static int binarySearch(int[] targetArray, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(targetArray[mid] == target)
                return mid;
            
            if(targetArray[mid] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        
        return -1;
    }
}