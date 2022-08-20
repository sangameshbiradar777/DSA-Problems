class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        
        for(int index = 0; index < arr.length; index++) {
            if(binarySearch(arr[index] * 2, arr)) 
                return true;
        }
        
        return false;
    }
    
    static boolean binarySearch(int target, int[] targetArray) {
        if(target == 0) 
            return targetArray[1] == 0;
        
        int start = 0;
        int end = targetArray.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(targetArray[mid] == target)
                return true;
            
            if(targetArray[mid] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        
        return false;
    }
}