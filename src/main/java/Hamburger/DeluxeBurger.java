package Hamburger;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("Deluxe","Sausage & Bacon", 14.54, "white");
        super.addHamburgerAddtion1("chip",2.75);
        super.addHamburgerAddtion2("Drink", 3.41);
    }


    @Override
    public void addHamburgerAddtion1(String name, double price) {
        System.out.println("cannot add additional item to deluxe burger");
    }

    @Override
    public void addHamburgerAddtion2(String name, double price) {
        System.out.println("cannot add additional item to deluxe burger");
    }

    @Override
    public void addHamburgerAddtion3(String name, double price) {
        System.out.println("cannot add additional item to deluxe burger");
    }

    @Override
    public void addHamburgerAddtion4(String name, double price) {
        System.out.println("cannot add additional item to deluxe burger");
    }
}
