class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int left = 0, right = 1; left < right && right < prices.length; ) {
            int profit = prices[right] - prices[left];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
    
}
