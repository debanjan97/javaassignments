import java.util.*;
import java.io.*;

class Alpha{
  public static void checkAll(String s){
    boolean flag[] = new boolean[26]; //Automatically initialized to False
    String lower_s = s.toLowerCase();
    int count = 26;
    for(int i=0; i<s.length(); i++){
      int index = lower_s.charAt(i) - 97;
      if(!flag[index]){
        flag[index] = true;
        count--;
      }
    }
    if(count == 0){
      System.out.println("All characters are present !");
    }
    else{
      System.out.println("Not all characters are present !");
    }
    //Time complexity O(n)
    //Space Complexity O(n);
  }

  public static void main(String[] args){
    String s = "abCdEfghijKLMNopQrStuVWXY";
    checkAll(s);
  }
}
