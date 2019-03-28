import java.io.*;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDirectory{
	public static void main(String[] args) throws IOException{
		Process process;
		String homeDirectory = System.getProperty("user.home"); //getting home directory
		System.out.println(homeDirectory);

		String commandForListingFiles = "ls -l "+homeDirectory; //ls -l $HOME
		process = Runtime.getRuntime().exec(commandForListingFiles);
		BufferedReader inputStream = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		ArrayList <String> listOfFiles = new ArrayList<String> ();
		String s = "";
		while((s = inputStream.readLine()) != null) {
			String[] tokens = s.split(" ");
			if(tokens[tokens.length - 1].contains(".")){
				//Checking if it is a file
				//file contains extension
				listOfFiles.add(tokens[tokens.length - 1]);
				//creating a list of files under home
			}
		}
		//System.out.println(listOfFiles);
		String checkContinue = "", rule;
		do{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Pattern = ");
			rule = sc.nextLine();
			boolean flag = false;
			Pattern p = Pattern.compile(rule);
			for(String each: listOfFiles){
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
