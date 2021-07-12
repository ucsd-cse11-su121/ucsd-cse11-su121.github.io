import tester.*;

class ArrayExamples {
    int[] nums = { 4, 2, 7 };
    int[] nums2 = nums;

    int firstNumber = this.nums[0];
    int secondNumber = this.nums[1];
    int thirdNumber = this.nums[2];
    //int fourthNumber = this.nums[3];

    String[] strs = { "a", "b", "z", "y" };
    //String[] nAndS = { 2, "b", "z" };

    int countStrs = this.strs.length;
    int countNums = this.nums.length;

    //Returns true if the array has no elements,
    //false otherwise
    boolean isEmpty(int[] arr) {
        // if (arr.length > 0) { 
        //     return false; 
        // }
        // else { 
        //     return true; 
        // }

        return arr.length == 0;
    }

    //Testing a method using a field - because we are assigning 
    //the method's return value to a field
    //requires a visual confirmation of the value
    boolean isNumsEmpty = this.isEmpty(nums);

    int[] emptyNums = { };

    //Testing using a Tester method
    //compare actual values vs expected values
    boolean testEmpty(Tester t) {
        return t.checkExpect(this.isEmpty(nums), false) &&
               t.checkExpect(this.isEmpty(emptyNums), true);
    }
}
