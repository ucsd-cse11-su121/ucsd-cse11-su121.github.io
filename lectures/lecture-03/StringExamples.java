class StringExamples {
    
    String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    String ex1 = this.firstHalf("banana");
    String ex1Exepect = "ban";

    String ex2 = this.firstHalf("hello");
    String ex2Expect = "he";

    String ex3 = this.firstHalf("a");
    String ex3Expect = "";
}
