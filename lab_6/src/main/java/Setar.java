public class Setar{

  static String Bintang(String btg){
    if (btg.length() <=1 )
      return btg;
    else
      return  btg.charAt(0) + "*" + Bintang(btg.substring(1)) ;
  }
  public static void main(String [] args){
    System.out.println(Bintang("depechan"));
  }
}
