package IncrementalAssignment1.assignment.data;
public class ClassOne{
	int IntVariable;
	char CharVariable;
	public void printData(){
		System.out.println("IntVariable = "+IntVariable+" CharVariable = "+CharVariable);
	}
	public void printLocalVariable(){
		int localVar1, localVar2;
		//System.out.println("Var1 = "+localVar1+" Var2 = "+localVar2);
		//localVar1 and localVar2 are not initialised
		//Not possible to print
	}
}
