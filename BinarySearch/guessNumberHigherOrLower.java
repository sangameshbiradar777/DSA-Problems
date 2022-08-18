/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // This can be solved by a straight forward binary search code.
        //declare start variable and end variable and initialize start as 1 and end as n.
        int start = 1;
        int end = n;
        int res = 0;
        
        while(start <= end) {
            // to calulate mid we can use (start + end) / 2 but if start and end are very big 
            // numbers they can easily overflow int. So, we can modify the formula like below.
            int mid = start + (end - start) / 2;

            // call the guess api to check the guess is correct
            int guessedNum = guess(mid);

            // if guess == 1 our number is lower than the picked number so make start = mid + 1
            if(guessedNum == 1)
                start = mid + 1;

            // if guess == -1 our number is greater than the picked number so make end = mid - 1
            if(guessedNum == -1)
                end = mid - 1;

            // if both the conditions do not satisfy than means our guess is right, make res = mid
            if(guessedNum == 0) {
                res = mid;
                break;
            }

            
        }
        
        return res;
    }
}