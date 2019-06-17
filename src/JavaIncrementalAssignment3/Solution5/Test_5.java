package JavaIncrementalAssignment3.Solution5;

class OuterClass1{
  class InnerClass1{
    public InnerClass1(String s){
      System.out.println(s);
    }
  }
}
class OuterClass2 extends OuterClass1{ //inheriting outer class
  class InnerClass2 extends InnerClass1{ //inheriting inner class
    public InnerClass2(){
      super("Called Super");
    }
  }
}
public class Test_5{
  public static void main(String[] args) {
    OuterClass2 myObject = new OuterClass2();
    OuterClass2.InnerClass2 finalObject = myObject.new InnerClass2();
  }
}
