package effective.chapter4.item20;

public abstract class IntArrayChild extends IntArrays implements Singer{

    @Override
    public void sing(String s) {
        int i = a * a;
        System.out.println(a+a);
        System.out.println(kk());
    }

//    public static void main(String[] args) {
//        new IntArrayChild().sing("z");
//    }

}

interface Singer{
    int a = 1;
    void sing(String s);
//    boolean equals(Object obj);
//    default boolean equals(Object obj) {
//        return (this == obj);
//    }
    default boolean kk(){
        return k();
    }
    private boolean k(){
        return false;
    }
    static boolean kkk(){
        return kkkk();
    }
    private static boolean kkkk(){
        return false;
    }
}
//interface Songwriter{
//    void compose(int chartPosition);
//}
//interface SingerSongwriter extends Singer, Songwriter{
//    void strum();
//    void actSensitive();
//}

//abstract class Singer{
//    abstract void sing(String s);
//}
//abstract class Songwriter{
//    abstract void compose(int chartPosition);
//}
//abstract class SingerSongwriter{
//    abstract void sing(String s);
//    abstract void compose(int chartPosition);
//    abstract void strum();
//    abstract void actSensitive();
//}