package JavaAssignment1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDirectory{
	public static void main(String[] args) throws IOException{
		Process process;
		
		//getting home directory		
		String homeDirectory = System.getProperty("user.home"); 
		
		//ls -l $HOME
		String commandForListingFiles = "ls -l "+homeDirectory; 
		/*
			***Section of Output for "ls -l $HOME"***
	
			drwxr-xr-x  2 zadmin zadmin 4096 May  6 09:14 Documents
			drwxr-xr-x  9 zadmin zadmin 4096 Jun 11 13:13 Downloads
			-rw-r--r--  1 zadmin zadmin 8980 Mar 13 15:59 examples.desktop
			drwxr-xr-x  6 zadmin zadmin 4096 Apr 17 10:57 gs-spring-boot

		*/
		process = Runtime.getRuntime().exec(commandForListingFiles);
		BufferedReader inputStream = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		
		//listOfFiles will contain all the filenames under home
		ArrayList <String> listOfFiles = new ArrayList<String> ();
				
		String s = "";
		
		//Reading every line of the output one by one
		while((s = inputStream.readLine()) != null) {
			String[] tokens = s.split(" ");
			//Checking if it is a file
			/*
				***The output line starts with a "d" if it is a directory***
				drwxr-xr-x  9 zadmin zadmin 4096 Jun 11 13:13 Downloads

				***The output line starts with a "-" if it is a directory***
				-rw-r--r--  1 zadmin zadmin 8980 Mar 13 15:59 examples.desktop

				I have used this method to filter files from all the contents in
				the home directory
			*/
			if(tokens[0].charAt(0) == '-'){
				//Last Word of each line of the Output contains the file name
				//storing the filename in listOfFiles
				listOfFiles.add(tokens[tokens.length - 1]);
			}
		}
		String checkContinue = "", rule;
		do{
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Pattern = ");
			rule = sc.nextLine();
			boolean flag = false;

			//Changing input string into pattern for the pattern matching
			Pattern p = Pattern.compile(rule);
			for(String each: listOfFiles){
				//pitching the pattern against every file present in listOfFile
				Matcher m = p.matcher(each);
				boolean b = m.matches();
				if(b){
					System.out.println("File Found at "+homeDirectory+"/"+each);
					flag = true;
				}
			}
			if(!flag){
				System.out.println("File not found !");
			}
			System.out.println("Want to continue? (Y/N) ");
			checkContinue = sc.nextLine();
		}while(checkContinue.equals("Y") || checkContinue.equals("y"));



	}
}

