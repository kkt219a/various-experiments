package effective.chapter2.item5;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpellCheckerDI {

    private final Lexicon dictionary;

    public SpellCheckerDI(Supplier<Lexicon> dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary.get());
    }

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }

    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Lexicon lexicon = new TestDictionary();
        SpellCheckerDI spellChecker = new SpellCheckerDI(() -> lexicon);
        spellChecker.isValid("hello");
    }

}

