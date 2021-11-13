package effective.chapter8.item52;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

public class Ovld {
    static void tempSubmit(Runnable value){

    }
    static void tempSubmit(Callable<? extends Object> value){

    }
    static void tempSubmit(int value){

    }
    public static void main(String[] args) {
        Ovld.tempSubmit((Runnable) System.out::println);
    }

//    public static void main(String[] args) {
//        // 1번. Thread의 생성자 호출
//        new Thread(System.out::println).start();
//        // 2번. ExecutorService의 submit 메소드 호출
//        ExecutorService exec = Executors.newCachedThreadPool();
//        Runnable mysqlCallbackHandler = System.out::println;
//        Ovld.tempSubmit(System.out::println);
//        exec.submit(Ovld::hello);
//        exec.submit(System.out::println);
//    }
}
