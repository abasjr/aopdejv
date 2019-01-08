import java.util.Scanner;

public class PesanRahasia {

    /**
     *
     * @param iniPesan merupakan satu baris pesan rahasia
     * @return kalimat X
     */
    public static String constructX(String iniPesan){
      String kalimatX = "";

      for (int i=0;i < iniPesan.length(); i++){
        if (i % 2 == 0)
          kalimatX += iniPesan.charAt(i);
      }
      return kalimatX;
    }

    /**
     *
     * @param kalimatX hasil dari constructX
     * @return kalimat Y
     */
    public static String constructY(String kalimatX) {
      String kalimatY = "";
      int i = 0;
      int j = 0;
      while (i<4){
        if (kalimatX.charAt(j)=='A'){
          i++;
          if (i==3)
            break;
        }
        j++;
      }
      kalimatY += kalimatX.substring(0,j+1);
      return kalimatY;
    }

    /**
     *
     * @param kalimatY hasil dari construct Y
     * @return hasil terjemahan pesan
     */
    public static String constructIsiPesanSebenarnya(String kalimatY) {
      String result = "";

      for (int l=0; l<kalimatY.length(); l++){
        if (l%2 ==1)
          result += kalimatY.charAt(l);
      }
      return result;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      boolean done = false;
      while (done!=true){
        System.out.print("Masukkan Pesan      : ");
        String pesan = scanner.nextLine();
        if (pesan.equals("EXIT")){
          done = true;
          System.out.println("Anda sudah keluar dari program.");
          scanner.close();
        }
        else
          System.out.printf("Isi Sebenarnya      : %s\n", constructIsiPesanSebenarnya(constructY(constructX(pesan))));
      }
      scanner.close();
    }
}
