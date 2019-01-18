package data;

import java.util.ArrayList;

import static data.helpers.Clock.Delta;

public class Wave {

    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;
    private int enemiewPerWave;
    private boolean waveCompleted;

    public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        this.enemiewPerWave = enemiesPerWave;
        this.timeSinceLastSpawn = 0;
        this.enemyList = new ArrayList<Enemy>();
        this.waveCompleted = false;

        Spawn();
    }

    public void Update() {
        boolean allEnemiesDead = true;
        if(enemyList.size() < enemiewPerWave) {
            timeSinceLastSpawn += Delta();
            if (timeSinceLastSpawn > spawnTime) {
                Spawn();
                timeSinceLastSpawn = 0;
            }
        }

        for (Enemy e: enemyList) {
            if (e.isAlive()) {
                allEnemiesDead = false;
                e.Update();
                e.Draw();
            }
        }

        if (allEnemiesDead)
            waveCompleted = true;

    }

    public void Spawn() {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), 64 , 64, 100, enemyType.getSpeed()));
    }

    public boolean isWaveCompleted() {
        return waveCompleted;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
