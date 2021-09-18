package effective.chapter2.item2;


public class NutritionFactsConstructor {
    private final int servingSize;  // (mL, 1회 제공량)     필수
    private final int servings;     // (회, 총 n회 제공량)  필수
    private final int calories;     // (1회 제공량당)       선택
    private final int fat;          // (g/1회 제공량)       선택
    private final int sodium;       // (mg/1회 제공량)      선택
    private final int carbohydrate; // (g/1회 제공량)       선택

    //필수 매개변수만 받는 생성자
    public NutritionFactsConstructor(int servingSize, int servings) {
        this(servingSize,servings,0);
    }

    // 필수 매개변수 + 선택 매개변수 1개
    public NutritionFactsConstructor(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    // 필수 매개변수 + 선택 매개변수 2개
    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    // 필수 매개변수 + 선택 매개변수 3개
    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    // 필수 매개변수 + 선택 매개변수 4개
    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsConstructor nutritionFacts = new NutritionFactsConstructor(1, 1);
        System.out.println("nutritionFacts.servingSize = " + nutritionFacts.servingSize);
        System.out.println("nutritionFacts.servings = " + nutritionFacts.servings);
        System.out.println("nutritionFacts.calories = " + nutritionFacts.calories);
        System.out.println("nutritionFacts.fat = " + nutritionFacts.fat);
        System.out.println("nutritionFacts.sodium = " + nutritionFacts.sodium);
        System.out.println("nutritionFacts.carbohydrate = " + nutritionFacts.carbohydrate);
    }
}
