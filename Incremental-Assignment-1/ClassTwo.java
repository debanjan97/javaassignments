package debanjan.assignment.singleton;

public class ClassTwo{
	String varString;
	static String staticString; //a static member for a static method to initialize
	static public ClassTwo initString(String s){
		/*
		varString = s;
		*/
		// Cant access non-static variable inside a static method
		staticString = s;
		return new ClassTwo();
	}
	public void printData(){
		//System.out.println(varString);
		//Can't print which is not initialised
		System.out.println(staticString);
	}


}
