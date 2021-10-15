package effective.chapter6.item40;

public class ChildClass extends ParentClass implements ParentInterface{

    void giveFood() {
        System.out.println(" child food! ");
    }

    public void giveMoney() {
        System.out.println(" child money! ");
    }

    void giveHouse() {
        super.giveHouse();
    }

}
