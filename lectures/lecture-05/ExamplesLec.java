class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // Write a method called add that takes another point
    // and returns a new point with the two x coordinates added
    // and the two y coordinates added as its x and y field
    Point add(Point other) {      
      return new Point(this.x + other.x, this.y + other.y);
    }

}

class Line {
    int slope;
    int yIntercept;
    Line(int slope, int yIntercept) {
      this.slope = slope;
      this.yIntercept = yIntercept;
    }

    //Write a method calcY that calculates the y value for a given x
    int calcY(int x) {
      //f(x) = mx + y0
      //return this.slope * x + this.yIntercept;  //same thing - multiplication before addition
      return (this.slope * x) + this.yIntercept;
    }
}

class ExamplesLec {
  //Point
  Point p1 = new Point(8, 16);
  Point p2 = new Point(3, 4);

  Point pointAdd1 = this.p1.add(p2);   //(11, 20)

  Line line1 = new Line(1, 5);
  Line line2 = new Line(3, -5);

  int calcY1 = this.line1.calcY(5);   //10
  int calcY2 = this.line2.calcY(3);   //4
  int calcY3 = this.line1.calcY(-5);  //0

  int n = 15 / 2;
  double m = 15.0 / 2.0;

  double oneThird = 1.0 / 3.0;    //.33333333333
  double twoThirds = 2.0 / 3.0;   //.66666666667 - but it didin't round up

  double addTogether = 0.1 + 0.2 + 0.3;   //0.6
  double anotherOne = (0.1 + 0.2) + 0.3;  //0.6
  double yetAnother = 0.1 + (0.2 + 0.3);  //0.6

  double divided = 15 / 2;
  double dividedAgain = n / 2.0;
  double dividedAgain1 = 1.0*n / 2; //more work for the computer

  //int sqrt1 = Math.sqrt(2); //java compile error - cannot assign double to int
  double sqrt2 = Math.sqrt(2);
  double sqrt2FromDouble = Math.sqrt(2.0);

  double cubeOf12 = Math.pow(12, 3);

  double maxOf45  = Math.max(4, 5);

}
