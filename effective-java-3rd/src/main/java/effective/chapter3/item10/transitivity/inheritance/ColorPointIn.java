package effective.chapter3.item10.transitivity.inheritance;

import effective.chapter3.item10.transitivity.Color;
import effective.chapter3.item10.transitivity.Point;

public class ColorPointIn extends Point {
    private final Color color;

    public ColorPointIn(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // ColorPointIn 재정의 추가 - 대칭성 위배
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof ColorPointIn))
//            return false;
//        return super.equals(o) && ((ColorPointIn) o).color == color;
//    }

    // 코드 10-3 잘못된 코드 - 추이성 위배! (57쪽)
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        // o가 일반 Point면 색상을 무시하고 비교한다.
        if (!(o instanceof ColorPointIn))
            return o.equals(this);

        // o가 ColorPoint면 색상까지 비교한다.
        return super.equals(o) && ((ColorPointIn) o).color == color;
    }

    public static void main(String[] args) {
        // 첫 번째 equals 메서드(코드 10-2)는 대칭성을 위배한다. (57쪽)
        Point p = new Point(1, 2);
        ColorPointIn cp = new ColorPointIn(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // 두 번째 equals 메서드(코드 10-3)는 추이성을 위배한다. (57쪽)
        ColorPointIn p1 = new ColorPointIn(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPointIn p3 = new ColorPointIn(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
