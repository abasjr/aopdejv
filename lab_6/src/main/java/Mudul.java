public class Mudul{

  static int factorial(int number){
    if (number <= 1)
      return 1;
    else
      return number * factorial(number -1);
  }
  public static void main(String [] args){
    int hasil = factorial(5);
    System.out.println(hasil);
  }
}
