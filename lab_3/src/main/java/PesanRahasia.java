import java.util.Scanner;

public class PesanRahasia {

    public static String constructX(String iniPesan){
        String kalimatX = "";
        for (int i=0; i<iniPesan.length(); i++){
            if (i%2 == 0){
                kalimatX += iniPesan.charAt(i);
            }
        }
        System.out.println(kalimatX);

        return kalimatX;
    }

    public static String constructY(String kalimatX) {
        String kalimatY = "";
        int counterA = 0;
        int pointer = 0;
        while (counterA < 3) {
            if (kalimatX.charAt(pointer) == 'A') {
                counterA++;
            }
            kalimatY += kalimatX.charAt(pointer);
            pointer++;
        }
        System.out.println(kalimatY);
        return kalimatY;
    }

    public static String constructIsiPesanSebenarnya(String kalimatY) {
        String isiPesanSebenarnya="";
        for (int i=0; i<kalimatY.length(); i++){
            if (i%2 == 1){
                isiPesanSebenarnya += kalimatY.charAt(i);
            }
        }

        return isiPesanSebenarnya;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Pesan      : ");
        String pesan = scanner.nextLine();
        System.out.printf("Isi Sebenarnya      : %s\n", constructIsiPesanSebenarnya(constructY(constructX(pesan))));
        scanner.close();
    }
}
