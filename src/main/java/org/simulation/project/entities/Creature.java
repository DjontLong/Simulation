package org.simulation.project.entities;

import org.simulation.project.map.GameMap;

import java.util.*;

public abstract class Creature extends Entity {
    protected int hp;
    protected int speed;

    public Creature(Coordinates coordinates, int hp, int speed) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
    }

    // Алгоритм BFS для поиска ближайшего объекта
    public Coordinates bfs(GameMap gameMap, Class<? extends Entity> targetClass) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        queue.add(coordinates);
        visited.add(coordinates);

        int[] dx = {-1, 1, 0, 0}; // Направления по оси X
        int[] dy = {0, 0, -1, 1}; // Направления по оси Y

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.getX() + dx[i];
                int ny = current.getY() + dy[i];

                // Проверка на выход за пределы карты
                if (nx >= 0 && nx < gameMap.getWidth() && ny >= 0 && ny < gameMap.getHeight()) {
                    Coordinates next = new Coordinates(nx, ny);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        Entity entity = gameMap.getEntity(next);

                        // Если найден нужный объект, возвращаем его координаты
                        if (entity != null && targetClass.isInstance(entity)) {
                            return next;
                        }

                        queue.add(next);
                    }
                }
            }
        }
        return null; // Если не нашли
    }

    public abstract void makeMove(GameMap gameMap);
}