package effective.chapter8.item56;

public class ImplSpec {
    // 자기사용 패턴 등 내부 구현 방식을 명확히 드러내기 위해 @implSpec 사용 (335쪽)
    /**
     * Returns true if this collection is empty.
     *
     * @implSpec This implementation returns {@code this.size() == 0}.
     *
     * @return true if this collection is empty
     */
    public boolean isEmpty() {
        return false;
    }
    // 한글 버전 (335쪽)
    // /**
    //  * 이 컬렉션이 비었다면 true를 반환한다.
    //  *
    //  * @implSpec 이 구현은 {@code this.size() == 0}의 결과를 반환한다.
    //  *
    //  * @return 이 컬렉션이 비었다면 true, 그렇지 않으면 false
    //  */
    // public boolean isEmpty() {
    //     return false;
    // }
}
