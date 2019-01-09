class Motor{
  String nama;
  String merk;

  Motor(String nama, String merk){
    this.nama = nama;
    this.merk = merk;
  }

  public static void main (String args[]){

    // Contoh 1
    Motor a = new Motor("bleki", "Yamahmud");
    Motor b = new Motor("bleki", "Yamahmud");
    System.out.println(a==b); // false

    // Contoh 2
    Motor c = new Motor("bleki", "Yamahmud");
    Motor d = a;
    d.nama = "hajigur";
    System.out.println(c.nama); //bleki

    // Contoh 3
    Motor e = new Motor("bleki", "Yamahmud");
    Motor f = e;
    f = new Motor("hajigur", "Yamahmud");
    System.out.println(e.nama); // bleki

  }
}
