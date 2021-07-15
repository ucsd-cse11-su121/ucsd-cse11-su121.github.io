import tester.*;

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
        int result = 1;

        for (int current = 1; current <= n; current = current + 1) {
            result = result * current;
        }

        return result;
    }

    int result1 = factorial(4); //should be 24
    int result2 = factorial(5); //should be 120
    int result3 = factorial(6); //should be 720

    
    //factorial: takes a number n and returns n!
    int factorial2(int n) {
        int result = 1;

        for (int current = n; current > 0; current = current - 1) {
            result = result * current;
        }

        return result;
    }

    int result1fact2 = factorial2(4); //should be 24
    int result2fact2 = factorial2(5); //should be 120
    int result3fact2 = factorial2(6); //should be 720

    //factorial: takes a number n and returns n!
    //recursion - recursive method/function
    //       a method that calls itself
    int factorial3(int n) {
        //Base case - termination case
        if (n <= 1) {
            return 1;
        }

        //Recrusive case
        return n * factorial3(n - 1);        
    }

    int result1fact3 = factorial3(4); //should be 24
    int result2fact3 = factorial3(5); //should be 120
    int result3fact3 = factorial3(6); //should be 720





    //Create and return a times table as a string
    String timesTables(int width, int height) {
        String table = "\n";  //new line

        for (int row = 1; row <= height; row += 1) {
            for (int col = 1; col <= width; col += 1) {
                table = table + "\t" + (col * row);     //\t - escape seuqnce - next tab stop
            }
            table += "\n";  // \n - escape sequence - new line
        }

        return table;
    }

    String tt1 = timesTables(5, 5);
    String tt2 = timesTables(3, 7);



    //max -> returns the largest number in an int array
    int max(int[] nums) {
        //int largest = nums[0];            //use the first number in the arrray
        int largest = Integer.MIN_VALUE;    //smallest possible integer

        for (int n: nums) {
            if (n > largest) {
                largest = n;
            }
        }

        return largest;
    }

    void testMax(Tester t) {
        int[] max1 = { 1, -1, 5, 6 };       //6
        int[] max2 = { 1, 3, 55, 6, 50 };   //55
        t.checkExpect(this.max(max1), 6);
        t.checkExpect(this.max(max2) , 55);
    }

    //sumAllButFirst -> sums all the numbers in an int array except the first number
    int sumAllButFirst(int[] arr) {
        boolean pastFirst = false;
        int total = 0;

        for (int n: arr) {
            if (pastFirst) {
                total += n;
            }
            else {
                pastFirst = true;
            }
        }

        return total;
    }

    void testAllButFirst(Tester t) {
        int[] abf1 = { 1, 9, 100};          //109
        int[] abf2 = { 1 };                 //0
        int[] abf3 = { 1, 2, 3, 4, 5, 6 };  //20
        t.checkExpect(this.sumAllButFirst(abf1), 109);
        t.checkExpect(this.sumAllButFirst(abf2), 0);
        t.checkExpect(this.sumAllButFirst(abf3), 20);
    }

    //sumAllButFirst -> sums all the numbers in an int array except the first number
    int sumAllButFirst2(int[] arr) {
        int total = 0;

        for (int i = 1; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }

    void testAllButFirst2(Tester t) {
        int[] abf1 = { 1, 9, 100};          //109
        int[] abf2 = { 1 };                 //0
        int[] abf3 = { 1, 2, 3, 4, 5, 6 };  //20
        t.checkExpect(this.sumAllButFirst2(abf1), 109);
        t.checkExpect(this.sumAllButFirst2(abf2), 0);
        t.checkExpect(this.sumAllButFirst2(abf3), 20);
    }


}
