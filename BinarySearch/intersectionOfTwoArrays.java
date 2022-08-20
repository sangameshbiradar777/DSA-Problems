class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] smallArray = nums1.length > nums2.length ? nums2 : nums1;
        int[] bigArray = nums1.length <= nums2.length ? nums2 : nums1;
        
        int[] similarArray = new int[smallArray.length];
        int index = 0;
        
        for(int i = 0; i < smallArray.length; i++) {
            if(!isPresent(smallArray[i], index, similarArray)) {
                if(search(smallArray[i], bigArray))
                    similarArray[index++] = smallArray[i];
            }
                
        }
        
        int[] resArray = new int[index];
        
        for(int i = 0; i < index; i++)
            resArray[i] = similarArray[i];
        
        return resArray;
    }
    
    static boolean isPresent(int num, int length, int[] arr) {
        for(int i = 0; i < length; i++){
            if(arr[i] == num)
                return true;
        }
            
        return false;
    }
    
    static boolean search(int target, int[] targetArray) {
        for(int i = 0; i < targetArray.length; i++)
            if(targetArray[i] == target)
                return true;
        return false;
    }
}