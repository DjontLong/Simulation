package org.simulation.project;

import org.simulation.project.entities.*;
import org.simulation.project.map.GameMap;

public class App {
    public static void main(String[] args) {
        // Создаем карту размером 10x10
        GameMap gameMap = new GameMap(10, 10);

        // Добавляем сущности на карту
        gameMap.setupDefaultEntityPositions();

        // Создаем объекты существа
        Sheep sheep = new Sheep(new Coordinates(5, 7), 10, 1);
        Wolf wolf = new Wolf(new Coordinates(0, 0), 10, 2, 3);

        // Добавляем их на карту
        gameMap.addEntity(sheep);
        gameMap.addEntity(wolf);

        // Основной цикл игры (например, 10 ходов)
        for (int turn = 0; turn < 10; turn++) {
            System.out.println("Turn: " + (turn + 1));

            // Волк делает ход
            wolf.makeMove(gameMap);

            // Овца делает ход
            sheep.makeMove(gameMap);

            // Отрисовываем карту после каждого хода
            gameMap.render();

            // Добавить задержку для удобства наблюдения
            try {
                Thread.sleep(1000);  // Задержка 1 секунда между ходами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }
}