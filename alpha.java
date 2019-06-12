class Alpha{
  public static void checkAll(String stringToBeTested){
    // boolean array of size 26, storing if the character appeared or not in the string
    boolean isPresent[] = new boolean[26]; 

    // converting and storing the string in lower case
    // it will not affect the case sensitivity
    // it will make us deal with lower characters only
    // no need of handling uppercase characters seperately
    String lowerCaseString = stringToBeTested.toLowerCase();

    int countOfAlphabetsNotAppeared = 26;
    for(int i=0; i<stringToBeTested.length(); i++){
	
      // mapping the ascii values of alphabets to indexes of boolean array
      int index = lowerCaseString.charAt(i) - 97;
      if(!isPresent[index]){
        isPresent[index] = true;
        countOfAlphabetsNotAppeared--;
      }
    }

    //no alphabet remains
    if(countOfAlphabetsNotAppeared == 0){
      System.out.println("All characters are present !");
    }
    else{
      System.out.println("Not all characters are present !");
    }
    //Time  complexity O(n);
    //Space complexity O(n);
  }

  public static void main(String[] args){
    String stringToBeTested = "abCdEfghijKLMNopQrStuVWXYz";
    checkAll(stringToBeTested);
  }
}
