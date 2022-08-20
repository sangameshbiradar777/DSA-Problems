class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smallArray = nums1.length < nums2.length ? nums1 : nums2;
        int[] bigArray = nums1.length >= nums2.length ? nums1 : nums2;
        
        int smallArrLength = smallArray.length;
        int[] similarArray = new int[smallArrLength];
        int similarArrIndex = 0;
        
        Arrays.sort(bigArray);
        
        for(int index = 0; index < smallArrLength; index++) {
            int currentEl = smallArray[index];
            int noOfElements = isPresent(currentEl, similarArray, similarArrIndex);
            
            if(binarySearch(currentEl, bigArray, noOfElements)) {
                similarArray[similarArrIndex++] = currentEl;
            }
        }
        
        
        int[] res = new int[similarArrIndex];
        
        for(int i = 0; i < similarArrIndex; i++)
            res[i] = similarArray[i];
        
        return res;
    }
    
    static int isPresent(int target, int[] targetArray, int index) {
        int count = 0;
        for(int i = 0; i < index; i++) {
            if(targetArray[i] == target)
                count++;
        }
        
        return count;
    }
    
    static boolean binarySearch(int target, int[] targetArray, int nthNumber) {
        int start = 0;
        int end = targetArray.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(targetArray[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        if(start + nthNumber >= targetArray.length)
            return false;
        
        return targetArray[start + nthNumber] == target;
    }
}