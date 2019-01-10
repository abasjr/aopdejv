public class Mudur{

  static int mdr(int number){
    if (number <= 1)
      return 1;
    else
      System.out.println(number);
      return mdr(number-1);
  }

  public static void main(String[] args){
    int result = mdr(5);
    System.out.println(result);
  }
}
