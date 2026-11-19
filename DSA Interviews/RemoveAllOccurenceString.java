public class RemoveAllOccurenceString {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        StringBuilder result = removeOccurrences(s,part);
        System.out.println(result);

    }
    public static StringBuilder removeOccurrences(String s, String part ) {

        StringBuilder sb = new StringBuilder(s);    // First we create a StringBuilder that stores our String. We do this because String is immutable.

        int index = sb.indexOf(part);                   // This searches for the first occurrence of our substring "abc" from the start
                                                        // Returns the index of the first time 'a' in abc appears. Returns -1 is there is no Substring.
        while (index!=-1){

            sb.delete(index, index + part.length());    // sb.delete ( 2, 2+3)  Deletes all the elements indices from 2 - 4.
            index = sb.indexOf(part);                   // Updates index and finds the value of the next substring "abc".
        }
        return sb;                                      // return sb.toString(), if you want to return the value as a String to your String Method
    }
}

/**

 sb.delete ( 2, 2+3)  Deletes all the elements indices from 2 - 4. (2,5)  and not 2 - 5
 because starting index is inclusive, ending index is exclusive.
 */
