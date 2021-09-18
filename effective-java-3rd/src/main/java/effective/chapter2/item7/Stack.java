package effective.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        this.ensureCapacity();
        this.elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = this.elements[--size];
        //인스턴스가 직접 사용하는거니까
        this.elements[size] = null;
        return result;
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다. 배열 크기를 늘려야 할 때마다 대략 2배씩 늘린다.
    private void ensureCapacity() {
        if (this.elements.length == size) {
            this.elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}