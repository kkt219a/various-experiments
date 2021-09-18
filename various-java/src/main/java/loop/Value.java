package loop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Value {
    Integer[] arrayValue = new Integer[10000000];
    List<Integer> arrayListValue = new ArrayList<>();
    List<Integer> linkedListValue = new LinkedList<>();


    public Value() {
        for(int i=0;i<10000000;i++){
            arrayValue[i] = i;
            arrayListValue.add(i);
            if(i<100000) {
                linkedListValue.add(i);
            }
        }
    }

    public Integer[] getArrayValue() {
        return arrayValue;
    }

    public List<Integer> getArrayListValue() {
        return arrayListValue;
    }

    public List<Integer> getLinkedListValue() {
        return linkedListValue;
    }
}
