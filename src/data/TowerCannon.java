package data;

import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;

import static data.helpers.Artist.DrawQuadTex;
import static data.helpers.Artist.*;
import static data.helpers.Clock.Delta;

public class TowerCannon {

    private float x, y, timeSinceLastShot, firingSpeed;
    private int damage, height, width;
    private Texture bastTexture, cannonTexture;
    private Tile startTile;
    private ArrayList<Projectile> projectiles;

    public TowerCannon(Texture baseTexture, Tile startTile, int damage) {
        this.bastTexture = baseTexture;
        this.cannonTexture = QuickLoad("cannonGun");
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
        this.damage = damage;
        this.firingSpeed = 30;
        this.timeSinceLastShot = 0;
        this.projectiles = new ArrayList<Projectile>();
    }

    private void shoot() {
        timeSinceLastShot = 0;
        projectiles.add(new Projectile(QuickLoad("bullet"), x + 32, y + 32, 5, 10));

    }

    public void update() {
        timeSinceLastShot += Delta();
        if (timeSinceLastShot > firingSpeed)
        shoot();

        //LESSON 30
        for (Projectile p: projectiles)
            p.update();

    }

    public void draw() {
        DrawQuadTex(bastTexture, x, y, width, height);
        DrawQuadTex(cannonTexture, x, y, width, height);
    }
}
