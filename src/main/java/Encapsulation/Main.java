package Encapsulation;

public class Main {
    public static void main(String[] args) {
        Printer pr = new Printer(5,true);
        pr.addToner(30);
        System.out.println(pr.getPagePrinted());
        pr.printPage(7);
        pr.printPage(2);
        System.out.println(pr.getPagePrinted());
    }



}
