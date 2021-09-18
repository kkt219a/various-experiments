package effective.chapter2.item5;

import java.util.List;

public class SpellCheckerSingleton {

    private final Lexicon dictionary = new KoreanDictionary();

    private SpellCheckerSingleton() {
    }

    public static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton() {
    };

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }


    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        SpellCheckerSingleton.INSTANCE.isValid("hello");
    }

}

