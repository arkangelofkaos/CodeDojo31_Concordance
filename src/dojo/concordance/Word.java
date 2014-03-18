package dojo.concordance;

/**
 * @author arkangelofkaos
 */
public final class Word implements Comparable<Word> {

    private final String value;

    private Word(String value) {
        this.value = value;
    }

    /**
     * @param value Raw string value
     * @return Word wrapping the sanitized String
     */
    public static Word word(String value) {
        String sanitizedString = value.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        return new Word(sanitizedString);
    }

    public String getValue() {
        return value;
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

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
