import controllers.WelcomeController;
import core.GameMaster;
import gui.WelcomeScreen;

/**
 * Class for playing That's Life!
 */
public class ThatsLife {
    public static void main(String[] args) {
        WelcomeScreen welcomeScr;
        GameMaster game;
        WelcomeController initCtrl;

        welcomeScr = new WelcomeScreen();
        game = new GameMaster();
        initCtrl = new WelcomeController(welcomeScr, game);
    }
}
