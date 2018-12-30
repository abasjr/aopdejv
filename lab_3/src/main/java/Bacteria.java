public class Bacteria{

  public static int calculate(){
    int bacterias = 1;
    int hours = 0;

    while (bacterias < 21492){
      bacterias *= 2;
      hours += 1;
    }
    return hours;
  }

  public static void main(String []args){
    System.out.printf("Jumlah jam yang diperlukan adalah : %s\n", Bacteria.calculate());
  }
}
