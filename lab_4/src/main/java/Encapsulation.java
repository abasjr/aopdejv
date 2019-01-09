// Enkapsulasi = bungkussh
// membatasi akses langsung ke beberapa properti objek(atribut/method)
// encapsulation dengan cara kasih access modifier
// Access Modifier = private,default, protected,public

// contoh Class Design OOP

public class Encapsulation{

  // atribut dari kelas
  private String var1;  // Instance variable, menggunakan access modifier private
  private int var2;

  // contructor kelas Encapsulation
  public Encapsulation(String var1, int var2){
    this.var1 = var1; // keyword 'this', menunjuk kepada atribut/method suatu object di kelas ini (kelas Encapsulation)
    this.var2 = var2;
  }

  // Setter & Getter
  public void setVar1(String var1){
    this.var1 = var1;
  }

  public String getVar1(){
    return var1;
  }

  public void setVar2(int var2){
    this.var2 = var2;
  }

  public int getVar2(){
    return var2;
  }

  public void method1(String args1) {
    System.out.println(var1 + " " + args1);
  }

  public int method2(int args2){
    return var2 + args2;
  }

  public static void main(String args[]){
    System.out.println();
  }
}
