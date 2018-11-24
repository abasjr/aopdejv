package characterv2;

public class KucingBangsawan extends Kucing{
    private String title;

    public KucingBangsawan(String name, int health, int power, String title){
        super(name, health, power);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void execute(KucingRakyat kucing){
        if (this.health > 0 ) kucing.health = 0;
    }

    public String status(){
        String status = super.status() + "\n";
        status += String.format("Title : %s", this.title);
        return status;
    }

}
