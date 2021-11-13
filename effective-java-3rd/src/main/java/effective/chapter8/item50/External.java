package effective.chapter8.item50;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class External {
    private List<Integer> lists = new ArrayList<>();
    public void init(){
        lists.addAll(IntStream.rangeClosed(0,3).boxed().collect(Collectors.toList()));
    }
    public List<Integer> getLists() {
        return lists;
    }
    public static void main(String[] args) {
        External external = new External();
        external.init();
        // [0, 1, 2, 3]
        System.out.println("external = " + external.getLists());
        List<Integer> lists = external.getLists();
        lists.remove(0);
        // [1, 2, 3]
        System.out.println("external = " + external.getLists());
    }
}
