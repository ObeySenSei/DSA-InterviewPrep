public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "Ac3?e3c&a";   //  or use "race acar"
        boolean result = isPalindrome(str);
        System.out.println(result);
    }
    public static boolean isPalindrome(String str){

        int n = str.length();         // Calculate the length of the String

        int start = 0;
        int end = n - 1;

        while(start < end){           // (start <= end) Why? Because when both pointers meet or cross, there are no more character pairs to compare.

            if(!AlphaNum(str.charAt(start))) {   /// If the function returns FALSE, we skip that special character (start++)
                start++;
                continue;          ///  Here, continue executes only when the character is NOT alphanumeric. If the character IS alphanumeric, Java skips the entire if block and proceeds to the next statement after it.
            }                     ///  continue immediately skips the remaining loop body and starts the next iteration.

            if(!AlphaNum(str.charAt(end))) {
                end--;
                continue;
            }
            if(Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))){
                return false;
            }
            start++; end--;
        }
        return true;
    }

    private static boolean AlphaNum(char ch) {
        if(( ch>='A' && ch <='Z' || ch>='a' && ch <='z' || ch>='0' && ch <='9')){
            return true;
        }
        return false;
    }
}
/**
 *
 if(Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))){
 Here, while converting our characters to LowerCase:
 we are checking whether our character at the start index == to character at the end index.

 */