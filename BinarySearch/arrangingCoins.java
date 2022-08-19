Binary search approach

class Solution {
    public int arrangeCoins(int n) {
        int start = 1;
        int end = n;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(firstNSum(mid) == n)
                return mid;
            
            if(firstNSum(mid) > n)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        
        return end;
    }
    
    static long firstNSum(long num) {
        return (num * (num + 1)) / 2;
    }
}



Bruteforce solution

class Solution {
    public int arrangeCoins(int n) {
	        int incr = 1;
			int noOfStairs = 0;
        
			while(n >= 0) {
				if(n >= incr)
					noOfStairs++;
					
				n -= incr++;
			}
        
			 return noOfStairs;
    }