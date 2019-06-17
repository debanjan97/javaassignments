package IncrementalAssignment1.assignment.main;


import IncrementalAssignment1.assignment.data.ClassOne;
import IncrementalAssignment1.assignment.singleton.ClassTwo;

public class Test{
	public static void main(String[] args) {
		ClassOne objectOne = new ClassOne();
		objectOne.printData();
		objectOne.printLocalVariable();
		ClassTwo objectTwo = ClassTwo.initString("Hello");
		objectTwo.printData();
	}
}
