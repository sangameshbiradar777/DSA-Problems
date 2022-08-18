public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // This quesion can be solved by simple binary search.
        int start = 1;
        int end = n;
        int res = 0;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(start == mid && end == mid){
                res = mid;
                break;
            }
            
            boolean isBad = isBadVersion(mid);
            
            if(!isBad)
                start = mid + 1;
            else 
                end = mid;
        }
        
        return res;
    }
}