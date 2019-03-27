package debanjan.assignment.main;
import debanjan.assignment.singleton.*;
import debanjan.assignment.data.*;


public class Test{
	public static void main(String[] args) {
		ClassOne objectOne = new ClassOne();
		objectOne.printData();
		objectOne.printLocalVariable();
		ClassTwo objectTwo = ClassTwo.initString("Hello");
		objectTwo.printData();
	}
}
