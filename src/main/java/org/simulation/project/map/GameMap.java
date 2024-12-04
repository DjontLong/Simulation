package org.simulation.project.map;

import org.simulation.project.entities.*;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private HashMap<Coordinates, Entity> map;

    public GameMap() {
        map = new HashMap<>();
    }

    // Добавить сущность
    public void addEntity(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        map.put(coordinates, entity);
    }

    // Удалить сущность
    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    // Получить сущность
    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    // Расположить сущности на карте
    public void setupDefaultEntityPositions() {
        addEntity(new Wolf(new Coordinates(0, 0), 5, 3, 1));
        addEntity(new Sheep(new Coordinates(5, 7), 4, 1));

        addEntity(new Rock(new Coordinates(5, 8)));
        addEntity(new Tree(new Coordinates(3, 8)));

        addEntity(new Grass(new Coordinates(3, 8)));
        addEntity(new Grass(new Coordinates(9, 8)));
        addEntity(new Grass(new Coordinates(3, 5)));
    }

    // Отрисовать карту
    public void render() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                Entity entity = getEntity(coordinates);

                if (entity != null) {
                    System.out.print(entity.getClass().getSimpleName().charAt(0));
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}