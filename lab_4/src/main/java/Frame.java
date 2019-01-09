// konsep static keyword

public class Frame{
  public static final int WIDTH = 200;
  public static final int HEIGHT = 500;
  public String tipe;

  public Frame(String tipe){
    this.tipe = tipe;
  }

  public static int size(){
    return HEIGHT * WIDTH;
  }

  public static void main(String []args){
    int frameWidth = Frame.WIDTH;
    int frameHeight = Frame.HEIGHT;
    int frameSize = Frame.size();
    System.out.println(frameSize);
    System.out.println(frameWidth);
    System.out.println(frameHeight);

    //instansiasi
    Frame bingkai = new Frame("Bingkai Foto");
    String tipeBingkai = bingkai.tipe;
    System.out.println(tipeBingkai);
    System.out.println(bingkai.WIDTH);
    System.out.println(bingkai.HEIGHT);
  }
}
