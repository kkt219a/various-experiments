package effective.chapter2.item8.finalizeattack;

public class SuperAttack {
    Integer value;
    public SuperAttack(Integer value) {
        if(value<0){
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
        this.value = value;
    }
}
