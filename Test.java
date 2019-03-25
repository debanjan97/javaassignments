import java.io.*;
import java.util.*;
public class Test
{
  public static void main(String[] args)throws Exception
  {
    String path = args[0];
    System.out.println(args[0]);
    Map<Character, Integer> char_count = new HashMap<Character, Integer>();
    File file = new File(path);
    BufferedReader br = new BufferedReader(new FileReader(file));
    FileWriter fw = new FileWriter("output.txt");
    String st;
    //fw.write("hi");
    while((st = br.readLine()) != null){
      System.out.println(st);
      for(int i=0; i<st.length(); i++)
      {
        if (char_count.containsKey(st.charAt(i))){
          int val = char_count.get(st.charAt(i));
          val++;
          char_count.put(st.charAt(i), val);
        }
        else{
          char_count.put(st.charAt(i), 0);
        }
      }
    }
    for (Map.Entry<Character, Integer> entry : char_count.entrySet()){
      fw.write(entry.getKey()+" : "+entry.getValue()+"\n");
    }
    fw.close();
  }
}
