package IncrementalAssignments2.Solution4;
class TestClass{
	public TestClass(String s){
		System.out.println("Message = "+s);
	}
}
public class Test{
	public static void main(String[] args) {
		TestClass[] arrayObject = new TestClass[10];
		for(int i=0; i<10; i++){
			arrayObject[i] = new TestClass(Integer.toString(i));
		}
	}
}
