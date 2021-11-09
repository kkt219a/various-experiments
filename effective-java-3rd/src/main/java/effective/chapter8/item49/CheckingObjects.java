package effective.chapter8.item49;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CheckingObjects {
    Integer age;
    String name;
    public CheckingObjects(Integer age, String name) {
        //Integer newAge = Objects.requireNonNull(age,()-> name+"이라는 사람의 나이가 null이래!");
        Objects.checkIndex(8,6);
        this.age = age;
        this.name = name;
    }
    public void printAge(){
        System.out.println(age);
    }
    public void printName(){
        System.out.println(name);
    }
    public static void main(String[] args) {
        CheckingObjects twoInclude = new CheckingObjects(25, "kkt");
        CheckingObjects ageInclude = new CheckingObjects(27, null);
        CheckingObjects nameInclude = new CheckingObjects(null, "kkt");
        CheckingObjects notInclude = new CheckingObjects(null, null);
        twoInclude.printAge(); //25
        twoInclude.printName(); //kkt
        ageInclude.printAge(); //27
        ageInclude.printName(); //null
        nameInclude.printAge(); //null
        nameInclude.printName(); //kkt
        notInclude.printAge(); //null
        notInclude.printName(); //null
    }
}
