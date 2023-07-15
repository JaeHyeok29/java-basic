// Literals.java
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
public class Literals {
  public static void main(String[] args) {
    int hexRepresentation = 0x1a;
    long bytes = 0b11010010_01101001_10010100_10010010;
    long maxLong = 0x7fff_ffff_ffff_ffffL;
    long phoneNumber = 010_1987_1994L;
    final float PI = 3.14_15F;
    double doublePrecision = 1.234e2;
    String spanishWord = "S\u00ED Se\u00F1or";
    final char BACKSPACE = '\b', TAB = '\t';
    final char FORM_FEED = '\f', CARRAGE_RETURN = '\r', LINE_FEED = '\n';
    final char SINGLE_QUOTE = '\'', BACK_SLASH = '\\';

    System.out.printf("The max of long integer > phone number = %b\n", maxLong > phoneNumber);
    System.out.printf("%c%c%c", 'a', BACKSPACE, 'c');
    System.out.printf("%c%c%c%c", 'a', LINE_FEED, 'c', LINE_FEED);
  }
}
