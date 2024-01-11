public class HangmenGameApp {
    public static void main(String[] args) {
        HangmenGame game = new HangmenGame(UserPrompt.askForAllWords());
        game.run();
    }
}
