package effective.chapter8.item49.checkingext;


import java.util.Optional;

public class CheckingOptional {
    Integer age;
    String name;
    public CheckingOptional(Integer age, String name) {
        Integer newAge = Optional.of(age).orElseThrow(NullPointerException::new);
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
        CheckingOptional twoInclude = new CheckingOptional(25, "kkt");
        CheckingOptional ageInclude = new CheckingOptional(27, null);
        CheckingOptional nameInclude = new CheckingOptional(null, "kkt");
        CheckingOptional notInclude = new CheckingOptional(null, null);
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
