class Point {
    int x;  //unititalzied fields definitions, or fields defs, without values
    int y;  //have default values of 0

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //quadrant takes no parameters, and returns a string
    //of which qudrant the point is in
    String quadrant() {
        if (this.x > 0 && this.y > 0) {
            return "1";
        }
        else if (this.x < 0 && this.y > 0) {
            return "2";
        }
        else if (this.x < 0 && this.y < 0) {
            return "3";
        }
        else if (this.x > 0 && this.y < 0) {
            return "4";
        }
        else {
            //error message?
            //or return something, like on an axis
            return "On axis";
        }
    }
}

class ExamplesLec {

    int examplesOfNum = 4 + 5;

    Point fourFivePoint = new Point(4, 5);
    Point negOneThreePoint = new Point(-1, -3);
    Point fourFivePointAgain = this.fourFivePoint;

    String quadA = this.fourFivePoint.quadrant();       //"1"
    //"1" or "Qudrant 1" or "Quad 1" - whatever we want to print
    String quadB = this.negOneThreePoint.quadrant();    //"3"

    Point onTheLine = new Point(5, 0);
    String quadC = this.onTheLine.quadrant();           //On axis


    //weeklyPay: takes a number of hours worked and an hourly rate, 
    //and returns the pay with overtime (over 40 hours) 
    //counting as double the rate
    int weeklyPay(int hoursWorked, int hourlyRate) { 
        if (hoursWorked > 40) {
            //return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));  //logic erro
            //return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * (hourlyRate));  //works
            return (40 * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));         //works
        }
        else {
            return (hoursWorked * hourlyRate);
        }
    }

    int wp1 = this.weeklyPay(20, 10);   //200
    int wp2 = this.weeklyPay(40, 10);   //400
    int wp3 = this.weeklyPay(50, 10);   //600
    int wp4 = this.weeklyPay(45, 10);   //500
}
