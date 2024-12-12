package org.simulation.project.entities;

import org.simulation.project.map.GameMap;

import java.util.Random;

public class Wolf extends Creature {
    private int attackPower;

    public Wolf(Coordinates coordinates, int hp, int speed, int attackPower) {
        super(coordinates, hp, speed);
        this.attackPower = attackPower;
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
        // Находим ближайшую овцу
        Coordinates target = bfs(gameMap, Sheep.class);

        if (target != null) {
            // Если овца найдена, двигаемся к её координатам
            setCoordinates(target);
        } else {
            // Если овца не найдена, делаем случайный ход или по другой логике
            randomMove(gameMap);
        }
    }
    @Override
    public String getSymbol() {
        return "🐺"; // Эмоджи волка
    }
}