package HashMap;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

//        temp = new StockItem("cup", 0.45, 7);
//        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        Basket myBasket = new Basket("Emily");

        sellItem(myBasket,"car",1);
        System.out.println(myBasket);

        sellItem(myBasket,"car",1);
        System.out.println(myBasket);

        sellItem(myBasket,"car",1);
        sellItem(myBasket,"spanner",5);

        sellItem(myBasket,"juice",4);
        sellItem(myBasket,"cup",12);
        sellItem(myBasket,"bread",1);
        System.out.println(myBasket);

        Basket basket = new Basket("customer");
        sellItem(basket,"cup",100);
        sellItem(basket,"juice",5);
        sellItem(basket, "cup",1);
        System.out.println(basket);

        removeItem(myBasket,"car",2);
        removeItem(myBasket,"cup",21);
        removeItem(myBasket,"car",1);
        System.out.println("cars removed: " + removeItem(myBasket, "car",1));
        System.out.println(myBasket);

        //remove all items test
        removeItem(myBasket,"bread",1);
        removeItem(myBasket,"cup",15);
        removeItem(myBasket,"juice",4);
        removeItem(myBasket,"cup",3);
        checkOut(myBasket);
        System.out.println(myBasket);
        System.out.println(stockList);

        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        for (Map.Entry<String,Double> prices: stockList.PriceList().entrySet()){
//            System.out.println(prices.getKey() + " costs " + prices.getValue());
//        }


        //purposed failure to test unmodified map
        //even though the map is unmodifiable, the object is still modifiable
//        temp = new StockItem("pen",1.12,8);
////        stockList.Items().put(temp.getName(),temp);
        //can be a potential flaw
        //stockList.Items().get("car").adjustStock(2000);

    }
//rewrite some methods so when quantity is changed the item in basket will be changed too
    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + stockItem);
            return 0;
        }

        //change it for reserve
//        if(stockList.sellStock(item,quantity) !=0){
        if(stockList.reserveStock(item, quantity) !=0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't have " + stockItem);
            return 0;
        }

        //change it for reserve
//        if(stockList.sellStock(item,quantity) !=0){
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item: basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
