import tester.*;
class Point {
  double x, y;
  Point(double x, double y) { this.x = x; this.y = y; }
  double distance(Point other) {
    return Math.sqrt(
      Math.pow(this.x - other.x, 2) + 
      Math.pow(this.y - other.y, 2));
  }
  double xDistance(Point other) { return Math.abs(other.x - this.x); }
  double yDistance(Point other) { return Math.abs(other.y - this.y); }
}

interface Region {
  boolean contains(Point p);
  Region add(Region other);
  Region overlap(Region other);
}

abstract class ARegion implements Region {
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
  public Region overlap(Region other) {
    return new IntersectRegion(this, other);
  }
}

abstract class AComboRegion extends ARegion {
  Region r1;
  Region r2;
  AComboRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
}

class UnionRegion extends AComboRegion {
  UnionRegion(Region r1, Region r2) {
    super(r1, r2);
  }
  public boolean contains(Point toCheck) {
    return this.r1.contains(toCheck) || 
           this.r2.contains(toCheck);
  }
}

class IntersectRegion extends AComboRegion {
  IntersectRegion(Region r1, Region r2) {
    super(r1, r2);
  }
  public boolean contains(Point toCheck) {
    return this.r1.contains(toCheck) && 
           this.r2.contains(toCheck);
  }
}

class SubtractRegion extends AComboRegion {
  SubtractRegion(Region r1, Region r2) {
    super(r1, r2);
  }
  public boolean contains(Point toCheck) {
    return this.r1.contains(toCheck) && 
           !this.r2.contains(toCheck);
  }
}

class SquareRegion extends ARegion {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    this.center = center;
    this.sideLength = sideLength;
  }
  public boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength / 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
  }
}

class CircleRegion extends ARegion {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}

class ExamplesARegion {

}
