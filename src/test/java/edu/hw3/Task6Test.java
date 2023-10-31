package edu.hw3;

import edu.hw3.task6.MyStockMarket;
import edu.hw3.task6.Stock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    public void BasicTest() {
        MyStockMarket myStockMarket = new MyStockMarket();

        Stock dnsStock = new Stock("DNS", 1000);
        Stock burgerKingStock = new Stock("Burger king", 300);
        Stock amazonStock = new Stock("Amazon", 2000);

        myStockMarket.add(dnsStock);
        myStockMarket.add(burgerKingStock);
        myStockMarket.add(amazonStock);

        assertThat(myStockMarket.mostValuableStock().name())
                .isEqualTo("Amazon");
        myStockMarket.remove(amazonStock);

        assertThat(myStockMarket.mostValuableStock().name())
                .isEqualTo("DNS");
        myStockMarket.remove(dnsStock);

        assertThat(myStockMarket.mostValuableStock().name())
                .isEqualTo("Burger king");
        myStockMarket.remove(burgerKingStock);
    }
}
