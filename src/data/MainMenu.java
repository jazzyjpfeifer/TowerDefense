package data;

import UI.UI;
import data.helpers.StateManager;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;


import static UI.UI.*;
import static data.helpers.Artist.*;


public class MainMenu {

    private Texture background;
    private UI menuUI;

    public MainMenu() {
        background = QuickLoad("mainmenu");
        menuUI = new UI();
        menuUI.addButton("Play", "play_btn", WIDTH / 2 - 128, (int) (HEIGHT * 0.35f));
        menuUI.addButton("Editor", "edit_btn", WIDTH / 2 - 128, (int) (HEIGHT * 0.45f));
        menuUI.addButton("Quit", "quit_btn", WIDTH / 2 - 128, (int) (HEIGHT * 0.55f));


    }

    private void updateButtons() {
        if (Mouse.isButtonDown(0)) {
            if (menuUI.isButtonClicked("Play"))
                StateManager.setState(StateManager.GameState.GAME);
            if (menuUI.isButtonClicked("Editor"))
                StateManager.setState(StateManager.GameState.EDITOR);
            if (menuUI.isButtonClicked("Quit"))
                System.exit(0);
        }
    }

    public void update() {
        DrawQuadTex(background, 0, 0, 2048, 1024);
        menuUI.draw();
        updateButtons();
    }
}
