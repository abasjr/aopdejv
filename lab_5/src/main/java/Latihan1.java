class Latihan1{
  public static void main(String[] args){
    int[] numbers = new int[10]; // menginisiasi array of int dengan panjang 10
    System.out.println(numbers[5]); // menampilkan 0 , karena isinya nol semua (formatnya integer)

    String[] strList = new String[5];// inisiasi array String dengan panjang 5
    System.out.println(strList[0]);// menampilkan  , karena isinya null semua (formatnya string)

    int[] primes = {2,3,5,7,11}; //menginisiasi array of int dengan initial values
    System.out.println(primes[2]);// menampilkan 5, karena 0,1,2 -> 2,3,5

  }
}

