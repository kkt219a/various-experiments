package effective.chapter8.item56;

public class MethodTag<E> {
    // 메서드 주석 (333-334쪽)
    /**
     * Returns the element at the specified position in this list.
     *
     * <p>This method is <i>not</i> guaranteed to run in constant
     * time. In some implementations it may run in time proportional
     * to the element position.
     *
     * @param  index index of element to return; must be
     *         non-negative and less than the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= this.size()})
     */
    E get(int index) {
        return null;
    }
    // 한글 버전 (334쪽)
    // /**
    //  * 이 리스트에서 지정한 위치의 원소를 반환한다.
    //  *
    //  * <p>이 메서드는 상수 시간에 수행됨을 보장하지 <i>않는다</i>. 구현에 따라
    //  * 원소의 위치에 비례해 시간이 걸릴 수도 있다.
    //  *
    //  * @param  index 반환할 원소의 인덱스; 0 이상이고 리스트 크기보다 작아야 한다.
    //  * @return 이 리스트에서 지정한 위치의 원소
    //  * @throws IndexOutOfBoundsException index가 범위를 벗어나면,
    //  * 즉, ({@code index < 0 || index >= this.size()})이면 발생한다.
    //  */
    // E get(int index) {
    //     return null;
    // }

}
