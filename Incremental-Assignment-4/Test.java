import java.lang.*;

class ShampooFinishedException extends Exception {
  public ShampooFinishedException(String message) {
    super(message);
  }
}
class NoHairException extends Exception {
  public NoHairException(String message) {
    super(message);
  }
}
class NoWaterException extends Exception {
  public NoWaterException(String message) {
    super(message);
  }
}

class Bathroom{
  public void useShampoo(boolean shampoo, boolean hair, boolean water) throws ShampooFinishedException, NoHairException, NoWaterException{
    if(!shampoo){
      throw new ShampooFinishedException("Shampoo is Finished !");
    }
    if(!water){
      throw new NoWaterException("There is no Water !");
    }
    if(!hair){
      throw new NoHairException("No Need of Shampoo, use Oil instead !");
    }
    System.out.println("Application of Shampoo is done successfuly !");
    //throw new NullPointerException();
  }
}
public class Test{
  public static void main(String[] args) {
    boolean shampoo, hair, water;
    Bathroom newBath = new Bathroom();
    try{
      shampoo = true;
      hair = false;
      water = true;
      newBath.useShampoo(shampoo, hair, water);
    }
    catch(ShampooFinishedException|NoWaterException|NoHairException|NullPointerException ex){
      System.out.println(ex.getMessage());
    }
    finally{
      System.out.println("Successfuly Checked !");
    }
  }
}
