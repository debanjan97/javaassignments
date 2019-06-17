
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Test
{
  public static void main(String[] args)throws Exception
  {
    String path;
    try {
      path = args[0];
    }
    catch (Exception e) {
      System.out.println("No Path Provided in Command Line");
      return;
    }
    Map<Character, Integer> charCount = new HashMap<>();
    File file = new File(path);
    BufferedReader br = new BufferedReader(new FileReader(file));
    FileWriter fw = new FileWriter("output.txt");
    String st; //for parsing
    while((st = br.readLine()) != null){
      for(int i=0; i<st.length(); i++)
      {
        if (charCount.containsKey(st.charAt(i))){
          int tempCount = charCount.get(st.charAt(i));
          tempCount++;
          charCount.put(st.charAt(i), tempCount);
        }
        else{
          //if character found for the first time
          charCount.put(st.charAt(i), 0);
        }
      }
    }
    for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
      fw.write(entry.getKey()+" : "+entry.getValue()+"\n");
    }
    fw.close();
  }
}
