package characterv2;

public class KucingPrajurit extends KucingRakyat {
    public KucingPrajurit (String name, int health, int power){
        super(name, health, power);
    }

    public void attack(Kucing kucing){
        if (this.health > 0) {
            if ((kucing.health - (2 * this.power)) >= 0) {
                kucing.health -= (2 * this.power);
            } else kucing.health = 0;
        }
    }
}
