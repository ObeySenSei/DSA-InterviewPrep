package String;

public class StringCompressionBasicValue {
    public static void main(String[] args) {
        char[] s = {'a','a','b','b','c','c'};    // Characters are denoted by single inverted comma.
        int result =  stringCompression (s);
        System.out.println(result);
    }
    private static int stringCompression(char[] s) {

        int count = 0;

        for (int i=0; i<s.length; i++){        ///  If s is a character array (char[]), you need to access an individual character using its index.
            if (s[i] == 'a' || s[i] == 'b' || s[i] == 'c'){
                count++;
            }
        }
        return count;
    }

}
