class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length <= 2)
            return nums[0];
            
        return binarySearch(nums);
    }
    
    static int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        if(nums[start] < nums[start + 1])
            return nums[start];
        
        if(nums[end] > nums[end - 1])
            return nums[end];
        
        while(start <= end) {
            int mid = start + (end - start) / 2;

            int midEl = nums[mid];
            int midGreater = nums[mid + 1];
            int midLesser = nums[mid - 1];

            if(midEl > midLesser && midEl < midGreater)
                return midEl;

            if(mid % 2 == 0) {
                if(midEl != midGreater)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(midEl != midLesser)
                    end = mid - 1;
                else 
                    start = mid + 1;
            } 
        }
        
        return -1;
    }
}