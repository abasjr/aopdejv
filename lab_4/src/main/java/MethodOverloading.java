// Overloading terhadap metode
// Syaratnya:
// Nama method harus sama
// Daftar parameter harus berbeda
// Return type boleh sama, juga boleh berbeda

class Matematika{

  public int isiNilai(int nilai){
    return nilai * nilai;
  }

  public double isiNilai(double nilai){
    return nilai * nilai;
  }
}

public class MethodOverloading{
  public static void main (String []args){
    Matematika mtk = new Matematika();

    // mengambil nilai integer
    int hasil = mtk.isiNilai(4);
    System.out.println(hasil);

    //mengambil nilai double
    double result = mtk.isiNilai(12.0);
    System.out.println(result);
  }
}
