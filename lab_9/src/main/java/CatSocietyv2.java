import characterv2.KucingBangsawan;
import characterv2.KucingRakyat;
import characterv2.KucingPrajurit;

public class CatSocietyv2 {
    public static void main(String[] args) {
        KucingBangsawan kucingBangsawan= new KucingBangsawan("Aya", "10000000000000000000000000000000000000000000000000000000000000000000000000000", "30000000000000000000000000000000", "Empress");
        KucingPrajurit kucingPrajurit= new KucingPrajurit("Rian", "120000000000000000000000000000000000000000000000000000000000000000000000000000", "30000000000000000000000000000000");
        KucingRakyat kucingRakyat = new KucingRakyat("Salsa", "80000000000000000000000000000000000000000000000000000000000000000000000000000", "20000000000000000000000000000000");

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
