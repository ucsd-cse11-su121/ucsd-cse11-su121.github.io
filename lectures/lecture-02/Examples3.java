class Examples3 {
    int numberOfStaff = 14;       //int value, integer literal
    //String name = "Greg Miranda"; //String value, string literal

    //String className = 11;      //type mismatch
    //String className = "11";
    //int klassName = 11;

    //String name = "Greg" + "Miranda";
    String firstName = "Greg";
    String lastName = "Miranda";
    String space = " ";             //single space

    // + concatentats or appends strings
    String fullName = this.firstName + this.space + this.lastName;

    String str = this.firstName + 2;    //Greg2?
    String str1 = this.firstName + "2"; //Greg2

    String className = "11" + 200;
    //int klassName = 11 + "200";   //type mismatch
    String klassName = 11 + "200";

    String value = 1 + 2 + 3 + "" + 4 + 5 + 6;
    //String value = (1 + 2 + 3) + "" + 4 + 5 + 6;
    //615
    //6456 - correct
    //123456

    String eleven = 11 + "";    //hack - quickly convert integer to a string
    //String val = 1 + 2 + 3;   //type mismatch
}
