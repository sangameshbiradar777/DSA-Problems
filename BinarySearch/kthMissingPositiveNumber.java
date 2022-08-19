// Binary Search Solution

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        
        int missing = NoOfMissingNumbers(arr[arr.length - 1], arr.length);
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(NoOfMissingNumbers(arr[mid], mid + 1) >= k)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        
        if(end == -1) return k;
        return arr[end] + k - NoOfMissingNumbers(arr[end], end + 1);
    }
    
    static int NoOfMissingNumbers(int num, int length) {
        return num - length;
    }
    
}


// Bruteforce Solution

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingNumbers = 0;
        int index = 0;
        
        for(int incr = 1; incr <= arr[arr.length - 1]; incr++) {
            if(incr != arr[index])
                missingNumbers++;
            else
                index++;
            
            if(missingNumbers == k)
                return incr;
        }
        
        return arr[arr.length - 1] + k - missingNumbers;
    }
        
    }
    
}