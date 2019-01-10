public class Kebo{

  static int Fibo(int number){
    if (number <=1)
      return 1;
    else
      return number + Fibo(number-1);
  }
  public static void main(String[] args){
    int hasil = Fibo(5);
    System.out.println(hasil);
    System.out.println(Fibo(6));
  }
}
