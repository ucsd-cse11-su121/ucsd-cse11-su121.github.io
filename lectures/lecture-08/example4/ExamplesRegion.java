import tester.*;

class Point {
  int x;
  int y;
  Point(int x, int y) {
    //super();
    this.x = x;
    this.y = y;
  }
  boolean belowLeftOf(Point other) {
    return this.x <= other.x && this.y <= other.y;
  }
  boolean aboveRightOf(Point other) {
    return this.x >= other.x && this.y >= other.y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

interface Region { // Added an interface declaration with the shared method
  boolean contains(Point p);
  Region add(Region other);         //union
  Region overlap(Region other);     //intersection
}

abstract class ARegion implements Region {
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }

  public Region overlap(Region other) {
    return new IntersectRegion(this, other);
  }
}

class RectRegion extends ARegion { // Declared "implements Region" (the interface)
  Point lowerLeft;
  Point upperRight;
  RectRegion(Point lowerLeft, Point upperRight) {
    //super();
    this.lowerLeft = lowerLeft;
    this.upperRight = upperRight;
  }
  public boolean contains(Point p) {
    return this.lowerLeft.belowLeftOf(p) && this.upperRight.aboveRightOf(p);
  }
}

class CircRegion extends ARegion {
  Point center;
  int radius;
  CircRegion(Point center, int radius) {
    //super();
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point p) {
    return this.center.distance(p) < this.radius;    
  }
}

class UnionRegion extends ARegion {
  Region r1;
  Region r2;
  UnionRegion(Region r1, Region r2) {
    //super();
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) || this.r2.contains(p);
  }
}

class IntersectRegion extends ARegion {
  Region r1;
  Region r2;
  IntersectRegion(Region r1, Region r2) {
    //super();
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) && this.r2.contains(p);
  }
}

class SquareRegion extends ARegion {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    //super();
    this.center = center;
    this.sideLength = sideLength;
  }
  public boolean contains(Point p) {
    int xDiff = Math.abs(p.x - this.center.x);
    int yDiff = Math.abs(p.y - this.center.y);
    boolean xInside = (xDiff < (this.sideLength / 2));
    boolean yInside = (yDiff < (this.sideLength / 2));
    return xInside && yInside;
  }
}

class CircleRegion extends ARegion {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    //super();
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}

class ExamplesRegion {
  Region circ1 = new CircleRegion(new Point(10, 5), 4.0);
  Region sq = new SquareRegion(new Point(10, 1), 8.);
  Region ur = this.circ1.add(this.sq);

  // To _find_ add method for this.circ1.add:
  //    - First look in CircleRegion
  //    - Not found! So look in ARegion, because CircleRegion extends it

  //Region ir = new IntersectRegion(this.circ1, this.sq);
  Region ir = this.circ1.overlap(this.sq);

  Region circA = new CircleRegion(new Point(6,  5), 3);
  Region circB = new CircleRegion(new Point(12, 5), 3);
  Region circC = new CircleRegion(new Point(18, 5), 3);

  //Region all3Circles = 
  //  new UnionRegion(this.circA, new UnionRegion(this.circB, this.circC));

  // Region all6Circles = 
  //   new UnionRegion(this.circA, 
  //         new UnionRegion(this.circB, 
  //           new UnionRegion(this.circC, 
  //             new UnionRegion(this.circD, 
  //               new UnionRegion(this.circE, this.circF)))));

  Region all3Circles2 = this.circA.add(this.circB).add(this.circC);  

  boolean testAll3CirclesA = this.all3Circles2.contains(new Point(4, 5));
  boolean testAll3CirclesB = this.all3Circles2.contains(new Point(10, 5));
  boolean testAll3CirclesC = this.all3Circles2.contains(new Point(20, 5));


}
