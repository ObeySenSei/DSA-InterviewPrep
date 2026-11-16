public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        System.out.println("The max amount of water than can be held by the given Containers:  " + result);
    }
    public static int maxArea (int[] height){
        int maxArea = 0;
        int n = height.length;

        for (int i=0; i<n; i++) {
            for (int j = i + 1; j < n; j++) {
                int width = j - i;                                        // calculates Width of a particular Container
                int currentHeight = Math.min(height[i], height[j]);       // calculates Height of two boundaries of a Container

                int currentArea = width * currentHeight;                  // Formula to calculate Area

                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }
}
