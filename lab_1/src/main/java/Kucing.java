public class Kucing{
  String nama;
  String ras;
  int umur;

  public Kucing(String nama,String ras,int umur){
    this.nama = nama;
    this.ras = ras;
    this.umur = umur;
  }

  public String berjalan(int jumlahLangkah){
    return "Kucingku, " + nama + " telah berjalan sejauh " + jumlahLangkah + " langkah";
  }

  public String  mengeong(){
    return "Meooooooonnnnnng";
  }

  public int tidur(){
    umur+=1;
    return umur;
  }

  public static void main (String [] args){
    Kucing kucing1 = new Kucing("Miley Sirup","Persia",5);
    Kucing kucing2 = new Kucing("Boyence","Liar",20);
    System.out.println(kucing1.mengeong());
    System.out.println(kucing1.berjalan(8));
    System.out.println("Kucingku umurnya " + kucing1.umur + " abis tidur jadi " + kucing1.tidur());

    System.out.println(kucing2.mengeong());
    System.out.println(kucing2.berjalan(3));
    System.out.println("Kucingku umurnya " + kucing2.umur + " abis tidur jadi " + kucing2.tidur());


  }
}
