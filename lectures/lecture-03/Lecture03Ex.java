class Lecture03Ex {
    boolean b1 = 4 < 5;
    boolean b2 = 5 < 4;

    boolean b3 = 4 == 4;	//checks for equality
    boolean b4 = 4 == 5;

    boolean b5 = 5 > 4;
    boolean b6 = 5 >= 4;

    //boolean stringComp = "a" < "b";   //does not work
    boolean stringComp1 = "a" == "a";
    boolean stringComp2 = "a" == "b";

    boolean b7 = 4 != 5;
    boolean b8 = 5 != 5;

    boolean and1 = true && true;
    boolean and2 = true && false;
    boolean and3 = false && true;
    boolean and4 = false && false;

    boolean or1 = true || true;
    boolean or2 = true || false;
    boolean or3 = false || true;
    boolean or4 = false || false;

    boolean numberLine1(int number) {
        return number >= 2;        
    }

    boolean example1 = this.numberLine1(2);
    boolean example2 = this.numberLine1(5);
    boolean example3 = this.numberLine1(-1);

    boolean numberLine2(int number) {
        return ((number > 5) && (number < 7))
                    || (number < 2);
      }
      
      boolean nl2a = this.numberLine2(8);
      boolean nl2b = this.numberLine2(6);
      boolean nl2c = this.numberLine2(1);
      boolean nl2d = this.numberLine2(4);

}
