package BasicQuestions;

public class test {
    public static void main(String[] args) {
        String s = "JAVA IS  FUN";
        reverseWord(s);
    }
    public static void reverseWord(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));                // s points to where - points to the charAt(i)
        }

        int start = 0;

        for (int i=0; i<=sb.length(); i++){
            if(i == sb.length() || sb.charAt(i) == ' '){
            int left = start;
            int right = i - 1;

            while (left < right){
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);

                left++;
                right--;
            }
            start = i+1;
            }
        }
        System.out.println(sb);
    }
}
