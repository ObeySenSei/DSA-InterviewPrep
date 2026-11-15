public class PrintSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        print(arr);
    }

    public static void print(int[] arr) {

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                System.out.print("[ ");

                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("]");
            }
        }
    }
}
