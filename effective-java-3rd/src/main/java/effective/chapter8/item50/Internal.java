package effective.chapter8.item50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Internal {
    private List<Product> lists = new ArrayList<>();
    public List<Product> getLists() {
        return lists;
    }
    public void addValue(Product value) {
        this.lists.add(value);
    }
    public static void main(String[] args) {
        Internal internal = new Internal();
        Product value = new Product( "옷");
        internal.addValue(value);
        // 옷
        System.out.println(internal.getLists().get(0).name);
        value.setName("가방");
        // 가방
        System.out.println(internal.getLists().get(0).name);
    }
    private static class Product{
        String name;
        public Product(String name) {
            this.name = name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
