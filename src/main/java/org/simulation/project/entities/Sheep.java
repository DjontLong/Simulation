package org.simulation.project.entities;

import org.simulation.project.map.GameMap;

import java.util.Random;

public class Sheep extends Creature {
    public Sheep(Coordinates coordinates, int hp, int speed) {
        super(coordinates, hp, speed);
    }

    private void randomMove(GameMap gameMap) {
        // Логика для случайного перемещения
        Coordinates current = getCoordinates();
        Random rand = new Random();
        int dx = rand.nextInt(3) - 1;  // -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // -1, 0, 1
        Coordinates next = new Coordinates(current.getX() + dx, current.getY() + dy);

        if (gameMap.isValidMove(next)) {
            setCoordinates(next);
        }
    }

    @Override
    public void makeMove(GameMap gameMap) {
        // Находим ближайшую траву
        Coordinates target = bfs(gameMap, Grass.class);

        if (target != null) {
            // Если трава найдена, двигаемся к её координатам
            setCoordinates(target);
        } else {
            // Если трава не найдена, делаем случайный ход или по другой логике
            randomMove(gameMap);
        }
    }


    @Override
    public String getSymbol() {
        return "🐑"; // Эмоджи овцы
    }
}