package effective.chapter8.item49.checkingext;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CheckingIde {
    Integer age;
    String name;
    public CheckingIde(@NotNull Integer age, @Nullable String name) {
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
        CheckingIde twoInclude = new CheckingIde(25, "kkt");
        CheckingIde ageInclude = new CheckingIde(27, null);
        CheckingIde nameInclude = new CheckingIde(null, "kkt");
        CheckingIde notInclude = new CheckingIde(null, null);
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
