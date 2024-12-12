package org.simulation.project.map;

import org.simulation.project.entities.*;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private HashMap<Coordinates, Entity> map;
    private int width;
    private int height;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
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

    // Получить ширину карты
    public int getWidth() {
        return width;
    }

    // Получить высоту карты
    public int getHeight() {
        return height;
    }

    // Проверка на допустимость перемещения
    public boolean isValidMove(Coordinates coordinates) {
        if (coordinates.getX() < 0 || coordinates.getX() >= width ||
                coordinates.getY() < 0 || coordinates.getY() >= height) {
            return false; // Выход за пределы карты
        }

        Entity entity = getEntity(coordinates);
        return entity == null || !(entity instanceof Rock || entity instanceof Tree); // Проверка на препятствия
    }

    // Метод для установки начальных позиций сущностей
    public void setupDefaultEntityPositions() {
        // Добавляем сущности на карту в стартовые позиции
        addEntity(new Wolf(new Coordinates(0, 0), 10, 2, 3));
        addEntity(new Sheep(new Coordinates(5, 7), 10, 1));

        // Добавляем природные объекты
        addEntity(new Rock(new Coordinates(3, 3)));
        addEntity(new Tree(new Coordinates(2, 5)));
        addEntity(new Grass(new Coordinates(4, 4)));
        addEntity(new Grass(new Coordinates(6, 6)));
    }

    // Отрисовать карту
    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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
