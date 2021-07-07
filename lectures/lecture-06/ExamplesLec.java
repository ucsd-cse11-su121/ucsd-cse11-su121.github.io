import tester.*;

class ExamplesLec {

    //Compute average of two numbers
    double average(double n1, double n2) {

        double sum = n1 + n2;   //sum is a local variable
        return sum / 2.0;

        //return (n1 + n2) / 2.0;
    }

    boolean testAverage(Tester t) {
        ExamplesLec ex = new ExamplesLec(); //ex is a local variable 
            //(a reference to a new ExamplesLec object)

        //return t.checkExpect(this.average(1, 2), 1.5);
        return t.checkExpect(ex.average(1, 2), 1.5) && 
               t.checkExpect(ex.average(5, 8), 6.5);
    }


    //weeklyPay: takes a number of hours worked and an hourly rate, 
    //and returns the pay with overtime (over 40 hours) 
    //counting as double the rate
    int weeklyPay(int hoursWorked, int hourlyRate) { 
/* old version
        if (hoursWorked > 40) {
            //return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));  //logic erro
            //return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * (hourlyRate));  //works
            return (40 * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));         //works
        }
        else {
            return (hoursWorked * hourlyRate);
        }
*/
        int pay = hoursWorked * hourlyRate; //pay is a local variable

        if (hoursWorked > 40) {
            pay += ((hoursWorked - 40) * (hourlyRate));
        }

        return pay;
    }

    boolean testWeeklyPay(Tester t) {
        return 
            t.checkExpect(this.weeklyPay(20, 10), 200) && 
            t.checkExpect(this.weeklyPay(40, 10), 400) && 
            t.checkExpect(this.weeklyPay(50, 10), 600) && 
            t.checkExpect(this.weeklyPay(45, 10), 500);
    }

    int wp1 = this.weeklyPay(20, 10);   //200
    int wp2 = this.weeklyPay(40, 10);   //400
    int wp3 = this.weeklyPay(50, 10);   //600
    int wp4 = this.weeklyPay(45, 10);   //500

}
