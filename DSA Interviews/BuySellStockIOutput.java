public class BuySellStockIOutput {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int maxProfit = findMaxProfit(price);
    }

    public static int findMaxProfit(int[] price){
        int minPrice = price[0];
        int maxProfit = 0;

        // Trackers for the days
        int buyDay = 0;
        int sellDay = 0;
        int tempBuyDay = 0;

        for(int i = 1; i < price.length; i++){
            if (price[i] < minPrice){
                minPrice = price[i];
                tempBuyDay = i; // Save this as a potential buy day
            }

            int currentProfit = price[i] - minPrice;

            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
                buyDay = tempBuyDay; // Lock in the winning buy day
                sellDay = i;          // Lock in the winning sell day
            }
        }

        System.out.println("Max Profit: " + maxProfit);
        System.out.println("Best day to buy: Day " + buyDay + " (Price: " + price[buyDay] + ")");
        System.out.println("Best day to sell: Day " + sellDay + " (Price: " + price[sellDay] + ")");

        return maxProfit;
    }
}
