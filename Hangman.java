public class Hangman {
  public final String word; //!!!!!!!!!!!!!!!!!!!!!
  private boolean[] revealedPos;
  private int lives;
  private boolean localWin;

  public Hangman(String word) {
    this.word = word.toUpperCase();
    revealedPos = new boolean[word.length()];
    lives = 4;
    localWin = false;
  }

  public int getLives() {
    return lives;
  }

  public boolean getLocalWin() {
    return localWin;
  }

  private void setLocalWin() {
    localWin = true;
    for(boolean b : revealedPos)
      if(!b) {
        localWin = false;
        return;
      }
  }

  public void reveal(char letter) {
    int i = word.indexOf(letter);
    if(i != -1)
      while(i < word.length() && i != -1) {
        revealedPos[i] = true;
        if(i >= word.length()) break;
        i = word.indexOf(letter, i + 1);
      }
    else
      lives--;
    setLocalWin();
  }

  public void print(int idx) {
    Out.println(String.format("Word %s:", idx + 1));
    printWord();
    printHanger();
    printLives();
    Out.println();
  }

  private void printWord() {
    for(int i = 0; i < word.length(); i++)
      if(revealedPos[i])
        Out.print(word.charAt(i));
      else Out.print('.');
    Out.println(String.format(" (%s)", word.length()));
  }

  private void printHanger() {
    switch (lives) {
      case 4:
        Out.println(" ________");
        Out.println(" |      |");
        Out.println(" |");
        Out.println(" |");
        Out.println(" |");
        Out.println(" |");
        Out.println("_|_");
        break;
      case 3:
        Out.println(" ________");
        Out.println(" |      |");
        Out.println(" |      O");
        Out.println(" |");
        Out.println(" |");
        Out.println(" |");
        Out.println("_|_");
        break;
      case 2:
        Out.println(" ________");
        Out.println(" |      |");
        Out.println(" |      O");
        Out.println(" |      |");
        Out.println(" |");
        Out.println(" |");
        Out.println("_|_");
        break;
      case 1:
        Out.println(" ________");
        Out.println(" |      |");
        Out.println(" |      O");
        Out.println(" |     /|\\");
        Out.println(" |");
        Out.println(" |");
        Out.println("_|_");
        break;
      case 0:
        Out.println(" ________");
        Out.println(" |      |");
        Out.println(" |      O");
        Out.println(" |     /|\\");
        Out.println(" |     / \\");
        Out.println(" |");
        Out.println("_|_");
        break;
    }
  }

  private void printLives() {
    Out.println("Remaining lives: " + lives);
  }
}
