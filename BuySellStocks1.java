/*
pblm link --> https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
Logic --> Ek array create karo and usme store karo ki current day pe buy kiya toh MAXIMUM FUTURE PROFIT kitna denerate ho sakta hai

Example se samajhte hai
[7,1,5,3,6,4]
[0,0,0,0,0,4]
           i

[7,1,5,3,6,4]
[0,0,0,0,6,4]
         i

[7,1,5,3,6,4]
[0,0,0,6,6,4]
       i

[7,1,5,3,6,4]
[0,0,6,6,6,4]
     i

[7,1,5,3,6,4]
[0,6,6,6,6,4]
   i

[7,1,5,3,6,4]
[7,6,6,6,6,4]
 i
isme hum future profit ko current day ke price se compare kar rahe hai and phir maximum profit ko update kar rahe hai

arr1 - [7,1,5,3,6,4]
arr2 - [7,6,6,6,6,4]
ab maximum profit jo buy and sell krke generate kiya jaa sakta hai usko arr2[day_index]-arr1[day_index] ke help se find karlo 
u will get the final right answer
*/
class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int n = prices.length;
        int maxPriceArr[] = new int[n];
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,prices[i]);
            maxPriceArr[i] = max;
        }
        //now just difference calculate karo, future maximum price and current day ka price and maximum profit find kro
        int profit = 0;
        for(int i=0;i<n;i++){
            profit = Math.max(maxPriceArr[i]-prices[i],profit);
        }
        return profit;
    }
}
