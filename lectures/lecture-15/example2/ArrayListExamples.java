//https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/ArrayList.html
import java.util.ArrayList;

class ArrayListExamples {

    //Return a NEW arraylist of just the strings longer than the
    //given length
    static ArrayList<String> longStrings(ArrayList<String> strs, int length) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String s: strs) {
            if (s.length() > length) {
                toReturn.add(s);
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {

    }
}
