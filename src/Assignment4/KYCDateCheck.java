package Assignment4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Scanner;




public class KYCDateCheck{
	public static void main(String[] args) throws ParseException, IOException {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		while(noOfTestCases != 0){
			String input, token[];
			input = br.readLine();
			token = input.split(" ");
			SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
			parser.setLenient(false);

			Calendar signUpDate = Calendar.getInstance();
			Calendar currentDate = Calendar.getInstance();

			signUpDate.setTime(parser.parse(token[0]));
			currentDate.setTime(parser.parse(token[1]));

			if(signUpDate.compareTo(currentDate) > 0 ){
				System.out.println("No Range");
			}
			else{
				Calendar lowerDate = Calendar.getInstance();
				Calendar upperDate = Calendar.getInstance();
				lowerDate.setTime(signUpDate.getTime());
				upperDate.setTime(signUpDate.getTime());
				int currentYear = currentDate.get(Calendar.YEAR);
				System.out.println(currentYear);
				lowerDate.set(Calendar.YEAR, currentYear);
				upperDate.set(Calendar.YEAR, currentYear);
				lowerDate.add(Calendar.DATE, -30);
				System.out.println(parser.format(lowerDate.getTime()));
				upperDate.add(Calendar.DATE, 30);
				System.out.println(parser.format(upperDate.getTime()));
				if(currentDate.compareTo(upperDate) < 0 ){
					upperDate.setTime(currentDate.getTime());
				}
				System.out.println(parser.format(lowerDate.getTime()) + " "+ parser.format(upperDate.getTime()));
			}
			noOfTestCases--;

		}

	}
}
