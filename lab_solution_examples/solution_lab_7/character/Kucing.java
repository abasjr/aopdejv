package characterv2;

public class Kucing {
    protected String name;
    protected int health;
    protected int power;

    public Kucing(String name, int health, int power){
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void attack(Kucing kucing) {
        if (this.health > 0) {
            if ((kucing.health - this.power) >= 0) {
                kucing.health -= this.power;
            } else kucing.health = 0;
        }
    }

    public void sleep() {
        if (this.health > 0) this.health += 20;
    }

    public String status(){
        String status = String.format("Nama : %s\nHealth : %s\nPower : %s",
                this.name, this.health, this.power);
        return status;
    }
}
