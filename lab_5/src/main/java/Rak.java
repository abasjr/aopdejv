import java.util.Scanner;

public class Rak {
  String[] rak;

  public boolean cekBarang(String namaBarang){
    for (int i=0; i < rak.length; i++){
      if (rak[i]!=null && rak[i].equals(namaBarang))
        return true;
    }
    return false;
  }

  public int cariBarang(String namaBarang){
    for (int i=0; i< rak.length; i++){
      if (rak[i]!=null && rak[i].equals(namaBarang))
        return i;
    }
    return -1;
  }

  public boolean simpanBarang(String namaBarang, int nomorRak){
    if (rak[nomorRak]==null){
      rak[nomorRak]=namaBarang;
      return true;
    }
    return false;
  }

  public String ambilBarang(int nomorRak){
    String namaBarang = rak[nomorRak];
    if (rak[nomorRak]==null)
      return "Rak kosong";
    else
      rak[nomorRak]=null;
    return namaBarang;
  }

  public void pindahBarang(String namaBarang, int tempatAwal, int tempatPindah){
    if (rak[tempatPindah]==null){
      rak[tempatPindah]=rak[tempatAwal];
      rak[tempatAwal]=null;
    }
    else{
      String barang=rak[tempatPindah];
      rak[tempatPindah]=rak[tempatAwal];
      rak[tempatAwal]=barang;
    }
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
