package effective.chapter2.item2;

import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
public class NutritionFactsLombok {
    // If a certain field/parameter is never set during a build session, then it always gets 0 / null / false.
    // If you've put @Builder on a class (and not a method or constructor)
    // you can instead specify the default directly on the field, and annotate the field with @Builder.Default:
    @Builder.Default
    private int servingSize = 10;

    private int servings;
    private int sodium;
    private int carbohydrate;

    // for collection @Singular
    @Singular
    private List<String> names;

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("k");
        a.add("k");
        a.add("t");
        a.add("t");

        NutritionFactsLombok build = NutritionFactsLombok.builder()
                .servings(10)
                .servingSize(1)
                .name("kkt")
                .name("kkt2")
                .names(a)
                .build();
        build.names.forEach(System.out::println);
    }
}
