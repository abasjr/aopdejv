import character.Kucing;
import character.KucingBangsawan;
import character.KucingRakyat;
import character.KucingPrajurit;

public class CatSociety {
    public static void main(String[] args) {
        KucingBangsawan kucingBangsawan= new KucingBangsawan("Aya", 100, 30, "Empress");
        KucingPrajurit kucingPrajurit= new KucingPrajurit("Rian", 120, 30);
        KucingRakyat kucingRakyat = new KucingRakyat("Salsa", 80, 20);

        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.attack(kucingRakyat);
        kucingRakyat.attack(kucingBangsawan);
        kucingPrajurit.attack(kucingBangsawan);
        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.sleep();
        kucingPrajurit.sleep();
        kucingRakyat.sleep();
        System.out.println(kucingBangsawan.status() + "\n");
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingRakyat.payTax();
        kucingPrajurit.payTax();
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
        kucingBangsawan.execute(kucingPrajurit);
        kucingBangsawan.execute(kucingRakyat);
        kucingRakyat.sleep();
        kucingPrajurit.sleep();
        System.out.println(kucingPrajurit.status() + "\n");
        System.out.println(kucingRakyat.status() + "\n");
    }
}
