public class HangmenGame {
    private Hangman[] hangmen;
    private boolean end;

    public HangmenGame(String[] words) {
        hangmen = new Hangman[words.length];
        for(int i = 0; i < words.length; i++)
            hangmen[i] = new Hangman(words[i]);
    }

    public void run() {
        print();
        boolean loss = false;
        while(!end) {
            Guess guess = UserPrompt.askForGuess(hangmen.length);
            int idxWord = guess.getIdxWord();
            char letter = guess.getLetter();
            if(!hangmen[idxWord].getLocalWin()) {
                hangmen[idxWord].reveal(letter);
                loss = hangmen[idxWord].getLives() <= 0;
            }
            print();
            end = win() || loss;
        }
        if(loss)
            Out.println(String.format("You lost! You won %s word(s).", getWordsWon()));
        else //win
            Out.println("You won! All words were guessed right.");
    }

    private boolean win() {
        for(Hangman hangman : hangmen)
            if(!hangman.getLocalWin())
                return false;
        return true;
    }

    private int getWordsWon() {
        int n = 0;
        for(Hangman hangman : hangmen)
            if(hangman.getLocalWin())
                n++;
        return n;
    }

    private void print() {
        for(int i = 0; i < hangmen.length; i++)
            hangmen[i].print(i);
    }
}
