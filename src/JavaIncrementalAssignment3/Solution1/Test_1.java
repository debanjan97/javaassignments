package JavaIncrementalAssignment3.Solution1;
abstract class Rodent{
  public Rodent(){
    System.out.println("Object of class Rodent is created");
  }
  public void print(String s){
    System.out.println("All "+s+"s "+ "are all Rodents !");
  }
  public abstract void sprint();
  public abstract void sleep();
  public abstract void eat(String s);
  public abstract void cutWire();

}

class Mouse extends Rodent{
  public Mouse(){
    System.out.println("Object of class Mouse is created");
  }
  public void sprint(){
    System.out.println("Mouse is runnning at 15cm/s");
    //trying to call sprint of class Rodent
    //super.sprint();
    //error
  }
  public void sleep(){
    System.out.println("Mouse is sleeping");
  }
  public void eat(String s){
    System.out.println("Mouse is eating "+s);
  }
  public void cutWire(){
    System.out.println("Mouse is eating wires");
  }
}

class Gebril extends Rodent{
  public Gebril(){
    System.out.println("Object of class Gebril is created");
  }
  public void sprint(){
    System.out.println("Gebril is runnning at 20 cm/s");
  }
  public void sleep(){
    System.out.println("Gebril is sleeping");
  }
  public void eat(String s){
    System.out.println("Gebril is eating "+s);
  }
  public void cutWire(){
    System.out.println("Gebril is eating wires");
  }
}

class Hamster extends Rodent{
  public Hamster(){
    System.out.println("Object of class Hamster is created");
  }
  public void sprint(){
    System.out.println("Hamster is runnning at 10cm/s");
  }
  public void sleep(){
    System.out.println("Hamster is sleeping");
  }
  public void eat(String s){
    System.out.println("Hamster is eating "+s);
  }
  public void cutWire(){
    System.out.println("Hamster is eating wires");
  }
}

class Test_1{
  public static void main(String args[]){
    Rodent[] group_of_rodents = new Rodent[3];
    group_of_rodents[0] = new Mouse();
    group_of_rodents[1] = new Gebril();
    group_of_rodents[2] = new Hamster();
    group_of_rodents[0].print("mouse");
    group_of_rodents[1].print("gebril");
    group_of_rodents[2].print("hamster");
    group_of_rodents[0].sprint();

  }
}
