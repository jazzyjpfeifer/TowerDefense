package data;

import data.helpers.Clock;
import data.helpers.StateManager;
import org.lwjgl.opengl.Display;

import static data.helpers.Artist.*;



public class Boot {

    public Boot() {

        BeginSession();


        while (!Display.isCloseRequested()) {
            Clock.update();

            //game.update();
            StateManager.update();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();

    }

    public static void main(String[] args) {
        new Boot();
    }
}
