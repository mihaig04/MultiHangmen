public class Guess {
    private final int idxWord;
    private final char letter;

    public Guess(int idxWord, char letter) {
        this.idxWord = idxWord;
        this.letter = letter;
    }

    public int getIdxWord() {
        return idxWord;
    }

    public char getLetter() {
        return letter;
    }
}
