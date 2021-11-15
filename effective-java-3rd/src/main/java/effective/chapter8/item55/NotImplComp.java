package effective.chapter8.item55;

import org.jetbrains.annotations.NotNull;

public class NotImplComp implements Comparable<NotImplComp>{
    Integer age;
    String name;
    public NotImplComp(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull NotImplComp o) {
        return 0;
    }
}
