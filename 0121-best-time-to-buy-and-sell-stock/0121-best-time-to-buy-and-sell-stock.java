class Solution {
    public int maxProfit(int[] prices) {
        int buyingIndex = 0, sellingIndex = 0, currentMaxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if(prices[i] < prices[buyingIndex]){
                currentMaxProfit = Math.max(currentMaxProfit, prices[sellingIndex] - prices[buyingIndex]);
                buyingIndex = i;
                sellingIndex = i;
            }
            if(prices[i] > prices[sellingIndex]){
                sellingIndex = i;
            }
        }

        return  Math.max(currentMaxProfit, prices[sellingIndex] - prices[buyingIndex]);
    }
}