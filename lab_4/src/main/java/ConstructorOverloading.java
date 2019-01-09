class Buku{
  private String penulis;
  private String judul;
  private int isbn;

  public Buku(String penulis, String judul){   // constructor
    this.penulis = penulis;
    this.judul = judul;
  }

  public Buku(){ // overloading contructor
  }

  // overloading contructor juga
  public Buku(String penulis, String judul, int isbn){
    this.penulis = penulis;
    this.judul = judul;
    this.isbn = isbn;
  }

  public void info(){
    System.out.println("Penulis = " + this.penulis);
    System.out.println("Judul = " + this.judul);
    System.out.println("ISBN = "+ this.isbn);
  }
}

public class ConstructorOverloading{
  public static void main(String args[]){

    // inisiasi objek Buku
    Buku fisika = new Buku("Komar","Belajar Fisika");
    fisika.info();
    System.out.println();

    // inisiasi objek Buku
    Buku gambar = new Buku();
    gambar.info();
    System.out.println();

    // inisiasi objek Buku
    Buku sejarah = new Buku("Udin","Sejarah Indonesia", 1231421);
    sejarah.info();
  }
}
