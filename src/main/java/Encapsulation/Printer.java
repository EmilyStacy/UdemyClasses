package Encapsulation;

public class Printer {
    private int tonerLevel = 0;
    private int pagePrinted = 0;
    private boolean isdublex;

    public Printer(int tonerLevel, boolean isdublex) {
        if(tonerLevel >= 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }else{
            this.tonerLevel = -1;
        }

        this.pagePrinted = 0;
        this.isdublex = isdublex;
    }

    public int addToner(int tonerAmount){
        if(tonerAmount > 0 && tonerAmount <=100){
            if(this.tonerLevel + tonerAmount > 100){
                System.out.println("Overloading. Filling failed");
                return -1;
            }
            this.tonerLevel += tonerAmount;
            System.out.println("tonerLevel refilled to " + tonerLevel + "%." );
            return this.tonerLevel += tonerAmount;
        }
        return -1;
    }

    public int getPagePrinted() {
        return pagePrinted;
    }

    public int printPage(int pages){
        int pagesToPrint = pages;
        if(this.isdublex){
            pagesToPrint = (pages /2) + (pages%2);
            System.out.println("printer in duble mode");
        }

        pagePrinted+= pagesToPrint;
        System.out.println("pages printed" + pagePrinted);
        return pagesToPrint;


    }


}
