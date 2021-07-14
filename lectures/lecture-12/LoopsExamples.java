import tester.*;

class LoopsExamples {

    //Returns the sum of the lengths of the strings instrs
    //for ANY length array that is given to us
    int sumOfLengths(String[] strs) {

        //We need a way to do the sum for all the elements, no matter how many there are
        int sum = 0;

        for (String s: strs) {
            sum = sum + s.length();
        }

        return sum;

        // if (strs.length == 3) {
        //     return strs[0].length() + strs[1].length() + strs[2].length();
        // }
        // else {
        //     return strs[0].length() + strs[1].length() + strs[2].length() + strs[3].length();
        // }
    }

    String[] fruit = { "apple", "banana", "cucumber" };     //19
    String[] letters = { "b", "e", "a", "r" };              //4

    boolean testSumOfLengths(Tester t) {
        return t.checkExpect(this.sumOfLengths(fruit), 19) &&
               t.checkExpect(this.sumOfLengths(letters), 4);
    }

    //Write a method that takes an array of int and returns 
    //the product (multiplication) of those numbers
    int product(int[] nums) {
        int total = 1;

        for (int n: nums) {
            total = total * n;
        }

        return total;
    }

    int[] nums1 = { 2, 4, 6 };          //48
    int[] nums2 = { 5, 3, 1, 2, 1 };    //30

    boolean testProduct(Tester t) {
        return t.checkExpect(this.product(nums1), 48) &&
               t.checkExpect(this.product(nums2), 30);
    }

    //average: take an array of double and return a double
    //representing the average (mean)
    double average(double[] doubles) {
        double total = 0.0;
        //int count = 0;

        if (doubles.length == 0) {
            return 0.0;
        }

        for (double d: doubles) {
            total = total + d;
            //count = count + 1;
        }

        //return total / count;
        return total / doubles.length;
    }

    double[] ds1 = { 2.0, 4.0, 1.0 };       //  7 / 3
    double[] ds2 = { 5.0, 1.0, 3.0, 6.0 };  // 15 / 4
    double[] ds3 = { };                     //  0 / 0

    boolean testAverage(Tester t) {
        return t.checkExpect(this.average(ds1), 7.0 / 3.0) &&
               t.checkExpect(this.average(ds2), 15.0 / 4.0) &&
               t.checkExpect(this.average(ds3), 0.0);
    }

    //write sumEvens - try writing sumEvens, which takes an array of ints and
    //returns the sum of just the even ones
    //{ 1,  2, 7, 4 }    -> 6
    //{ 4,  2, 4, 5 }    -> 10
    //{ 0, -2, 7, 4, 8 } -> 10
    int sumEvens(int[] array) {
        int sum = 0;

        for (int i: array) {
            if (i % 2 == 0) {
                //System.out.println("i: " + i + ", sum: " + sum);  //debug statements
                sum += i;               //sum = sum + i;
            }
        }

        return sum;
    }

    int[] array1 = { 1, 2, 7, 4 };      //  6
    int[] array2 = { 4, 2, 4, 5 };      //  10
    int[] array3 = { 0, -2, 7, 4, 8 };  //  10
    int[] array4 = { 1, 2, 4, 5 };      //  6
    int[] array5 = { 1, 2, 4, 5, 100 }; //  106    //105

    boolean testSumEvens(Tester t) {
        System.out.println("sumEvens: array1: " + this.sumEvens(array1));
        System.out.println("sumEvens: array2: " + this.sumEvens(array2));
        System.out.println("sumEvens: array3: " + this.sumEvens(array3));

        return t.checkExpect(this.sumEvens(array1), 6) &&
               t.checkExpect(this.sumEvens(array2), 10) &&
               t.checkExpect(this.sumEvens(array3), 10) &&
               t.checkExpect(this.sumEvens(array4), 6);
    }

    //sumEveryOther - which adds up the elements at the even indices
    //in an array of int and return the result
    int sumEveryOther(int[] nums) {
        int total = 0;

        for (int index = 0; index < nums.length; index += 2) {
            total += nums[index];
        }

        return total;
    }

    void testEveryOther(Tester t) {
        t.checkExpect(this.sumEveryOther(array1), 8);
        t.checkExpect(this.sumEveryOther(array2), 8);
        t.checkExpect(this.sumEveryOther(array3), 15);
        t.checkExpect(this.sumEveryOther(array4), 5);
        t.checkExpect(this.sumEveryOther(array5), 105);
    }
}
