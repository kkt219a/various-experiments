package effective.chapter8.item49.checkingext;


import javax.validation.constraints.NotNull;

public class CheckingJavax {
    Integer age;
    String name;
    public CheckingJavax(@NotNull Integer age, String name) {
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
        CheckingJavax twoInclude = new CheckingJavax(25, "kkt");
        CheckingJavax ageInclude = new CheckingJavax(27, null);
        CheckingJavax nameInclude = new CheckingJavax(null, "kkt");
        CheckingJavax notInclude = new CheckingJavax(null, null);
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
