package effective.chapter2.item5;

import java.util.List;

public class SpellCheckerStaticUtility {

    private static final Lexicon dictionary = new KoreanDictionary();

    private SpellCheckerStaticUtility() {
        // Noninstantiable
    }

    public static boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }

    public static List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        SpellCheckerStaticUtility.isValid("hello");
    }
}


