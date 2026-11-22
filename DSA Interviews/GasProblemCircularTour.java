public class GasProblemCircularTour {
    public static void main(String[] args) {
        int[] gas =  {1, 2, 4, 5, 9};
        int[] cost = {3, 4, 1, 10, 1};

        int resultIndex = findStation(gas, cost);
        System.out.println("The Gas station where the Circular Tour can be completed: " + resultIndex);
    }

    private static int findStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;

        for (int i=0; i<gas.length; i++){
            int netGas = gas[i] - cost[i];           // Net Gas has been declared inside because it has to reset for every iteration to calculate different values.

            totalGas = totalGas + gas[i];            // Notice we have same i values for every iteration.
            totalCost = totalCost + cost[i];

            tank = tank + netGas;

            if (tank < 0){
                start = i + 1;                       // start gets incremented when the current (i)th station in invalid
                tank = 0;                            /// we have to reset the tank value to 0. VVI
            }
        }
        if (totalGas < totalCost){
            return -1;                               // No valid index (station exists)
        }
        return start;                                // return the candidate starting index after eliminating invalid starting positions.
    }

}
/**

 One important distinction:
 - tank < 0 → the current candidate starting point is invalid, so reset start = i + 1.
 - totalGas < totalCost → no valid circular tour exists.
 - Otherwise → start is guaranteed to be a valid starting index.

 */