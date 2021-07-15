public class ArrayTest {
    static void updateArray(int[] array) {

        int count = 0;

        //will not update the array
        for (int n: array) {
            n = count;  ///does not update the original array

            count += 1;
        }

        //will update the array
        for (int i=0; i<array.length; i++) {
            array[i] = i;
        }

    }

    public static void main(String[] args) {


        int[] arr = { 0, 0, 0, 0, 0 };
        updateArray(arr);

        for (int n: arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        //   init         test     update
        /*
        for (int num = 0; num < 7; num = num + 1) {
            //loop body
            System.out.println("num is: " + num);
        }
        */
    }
}
