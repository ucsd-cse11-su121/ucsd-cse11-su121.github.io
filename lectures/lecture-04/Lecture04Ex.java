class Lecture04Ex {

    //Write a method absolute value that takes a number and
    //returns the negation if it's less than 0 or that
    //number otherwise
    int absolute(int number) {
        if (number < 0) {
            return number * -1; //then branch
        }
        else {
            return number;      //else branch
        }
    }

    int abs1 = this.absolute(-2);	//should produce 2
    int abs2 = this.absolute(4);	//should produce 4
}
