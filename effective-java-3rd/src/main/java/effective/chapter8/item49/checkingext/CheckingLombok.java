package effective.chapter8.item49.checkingext;


import lombok.NonNull;

public class CheckingLombok {
    Integer age;
    String name;
    public CheckingLombok(@NonNull Integer age, String name) {
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
        CheckingLombok twoInclude = new CheckingLombok(25, "kkt");
        CheckingLombok ageInclude = new CheckingLombok(27, null);
        CheckingLombok nameInclude = new CheckingLombok(null, "kkt");
        CheckingLombok notInclude = new CheckingLombok(null, null);
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
