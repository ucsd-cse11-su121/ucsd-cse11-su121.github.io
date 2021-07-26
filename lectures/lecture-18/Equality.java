import java.util.Arrays;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /***
     * 
     * @param other Another point to reference to
     * @return true if the points have the xame x and y coordinates, false otherwise
     */
    boolean same(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }
}

class Equality {

    Point p = new Point(4, 5);
    Point p2 = new Point(4, 5);

    boolean pAndP2EqualsByOperator = (p == p2);
    boolean pAndP2Equals = p.equals(p2);    //Calling the .equals method on built-in Object class
    boolean pAndP2SameByMethod = p.same(p2);

    int[] numsA = { 5, 1, 7 };
    int[] numsB = { 5, 1, 7 };

    boolean numsEqualsByOperator = (numsA == numsB);
    boolean numsEqualByMethod = numsA.equals(numsB);
    boolean numsEqualByArrayEqual = Arrays.equals(numsA, numsB);
    //calls .equals() on all elements if they are objects
    //or compares with == if they are primitives

    String s1 = "apple";
    String s2 = "applesauce".substring(0, 5);   //ensures we get a new string reference for s2
    String[] strs1 = { s1, s2 };
    String[] strs2 = { s2, s1 };

    boolean strsEqualsByOperator = (strs1 == strs2);
    boolean strsEqualByMethod = strs1.equals(strs2);
    boolean strsEqualByArrayEqual = Arrays.equals(strs1, strs2);
    boolean s1AndS2EqualByOperator = (s1 == s2);

    public static void main(String[] args) {
        String appleVar1 = "apple";
        String appleVar2 = "apple";

        System.out.println("appleVar1 == applveVar2: " + (appleVar1 == appleVar2));
        System.out.println(appleVar1 + " == " + args[0]);
        System.out.println(appleVar1.length() + "  " + args[0].length());
        System.out.println("appleVar1 == args[0]: " + (appleVar1 == args[0]));
        System.out.println("appleVar1.equals(args[0]): " + (appleVar1.equals(args[0])));
    }
}
