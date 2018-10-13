import java.util.Scanner;

/**
 * Template untuk lab 5, Anda diperbolehkan mengubah template sesuka hati Anda.
 */
public class Rak {
    String[] rak;

    public boolean cekBarang(String namaBarang){

    }

    public int cariBarang(String namaBarang){

    }

    public boolean simpanBarang(String namaBarang, int nomorRak){

    }

    public String ambilBarang(int nomorRak){

    }

    public void pindahBarang(String namaBarang, int tempatAwal, int tempatPindah){

    }

    public static void main(String []args){
        Rak iniRak = new Rak();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while(!exit){
            String[] input = scanner.nextLine().split(" ");
            String namaBarang;
            int letak;
            switch(input[0]){
                case "INISIASI_RAK":
                    int n = Integer.parseInt(input[1]);
                    iniRak.rak = new String[n];
                    break;
                case "CEK_BARANG":
                    namaBarang = input[1];
                    if (iniRak.cekBarang(namaBarang)){
                        System.out.println("Barang tersedia");
                    } else{
                        System.out.println("Barang tidak tersedia");
                    }
                    break;
                case "CARI_BARANG":
                    namaBarang = input[1];
                    letak = iniRak.cariBarang(namaBarang);
                    if (letak == -1) System.out.println("Barang tidak ditemukan");
                    else System.out.printf("Barang terletak pada %s\n", letak);
                    break;
                case "SIMPAN_BARANG":
                    namaBarang = input[1];
                    letak = Integer.parseInt(input[2]);
                    if (iniRak.simpanBarang(namaBarang, letak))
                        System.out.printf("%s berhasil disimpan di %s\n", namaBarang, letak);
                    else System.out.printf("Gagal menyimpan %s\n", namaBarang);
                    break;
                case "AMBIL_BARANG":
                    letak = Integer.parseInt(input[1]);
                    namaBarang = iniRak.ambilBarang(letak);
                    if (namaBarang.equals("Rak kosong")) System.out.println(namaBarang);
                    else System.out.printf("Berhasil mengambil %s\n", namaBarang);
                    break;
                case "PINDAH_BARANG":
                    namaBarang = input[1];
                    int tempatAwal = Integer.parseInt(input[2]);
                    int tempatAkhir = Integer.parseInt(input[3]);
                    iniRak.pindahBarang(namaBarang, tempatAwal, tempatAkhir);
                    System.out.printf("Pemindahan Berhasil, rak nomor %s berisi %s dan rak nomor %s berisi %s\n", tempatAkhir, namaBarang, tempatAwal, iniRak.rak[tempatAwal] );
                    break;
                case "EXIT":
                    exit = true;
                    break;
            }
        }
    }
}
