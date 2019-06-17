package IncrementalAssignments2.Solution2;
class ClassOne{
	public ClassOne(int arg1){
		System.out.println("Argument 1 = "+arg1);
		new ClassOne(4, 5);
	}
	public ClassOne(int arg1, int arg2){
		int sum = arg1 + arg2;
		System.out.println("Sum of both arguments = "+sum);
	}
}

public class Overload{
	public static void main(String[] args) {
		ClassOne objectOne = new ClassOne(55);
	}
}
