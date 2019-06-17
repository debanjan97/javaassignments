package JavaIncrementalAssignment3.Solution4;

interface Cycle{
  public void balance();
}
class Unicycle implements Cycle{
  public void balance(){
    System.out.println("Hard");
  }
}
class Bicycle implements Cycle{
  public void balance(){
    System.out.println("Medium");
  }
}
class Tricycle implements Cycle{
  public void balance(){
    System.out.println("Easy");
  }
}
class UnicycleFactory{
  public Unicycle deployUnit(){
    return new Unicycle();
  }
}
class BicycleFactory{
  public Bicycle deployUnit(){
    return new Bicycle();
  }
}
class TricycleFactory{
  public Tricycle deployUnit(){
    return new Tricycle();
  }
}

public class Test_4{
  public static void main(String[] args) {
    UnicycleFactory factoryOne = new UnicycleFactory();
    Unicycle cycle1 = factoryOne.deployUnit();
    cycle1.balance();
  }
}
