import java.util.Scanner;
import java.lang.Math;

public class Calculator{

  public static int hitung(int angka1, String operator, int angka2){
    int hasil = 0;

    switch (operator){
      case "+":
        hasil = angka1 + angka2;
        break;
      case "-":
        hasil = angka1 - angka2;
        break;
      case "*":
        hasil = angka1 * angka2;
        break;
      case "/":
        hasil = angka1 / angka2;
        break;
      case "%":
        hasil = angka1 % angka2;
        break;
      case "^":
        hasil = (int) Math.pow(angka1, angka2);
        break;
      case "v":
        if (angka2 == 2)
          hasil = (int) Math.sqrt(angka1);
        else if (angka2 ==3)
          hasil = (int) Math.cbrt(angka1);
        else
          System.out.println("Invalid number");
        break;
      default:
        System.out.println("Invalid operator");
    }
    return hasil;
  }

  public static void main (String []args){
    Scanner input = new Scanner(System.in);

    System.out.println("KALKULATOR");
    System.out.println("==========");

    System.out.print("Masukan Input: ");
    String a= input.next();
    int angka1 = Integer.parseInt(a);
    String operator = input.next();
    String b = input.next();
    int angka2 = Integer.parseInt(b);

    System.out.println();
    System.out.println("Hasil perhitungan: " + Calculator.hitung(angka1,operator,angka2));
  }


}
