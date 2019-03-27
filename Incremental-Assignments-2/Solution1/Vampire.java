import java.util.*;
import java.lang.*;
public class Vampire{
	public static boolean checkNumber(int number){
		for(int i=1; i<Math.sqrt(number); i++){
			if(number%i == 0){
				int remainingNumber = number/i;
				String partOne = Integer.toString(i);
				String partTwo = Integer.toString(remainingNumber);
				String actualNumber = Integer.toString(number);
				String derivedNumber = partOne + partTwo;
				char[] actualNumberArray = actualNumber.toCharArray();
				char[] derivedNumberArray = derivedNumber.toCharArray();
				Arrays.sort(actualNumberArray);
				Arrays.sort(derivedNumberArray);
				boolean doesBothtrailsZero = false;
				if (partOne.endsWith("0") && partTwo.endsWith("0")){
					doesBothtrailsZero = true;
				}
				if(Arrays.equals(actualNumberArray, derivedNumberArray) && partOne.length() == partTwo.length() && !doesBothtrailsZero){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int count = 100;
		for(int i=0; count != 0; i++){
			String number;
			number = Integer.toString(i);
			if(number.length() % 2 == 0)
			{
				boolean flag = checkNumber(i);
				if (flag){
					System.out.println(101-count+" => "+i);
					count--;
				}
			}

		}
	}
}
