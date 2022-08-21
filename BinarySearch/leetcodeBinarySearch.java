class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(target, nums);
    }
    
    static int binarySearch(int target, int[] targetArray) {
        int start = 0;
        int end = targetArray.length - 1;
        
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