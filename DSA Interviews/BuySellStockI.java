
public class BuySellStockI {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int maxProfit = findMaxProfit(price);
        System.out.println(maxProfit);

    }
    public static int findMaxProfit(int[] price){

        int minPrice = price[0];          // or we can set it to  Interger.MAX_VALUE;
        int maxProfit = 0;

        for(int i=1; i<price.length; i++){        // i = 1 since we already assume that the first element arr[0] holds the minimum price.
            if (price[i] < minPrice){
                minPrice = price[i];
            }
            int currentProfit = price[i] - minPrice;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}