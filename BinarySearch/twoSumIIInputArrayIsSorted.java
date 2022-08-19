class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];
        
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            
            if(sum == target){
                res[0] = ++start;
                res[1] = ++end;
                break;
            }
                
            
            if(sum > target)
                end--;
            else
                start++;
        }
        
        return res;
    }
}