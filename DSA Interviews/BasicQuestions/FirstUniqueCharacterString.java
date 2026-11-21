package BasicQuestions;       // Nested loops (Brute Force)

public class FirstUniqueCharacterString {
    public static void main(String[] args) {
        String str = "level";
        char ch = findCharacter(str);
        System.out.println("The character that appears first exactly once : " + ch);
    }
    public static char findCharacter(String str) {

        ///    char c = '\0';   Java doesn't allow an empty character literal like ''.  So use '\0';

        for(int i=0; i<str.length(); i++){
            int count = 0;
            for(int j=0; j<str.length(); j++){
                if (str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
            if(count==1){
                return str.charAt(i);    // As soon as the count reaches 1, simply return that character c.
            }
        }
        return '\0';
    }
}
