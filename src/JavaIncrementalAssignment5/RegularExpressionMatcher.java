package JavaIncrementalAssignment5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RegularExpressionMatcher{
  public static void main(String[] args) {
    String rule = "^[A-Z].*[.]$";
    String input;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string for evaluation = ");
    input = sc.nextLine();
    Pattern p = Pattern.compile(rule);
    Matcher m = p.matcher(input);
    boolean b = m.matches();
    if (b){
      System.out.println("It matches with the pattern !");
    }
    else{
      System.out.println("It doesn't match with the pattern !");
    }

  }
}
