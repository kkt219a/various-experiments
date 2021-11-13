package effective.chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {
    public enum Cheese{ STILTON }
    private final List<Cheese> cheesesInStock = new ArrayList<>();
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    /**
     * @return 매장 안의 모든 치즈 목록 반환, 재고가 없다면 null 반환
     */
    public List<Cheese> getCheeses(){
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }
    public List<Cheese> getCheesesGeneral(){
        return new ArrayList<>(cheesesInStock);
    }

    public List<Cheese> getCheesesEmptyCollections(){
        return cheesesInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
    }

    public Cheese[] getCheesesArray(){
        return cheesesInStock.toArray(new Cheese[0]);
    }

    public Cheese[] getCheesesEmptyArray(){
        return cheesesInStock.toArray(new Cheese[0]);
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Cheese> cheeses = shop.getCheesesGeneral();
        if(cheeses != null && cheeses.contains(Cheese.STILTON)){
            System.out.println(Cheese.STILTON + "재고 존재!");
        }
    }

}
