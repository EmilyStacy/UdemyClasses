package Hamburger;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic","saussage",3.56, "white");
        hamburger.addHamburgerAddtion1("Cheese", 0.27);
        double price = hamburger.itemizeHamburger();
        System.out.println(price);
    }
}
