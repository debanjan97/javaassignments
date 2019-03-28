import java.io.*;
import java.util.*;

public class Ping{
	public static ArrayList<String> runSystemCommand(String command, int no_of_packets) {
		ArrayList <String>  ping_list= new ArrayList();
		int count = 0;
  		try {
  			Process p = Runtime.getRuntime().exec(command);
  			BufferedReader inputStream = new BufferedReader(
  					new InputStreamReader(p.getInputStream()));

  			String s = "";
  			while ((s = inputStream.readLine()) != null) {
  				System.out.println(s); //print the actual output
				count++;
				if(count != 1)
				{
					String[] tokens = s.split(" time=| ms");
					ping_list.add(tokens[1]);
					//token[0] = "..."
					//token[1] = 34 (the ping)
					//token[2] = ms
				}
  			}

  		} catch (Exception e) {
  		}
		return ping_list;
  	}

  	public static void main(String[] args) {

  		String ip = args[0]; //ip address is passed as command line argument
		int no_of_packets = Integer.parseInt(args[1]); //no of packets
  		ArrayList<String> ping_list = runSystemCommand("ping " + ip + " -c "+args[1], no_of_packets); //$ping google.com -c 5
		Collections.sort(ping_list);
		System.out.println(ping_list);
		float result;
		if(no_of_packets%2 == 0){
			int index_1 = no_of_packets/2 - 1;
			int index_2 = no_of_packets/2;
			result = (Float.parseFloat(ping_list.get(index_1)) + Float.parseFloat(ping_list.get(index_2)))/2;
		}
		else{
			int index = no_of_packets/2;
			result = Float.parseFloat(ping_list.get(index));
		}
		System.out.println("Median is "+result+ " ms");

  	}
}
