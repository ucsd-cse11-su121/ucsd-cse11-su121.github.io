class MainExample {

    int x = 5;

    static int sum(int n, int m) {
        //int y = this.x;   //compiler error - cannose use this in a static method
        return n + m;
    }

    public static void main(String[] args) {

        String s1 = args[0];
        System.out.println(s1);

        String s2 = args[2];
        System.out.println(s2);






        //System.out.println("Hello");
        //System.out.println("CSE 11!");

        //System.out.println(MainExample.sum(6, 7));
    }

}
