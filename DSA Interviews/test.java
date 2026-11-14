
public class test {
    public static void main(String[] args) {
        System.out.println(findPower(2.0,5));
    }
    public static double findPower (double x, int n){
        if (n==0) return 1.0;
        if (x==0) return 0.0;
        if (x==1) return 1.0;
        if (x==-1 && n%2==0) return 1.0;
        if (x==-1 && n%2!=0) return -1.0;

        long power = n;             // to handle interger overflow edge case

        if (power < 0){
            x = 1 / x;
            power = - power;
        }
        double ans = 1;
        double base = x;

        while (power > 0){
            if (power % 2 == 1){
                ans = ans * base;
            }
            base = base * base;
            power = power / 2;
        }
        return ans;
    }
}
