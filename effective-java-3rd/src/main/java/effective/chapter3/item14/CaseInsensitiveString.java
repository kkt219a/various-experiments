package effective.chapter3.item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class CaseInsensitiveString
        implements Comparable<CaseInsensitiveString> {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    // 자바가 제공하는 비교자를 사용해 클래스를 비교한다.
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    public static void main(String[] args) {
        Set<CaseInsensitiveString> s = new TreeSet<>();
        for (String arg : args)
            s.add(new CaseInsensitiveString(arg));
        System.out.println(s);
    }
}
