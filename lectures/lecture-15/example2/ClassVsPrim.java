class Pair<TypeOfA, TypeOfB> {
    TypeOfA a;
    TypeOfB b;
    Pair(TypeOfA a, TypeOfB b) {
        this.a = a;
        this.b = b;
    }
}

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class ClassVsPrim {

  //Pair<int, int> p = new Pair<>(56, 55);

  //Integer i = new Integer(45);  //old way, don't use 
  // This mens the same thing as above
  Integer i = 45;                 //use this

  Integer i2 = i + 3;

  int n = i2;
  int n2 = i2.intValue();

  Pair<Integer, Boolean> p = new Pair<>(45, true);
}
