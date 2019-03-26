class OuterClass1{
  class InnerClass1{
    public InnerClass1(String s){
      System.out.println(s);
    }
  }
}
class OuterClass2{
  class InnerClass2 extends OuterClass1.InnerClass1{
    public InnerClass2(){
      new OuterClass1.super("Called Super");
    }
  }
}
public class Test_5{
  public static void main(String[] args) {
    OuterClass2 myObject = new OuterClass2();
    OuterClass2.InnerClass2 finalObject = myObject.new InnerClass2();
  }
}
