public class UserPrompt {

    public static String[] askForAllWords() {
        int n = UserPrompt.askForHangmenCount();
        String[] words = new String[n];
        for(int i = 0; i < n; ++ i)
            words[i] = UserPrompt.askForWord(i);
        Out.println();
        return words;
    }

    private static int askForHangmenCount() {
        int n;
        Out.println("With how many words do you want to play? (at least 1, at most 10) ");
        n = In.readInt();
        while(!In.done() || n < 1 || n > 10) {
            In.readLine();
            Out.println("Invalid input. With how many words do you want to play? (at least 1, at most 10) ");
            n = In.readInt();
        }
        return n;
    }

    private static String askForWord(int idxWord) {
        String s;
        Out.println(String.format("Which word do you want to have on hangman #%s? ", idxWord + 1));
        //A broader definition of a word is used for the input
        s = In.readWord();
        while(!In.done()) {
            Out.println(String.format("Invalid input. Which word do you want to have on hangman #%s? ", idxWord));
            s = In.readWord();
        }
        return s;
    }

    public static Guess askForGuess(int maxIdxWord) {
        return new Guess(UserPrompt.AskForIdxWord(maxIdxWord), UserPrompt.AskForLetter());
    }

    private static int AskForIdxWord(int maxIdxWord) {
        int idxWord;
        Out.println("Which word (number) do you want to play?  ");
        idxWord = In.readInt();
        while(!In.done() || idxWord < 1 || idxWord > maxIdxWord) {
            In.readLine();
            Out.println("Invalid input. Which word (number) do you want to play? ");
            idxWord = In.readInt();
        }
        return idxWord - 1;
    }

    private static char AskForLetter() {
        char letter;
        Out.println("Which letter do you want to guess? ");
        letter = In.readChar();
        while(!In.done() || !Character.isLetter(letter)) {
            Out.println("Invalid input. Which letter do you want to guess? ");
            letter = In.readChar();
        }
        return Character.toUpperCase(letter);
    }
}
