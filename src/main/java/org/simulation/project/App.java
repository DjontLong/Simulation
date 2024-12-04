package org.simulation.project;

import org.simulation.project.map.GameMap;

public class App
{
    public static void main( String[] args )
    {
        GameMap gameMap = new GameMap();
        gameMap.setupDefaultEntityPositions();

        gameMap.render();

        int a = 123;
    }
}
