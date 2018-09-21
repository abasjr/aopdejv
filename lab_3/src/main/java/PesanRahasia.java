import java.util.Scanner;

public class PesanRahasia {

    public static String constructX(String iniPesan){

    }

    public static String constructY(String kalimatX) {

    }

    public static String constructIsiPesanSebenarnya(String kalimatY) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Pesan      : ");
        String pesan = scanner.nextLine();
        System.out.printf("Isi Sebenarnya      : %s\n", constructIsiPesanSebenarnya(constructY(constructX(pesan))));
        scanner.close();
    }
}
