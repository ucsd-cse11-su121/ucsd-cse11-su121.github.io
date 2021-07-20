import tester.*;

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class TextTweet {
  String author, content;
  TextTweet(String author, String content) {
    this.author = author;
    this.content = content;
  }
}

interface Checker<T> {
  boolean check(T t);
}

class CloseTo0 implements Checker<Point> {
  public boolean check(Point pt) {
    return pt.distance(new Point(0,0)) < 5;
  }
}

class InQuad1 implements Checker<Point> {
  public boolean check(Point pt) {
    return pt.x > 0 && pt.y > 0;
  }
}

class LongTweet implements Checker<TextTweet> {
  public boolean check(TextTweet tt) {
    return tt.content.length() > 20;
  }
}

class StartsWithWelcome implements Checker<TextTweet> {
  public boolean check(TextTweet tt) {
    return tt.content.indexOf("#welcome") == 0;
  }
}


class GenericsExamples {

  <T> int count(T[] ts, Checker<T> c) {
    int count = 0;

    for (T t: ts) {
      if (c.check(t)) {
        count += 1;
      }
    }

    return count;  
  }
  
  int countStartsWithWelcome(TextTweet[] tts) {
    return count(tts, new StartsWithWelcome());
  }

  int countLongTweets(TextTweet[] tts) {
    return count(tts, new LongTweet());
  }

  //Loooks for points near 0.0, within distance of 5
  int countNear0(Point[] pts) {    
    return count(pts, new CloseTo0());
  }

  int countInQudrant1(Point[] pts) {
    return count(pts, new InQuad1());
  }

  TextTweet t1 = new TextTweet("gregmiranda", "#welcome to CSE11, incoming students!");
  TextTweet t2 = new TextTweet("jacobsschool", "#welcome to #engineering at #ucsd ");
  TextTweet t3 = new TextTweet("ucsd", "#welcome to UCSD!");
  TextTweet t4 = new TextTweet("warrencollegeucsd", "You're going to love #ucsd new students!");

  TextTweet[] tts = { t1, t2, t3, t4 };

  Point[] pts = { new Point(10, 10), new Point(1, 1), new Point(2, 3) };
  Point[] pts2 = { new Point(-1, 10), new Point(1, -1), new Point(2, 3) };

  int startsWithWelcome = this.countStartsWithWelcome(tts); //3
  int longTweets = this.countLongTweets(tts); //3

  int result = this.countNear0(pts);    //2
  int result2 = this.countInQudrant1(pts2); //1

}
