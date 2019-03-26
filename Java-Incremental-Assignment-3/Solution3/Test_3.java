interface Interface1{
  public void functionOne();
  public void functionTwo();
}

interface Interface2{
  public void functionThree();
  public void functionFour();
}

interface Interface3{
  public void functionFive();
  public void functionSix();
}

interface Interface4 extends Interface1, Interface2, Interface3{
  public void functionSeven();
}

class Class1{
  public Class1(){
    System.out.println("Class1");
  }
}

class Class2 extends Class1 implements Interface4{
  public void functionOne(){
    System.out.println("Function 1");
  }
  public void functionTwo(){
    System.out.println("Function 2");
  }
  public void functionThree(){
    System.out.println("Function 3");
  }
  public void functionFour(){
    System.out.println("Function 4");
  }
  public void functionFive(){
    System.out.println("Function 5");
  }
  public void functionSix(){
    System.out.println("Function 6");
  }
  public void functionSeven(){
    System.out.println("Function 7");
  }
  public void passInterface1(Interface1 i){
    i.functionOne();
  }
  public void passInterface2(Interface2 i){
    i.functionThree();
  }
  public void passInterface3(Interface3 i){
    i.functionFive();
  }
  public void passInterface4(Interface4 i){
    i.functionSeven();
  }
}
public class Test_3{
  public static void main(String[] args){
    Class2 myObject = new Class2();
    myObject.passInterface1(myObject);
    myObject.passInterface2(myObject);
    myObject.passInterface3(myObject);
    myObject.passInterface4(myObject);
  }
}
