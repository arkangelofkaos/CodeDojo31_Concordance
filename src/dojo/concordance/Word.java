package dojo.concordance;

/**
 * @author arkangelofkaos
 */
public final class Word implements Comparable<Word> {

    private final String value;

    public Word(String value) {
        this.value = value;
    }

    public static Word word(String value) {
        return new Word(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Word o) {
        return this.value.compareTo(o.value);
    }
}
