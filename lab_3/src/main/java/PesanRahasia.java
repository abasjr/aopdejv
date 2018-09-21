import java.util.Scanner;

public class PesanRahasia {

    /**
     *
     * @param iniPesan merupakan satu baris pesan rahasia
     * @return kalimat X
     */
    public static String constructX(String iniPesan){

    }

    /**
     *
     * @param kalimatX hasil dari constructX
     * @return kalimat Y
     */
    public static String constructY(String kalimatX) {

    }

    /**
     *
     * @param kalimatY hasil dari construct Y
     * @return hasil terjemahan pesan
     */
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
