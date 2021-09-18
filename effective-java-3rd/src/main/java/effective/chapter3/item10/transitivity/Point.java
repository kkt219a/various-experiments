package effective.chapter3.item10.transitivity;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 잘못된 코드 - 색상 정보는 무시한 체 비교
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

//    // 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }
}