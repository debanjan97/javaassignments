import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Ping{
	public static ArrayList<String> runSystemCommand(String command, int noOfPackets) {
		
		//returns the ping time for every packet, as an ArrayList<String>
		ArrayList <String>  pingList= new ArrayList<>();
		int count = 0;
  		try {
  			Process p = Runtime.getRuntime().exec(command);
  			BufferedReader inputStream = new BufferedReader(
  					new InputStreamReader(p.getInputStream()));
			/*
					*** Output of "ping google.com -c 5" ***
					PING google.com (172.217.26.238) 56(84) bytes of data.
					64 bytes from bom05s09-in-f14.1e100.net (172.217.26.238): icmp_seq=2 ttl=55 time=210 ms
					64 bytes from bom05s09-in-f14.1e100.net (172.217.26.238): icmp_seq=3 ttl=55 time=233 ms
					64 bytes from bom05s09-in-f14.1e100.net (172.217.26.238): icmp_seq=4 ttl=55 time=256 ms
					64 bytes from bom05s09-in-f14.1e100.net (172.217.26.238): icmp_seq=5 ttl=55 time=279 ms

			*/
  			String s = "";
			//Reading the output line by line
  			while ((s = inputStream.readLine()) != null) {
				//print the actual output of the command
  				System.out.println(s); 
				count++;
				if(count != 1) //ignoring the first line of the command
				{
					//Splitting the line in such a way that we can extract the time
					// token[0] = /* first part of the string delimited due to "time=" */
					// token[1] = 34 /*(the ping)*/
					// token[2] = ms /* last part, delimited due to " " */
					String[] tokens = s.split(" time=| ms");
					pingList.add(tokens[1]);
				}
  			}

  		} catch (Exception e) {
  		}
		return pingList;
  	}

  	public static void main(String[] args) {
		String ipAddress;
		int noOfPackets;
		//args[0] contains the ip address provided as Command Line Argument
		try{
  			ipAddress = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Provide a URL");
			return;
		}
		try{		
			//args[1] contains the no of packets to send to ping the ip address
			noOfPackets = Integer.parseInt(args[1]); 
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Using Default No of Packets");
			noOfPackets = 5;
		}
		String commandToBeExecuted = "ping " + ipAddress + " -c "+Integer.toString(noOfPackets);
		//***example command***		
		//$ ping google.com -c 5
		//ip: google.com
		//no of packets: 5

  		ArrayList<String> pingList = runSystemCommand(commandToBeExecuted, noOfPackets); 
		//Printing the pings
		if(pingList.size() == noOfPackets)
			System.out.println(pingList);
		else {
			System.out.println("Invalid Url or Connection Problem");
			return;
		}

		float result;

		//Calculating Median
		Collections.sort(pingList);
		if(noOfPackets%2 == 0){
			int index_1 = noOfPackets/2 - 1;
			int index_2 = noOfPackets/2;
			result = (Float.parseFloat(pingList.get(index_1)) + Float.parseFloat(pingList.get(index_2)))/2;
		}
		else{
			int index = noOfPackets/2;
			result = Float.parseFloat(pingList.get(index));
		}
		System.out.println("Median is "+result+ " ms");

  	}
}
