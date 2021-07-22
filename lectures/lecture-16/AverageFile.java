import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class AverageFile {
    // Read in doubles from the path given as the first argument, and
    // print out the mean of those numbers. Assume the file has one number per
    // line.
  
    // What if the file had the numbers separated by spaces rather than by lines?
    public static void main(String[] args) throws IOException {

      printAverageByLines(args[0]);
      printAverageForOneLine(args[1]);

    } 

    static void printAverageByLines(String path) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(path));

      double total = 0;

      for (String s: lines) {
        total += Double.parseDouble(s);
      }

      System.out.println("Average: " + total / lines.size());
    }

    static void printAverageForOneLine(String path) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(path));

      String[] numbers = lines.get(0).split(" ");

      double total = 0;

      //int i=0;
      for (String s: numbers) {
        total += Double.parseDouble(s);
        //System.out.println(i + " " + Double.parseDouble(s));    //debug statements
        //i += 1;
      }

      System.out.println("Average: " + total / numbers.length);
    }

  }