package JavaIncrementalAssignment3.Solution2;
class Cycle{
  public void showDirection(String s){
    System.out.println(s);
  }
  public void showMaxSpeed(){
    System.out.println("30kmph");
  }
}

class Unicycle extends Cycle{
  public void balance(){
    System.out.println("True");
  }
}

class Bicycle extends Cycle{
  public void balance(){
    System.out.println("True");
  }
}

class Tricycle extends Cycle{
  public Tricycle(){
    System.out.println("I am Tricycle, I need no balance");
  }
}

class Test_2{
  public static void main(String[] args){
    Unicycle ob_u = new Unicycle();
    Bicycle ob_b = new Bicycle();
    Tricycle ob_t = new Tricycle();
    Cycle[] ob_c = new Cycle[3];
    ob_c[0] = (Cycle) ob_b;
    ob_c[1] = (Cycle) ob_t;
    ob_c[2] = (Cycle) ob_u;
    for(int i=0; i<3; i++){
      //ob_c[i].balance();
      //it is searching for balance in cycle class which is not present
      //error
    }
    ob_b = (Bicycle)ob_c[0];
    ob_t = (Tricycle)ob_c[1];
    ob_u = (Unicycle)ob_c[2];
    ob_b.balance();
    //ob_t.balance();
    //Tricycle doesnt have balance
    //so error
    ob_u.balance();
  }
}
