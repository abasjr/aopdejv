package characterv2;

public class KucingRakyat extends Kucing {
    public KucingRakyat(String name, int health, int power){
        super(name, health, power);
    }

    public void payTax(){
        if (this.health >0 ) this.health -= 20;
    }
}
