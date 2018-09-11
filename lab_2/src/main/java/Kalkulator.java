import java.util.Scanner;

public class Kalkulator {
    public static int hitung(int a, String operasi, int b){
        int hasil = 0;

        if(operasi.equals("+")){
            hasil = a + b;
        }

        if(operasi.equals("-")){
            hasil = a - b;
        }

        if(operasi.equals("*")){
            hasil = a * b;
        }

        if(operasi.equals("^")){
            hasil = (int) Math.pow(a,b);
        }

        if(operasi.equals("%")){
            hasil = a % b;
        }

        if(operasi.equals("/")){
            hasil = a / b;
        }

        if(operasi.equals("v")){
            if(b == 2){
                hasil = (int) Math.sqrt(a);
            }
            if(b == 3){
                hasil = (int) Math.cbrt(a);
            }
        }

        return hasil;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan bilangan pertama : ");
        int a = in.nextInt();
        System.out.print("Masukkan bilangan kedua : ");
        int b = in.nextInt();
        System.out.print("Masukkan simbol operasi : ");
        String op = in.next();

        System.out.println(hitungInt(a,op,b));
    }
}
