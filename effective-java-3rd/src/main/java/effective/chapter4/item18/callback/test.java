package effective.chapter4.item18.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class test {
    /**
     *
     * @throws Exception
     * @param args
     */
    public static void main(String[] args) {
        SomeService   service       = new SomeService();
        WrappedObject wrappedObject = new WrappedObject(service);
        Wrapper       wrapper       = new Wrapper(wrappedObject);
        wrapper.doSomething();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);a.add(4);a.add(5);a.add(6);a.add(7);a.add(8);a.add(9);
        List<Integer> aa = a.subList(0, 5); // root: a, parent: null
        List<Integer> aaa = aa.subList(0, 3); // root: a , parent: aa
        //abstractList의 clear 호출, subList의 removeRange 호출, root(arrayList)의 removeRange 호출
        //parent 타고 올라가면서 subList의 size랑 modCount만 수정
        aaa.clear();
        System.out.println("a = " + a);
        System.out.println("aa = " + aa);
        System.out.println("aaa = " + aaa);
        // 서브리스트 --> 클리어 --> 자신의 재정의 removeRange호출 --> root의 removeRange 호출 --> 완료
        // 서브리스트 --> 클리어 --> root의 클리어 호출
    }
}
