//import tester.*;

class LoopsExamples2 {
    public static void main(String[] args) {

        //   init         test     update
        for (int num = 0; num < 7; num = num + 1) {
            //loop body
            System.out.println("num is: " + num);
        }
    }


    //factorial: takes a number n and returns n!
    int factorial(int n) {
        int result = 0;

        for (int current = 0; current < n; current = current + 1) {
            result = result * current;
        }

        return result;
    }

    int result1 = factorial(4); //should be 24
    int result2 = factorial(5); //should be 120
}
