package effective.chapter3.item10.transitivity.composition;

import effective.chapter3.item10.transitivity.Color;
import effective.chapter3.item10.transitivity.Point;

import java.util.Objects;

// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60쪽)
public class ColorPointComp {
    private final Point point;
    private final Color color;

    public ColorPointComp(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPointComp))
            return false;
        ColorPointComp cp = (ColorPointComp) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}
